// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {}
  
  private static final SpeedController leftFrontVictorSP = new VictorSP(Constants.DRIVETRAIN_LEFT_FRONT_VICTORSP);
  private static final SpeedController leftRearVictorSP = new VictorSP(Constants.DRIVETRAIN_LEFT_BACK_VICTORSP);
  private static final SpeedController rightFrontVictorSP = new VictorSP(Constants.DRIVETRAIN_RIGHT_FRONT_VICTORSP);
  private static final SpeedController rightRearVictorSP = new VictorSP(Constants.DRIVETRAIN_RIGHT_BACK_VICTORSP);

  private static SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFrontVictorSP, leftRearVictorSP);
  private static SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightFrontVictorSP, rightRearVictorSP);
  
  public final DifferentialDrive robotDrive = new DifferentialDrive(leftMotors, rightMotors);

  public void stop(){
    robotDrive.arcadeDrive(0, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
