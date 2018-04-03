package org.usfirst.frc.team4290.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRightScoreScale extends CommandGroup {

    public AutoRightScoreScale() {
    	
    	// TODO: Add Sequence
    	
    	//Grab Cube
    	addSequential(new CubeGrabCommand(), 0.5);
    	
    	//Move Forward to Scale Staging Area
    	addSequential(new MoveForwardCommand(0.0, true), 3.5);
    	
    	//Turn to Face Switch
    	addSequential(new TurnLeftCommand(90.0));
    	
    	//Raise Forklift
    	addSequential(new ForkliftRaiseCommand(), 4.0);
    	
    	//Move Towards Scale
    	addSequential(new MoveForwardCommand(0.0), 0.5);
    	
    	//Drop Cube in Scale
    	addSequential(new CubeDropCommand(), 0.5);
    	
    	//Move Away from Scale
//    	addSequential(new MoveBackwardCommand(), 1.0);
    	
    	//Lower Forklift at Same Time
//    	addSequential(new ForkliftLowerCommand(), 4.0);

    }
}
