package org.usfirst.frc.team4290.robot.subsystems;

import org.usfirst.frc.team4290.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CubeGrabSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void grabCube()
    {
    	RobotMap.cubeGrabMotor.set(1);
    }
    
    public void dropCube()
    {
    	RobotMap.cubeGrabMotor.set(-1);
    }
    
    public void stop()
    {
    	RobotMap.cubeGrabMotor.set(0);
    }
}

