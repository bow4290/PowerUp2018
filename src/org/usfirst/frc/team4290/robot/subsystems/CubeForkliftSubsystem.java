package org.usfirst.frc.team4290.robot.subsystems;

import org.usfirst.frc.team4290.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CubeForkliftSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void forkliftUp()
    {
    	RobotMap.cubeForkliftMotor.set(0.7);
    }
    
    public void forkliftDown()
    {
    	RobotMap.cubeForkliftMotor.set(-0.7);
    }
    
    public void forkliftHold()
    {
    	RobotMap.cubeForkliftMotor.set(0.2);
    }
    
    public void stop()
    {
    	RobotMap.cubeForkliftMotor.set(0);
    }
}

