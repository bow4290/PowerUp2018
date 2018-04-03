package org.usfirst.frc.team4290.robot.subsystems;

import org.usfirst.frc.team4290.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClimberSubsystem extends Subsystem {

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    //Climb Upwards
    public void climbUp()
    {
    	RobotMap.climberMotor.set(1.0);
    }
    
    //Climb Down
    public void climbDown()
    {
    	RobotMap.climberMotor.set(-0.9);
    }
    
    //Stop Climb
    public void stop()
    {
    	RobotMap.climberMotor.set(0);
    }
}

