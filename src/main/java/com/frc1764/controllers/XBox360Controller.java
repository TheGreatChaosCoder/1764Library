/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frc1764.controllers;

import com.frc1764.controllers.Controllers;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class XBox360Controller extends Controllers{
    private XboxController xboxController;
    public static final int NUMBER_OF_BUTTONS = 12;
    private JoystickButton[] xboxButtons = new JoystickButton[NUMBER_OF_BUTTONS];

    enum Button{
        A_BUTTON(1),
        B_BUTTON(2),
        X_BUTTON(3),
        Y_BUTTON(4),
        LEFT_SHOULDER_BUTTON(5),
        RIGHT_SHOULDER_BUTTON(6),
        BACK_BUTTON(7),
        START_BUTTON(8),
        LEFT_JOYSTICK_BUTTON(9),
        RIGHT_JOYSTICK_BUTTON(10); 

        public final int BUTTON_NUMBER;

        private Button(int buttonNumber){
            BUTTON_NUMBER = buttonNumber;
        }
        
        public int getButtonNumber(){
            return BUTTON_NUMBER;
        }

        public static Button valueOfBtnNum(int btnNum) {
            for (Button e : values()) {
                if (e. BUTTON_NUMBER == btnNum) {return e;}
            }
            return null;
        }

        public static final int SIZE = 10;
    }

    enum BackTriggers{
        LEFT_TRIGGER(Hand.kLeft),
        RIGHT_TRIGGER(Hand.kRight);

        public final Hand HAND;

        private static float threshold = 0.4;

        private BackTrigger(Hand hand){
            HAND = hand;
        }

        public static float getThresholdValue(){
            return threshold;
        }

        public static final int SIZE = 2;
    }

    private JoystickButton[] xboButtons = new JoystickButton[Button.SIZE];

    private Trigger[] dpadButtons = new Trigger[POVDirection.SIZE];

    public XBox360Controller(int port){
        super(port);

        xboxController = new XboxController(port);

        for(int i=1; i<=Button.SIZE; i++){
            xboButtons[i-1] = new JoystickButton(xboxController, i);
        }

        for(POVDirection direction : POVDirection.values()){
            dpadButtons[direction.ordinal()] = new Trigger(() -> getPOVDirection() == direction);
        }
    }

    public double getLeftStickX(){
        return xboxController.getX(Hand.kLeft);
    }

    public double getLeftStickY(){
        return xboxController.getY(Hand.kLeft);
    }

    public double getRightStickX(){
        return xboxController.getX(Hand.kRight);
    }

    public double getRightStickY(){
        return xboxController.getY(Hand.kRight);
    }

    //toggleWhenPressed family of functions
    public void toggleWhenPressed(CommandBase command, int btnNum){
        xboxButtons[btnNum-1].toggleWhenPressed(command);
    }

    public void toggleWhenPressed(CommandBase command, int btnNum, boolean interruptible){
        xboxButtons[btnNum-1].toggleWhenPressed(command, interruptible);
    }
    
    public void toggleWhenPressed(CommandBase command, Button button){
        toggleWhenPressed(command, button.getButtonNumber());
    }

    public void toggleWhenPressed(CommandBase command, Button button, boolean interruptible){
        toggleWhenPressed(command, button.getButtonNumber(), interruptible);
    }

    public void toggleWhenPressed(CommandBase command, POVDirection direction){
        dpadButtons[direction.ordinal()].toggleWhenActive(command);
    }

    public void toggleWhenPressed(CommandBase command, POVDirection direction, boolean interruptible){
        dpadButtons[direction.ordinal()].toggleWhenActive(command, interruptible);
    }

    //canceleWhenPressed family of functions
    public void cancelWhenPressed(CommandBase command, int btnNum){
        xboxButtons[btnNum-1].cancelWhenPressed(command);
    }
    
    public void cancelWhenPressed(CommandBase command, Button button){
        cancelWhenPressed(command, button.getButtonNumber());
    }

    public void cancelWhenPressed(CommandBase command, POVDirection direction){
        dpadButtons[direction.ordinal()].cancelWhenActive(command);
    }

    //whenPressed family of functions
    public void whenPressed(CommandBase command, int btnNum){
        xboxButtons[btnNum-1].whenPressed(command);
    }

    public void whenPressed(CommandBase command, int btnNum, boolean interruptible){
        xboxButtons[btnNum-1].whenPressed(command, interruptible);
    }
    
    public void whenPressed(CommandBase command, Button button){
        whenPressed(command, button.getButtonNumber());
    }
    
    public void whenPressed(CommandBase command, Button button, boolean interruptible){
        whenPressed(command, button.getButtonNumber(), interruptible);
    }

    public void whenPressed(CommandBase command, POVDirection direction){
        dpadButtons[direction.ordinal()].whenActive(command);
    }

    public void whenPressed(CommandBase command, POVDirection direction, boolean interruptible){
        dpadButtons[direction.ordinal()].whenActive(command, interruptible);
    }

    //whileHeld family of functions
    public void whileHeld(CommandBase command, int btnNum){
        xboxButtons[btnNum-1].whileHeld(command);
    }

    public void whileHeld(CommandBase command, int btnNum, boolean interruptible){
        xboxButtons[btnNum-1].whileHeld(command, interruptible);
    }
    
    public void whileHeld(CommandBase command, Button button){
        whileHeld(command, button.getButtonNumber());
    }
    
    public void whileHeld(CommandBase command, Button button, boolean interruptible){
        whileHeld(command, button.getButtonNumber(), interruptible);
    }

    public void whileHeld(CommandBase command, POVDirection direction){
        dpadButtons[direction.ordinal()].whileActiveContinuous(command);
    }

    public void whileHeld(CommandBase command, POVDirection direction, boolean interruptible){
        dpadButtons[direction.ordinal()].whileActiveContinuous(command, interruptible);
    }

    //whenHeld family of functions
    public void whenHeld(CommandBase command, int btnNum){
        xboxButtons[btnNum-1].whenHeld(command);
    }

    public void whenHeld(CommandBase command, int btnNum, boolean interruptible){
        xboxButtons[btnNum-1].whenHeld(command, interruptible);
    }
    
    public void whenHeld(CommandBase command, Button button){
        whenHeld(command, button.getButtonNumber());
    }
    
    public void whenHeld(CommandBase command, Button button, boolean interruptible){
        whenHeld(command, button.getButtonNumber(), interruptible);
    }

    public void whenHeld(CommandBase command, POVDirection direction){
        dpadButtons[direction.ordinal()].whileActiveOnce(command);
    }

    public void whenHeld(CommandBase command, POVDirection direction, boolean interruptible){
        dpadButtons[direction.ordinal()].whileActiveOnce(command, interruptible);
    }

    //whenReleased family of functions
    public void whenReleased(CommandBase command, int btnNum){
        xboxButtons[btnNum-1].whenReleased(command);
    }

    public void whenReleased(CommandBase command, int btnNum, boolean interruptible){
        xboxButtons[btnNum-1].whenReleased(command, interruptible);
    }
    
    public void whenReleased(CommandBase command, Button button){
        whenReleased(command, button.getButtonNumber());
    }
    
    public void whenReleased(CommandBase command, Button button, boolean interruptible){
        whenReleased(command, button.getButtonNumber(), interruptible);
    }

    public void whenReleased(CommandBase command, POVDirection direction){
        dpadButtons[direction.ordinal()].whenInactive(command);
    }

    public void whenReleased(CommandBase command, POVDirection direction, boolean interruptible){
        dpadButtons[direction.ordinal()].whenInactive(command, interruptible);
    }

    public int getPOV(){
        return xboxController.getPOV();
    }

    public POVDirection getPOVDirection(){
        int pov = xboxController.getPOV(); //in degrees where up=north=0 degrees, increases clockwise

        return getPOVDirection(pov);
    }

    public boolean isTriggerPressed(Hand hand){
        return xboxController.getTriggerAxis(hand) > BackTriggers.getThresholdValue();
    }

    public boolean isTriggerPressed(BackTriggers trigger){
        return xboxController.getTriggerAxis(trigger.HAND) > BackTriggers.getThresholdValue();
    }

}
