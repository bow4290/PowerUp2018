package org.usfirst.frc.team4290.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMiddleScoreLeftScale extends CommandGroup {

    public AutoMiddleScoreLeftScale() {
    	
    	addSequential(new CubeGrabCommand(), 1.0);
    	
    	//addSequential(new MoveForwardCommand(0.0), 1.0);
    	addSequential(new AutoMoveForwardCommand(), 1.0);
    	
    	//addSequential(new TurnLeftCommand(90));
    	addSequential(new AutoTurnLeftCommand(), 2.0);
    	
    	//addSequential(new MoveForwardCommand(24.0), 4.0);
    	addSequential(new AutoMoveForwardCommand(), 4.0);
    	
    	//addSequential(new TurnRightCommand(90.0), 3.0);
    	addSequential(new AutoTurnRightCommand(), 2.0);
    	
    	addParallel(new ForkliftRaiseCommand(), 5.0);
    	//addParallel(new MoveForwardCommand(0.0), 8.0);
    	addParallel(new AutoMoveForwardCommand(), 8.0);
    	
    	//addSequential(new TurnRightCommand(90.0), 2.0);
    	addSequential(new AutoTurnRightCommand(), 2.0);
    	
//    	addSequential(new MoveForwardCommand(0.0), 1.0);
    	addSequential(new CubeDropCommand(), 1.0);
    	
    	addParallel(new MoveBackwardCommand(), 1.0);
    	addParallel(new ForkliftLowerCommand(), 5.0);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

}
