/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


public class BallShooter extends Subsystem {

  public static SpeedController ballShooterSpeedController = new PWMVictorSPX(RobotMap.Ball_SHOOTER);

  public static void in() {
    ballShooterSpeedController.set(0.5);
  }

  public static void out() {
    ballShooterSpeedController.set(-0.5);
  }

  public static void stop(){
    ballShooterSpeedController.stopMotor();
  }

  @Override
	protected void initDefaultCommand() {
		
	}
}
