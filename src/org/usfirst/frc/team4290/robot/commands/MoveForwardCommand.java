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
	//Decides whether to use Fast or normal version
	private boolean fast = false;
	//Get average sonar distance
	private ArrayList<Double> sonarValues = new ArrayList<>(); 

	//Normal Speed Forward
    public MoveForwardCommand(double distance) {
    	this.distance = distance;
    	this.fast = false;
    }
    //Fast Speed Forward
    public MoveForwardCommand(double distance, boolean fast) {
    	this.distance = distance;
    	this.fast = fast;
    }

    protected void initialize() {
    	RobotMap.turningGyro.reset();
    	RobotMap.sonarSensor.resetAccumulator();
    }

    protected void execute() {
    	
    	if (fast)
    	{
    		Robot.driveTrain.driveForwardFast();
    	} 
    	else
    	{
    		Robot.driveTrain.driveForward();
    	}
    }

    protected boolean isFinished() {
    	
    	double sonarDistance = RobotMap.sonarSensor.getAverageVoltage() * 40.69;
    	sonarValues.add(sonarDistance);
    	double avgDistance = getAverageDistance();
    	SmartDashboard.putNumber("sonar distance", avgDistance);
    	
    	if (distance == 0.0 ) {
    		return false;
    	}
        return distance > avgDistance;
    }

    protected void end() {
    	Robot.driveTrain.stop();
    }

    protected void interrupted() {
    	end();
    }
    
    //Gets Average Distance from Sonar
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
