package org.usfirst.frc.team4290.robot.subsystems;

import org.usfirst.frc.team4290.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CubeArmSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void raiseArm() {
    	RobotMap.cubeArmMotor.set(0.5);
    }
    
    public void lowerArm() {
    	RobotMap.cubeArmMotor.set(-0.5);
    }
    
    public void stopArm() {
    	RobotMap.cubeArmMotor.set(0);
    }
}

