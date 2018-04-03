package org.usfirst.frc.team4290.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMiddleScoreLeftSwitch extends CommandGroup {

    public AutoMiddleScoreLeftSwitch() {
    	
    	//Grab Cube 1 While Moving Forward
    	addSequential(new CubeGrabCommand(), 0.5);
    	//addParallel(new MoveForwardCommand(0.0), 0.5);
    	addSequential(new MoveForwardCommand(0.0, true), 0.45);

    	//Turn Toward Switch
    	addSequential(new TurnLeftCommand(50.0));
    	
    	//Move Toward Switch while Raising Forklift
    	addParallel(new ForkliftRaiseCommand(), 1.5);
    	//addParallel(new MoveForwardCommand(0.0), 2.25);
    	addParallel(new MoveForwardCommand(0.0, true), 1.0);
    	
    	//Turn to Face Switch
    	addSequential(new TurnRightCommand(27.5));
    	
    	//Move to Edge of Switch
    	//addSequential(new MoveForwardCommand(0.0), 1.0);
    	addSequential(new MoveForwardCommand(0.0, true), 1.0);
    	
    	//Drop Cube 1 in Switch
    	addSequential(new CubeDropCommand(), 0.5);
    	
    	//Back away from Switch
    	addSequential(new MoveBackwardCommand(true), 1.0);
    	
    	//Lower Forklift
    	addSequential(new ForkliftLowerCommand(), 1.5);
    	
    	//Turn to Face Cube Stack
    	addSequential(new TurnRightCommand(30.0, true));
    	
    	//Move Towards Cube Stack
    	addSequential(new MoveForwardCommand(0.0, true), 1.45);
    	
    	//Face Cube Stack
    	addSequential(new TurnLeftCommand(30.0, true));
    	
    	//Move towards Cube Stack
    	addSequential(new MoveForwardCommand(0.0, true), .75);
    	
    	//Grab Cube 2
    	addSequential(new CubeGrabCommand(), 0.5);
    	
    	//Move away from Cube Stack
    	addSequential(new MoveBackwardCommand(true), 0.5);
    	
    	//Turn Towards Switch Staging Area
//    	addSequential(new TurnLeftCommand(60.0, true));
    	
    	//Move Towards Switch Staging Area
//    	addSequential(new MoveForwardCommand(0.0, true), 1.0);
    	
    	//While Raising Forklift
//    	addSequential(new ForkliftRaiseCommand(), 2.0);
    	
    	//Turn Towards Switch
//    	addSequential(new TurnRightCommand(30.0, true));
    	
    	//Move Towards Switch
//    	addSequential(new MoveForwardCommand(0.0, true), 1.0);
    	
    	//Drop Cube 2 in Switch
//    	addSequential(new CubeDropCommand(), 0.5);
    	
    }
}
