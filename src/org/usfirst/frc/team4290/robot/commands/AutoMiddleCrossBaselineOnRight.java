package org.usfirst.frc.team4290.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMiddleCrossBaselineOnRight extends CommandGroup {

    public AutoMiddleCrossBaselineOnRight() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
    	// TODO: Add Sequences
    	addSequential(new CubeGrabCommand(), 1.0);
    	//Add Move Forward Sequence
    	//addSequential(new MoveForwardCommand(0.0), 4.0);
    	addSequential(new AutoMoveForwardCommand(), 4.0);
    	// Add Left Turn Sequence
    	//addSequential(new TurnRightCommand(90.0);
    	addSequential(new AutoTurnRightCommand(), 2.0);
    	// Add Move Forward Sequence
    	//addSequential(new MoveForwardCommand(24.0), 4.0);
    	addSequential(new AutoMoveForwardCommand(), 2.5);
    	// Add Turn Right Sequence
    	//addSequential(new TurnLeftCommand(90.0), 3.0);
    	addSequential(new AutoTurnLeftCommand(), 2.0);
    	// Add Move Forward Sequence
    	//addSequential(new MoveForwardCommand(12.0), 4.0);
    	addSequential(new AutoMoveForwardCommand(), 4.0);

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
