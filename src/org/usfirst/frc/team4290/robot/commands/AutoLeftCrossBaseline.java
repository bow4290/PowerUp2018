package org.usfirst.frc.team4290.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeftCrossBaseline extends CommandGroup {

    public AutoLeftCrossBaseline(boolean scale) {
     
    	//TODO: Add Sequence
    	//Grab Cube
    	addSequential(new CubeGrabCommand(), 0.5);
    	
    	//Move Forward Past Baseline
    	addSequential(new MoveForwardCommand(0.0), 3.5);
    	
    	if(scale)
    	{
    		addSequential(new ForkliftRaiseCommand(), 4.0);
    	}
    	
    }
    
}
