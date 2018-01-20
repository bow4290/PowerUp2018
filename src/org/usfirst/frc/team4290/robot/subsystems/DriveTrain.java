package org.usfirst.frc.team4290.robot.subsystems;

import org.usfirst.frc.team4290.robot.RobotMap;
import org.usfirst.frc.team4290.robot.commands.DriveWithJoysticks;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new DriveWithJoysticks());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void takeJoystickInputs(Joystick right) {
    	
    	RobotMap.driveTrain.arcadeDrive(right.getY(), right.getX());
//    	RobotMap.driveTrain.arcadeDrive(.1, .1);
    	
    }
    
    private boolean isSlow = false;
    
    public void switchIsSlow()
    {
    	isSlow = !isSlow;
    }
    
    private double oldSpeed = 0.0;
    
	public double speedBuffer(double joy, double perc) {
		double addSpeed = Math.abs(oldSpeed) * perc;
		if (Math.abs(joy - oldSpeed) < addSpeed + 0.01) {
			oldSpeed = joy;
		} else if (Math.abs(oldSpeed) < perc * 10 && Math.abs(joy) > 0.1) {
			oldSpeed = perc * 10 * Math.signum(joy);
//			oldSpeed += 0.01 * Math.signum(joy - oldSpeed);
		} else {
			oldSpeed += addSpeed * Math.signum(joy - oldSpeed);
		}
		double speedMultiplier = isSlow ? 0.8 : 1.0;
		return oldSpeed;
	}
	
	private double speedBuffer(double joy)
	{
		if (joy >= 0.5) 
			return 0.5;
		return 0.5;
		
	}
	
	public void turnRight()
	{
		RobotMap.driveTrain.arcadeDrive(0, -0.6);
	}
	
	public void turnLeft()
	{
		RobotMap.driveTrain.arcadeDrive(0, 0.6);
	}
	
	public void stop()
	{
		RobotMap.driveTrain.arcadeDrive(0, 0);
	}
	
	public void driveForward()
	{
		RobotMap.driveTrain.arcadeDrive(0.5, 0);
	}
	
	public void driveBackward()
	{
		RobotMap.driveTrain.arcadeDrive(-0.5, 0);
	}
	
}

