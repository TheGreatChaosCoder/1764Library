package com.frc1764.controllers;

import edu.wpi.first.wpilibj2.command.CommandBase;

public abstract class Controllers {
    private int port;

    public Controllers(int port){
        this.port = port;
    }

    public int getPort(){
        return port;
    }

    /*All of these abstract methods are used when assigning a command to a button.
     Methods are based on already created methods for the button class in wpilib2.*/

    public abstract void toggleWhenPressed(CommandBase command, int btnNum);

    public abstract void toggleWhenPressed(CommandBase command, int btnNum, boolean interruptible);

    public abstract void cancelWhenPressed(CommandBase command, int btnNum);

    public abstract void whenPressed(CommandBase command, int btnNum);

    public abstract void whenPressed(CommandBase command, int btnNum, boolean interruptible);

    public abstract void whileHeld(CommandBase command, int btnNum);

    public abstract void whileHeld(CommandBase command, int btnNum, boolean interruptible);

    public abstract void whenHeld(CommandBase command, int btnNum);

    public abstract void whenHeld(CommandBase command, int btnNum, boolean interruptible);

    public abstract void whenReleased(CommandBase command, int btnNum);

    public abstract void whenReleased(CommandBase command, int btnNum, boolean interruptible);

    //get the value of the pov (the d-pad/ the thing that resembles a d-pad)
    public abstract int getPOV();

    public enum POVDirection{
        NORTH, //up
        NORTHEAST, //up and to the right
        EAST, //right
        SOUTHEAST, //down and to the right
        SOUTH, //down
        SOUTHWEST, //down and to the left
        WEST, //left
        NORTHWEST; //up and to the left

        public static final int SIZE = 8;
    }

    public abstract POVDirection getPOVDirection(); //finds the pov direction by first getting the pov value directly from the controller

    public POVDirection getPOVDirection(int pov){ //in degrees where up=north=0 degrees, inceases clockwise
        switch(pov){
            case 0:
                return POVDirection.NORTH;
            case 45:
                return POVDirection.NORTHWEST;
            case 90:
                return POVDirection.WEST;
            case 135:
                return POVDirection.SOUTHWEST;
            case 180:
                return POVDirection.SOUTH;
            case 225:
                return POVDirection.SOUTHEAST;
            case 270:
                return POVDirection.WEST;
            case 315:
                return POVDirection.NORTHWEST;
            default:
                return null;
        }
    }

}