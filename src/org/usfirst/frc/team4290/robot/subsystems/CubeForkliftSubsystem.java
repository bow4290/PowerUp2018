package org.usfirst.frc.team4290.robot.subsystems;

import org.usfirst.frc.team4290.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CubeForkliftSubsystem extends Subsystem {

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    //Raise Forklift
    public void forkliftUp()
    {
    	RobotMap.cubeForkliftMotor.set(0.75);
    }
    
    //Lower Forklift
    public void forkliftDown()
    {
    	RobotMap.cubeForkliftMotor.set(-0.65);
    }
    
    //Hold Forklift at current height
    public void forkliftHold()
    {
    	RobotMap.cubeForkliftMotor.set(0.1);
    }
    
    //Stop Forklift Commands
    public void stop()
    {
    	RobotMap.cubeForkliftMotor.set(0);
    }
}

