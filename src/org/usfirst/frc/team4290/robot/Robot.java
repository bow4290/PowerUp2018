
package org.usfirst.frc.team4290.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.ArrayList;
import java.util.Comparator;

import org.usfirst.frc.team4290.robot.commands.AutoLeftCrossBaseline;
import org.usfirst.frc.team4290.robot.commands.AutoLeftScoreScale;
import org.usfirst.frc.team4290.robot.commands.AutoLeftScoreSwitch;
import org.usfirst.frc.team4290.robot.commands.AutoMiddleCrossBaselineOnLeft;
import org.usfirst.frc.team4290.robot.commands.AutoMiddleCrossBaselineOnRight;
import org.usfirst.frc.team4290.robot.commands.AutoMiddleScoreLeftScale;
import org.usfirst.frc.team4290.robot.commands.AutoMiddleScoreLeftSwitch;
import org.usfirst.frc.team4290.robot.commands.AutoMiddleScoreRightScale;
import org.usfirst.frc.team4290.robot.commands.AutoMiddleScoreRightSwitch;
import org.usfirst.frc.team4290.robot.commands.AutoRightCrossBaseline;
import org.usfirst.frc.team4290.robot.commands.TurnXDegrees;
import org.usfirst.frc.team4290.robot.subsystems.ClimberSubsystem;
import org.usfirst.frc.team4290.robot.subsystems.CubeForkliftSubsystem;
import org.usfirst.frc.team4290.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4290.robot.subsystems.SolenoidSubsystem;


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
	public static CubeForkliftSubsystem cubeForklift;
	public static ClimberSubsystem climber;
	public static SolenoidSubsystem pneumatics;
	
	Command autonomousCommand;
	SendableChooser<String> positionChooser;
	SendableChooser<String> scoreChooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		driveTrain = new DriveTrain();
		cubeForklift = new CubeForkliftSubsystem();
		climber = new ClimberSubsystem();
		pneumatics = new SolenoidSubsystem();
		RobotMap.init();
//		chooser.addDefault("Default Auto", new ExampleCommand());
//		// chooser.addObject("My Auto", new MyAutoCommand());
		positionChooser = new SendableChooser<>();
		positionChooser.addDefault("Middle", "M");//new AutoLeftCrossBaseline());
		positionChooser.addObject("Right start", "R");//new AutoMiddleScoreLeftSwitch());
		positionChooser.addObject("Left start", "L");//new AutoMiddleScoreLeftSwitch());
		SmartDashboard.putData("Start Position", positionChooser);
