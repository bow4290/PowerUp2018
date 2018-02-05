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
//    	moveForward command parallel
    	addParallel(new MoveForwardCommand(), 1.0);
    	//cube grab command parallel
//    	addParallel(new CubeGrabCommand(), 1.0);
    	// left turn command sequential
    	addSequential(new TurnLeftCommand() );
    	//move forward command sequential
    	addSequential(new MoveForwardCommand(), 3.5);
    	//right turn command sequential
    	addSequential(new TurnRightCommand() );
    	//move forward command sequential
    	addSequential(new MoveForwardCommand(), 2.0);
    	//right turn command sequential
    	addSequential(new TurnRightCommand() );
//    	raise fork lift command parallel
//    	addParallel(new ForkliftRaiseCommand(), 1.0);
    	//move forward command parallel
//    	addParallel(new MoveForwardCommand(), 1.0);
    	//drop cube command sequential
//    	addSequential(new CubeDropCommand(), 1.0);
    	//move backwards command parallel
//    	addParallel(new MoveBackwardCommand(), 1.0);
//    	lower fork lift command parallel
//    	addParallel(new ForkliftLowerCommand(), 1.0);
    	
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
