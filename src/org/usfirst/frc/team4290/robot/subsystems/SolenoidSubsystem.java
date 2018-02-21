package org.usfirst.frc.team4290.robot.subsystems;

import org.usfirst.frc.team4290.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SolenoidSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void shiftGears() {
    	
    	if(RobotMap.gearShiftSolenoid.get() == Value.kForward)
    	{
    		RobotMap.gearShiftSolenoid.set(Value.kReverse);
    	}
    	else
    	{
    		RobotMap.gearShiftSolenoid.set(Value.kForward);
    	}
    	
    }
    
    public void openCubeGrabber() {
    	RobotMap.cubeGrabSolenoid.set(Value.kReverse);
    }
    
    public void closedCubeGrabber() {
    	RobotMap.cubeGrabSolenoid.set(Value.kForward);

    }
}

