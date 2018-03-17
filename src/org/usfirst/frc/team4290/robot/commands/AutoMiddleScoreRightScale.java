package org.usfirst.frc.team4290.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMiddleScoreRightScale extends CommandGroup {

    public AutoMiddleScoreRightScale() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	addSequential(new CubeGrabCommand(), 1.0);
    	
    	addSequential(new MoveForwardCommand(12.0), 0.5);
    	
    	addSequential(new TurnRightCommand(90.0));
    	
    	addSequential(new MoveForwardCommand(12.0), 2.5);
    	
    	addSequential(new TurnLeftCommand(90.0));
    	
    	addParallel(new ForkliftRaiseCommand(), 5.0);
    	addParallel(new MoveForwardCommand(6.0), 5.0);
    	
    	addSequential(new TurnLeftCommand(90.0));
    	
//    	addSequential(new MoveForwardCommand(0.0), 1.0);
    	addSequential(new CubeDropCommand(), 1.0);
    	
    	addParallel(new MoveBackwardCommand(), 1.0);
    	addParallel(new ForkliftLowerCommand(), 5.0);

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
