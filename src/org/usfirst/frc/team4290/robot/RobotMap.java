package org.usfirst.frc.team4290.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
//import edu.wpi.first.wpilibj.RobotDrive;;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static DifferentialDrive driveTrain;
	
	public static SpeedController driveTrainLeftMotorFront;
	public static SpeedController driveTrainRightMotorBack;
	public static SpeedController driveTrainRightMotorFront;
	public static SpeedController driveTrainLeftMotorBack;
	public static Spark cubeGrabMotor;
	public static Spark cubeArmMotor;
	public static Spark cubeForkliftMotor;
	public static Spark climberMotor;
	public static ADXRS450_Gyro turningGyro;
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;

	public static void init() {
		
		driveTrainLeftMotorFront =  new Talon(0);
		driveTrainLeftMotorBack = new Talon(2);
		driveTrainRightMotorFront = new Talon(1);
		driveTrainRightMotorBack = new Talon(3);
		SpeedControllerGroup rightSide = new SpeedControllerGroup(driveTrainRightMotorFront, driveTrainRightMotorBack);
		SpeedControllerGroup leftSide = new SpeedControllerGroup(driveTrainLeftMotorFront, driveTrainLeftMotorBack);
		driveTrain = new DifferentialDrive(leftSide, rightSide);
		turningGyro = new ADXRS450_Gyro();
		
//		cubeGrabMotor = new Spark(0);
//		cubeArmMotor = new Spark(1);
//		cubeForkliftMotor = new Spark(2);
//		climberMotor = new Spark(3);
	
	}
}
