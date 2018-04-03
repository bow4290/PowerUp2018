package org.usfirst.frc.team4290.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMiddleScoreLeftScale extends CommandGroup {

    public AutoMiddleScoreLeftScale() {
    	
    	//TODO: Add Sequence
    	
    	//Grab Cube
    	addParallel(new CubeGrabCommand(), 0.5);
    	//While Moving Forward
    	addParallel(new MoveForwardCommand(0.0), 0.5);
    	
    	//Turn Left
    	addSequential(new TurnLeftCommand(85.0));
    	
    	//Move Past Switch
    	addSequential(new MoveForwardCommand(40.0));
    	
    	//Turn Right Towards Scale Staging Area
    	addSequential(new TurnRightCommand(85.0));
    	
    	//Raise Forklift to Scale Height
    	addParallel(new ForkliftRaiseCommand(), 5.0);
    	//While Moving Towards Scale Staging Area
    	addParallel(new MoveForwardCommand(10.0), 8.0);
    	
    	//Turn Towards Scale
    	addSequential(new TurnRightCommand(90.0));
    	
    	//Move Towards Scale
    	addSequential(new MoveForwardCommand(0.0), 1.0);
    	
    	//Drop Cube in Scale
    	addSequential(new CubeDropCommand(), 1.0);
    	
    	//Move Away from Scale
//    	addParallel(new MoveBackwardCommand(), 1.0);
    	//While Lowering Forklift
    	addParallel(new ForkliftLowerCommand(), 5.0);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

}
