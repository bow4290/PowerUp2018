package org.usfirst.frc.team4290.robot.subsystems;

import org.usfirst.frc.team4290.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClimberSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void climbUp()
    {
    	RobotMap.climberMotor.set(0.9);
    }
    
    public void climbDown()
    {
    	RobotMap.climberMotor.set(-0.9);
    }
    
    public void stop()
    {
    	RobotMap.climberMotor.set(0);
    }
}

