package org.usfirst.frc.team4290.robot.commands;

import java.util.ArrayList;
import java.util.Comparator;

import org.usfirst.frc.team4290.robot.Robot;
import org.usfirst.frc.team4290.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MoveForwardCommand extends Command {

	private double distance = 0.0;
	private ArrayList<Double> sonarValues = new ArrayList<>(); 
    public MoveForwardCommand(double distance) {
    	this.distance = distance;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	SmartDashboard.putNumber("Move forward pre reset", RobotMap.turningGyro.getAngle());
    	RobotMap.turningGyro.reset();
    	RobotMap.sonarSensor.resetAccumulator();
//    	SmartDashboard.putNumber("Move forward reset", RobotMap.turningGyro.getAngle());

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.driveForward();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double sonarDistance = RobotMap.sonarSensor.getAverageVoltage() * 40.69;
//    	SmartDashboard.putNumber("stop distance", distance);
    	sonarValues.add(sonarDistance);
    	double avgDistance = getAverageDistance();
    	SmartDashboard.putNumber("sonar distance", avgDistance);
    	
    	if (distance == 0.0 ) {
    		return false;
    	}
        return distance > avgDistance;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
    private double getAverageDistance() {
    	SmartDashboard.putNumber("Avg array size", sonarValues.size());
    	if (sonarValues.size() == 10) {
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
        	SmartDashboard.putNumber("Sonar avg distance", average);
    		sonarValues.clear();

    		return average;
    	}
    	return 100.0;
    }
}
