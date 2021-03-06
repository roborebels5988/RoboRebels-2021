/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import frc.robot.DriveConstants;
import frc.robot.RobotMap;

public class DriveTrain extends Subsystem { 

    // Set up speed controllers
    private static final SpeedController leftFrontVictorSP = new VictorSP(RobotMap.DRIVETRAIN_LEFT_FRONT_VICTORSP);
    private static final SpeedController leftRearVictorSP = new VictorSP(RobotMap.DRIVETRAIN_LEFT_BACK_VICTORSP);
    private static final SpeedController rightFrontVictorSP = new VictorSP(RobotMap.DRIVETRAIN_RIGHT_FRONT_VICTORSP);
    private static final SpeedController rightRearVictorSP = new VictorSP(RobotMap.DRIVETRAIN_RIGHT_BACK_VICTORSP);

    // Set up speed controller groups
    private static SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFrontVictorSP, leftRearVictorSP);
    private static SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightFrontVictorSP, rightRearVictorSP);

    // Set up Differential Drive
    public final static DifferentialDrive robotDrive = new DifferentialDrive(leftMotors, rightMotors);
    
    // Set up encoders
  private final Encoder m_leftEncoder = 
    new Encoder(RobotMap.DRIVETRAIN_LEFT_FRONT_VICTORSP, RobotMap.DRIVETRAIN_LEFT_BACK_VICTORSP, DriveConstants.kLeftEncoderReversed);

    // Set up encoders
  private final Encoder m_rightEncoder = 
  new Encoder(RobotMap.DRIVETRAIN_RIGHT_FRONT_VICTORSP, RobotMap.DRIVETRAIN_RIGHT_BACK_VICTORSP, DriveConstants.kRightEncoderReversed);

  public static DifferentialDriveOdometry m_odometry = new DifferentialDriveOdometry(
    MyGyro.gyro.getRotation2d(), new Pose2d(5.0, 13.5, new Rotation2d()));

  public static void stop(){
    DriveTrain.robotDrive.arcadeDrive(0, 0);

    }

  @Override
  public void periodic() {
    // Get my gyro angle. We are negating the value because gyros return positive
    // values as the robot turns clockwise. This is not standard convention that is
    // used by the WPILib classes.
    var gyroAngle = Rotation2d.fromDegrees(-MyGyro.gyro.getAngle());
    
    // Update the pose
    Pose2d m_pose = m_odometry.update(gyroAngle, m_leftEncoder.getDistance(), m_rightEncoder.getDistance());
  }
  
    @Override
    protected void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
}
}