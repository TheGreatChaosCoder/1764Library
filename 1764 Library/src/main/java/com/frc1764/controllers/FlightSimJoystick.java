/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frc1764.controllers;

import com.frc1764.controllers.Controllers;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class FlightSimJoystick extends Controllers{
    private Joystick joystick;
    public static final int NUMBER_OF_BUTTONS = 12;
    private JoystickButton[] joystickButtons = new JoystickButton[NUMBER_OF_BUTTONS];

    private Trigger[] povButtons = new Trigger[POVDirection.SIZE];

    public FlightSimJoystick(int port){
        super(port);

        joystick = new Joystick(port);
        for(int i=0; i<NUMBER_OF_BUTTONS; i++){ //i is the index of the array, i+1 is the btn number at that position
            joystickButtons[i] = new JoystickButton(joystick, i+1);
        }

        for(POVDirection direction : POVDirection.values()){
            povButtons[direction.ordinal()] = new Trigger(() -> getPOVDirection() == direction);
        }
    }

    public double getX(){
        return joystick.getX();
    }

    public double getY(){
        return joystick.getY();
    }

    public double getZRotation(){
        return joystick.getZ();
    }

    public double getSlider(){
       return joystick.getRawAxis(3);
    }

    public JoystickButton getJoystickButton(int btnNum){
        return joystickButtons[btnNum-1];
    }

    public Trigger getPOVButton(POVDirection direction){
        return povButtons[direction.ordinal()];
    }

    //toggleWhenPressed family of functions
    public void toggleWhenPressed(CommandBase command, int btnNum){
        joystickButtons[btnNum-1].toggleWhenPressed(command);
    }

    public void toggleWhenPressed(CommandBase command, int btnNum, boolean interruptible){
        joystickButtons[btnNum-1].toggleWhenPressed(command, interruptible);
    }

    public void toggleWhenPressed(CommandBase command, POVDirection direction){
        povButtons[direction.ordinal()].toggleWhenActive(command);
    }

    public void toggleWhenPressed(CommandBase command, POVDirection direction, boolean interruptible){
        povButtons[direction.ordinal()].toggleWhenActive(command, interruptible);
    }

    //canceleWhenPressed family of functions
    public void cancelWhenPressed(CommandBase command, int btnNum){
        joystickButtons[btnNum-1].cancelWhenPressed(command);
    }

    public void cancelWhenPressed(CommandBase command, POVDirection direction){
        povButtons[direction.ordinal()].cancelWhenActive(command);
    }

    //whenPressed family of functions
    public void whenPressed(CommandBase command, int btnNum){
        joystickButtons[btnNum-1].whenPressed(command);
    }

    public void whenPressed(CommandBase command, int btnNum, boolean interruptible){
        joystickButtons[btnNum-1].whenPressed(command, interruptible);
    }

    public void whenPressed(CommandBase command, POVDirection direction){
        povButtons[direction.ordinal()].whenActive(command);
    }

    public void whenPressed(CommandBase command, POVDirection direction, boolean interruptible){
        povButtons[direction.ordinal()].whenActive(command, interruptible);
    }

    //whileHeld family of functions
    public void whileHeld(CommandBase command, int btnNum){
        joystickButtons[btnNum-1].whileHeld(command);
    }

    public void whileHeld(CommandBase command, int btnNum, boolean interruptible){
        joystickButtons[btnNum-1].whileHeld(command, interruptible);
    }

    public void whileHeld(CommandBase command, POVDirection direction){
        povButtons[direction.ordinal()].whileActiveContinuous(command);
    }

    public void whileHeld(CommandBase command, POVDirection direction, boolean interruptible){
        povButtons[direction.ordinal()].whileActiveContinuous(command, interruptible);
    }

    //whenHeld family of functions
    public void whenHeld(CommandBase command, int btnNum){
        joystickButtons[btnNum-1].whenHeld(command);
    }

    public void whenHeld(CommandBase command, int btnNum, boolean interruptible){
        joystickButtons[btnNum-1].whenHeld(command, interruptible);
    }

    public void whenHeld(CommandBase command, POVDirection direction){
        povButtons[direction.ordinal()].whileActiveOnce(command);
    }

    public void whenHeld(CommandBase command, POVDirection direction, boolean interruptible){
        povButtons[direction.ordinal()].whileActiveOnce(command, interruptible);
    }

    //whenReleased family of functions
    public void whenReleased(CommandBase command, int btnNum){
        joystickButtons[btnNum-1].whenReleased(command);
    }

    public void whenReleased(CommandBase command, int btnNum, boolean interruptible){
        joystickButtons[btnNum-1].whenReleased(command, interruptible);
    }

    public void whenReleased(CommandBase command, POVDirection direction){
        povButtons[direction.ordinal()].whenInactive(command);
    }

    public void whenReleased(CommandBase command, POVDirection direction, boolean interruptible){
        povButtons[direction.ordinal()].whenInactive(command, interruptible);
    }

    public int getPOV(){
        return joystick.getPOV();
    }

    public POVDirection getPOVDirection(){
        int pov = joystick.getPOV(); //in degrees where up=north=0 degrees, increases clockwise

        return getPOVDirection(pov);
    }
}
