package org.usfirst.frc.team4290.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMiddleScoreRightSwitch extends CommandGroup {

    public AutoMiddleScoreRightSwitch() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	//TODO
    	//moveForward command parallel
    	addParallel(new MoveForwardCommand(), 2.0);
    	//cube grab command parallel
//    	addParallel(new CubeGrabCommand(), 1.0);
    	// right turn command sequential
    	addSequential(new TurnRightCommand());
    	//move forward command sequential
    	addSequential(new MoveForwardCommand(), 3.25);
    	//left turn command sequential
    	addSequential(new TurnLeftCommand());
    	//move forward command sequential
//    	addSequential(new MoveForwardCommand(), 1.0);
    	//Left turn command sequential
//    	addSequential(new TurnLeftCommand(), 1.0);
    	//raise fork lift command parallel
//    	addParallel(new ForkliftRaiseCommand(), 1.0);
    	//move forward command parallel
//    	addParallel(new MoveForwardCommand(), 1.0);
    	//drop cube command sequential
//    	addSequential(new CubeDropCommand(), 1.0);
    	//move backwards command parallel
//    	addParallel(new MoveBackwardCommand(), 1.0);
    	//lower fork lift command parallel
//    	addParallel(new ForkliftLowerCommand(), 1.0);

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
