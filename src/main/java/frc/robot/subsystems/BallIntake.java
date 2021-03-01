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

public class BallIntake extends Subsystem {

  public static SpeedController BALL_INTAKE_SPEED_CONTROLLER = new PWMVictorSPX(RobotMap.BALL_INTAKE);
  public static SpeedController BALL_LOADER_SPEED_CONTROLLER = new PWMVictorSPX(RobotMap.BALL_LOADER);

  public static void in() {
    BALL_INTAKE_SPEED_CONTROLLER.set(-0.45);
    BALL_LOADER_SPEED_CONTROLLER.set(-0.45);
  }

  public static void out() {
    BALL_INTAKE_SPEED_CONTROLLER.set(0.45);
    BALL_LOADER_SPEED_CONTROLLER.set(0.45);
  }
  public static void stop(){
    BALL_INTAKE_SPEED_CONTROLLER.set(0);
    BALL_LOADER_SPEED_CONTROLLER.set(0);
  }

  @Override
	protected void initDefaultCommand() {
		
	}
}
