package org.usfirst.frc.team4290.robot.commands;

import org.usfirst.frc.team4290.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRightScoreSwitch extends CommandGroup {

    public AutoRightScoreSwitch() {

    	// TODO: Add Sequence
    	
    	//Grab Cube
    	addSequential(new CubeGrabCommand(Robot.BOTH_ARM), 0.5);
    	
    	//Raise Forklift
    	addParallel(new ForkliftRaiseCommand(), 2.5);
    	//While Moving Forward
    	addParallel(new MoveForwardCommand(0.0), 2.5);
    	
    	//Turn Toward Switch
    	addSequential(new TurnRightCommand(90.0));
    	
    	//Move Toward Switch
    	addSequential(new MoveForwardCommand(0.0), 0.5);
    	
    	//Drop Cube in Switch
    	addSequential(new CubeDropCommand(Robot.BOTH_ARM), 1.0);
    	
    	//Move Away from Switch
    	addSequential(new MoveBackwardCommand(), 1.0);
    	
    	//Lower Forklift
    	addSequential(new ForkliftLowerCommand(), 3.0);
    	
    	//2 Cube Switch Auto Testing
    	
    	//Turn Toward Scale
//    	addSequential(new TurnRightCommand(90));
    	
    	//Move Pase Switch
//    	addSequential(new MoveForwardCommand(0.0), 0.75);
    	
    	//Turn Toward Cube 2
//    	addSequential(new TurnLeftCommand(90));
    	
    	//Move Toward Cube 2
//    	addSequential(new MoveForwardCommand(0.0), 1.0);
    	
    	//Grab Cube 2
//    	addSequential(new CubeGrabCommand(), 0.5);
    	
    	//Move Past Switch
//    	addParallel(new MoveBackwardCommand(), 0.5);
    	//While Raising Forklift
//    	addParallel(new ForkliftRaiseCommand(), 3.0);
    	
    	//Turn Towards Switch
//    	addSequential(new TurnLeftCommand(90.0));
    	
    	//Drop Cube 2 in Switch
//    	addSequential(new CubeDropCommand(), 0.5);
    	
    	//Move Away from Switch
//    	addParallel(new MoveBackwardCommand(), 2.0);
    	//While Lowering Forklift
//    	addParallel(new ForkliftLowerCommand(), 2.0);

    }
}
