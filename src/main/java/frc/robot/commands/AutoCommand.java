// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.BallScorer;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class AutoCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final BallScorer m_BallScorer;
  private final DriveTrain m_DriveTrain;

  /**
   * Creates a new ExampleCommand.
   *
   * @param BallScorer The subsystem used by this command.
   */
  public AutoCommand(BallScorer ballscorer, DriveTrain drivetrain) {
    m_BallScorer = ballscorer;
    m_DriveTrain = drivetrain;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(ballscorer, drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_DriveTrain.stop();
    m_BallScorer.LoaderIntake.set(0);
    m_BallScorer.Shooter.set(Value.kOff);
    }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
