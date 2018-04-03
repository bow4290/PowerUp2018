package org.usfirst.frc.team4290.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeftScoreSwitch extends CommandGroup {

    public AutoLeftScoreSwitch() {
    	
    	//TODO: Add Sequence
    	
    	//Grab Cube 1
    	addSequential(new CubeGrabCommand(), 0.5);
    	
    	//Raise Forklift to Switch Height
    	addParallel(new ForkliftRaiseCommand(), 2.5);
    	//While Moving Toward Switch Staging Area
    	addParallel(new MoveForwardCommand(0.0), 2.5);
    	
    	//Turn to Face Switch
    	addSequential(new TurnRightCommand(90.0));
    	
    	//Move Towards Switch
    	addSequential(new MoveForwardCommand(0.0), 1.0);
    	
    	//Drop Cube in Switch
    	addSequential(new CubeDropCommand(), 0.5);
    	
    	//Move Away from Switch
    	addParallel(new MoveBackwardCommand(), 1.0);
    	//While Lowering Forklift
    	addParallel(new ForkliftLowerCommand(), 2.5);

    	//2 Cube Switch Auto Testing
   	
    	//Turn Left Towards Scale
    	//addSequential(new TurnLeftCommand(90));
    	
    	//Move Forward Past Switch
    	//addSequential(new MoveForwardCommand(0.0), 0.75);
    	
    	//Turn Towards Cube 2
    	//addSequential(new TurnRightCommand(90));
    	
    	//Move Towards Cube 2
    	//addSequential(new MoveForwardCommand(0.0), 1.0);
    	
    	//Grab Cube 2
    	//addSequential(new CubeGrabCommand(), 0.5);
    	
    	//Move Backwards
    	//addParallel(new MoveBackwardCommand(), 0.5);
    	//While Raising Forklift
    	//addParallel(new ForkliftRaiseCommand(), 3.0);
    	
    	//Turn Towards Switch
    	//addSequential(new TurnRightCommand(90.0));
    	
    	//Drop Cube 2 in Switch
    	//addSequential(new CubeDropCommand(), 0.5);
    	
    	//Move Away from Switch
    	//addParallel(new MoveBackwardCommand(), 2.0);
    	//While Lowering Forklift
    	//addParallel(new ForkliftLowerCommand(), 2.0);
       
    }
}
