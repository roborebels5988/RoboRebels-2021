/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  //Initialize Controllers
  final public static Joystick stick = new Joystick(0);
  final public static XboxController controller = new XboxController(1);
  
  public OI(){
    //initialize buttons
    final Button LB = new JoystickButton(controller, 5);
    final Button RB = new JoystickButton(controller, 6);
    final Button A = new JoystickButton(controller, 1);
    final Button menu = new JoystickButton(controller, 8);


    //bind buttons
    RB.whileHeld(new BallIntakeStart());
    RB.whenReleased(new BallIntakeStop());
    LB.whileHeld(new Unstuck());
    LB.whenReleased(new UnstuckStop());
    A.whileHeld(new BallShooterStart());
    A.whenReleased(new BallShooterStop());
    menu.whileHeld(new Unstuck());
    menu.whenReleased(new UnstuckStop());

}
}
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
