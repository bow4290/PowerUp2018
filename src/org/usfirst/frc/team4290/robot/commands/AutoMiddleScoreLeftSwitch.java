package org.usfirst.frc.team4290.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMiddleScoreLeftSwitch extends CommandGroup {

    public AutoMiddleScoreLeftSwitch() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
    	//TODO
//    	addSequential(new CubeGrabCommand(), 1.0);
////    	moveForward command parallel
//    	addSequential(new MoveForwardCommand(12.0), 0.5);
//    	//cube grab command parallel    	// left turn command sequential
//    	addSequential(new TurnLeftCommand) );
//    	//move forward command sequential
//    	addSequential(new MoveForwardCommand(12.0), 2.5);
//    	//right turn command sequential
//    	addSequential(new TurnRightCommand() );
//    	//move forward command sequential
//    	addParallel(new MoveForwardCommand(6.0), 2.35);
//    	addParallel(new ForkliftRaiseCommand(), 1.0);
//    	//right turn command sequential
//    	addSequential(new TurnRightCommand() );
////    	raise fork lift command parallel
//    	addParallel(new ForkliftRaiseCommand(), 1.0);
//    	//move forward command parallel
//    	addParallel(new MoveForwardCommand(0.0), 1.0);
//    	//drop cube command sequential
//    	addSequential(new CubeDropCommand(), 1.0);
//    	//move backwards command parallel
//    	addParallel(new MoveBackwardCommand(), 1.0);
////    	lower fork lift command parallel
//    	addParallel(new ForkliftLowerCommand(), 1.0);
    	
    	addSequential(new CubeGrabCommand(), 1.0);
    	addSequential(new TurnLeftCommand(45.0));
    	
    	addParallel(new MoveForwardCommand(0.0), 4.0);
    	addParallel(new ForkliftRaiseCommand(), 2.0);
    	
    	addSequential(new TurnRightCommand(45.0));
    	
    	addSequential(new MoveForwardCommand(24.0));
    	
    	addSequential(new CubeDropCommand(), 1.0);
    	
    	addSequential(new MoveBackwardCommand(), 1.0);
    	
//    	addSequential(new MoveForwardCommand(), 4.0);
    	
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
