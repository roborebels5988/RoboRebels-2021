// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Settings;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class PrimaryControllerOI extends CommandBase {

  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  private final DriveTrain m_drivetrain;
  private GenericHID PrimaryController;

  /**
   * Creates a new ExampleCommand.
   *
   * @param drivetrain The subsystem used by this command.
   */
  public PrimaryControllerOI(DriveTrain drivetrain) {
    m_drivetrain = drivetrain;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drivetrain.stop();

    // initialise the primary controller
    if (Settings.xboxdrive) {
      PrimaryController = new XboxController(0);
    } else {
      PrimaryController = new Joystick(0);
    }
  }

  double throttle() {
    double localThrottle;
    if (Settings.xboxdrive == false) {
      localThrottle = 0.5 + 0.5 * -PrimaryController.getRawAxis(3);
    } else {
      localThrottle = 1;
    }
    return localThrottle;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = throttle() * -PrimaryController.getY();
    double rotation = throttle() * PrimaryController.getX();
    rotation = rotation / 1.5;
    m_drivetrain.robotDrive.arcadeDrive(speed, rotation);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
