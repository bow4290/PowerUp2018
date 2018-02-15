package org.usfirst.frc.team4290.robot.subsystems;

import org.usfirst.frc.team4290.robot.RobotMap;

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
    	RobotMap.gearShiftSolenoid.set(!RobotMap.gearShiftSolenoid.get());

    }
    
    public void openCubeGrabber() {
    	RobotMap.cubeGrabSolenoid.set(true);
    }
    
    public void closedCubeGrabber() {
    	RobotMap.cubeGrabSolenoid.set(false);

    }
}

