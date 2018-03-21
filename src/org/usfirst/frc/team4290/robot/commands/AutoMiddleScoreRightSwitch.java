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
//    	//cube grab command parallel
//    	addSequential(new CubeGrabCommand(), 1.0);
//    	//moveForward command parallel
//    	addSequential(new MoveForwardCommand(0.0), 0.5);
//    	// right turn command sequential
//    	addSequential(new TurnRightCommand(), 1.0);
//    	//move forward command sequential
//    	addSequential(new MoveForwardCommand(12.0), 2.5);
//    	//left turn command sequential
//    	addSequential(new TurnLeftCommand());
//    	//move forward command sequential
//    	addParallel(new MoveForwardCommand(6.0), 2.35);
//    	addParallel(new ForkliftRaiseCommand(), 2.0);
//    	//Left turn command sequential
//    	addSequential(new TurnLeftCommand());
//    	//raise fork lift command parallel
//    	addParallel(new ForkliftRaiseCommand(), 1.0);
//    	//move forward command parallel
//    	addParallel(new MoveForwardCommand(0.0), 1.0);
//    	//drop cube command sequential
//    	addSequential(new CubeDropCommand(), 1.0);
//    	//move backwards command parallel
//    	addParallel(new MoveBackwardCommand(), 1.0);
//    	//lower fork lift command parallel
//    	addParallel(new ForkliftLowerCommand(), 5.0);
    	
    	addSequential(new CubeGrabCommand(), 1.0);
    	
    	//addSequential(new MoveForwardCommand(0.0), 1.0);
    	addSequential(new AutoMoveForwardCommand(), 1.0);
    	
    	//addSequential(new TurnRightCommand(90.0));
    	addSequential(new AutoTurnRightCommand(), 1.0);
    	
//    	addParallel(new CubeGrabCommand());
//    	addParallel(new AutoTurnLeftCommand());
//    	
//    	addParallel(new MoveForwardCommand(24.0), 4.0);
    	addParallel(new AutoMoveForwardCommand(), 4.0);
    	addParallel(new ForkliftRaiseCommand(), 3.0);
    	
    	//addSequential(new TurnLeftCommand(90.0);
    	addSequential(new AutoTurnLeftCommand(), 1.0);
    	
    	//addSequential(new MoveForwardCommand(0.0), 2.0);
    	addSequential(new AutoMoveForwardCommand(), 2.0);
//    	
    	addSequential(new CubeDropCommand());
//    	
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