//		SmartDashboard.updateValues();
		scoreChooser = new SendableChooser<>();
		scoreChooser.addDefault("Score Switch", "switch");
		scoreChooser.addObject("Cross baseline", "baseline");
		scoreChooser.addObject("Score scale", "scale");
		SmartDashboard.putData("Score", scoreChooser);
		
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
//		autonomousCommand = new AutoLeftCrossBaseline();
//		Get field data
		String  gameData = DriverStation.getInstance().getGameSpecificMessage();
		SendableChooser<String> position = (SendableChooser<String>) SmartDashboard.getData("Start Position");
		SendableChooser<String> score = (SendableChooser<String>) SmartDashboard.getData("Score");
		
		switch (position.getSelected().toString()) {
		case "M":
			SmartDashboard.putString("Case M", "Case M");
			switch (score.getSelected().toString()) {
			case "switch":
				SmartDashboard.putString("Case Switch", "Case M Switch");

				if (gameData.charAt(0) == 'L') {
					autonomousCommand = new AutoMiddleScoreLeftSwitch();
				}
				else {
					autonomousCommand = new AutoMiddleScoreRightSwitch();
				}
				break;
			case "baseline":
				SmartDashboard.putString("Case M baseline", "Case M baseline");

				if (gameData.charAt(1) == 'L') {
					autonomousCommand = new AutoMiddleCrossBaselineOnRight();
				}
				else {
					autonomousCommand = new AutoMiddleCrossBaselineOnLeft();
				}
				break;
			case "scale":
				SmartDashboard.putString("Case M scale", "Case M scale");
				
				if (gameData.charAt(1) == 'L' &&  gameData.charAt(0) != 'L') {
					autonomousCommand = new AutoMiddleScoreLeftScale();
				}
				else {
					autonomousCommand = new AutoMiddleScoreRightScale();
				//TODO: Add baseline commands
				}
				break;
			default:
				break;
			}
			break;
		case "L":
			SmartDashboard.putString("Case L", "Case L");

			switch (score.getSelected().toString()) {
			case "switch":
				SmartDashboard.putString("Case L switch", "Case L switch");

				if (gameData.charAt(0) == 'L') {
					autonomousCommand = new AutoLeftScoreSwitch();
				}
				else if (gameData.charAt(1) == 'L'){
					autonomousCommand = new AutoLeftScoreScale();
				}
				else {
					autonomousCommand = new AutoLeftCrossBaseline();
				}
				break;
			case "baseline":
				SmartDashboard.putString("Case L baseline", "Case L baseline");

				autonomousCommand = new AutoLeftCrossBaseline();
				
				break;
			case "scale": 
				SmartDashboard.putString("Case L scale", "Case L scale");

				if (gameData.charAt(1) == 'L') {
					autonomousCommand = new AutoLeftScoreScale();
				}else {
					autonomousCommand = new AutoLeftCrossBaseline(); 
				}
				
				break;
			default:
				break;
			}
			break;
		case "R":
			SmartDashboard.putString("Case R", "Case R");

			switch (score.getSelected().toString()) {
			case "switch":
				SmartDashboard.putString("Case R switch", "Case R switch");
				break;
			case "baseline":
				SmartDashboard.putString("Case R baseline", "Case R baseline");

				autonomousCommand = new AutoRightCrossBaseline();
				
				break;
			case "scale":		
				SmartDashboard.putString("Case R scale", "Case R scale");

				if (gameData.charAt(1) == 'R') {
				autonomousCommand = new AutoLeftScoreScale();
			}else {
				autonomousCommand = new AutoLeftCrossBaseline(); 
			}
				
				break;
			default:
				break;
			}
			break;
		default:

			break;
		}
		
		SmartDashboard.putString("default", position.getSelected().toString() + " " + score.getSelected().toString());

		//TODO: REMOVE THIS FOR TESTING ONLY
//		autonomousCommand = new AutoLeftScoreScale();			
		
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
    	double sonarDistance = RobotMap.sonarSensor.getVoltage() * 40.69;
    	sonarValues.add(sonarDistance);
    	SmartDashboard.putNumber("distance", sonarDistance);
    	SmartDashboard.putNumber("sonar teleop distance", getAverageDistance());
		
//		SmartDashboard.putNumber("Gyro Periodic", RobotMap.turningGyro.getAngle());
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	private ArrayList<Double> sonarValues = new ArrayList<>(); 
	

	private double getAverageDistance() {
    	SmartDashboard.putNumber("Avg array size", sonarValues.size());
    	if (sonarValues.size() > 15) {
    		sonarValues.sort(Comparator.reverseOrder());
    		sonarValues.remove(0);
    		sonarValues.remove(0);
    		sonarValues.remove(0);
//    		sonarValues.remove(0);
    		sonarValues.remove(sonarValues.size() - 1);
    		sonarValues.remove(sonarValues.size() - 1);
    		sonarValues.remove(sonarValues.size() - 1);
//    		sonarValues.remove(sonarValues.size() - 1);

    		
    		double average = 0.0;
    		for (Double i : sonarValues) {
    			average += i;
    		}
    		average = average/sonarValues.size();
        	SmartDashboard.putNumber("Sonar avg distance", average+1);
    		sonarValues.clear();

    		return average;
    	}
    	return 100.0;
    }
}
