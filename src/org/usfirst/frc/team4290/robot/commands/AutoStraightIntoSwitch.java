package org.usfirst.frc.team4290.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoStraightIntoSwitch extends CommandGroup {

    public AutoStraightIntoSwitch() {
        // Add Commands here:
    	addSequential(new CubeGrabCommand(), 1.0);
    	
//    	addParallel(new ForkliftHoldCommand(), 5.0);
    	
    	//addSequential(new MoveForwardCommand(24.0), 3.0);
    	addSequential(new AutoMoveForwardCommand(), 3.0);
    	
    	addSequential(new ForkliftRaiseCommand(), 2.0);
    	
    	addSequential(new CubeDropCommand(), 1.0);
    	
    	addSequential(new MoveBackwardCommand(), 1.0);
    	
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

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
