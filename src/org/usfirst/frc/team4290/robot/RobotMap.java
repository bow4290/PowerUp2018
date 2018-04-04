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
	//Drive Train Motors
	public static SpeedController driveTrainLeftMotorFront;
	public static SpeedController driveTrainRightMotorBack;
	public static SpeedController driveTrainRightMotorFront;
	public static SpeedController driveTrainLeftMotorBack;
	
	//Secondary System Motors
	public static VictorSP cubeForkliftMotor;
	public static VictorSP climberMotor;
	
	//Pneumatics
	public static DoubleSolenoid gearShiftSolenoid;
	public static DoubleSolenoid cubeGrabRightSolenoid;
	public static DoubleSolenoid cubeGrabLeftSolenoid;
//	public static DoubleSolenoid cubeGrabSolenoid;
	
	//Sensors
	public static AnalogInput sonarSensor; 
	public static ADXRS450_Gyro turningGyro;

	public static void init() {

		//Drive Train Motors
		driveTrainLeftMotorFront =  new Spark(2);
		driveTrainLeftMotorBack = new Spark(3);
		driveTrainRightMotorFront = new Spark(0);
		driveTrainRightMotorBack = new Spark(1);
		SpeedControllerGroup rightSide = new SpeedControllerGroup(driveTrainRightMotorFront, driveTrainRightMotorBack);
		SpeedControllerGroup leftSide = new SpeedControllerGroup(driveTrainLeftMotorFront, driveTrainLeftMotorBack);
		driveTrain = new DifferentialDrive(leftSide, rightSide);
		
		//Secondary System Motors
		cubeForkliftMotor = new VictorSP(5);
		climberMotor = new VictorSP(4);
		
		//Sensors
		turningGyro = new ADXRS450_Gyro();
		sonarSensor = new AnalogInput(0);

		//Pneumatics
		cubeGrabRightSolenoid = new DoubleSolenoid(4, 5);
		cubeGrabLeftSolenoid = new DoubleSolenoid(2, 3);
		gearShiftSolenoid = new DoubleSolenoid(0, 1);

	}
}
