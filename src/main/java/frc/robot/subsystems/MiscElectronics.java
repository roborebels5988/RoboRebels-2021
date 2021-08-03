// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Settings;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MiscElectronics extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  // create encoders
  Encoder LeftEncoder;
  Encoder RightEncoder;
  private static final double cpr = 5;
  private static final double whd = 6; // wheel hub diamater (inches)

  // create gyro
  Gyro gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);

  public MiscElectronics() {
    
    // init cameras
    for (int i = 0; i < Settings.CameraAmount; i++) {
      System.out.println(i);
      CameraServer.getInstance().startAutomaticCapture(i);
    }

    Shuffleboard.getTab("Example tab").add("gyro", (Sendable) gyro);
    LeftEncoder = new Encoder(8, 9);
    RightEncoder = new Encoder(6, 7);
    LeftEncoder.setDistancePerPulse(Math.PI * whd / cpr); // distance per pulse is pi* (wheel
    RightEncoder.setDistancePerPulse(Math.PI * whd / cpr); // diameter / counts per revolution)
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    double LeftDist = LeftEncoder.getDistance();
    SmartDashboard.putNumber("Left Encoder", LeftDist);
    double RightDist = RightEncoder.getDistance();
    SmartDashboard.putNumber("Right Encoder", -RightDist);
    SmartDashboard.putNumber("gyro", gyro.getAngle());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
