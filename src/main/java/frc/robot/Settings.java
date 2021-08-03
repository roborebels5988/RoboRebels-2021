package frc.robot;

public class Settings {
    public static boolean xboxdrive = false; // I know this should be final but the linter yells at
                                             // me if I declare it as that
    public static int CameraAmount = 2; // Amount of cameras connected to the robot, setting a
                                        // higher value may decrease performance, value is 1
                                        // indexed.
}
