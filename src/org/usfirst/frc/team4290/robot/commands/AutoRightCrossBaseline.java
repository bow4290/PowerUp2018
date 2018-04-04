package org.usfirst.frc.team4290.robot.commands;

import org.usfirst.frc.team4290.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRightCrossBaseline extends CommandGroup {

    public AutoRightCrossBaseline(boolean scale) {
    	
    	// TODO Sequence to add:
    	
    	//Grab Cube
    	addSequential(new CubeGrabCommand(Robot.BOTH_ARM), 0.5);
    	
    	//Move Forward Past Baseline
    	addSequential(new MoveForwardCommand(0.0), 3.5);
    	
    	if(scale)
    	{
    		addSequential(new ForkliftRaiseCommand(), 4.0);
    	}
    	
    }
}
