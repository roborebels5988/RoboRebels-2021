/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  
  //Initialize drive motors
  public static final int DRIVETRAIN_LEFT_FRONT_VICTORSP = 0;
  public static final int DRIVETRAIN_LEFT_BACK_VICTORSP = 1;
  public static final int DRIVETRAIN_RIGHT_FRONT_VICTORSP = 2;
  public static final int DRIVETRAIN_RIGHT_BACK_VICTORSP = 3;
  
  //Initailize other motors
  public static final int BALL_INTAKE = 4;
  public static final int BALL_LOADER = 5;
  public static final int Ball_SHOOTER = 6;

  //initailize ultrasonic
  public static final int UltrasonicPort = 0;

}
