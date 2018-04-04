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
    
    //Shift into High Gear
    public void shiftHigh() {
    	RobotMap.gearShiftSolenoid.set(Value.kForward);
    }
    
    //Shift into Low Gear
    public void shiftLow() {
    	RobotMap.gearShiftSolenoid.set(Value.kReverse);
    }
    
    //Release Cube
    public void openCubeGrabber() {
    	RobotMap.cubeGrabLeftSolenoid.set(Value.kForward);
    	RobotMap.cubeGrabRightSolenoid.set(Value.kForward);
//    	RobotMap.cubeGrabSolenoid.set(Value.kForward);

    }
    
    //Grab Cube
    public void closedCubeGrabber() {
    	RobotMap.cubeGrabLeftSolenoid.set(Value.kReverse);
    	RobotMap.cubeGrabRightSolenoid.set(Value.kReverse);
//    	RobotMap.cubeGrabSolenoid.set(Value.kReverse);
    	
    }
    
    //Open Left Arm
    public void openLeftGrabber() {
    	RobotMap.cubeGrabLeftSolenoid.set(Value.kReverse);
    	
    }
    
    //Open Right Arm
    public void openRightGrabber() {
    	RobotMap.cubeGrabRightSolenoid.set(Value.kReverse);
    	
    }
    
    //Close Left Arm
    public void closeLeftGrabber() {
    	RobotMap.cubeGrabLeftSolenoid.set(Value.kForward);
    	
    }
    
    //Close Right Arm
    public void closeRightGrabber() {
    	RobotMap.cubeGrabRightSolenoid.set(Value.kForward);
    	
    }
}

