package org.usfirst.frc.team4290.robot.commands;

import org.usfirst.frc.team4290.robot.Robot;
import org.usfirst.frc.team4290.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TurnLeftCommand extends Command {
	
//	private static double const 90DEGREES = 90.0;

    public TurnLeftCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.turningGyro.reset();
//    	SmartDashboard.putNumber("Left Turn Gyro Reset Value", RobotMap.turningGyro.getAngle());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.turnLeft();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//    	SmartDashboard.putNumber("Left Turn Gyro Execute Value", RobotMap.turningGyro.getAngle());
//    	SmartDashboard.putBoolean("Left IsFinished Check", RobotMap.turningGyro.getAngle() < -90);
    	return RobotMap.turningGyro.getAngle() < -85;
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
