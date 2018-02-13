package org.usfirst.frc.team4290.robot.commands;

import org.usfirst.frc.team4290.robot.Robot;
import org.usfirst.frc.team4290.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MoveForwardCommand extends Command {

	private double distance = 0.0;
    public MoveForwardCommand(double distance) {
    	this.distance = distance;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	SmartDashboard.putNumber("Move forward pre reset", RobotMap.turningGyro.getAngle());
    	RobotMap.turningGyro.reset();
//    	SmartDashboard.putNumber("Move forward reset", RobotMap.turningGyro.getAngle());

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	Robot.driveTrain.driveForward();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double sonarDistance = RobotMap.sonarSensor.getRangeInches(); 
    	SmartDashboard.putNumber("sonar distance", sonarDistance);
    	SmartDashboard.putNumber("stop distance", distance);
    	if (distance == 0.0 ) {
    		return false;
    	}
        return distance > sonarDistance;
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
}
