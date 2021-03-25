// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BallScorer extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public BallScorer() {}

    private final SpeedController IntakeVictorSPX = new PWMVictorSPX(Constants.BALL_INTAKE);
    private final SpeedController LoaderVicterSPX = new PWMVictorSPX(Constants.BALL_LOADER);
    private final SpeedController ShooterVicterSPX = new PWMVictorSPX(Constants.BALL_SHOOTER);


    public final SpeedControllerGroup LoaderIntake = new SpeedControllerGroup(IntakeVictorSPX, LoaderVicterSPX);
    public final SpeedControllerGroup AllMotors = new SpeedControllerGroup(LoaderIntake, ShooterVicterSPX);
    
    
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
