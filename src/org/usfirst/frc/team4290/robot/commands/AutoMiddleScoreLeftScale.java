package org.usfirst.frc.team4290.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMiddleScoreLeftScale extends CommandGroup {

    public AutoMiddleScoreLeftScale() {
    	
    	addSequential(new CubeGrabCommand(), 1.0);
    	
    	addSequential(new MoveForwardCommand(0.0), 1.0);
    	
    	addSequential(new TurnLeftCommand(85.0));
    	
    	addSequential(new MoveForwardCommand(40.0));
    	
    	addSequential(new TurnRightCommand(85.0));
    	
    	addParallel(new ForkliftRaiseCommand(), 5.0);
    	addParallel(new MoveForwardCommand(10.0), 8.0);
    	
    	addSequential(new TurnRightCommand(90.0));
    	
//    	addSequential(new MoveForwardCommand(0.0), 1.0);
    	addSequential(new CubeDropCommand(), 1.0);
    	
//    	addParallel(new MoveBackwardCommand(), 1.0);
    	addParallel(new ForkliftLowerCommand(), 5.0);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

}
