/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

public class DriveTrain extends Subsystem { 

    private static final SpeedController leftFrontVictorSP = new VictorSP(RobotMap.DRIVETRAIN_LEFT_FRONT_VICTORSP);
    private static final SpeedController leftRearVictorSP = new VictorSP(RobotMap.DRIVETRAIN_LEFT_BACK_VICTORSP);
    private static final SpeedController rightFrontVictorSP = new VictorSP(RobotMap.DRIVETRAIN_RIGHT_FRONT_VICTORSP);
    private static final SpeedController rightRearVictorSP = new VictorSP(RobotMap.DRIVETRAIN_RIGHT_BACK_VICTORSP);
    private static SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFrontVictorSP, leftRearVictorSP);
    private static SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightFrontVictorSP, rightRearVictorSP);
    public final static DifferentialDrive robotDrive = new DifferentialDrive(leftMotors, rightMotors);
    
    public static void stop(){
      DriveTrain.robotDrive.arcadeDrive(0, 0);
    }

@Override
protected void initDefaultCommand() {
  // Set the default command for a subsystem here.
  // setDefaultCommand(new MySpecialCommand());
}
}
