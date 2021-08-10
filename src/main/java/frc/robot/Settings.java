package frc.robot;

public class Settings {
    // I know all of these should be final but the linter yells at
    // me if I declare it as that
    public static boolean xboxdrive = false; // If an Xbox controller should be used as the main
                                             // drive controller
    public static int CameraAmount = 2; // Amount of cameras connected to the robot, setting a
                                        // higher value may decrease performance, value is 1
                                        // indexed.
    public static boolean ShootInAuto = false; // If the robot should shoot in auto mode, if set to
                                               // false, the robot will still move forward, but the
                                               // shoot command will not activate.
}
