package org.usfirst.frc.team4290.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMiddleScoreLeftScale extends CommandGroup {

    public AutoMiddleScoreLeftScale() {
    	
    	addSequential(new MoveForwardCommand(12.0), 0.5);
    	addSequential(new TurnLeftCommand());
    	addSequential(new MoveForwardCommand(12.0), 2.5);
    	addSequential(new TurnRightCommand());
    	addSequential(new MoveForwardCommand(6.0), 5.0);
    	addSequential(new TurnRightCommand());
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

}
