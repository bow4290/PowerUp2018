package org.usfirst.frc.team4290.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMiddleCrossBaselineOnLeft extends CommandGroup {

    public AutoMiddleCrossBaselineOnLeft() {

    	// TODO: Add Sequences
    	
    	//Grab Cube
    	addParallel(new CubeGrabCommand(), 0.5);
    	//While Moving Forward
    	addParallel(new MoveForwardCommand(12.0), 0.5);
    	
    	//Turn Left
    	addSequential(new TurnLeftCommand(90.0));
    	
    	//Move Past Switch
    	addSequential(new MoveForwardCommand(12.0), 2.5);
    	
    	//Turn Towards Scale
    	addSequential(new TurnRightCommand(90.0));
    	
    	//Move Past Baseline
    	addSequential(new MoveForwardCommand(6.0), 3.5);

    }
}
