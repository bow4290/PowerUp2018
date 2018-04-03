package org.usfirst.frc.team4290.robot.subsystems;

import org.usfirst.frc.team4290.robot.Robot;
import org.usfirst.frc.team4290.robot.RobotMap;
import org.usfirst.frc.team4290.robot.commands.DriveWithJoysticks;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {


    public void initDefaultCommand() {
    	setDefaultCommand(new DriveWithJoysticks());
    }
    
    public void takeJoystickInputs(XboxController xBoxController) {
    	//Get Joystick Inputs from Main Controller Joystick(s)
    	RobotMap.driveTrain.arcadeDrive(speedBuffer(xBoxController.getY(Hand.kLeft), 0.04), -xBoxController.getX(Hand.kLeft));
    }
    
    //Speed Buffer
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
	
	//Turn Right at Normal Speed
	public void turnRight()
	{
		RobotMap.driveTrain.arcadeDrive(0.4, -0.9);
	}
	
	//Turn Right at Fast Speed
	public void turnRightFast()
	{
		RobotMap.driveTrain.arcadeDrive(0.4,  -1.0);
	}
	
	//Turn Left at Normal Speed
	public void turnLeft()
	{
		RobotMap.driveTrain.arcadeDrive(0.4, 0.9);
	}
	
	//Turn Left at Fast Speed
	public void turnLeftFast()
	{
		RobotMap.driveTrain.arcadeDrive(0.4, 1.0);
	}
	
	//Stop Driving
	public void stop()
	{
		RobotMap.driveTrain.arcadeDrive(0, 0);
	}
	
	//Drive Forward at Normal Speed
	public void driveForward()
	{
		//Drift Corrector
		double angle = RobotMap.turningGyro.getAngle();
    	SmartDashboard.putNumber("Original Angle", angle);
    	SmartDashboard.putNumber("Turn Angle", -angle * 0.05);

    	//If Too Far Right
    	if(angle > 2.0)
    	{
        	SmartDashboard.putNumber("Drift Right Angle", angle);
    		RobotMap.driveTrain.tankDrive(-0.7, -0.8);
    	}
    	//If Too Far Left
    	else if(angle < -2.0)
    	{
        	SmartDashboard.putNumber("Drift Left Angle", angle);
    		RobotMap.driveTrain.tankDrive(-0.8, -0.7);
    	}
    	//If Just Right
    	else
    	{
    		SmartDashboard.putNumber("Drive Forward Angle", angle);
    		RobotMap.driveTrain.tankDrive(-0.75, -0.75);
    	}
    	
	}
	
	//Drive Forward at Fast Speed
	public void driveForwardFast()
	{
		double angle = RobotMap.turningGyro.getAngle();
    	SmartDashboard.putNumber("Original Angle", angle);
    	SmartDashboard.putNumber("Turn Angle", -angle * 0.05);

    	//If Too Far Right
    	if(angle > 2.0)
    	{
        	SmartDashboard.putNumber("Drift Right Angle", angle);
    		RobotMap.driveTrain.tankDrive(-0.8, -0.9);
    	}
    	//If Too Far Left
    	else if(angle < -2.0)
    	{
        	SmartDashboard.putNumber("Drift Left Angle", angle);
    		RobotMap.driveTrain.tankDrive(-0.9, -0.8);
    	}
    	//If Just Right
    	else
    	{
    		SmartDashboard.putNumber("Drive Forward Angle", angle);
    		RobotMap.driveTrain.tankDrive(-0.85, -0.85);
    	}
	}
	
	//Drive Backwards at Normal Speed
	public void driveBackward()
	{
		RobotMap.driveTrain.arcadeDrive(0.7, 0);
	}
	
	//Drive Backwards at Fast Speed
	public void driveBackwardFast()
	{
		RobotMap.driveTrain.arcadeDrive(0.8, 0);
	}
}

