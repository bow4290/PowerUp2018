
package org.usfirst.frc.team4290.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4290.robot.commands.AutoLeftCrossBaseline;
import org.usfirst.frc.team4290.robot.commands.AutoMiddleScoreLeftSwitch;
import org.usfirst.frc.team4290.robot.commands.AutoMiddleScoreRightSwitch;
import org.usfirst.frc.team4290.robot.commands.TurnXDegrees;
import org.usfirst.frc.team4290.robot.subsystems.ClimberSubsystem;
import org.usfirst.frc.team4290.robot.subsystems.CubeArmSubsystem;
import org.usfirst.frc.team4290.robot.subsystems.CubeForkliftSubsystem;
import org.usfirst.frc.team4290.robot.subsystems.CubeGrabSubsystem;
import org.usfirst.frc.team4290.robot.subsystems.DriveTrain;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static RobotMap robotMap;
	public static DriveTrain driveTrain;
	public static CubeGrabSubsystem cubeGrab;
	public static CubeArmSubsystem cubeArm;
	public static CubeForkliftSubsystem cubeForklift;
	public static ClimberSubsystem climber;
	
	
	Command autonomousCommand;
	SendableChooser<String> chooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		driveTrain = new DriveTrain();
		cubeGrab = new CubeGrabSubsystem();
		cubeArm = new CubeArmSubsystem();
		cubeForklift = new CubeForkliftSubsystem();
		climber = new ClimberSubsystem();
		RobotMap.init();
//		chooser.addDefault("Default Auto", new ExampleCommand());
//		// chooser.addObject("My Auto", new MyAutoCommand());
		chooser = new SendableChooser<>();
		chooser.addDefault("Middle", "M");//new AutoLeftCrossBaseline());
		chooser.addObject("Right start", "R");//new AutoMiddleScoreLeftSwitch());
		chooser.addObject("Middle start", "M");//new AutoMiddleScoreLeftSwitch());
		chooser.addObject("Left start", "L");//new AutoMiddleScoreLeftSwitch());
		SmartDashboard.putData("Start Position", chooser);
		SmartDashboard.updateValues();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
//		Get field data
		String  gameData = DriverStation.getInstance().getGameSpecificMessage();
		SendableChooser<String> position = (SendableChooser<String>) SmartDashboard.getData("Start Position");
		SmartDashboard.putString("Position", position.getSelected());
		
//		Determine auto mode from field data
		if ("M".equals(position.getSelected())) {
			if ('L' == gameData.charAt(0)) {
	//			Call auto middle score switch left
				SmartDashboard.putString("Auto", "Middle Left");
				} else {
	//				call auto middle score switch right
				SmartDashboard.putString("Auto", "Middle Right" + gameData);
				} 
		}else if ("L".equals(position.getSelected())) {
			if ('L' == gameData.charAt(0)) {
//				Auto Left score switch
				SmartDashboard.putString("Auto", "Left Left");
			}else {
//				Auto cross baseline
				SmartDashboard.putString("Auto", "Left Baseline");
			}
		}else {
			if ('R' == gameData.charAt(0)) {
//				Auto Right score switch
				SmartDashboard.putString("Auto", "Right Right");
				
			}else {
//				Auto cross baseline
				SmartDashboard.putString("Auto", "Right Baseline");
			}
			
		}
		//TODO: REMOVE THIS FOR TESTING ONLY
		autonomousCommand = new AutoMiddleScoreRightSwitch();			
		
//		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
//		SmartDashboard.putNumber("Gyro Init", RobotMap.turningGyro.getAngle());
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
//		SmartDashboard.putNumber("Gyro Periodic", RobotMap.turningGyro.getAngle());
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
