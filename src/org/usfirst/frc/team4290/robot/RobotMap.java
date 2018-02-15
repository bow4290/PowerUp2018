package org.usfirst.frc.team4290.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Solenoid;
//import edu.wpi.first.wpilibj.RobotDrive;;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;
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
	//Remove Cube Grab motor when not testing
	public static Spark cubeGrabMotor;
	public static Spark cubeArmMotor;
	public static Talon cubeForkliftMotor;
	public static Talon climberMotor;
	public static ADXRS450_Gyro turningGyro;
	public static Solenoid gearShiftSolenoid;
	public static Solenoid cubeGrabSolenoid;
	public static AnalogInput sonarSensor; 
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	//Wire 4 Connect to 0
	//Wire 5 Connect to 1
	//Wire 3 connect to 2
	//Wire 1 connect to 3

	public static void init() {

		driveTrainLeftMotorFront =  new Talon(0); //Changed from 5/0 PowerUpBot
//		driveTrainLeftMotorBack = new Talon(2); //changed from 2
		driveTrainRightMotorFront = new Talon(1);//Changed from 4/1 PowerUpBot
//		driveTrainRightMotorBack = new Talon(3); //changed from 3
		SpeedControllerGroup rightSide = new SpeedControllerGroup(driveTrainRightMotorFront);
		SpeedControllerGroup leftSide = new SpeedControllerGroup(driveTrainLeftMotorFront);
		driveTrain = new DifferentialDrive(leftSide, rightSide);
		turningGyro = new ADXRS450_Gyro();
		cubeGrabSolenoid = new Solenoid(5);
		gearShiftSolenoid = new Solenoid(4);
//		cubeGrabMotor = new Spark(3);
//		cubeArmMotor = new Spark(1);
		cubeForkliftMotor = new Talon(2);
		climberMotor = new Talon(3);
		sonarSensor = new AnalogInput(1);
	
	}
}
