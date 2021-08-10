// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Settings;
import frc.robot.subsystems.BallScorer;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.Timer;
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
  Timer timer;

  public AutoCommand(BallScorer ballscorer, DriveTrain drivetrain) {

    m_BallScorer = ballscorer;
    m_DriveTrain = drivetrain;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(ballscorer, drivetrain);
    timer = new Timer();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
    m_BallScorer.Shooter.set(Value.kReverse);
  }

  int i = 0;

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (timer.get() <= 2) { // Go forward for 4 seconds
      m_DriveTrain.robotDrive.arcadeDrive(0.5, 0);
    } else {
      if (i <= 10) {
        if (Settings.ShootInAuto == true) {
          m_BallScorer.Shooter.set(Value.kForward);
        }
        i = i + 1;
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_DriveTrain.stop();
    // m_BallScorer.LoaderIntake.set(0);
    // m_BallScorer.Shooter.set(Value.kOff);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer.get() >= 4; // give it plenty of time to finish
  }
}
