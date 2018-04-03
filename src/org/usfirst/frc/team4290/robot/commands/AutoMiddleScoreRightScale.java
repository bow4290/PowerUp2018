package org.usfirst.frc.team4290.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMiddleScoreRightScale extends CommandGroup {

    public AutoMiddleScoreRightScale() {
    	
    	//TODO: Add Sequence
    	
    	//Grab Cube
    	addParallel(new CubeGrabCommand(), 0.5);
    	//While Moving Forward
    	addParallel(new MoveForwardCommand(0.0), 0.5);
    	
    	//Turn Right
    	addSequential(new TurnRightCommand(90.0));
    	
    	//Move Past Switch
    	addSequential(new MoveForwardCommand(12.0), 2.5);
    	
    	//Turn Left Towards Scale Staging Area
    	addSequential(new TurnLeftCommand(90.0));
    	
    	//Raise Forklift to Scale Height
    	addParallel(new ForkliftRaiseCommand(), 5.0);
    	//While Moving Towards Scale Staging Area
    	addParallel(new MoveForwardCommand(10.0), 8.0);
    	
    	//Turn Towards Scale
    	addSequential(new TurnLeftCommand(90.0));
    	
    	//Drop Cube in Scale
    	addSequential(new CubeDropCommand(), 1.0);
    	
    	//Move Away from Scale
//    	addParallel(new MoveBackwardCommand(), 1.0);
    	//While Lowering Forklift
    	addParallel(new ForkliftLowerCommand(), 5.0);
    }
}
