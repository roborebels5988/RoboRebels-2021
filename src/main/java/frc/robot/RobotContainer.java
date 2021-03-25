// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.LoadBalls;
import frc.robot.commands.PrimaryControllerOI;
import frc.robot.commands.ShootBalls;
import frc.robot.subsystems.BallScorer;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
// Define subsystems
  private final static DriveTrain m_driveTrain = new DriveTrain();
  private final static BallScorer m_ballscorer = new BallScorer();

  // Define commands
  public final static PrimaryControllerOI m_joystickOI = new PrimaryControllerOI(m_driveTrain);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

    // Define controller
    private final XboxController SubsystemController = new XboxController(1);

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Define buttons
    final Button a = new JoystickButton(SubsystemController, XboxController.Button.kA.value);
    final Button b = new JoystickButton(SubsystemController, XboxController.Button.kB.value);

    // Run the commands
    a.whileHeld(new LoadBalls(m_ballscorer));
    b.whileHeld(new ShootBalls(m_ballscorer));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
