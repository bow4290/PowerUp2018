package org.usfirst.frc.team4290.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeftScoreSwitch extends CommandGroup {

    public AutoLeftScoreSwitch() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
    	// TODO: Add Sequence
    	// Add Grab Cube Sequence
    	addSequential(new CubeGrabCommand(), 1.0);
    	// Add Move Forward Sequence
    	addParallel(new ForkliftRaiseCommand(), 6.0);
    	addParallel(new MoveForwardCommand(0.0), 3.0);
    	// Add Turn Right Sequence
    	addSequential(new TurnRightCommand(90.0));
    	// Add Move Forward Parallel
    	addSequential(new MoveForwardCommand(0.0), 0.5);
    	// Add Drop Cube Sequence
    	addSequential(new CubeDropCommand(), 1.0);
    	// Add Move Backwards Parallel
    	addSequential(new MoveBackwardCommand(), 1.0);
    	// Add Lower Forklift Parallel
    	addSequential(new ForkliftLowerCommand(), 1.0);


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
