package org.usfirst.frc.team4290.robot.commands;

import org.usfirst.frc.team4290.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMiddleCrossBaselineOnRight extends CommandGroup {

    public AutoMiddleCrossBaselineOnRight() {
    	
    	// TODO: Add Sequences
    	
    	//Grab Cube
    	addParallel(new CubeGrabCommand(Robot.BOTH_ARM), 0.5);
    	//While Moving Forward
    	addParallel(new MoveForwardCommand(12.0), 0.5);
    	
    	//Turn Right
    	addSequential(new TurnRightCommand(90.0));
    	
    	//Move Past Switch
    	addSequential(new MoveForwardCommand(12.0), 2.5);
    	
    	//Turn Towards Scale
    	addSequential(new TurnLeftCommand(90.0));
    	
    	//Move Past Baseline
    	addSequential(new MoveForwardCommand(0.0), 3.5);

    }
}
