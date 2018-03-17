package org.usfirst.frc.team4290.robot.commands;

import org.usfirst.frc.team4290.robot.Robot;
import org.usfirst.frc.team4290.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeftScoreScale extends CommandGroup {

    public AutoLeftScoreScale() {
        // Add Commands here:
        //      addSequential(new Command2());
        // these will run in order.
    	
    	// TODO: Add Sequence
    	// Add Grab Cube Sequence
    	addSequential(new CubeDropCommand(), 1.0);
    	// Add Move Forward Sequence
    	addParallel(new MoveForwardCommand(0.0), 7.75);
    	// Add Raise Forklift Parallel
    	addParallel(new ForkliftRaiseCommand(), 3.0);
    	// Add Turn Right Sequence
    	addSequential(new AutoTurnRightCommand(), 2.0);
    	// Add Move Forward Parallel
    	addSequential(new MoveForwardCommand(0.0), 2.0);
    	// Add Drop Cube Sequence
    	addSequential(new CubeGrabCommand(), 1.0);
    	// Add Move Backwards Parallel
    	addSequential(new MoveBackwardCommand(), 1.0);
    	// Add Lower Forklift Parallel
    	addSequential(new ForkliftLowerCommand(), 5.0);

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
