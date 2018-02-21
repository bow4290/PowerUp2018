package org.usfirst.frc.team4290.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
//import edu.wpi.first.wpilibj.RobotDrive;;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
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
//	public static Spark cubeGrabMotor;
//	public static Spark cubeArmMotor;
	public static VictorSP cubeForkliftMotor;
	public static VictorSP climberMotor;
	public static ADXRS450_Gyro turningGyro;
	public static DoubleSolenoid gearShiftSolenoid;
	public static DoubleSolenoid cubeGrabSolenoid;
	public static AnalogInput sonarSensor; 
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	

	public static void init() {

		driveTrainLeftMotorFront =  new Spark(2);
		driveTrainLeftMotorBack = new Spark(3);
		driveTrainRightMotorFront = new Spark(0);
		driveTrainRightMotorBack = new Spark(1);
		SpeedControllerGroup rightSide = new SpeedControllerGroup(driveTrainRightMotorFront, driveTrainRightMotorBack);
		SpeedControllerGroup leftSide = new SpeedControllerGroup(driveTrainLeftMotorFront, driveTrainLeftMotorBack);
		driveTrain = new DifferentialDrive(leftSide, rightSide);
		turningGyro = new ADXRS450_Gyro();
		cubeGrabSolenoid = new DoubleSolenoid(2, 3);
		gearShiftSolenoid = new DoubleSolenoid(0, 1);
//		cubeGrabMotor = new Spark(3);
//		cubeArmMotor = new Spark(1);
		cubeForkliftMotor = new VictorSP(5);
		climberMotor = new VictorSP(4);
		sonarSensor = new AnalogInput(1);
	
	}
}
