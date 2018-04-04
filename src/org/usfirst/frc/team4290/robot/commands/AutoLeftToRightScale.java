package org.usfirst.frc.team4290.robot.commands;

import org.usfirst.frc.team4290.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeftToRightScale extends CommandGroup {

    public AutoLeftToRightScale() {
    	//Grab Cube
    	addSequential(new CubeGrabCommand(Robot.BOTH_ARM), 0.5);
    	
    	//Move Forward to Scale Staging Area
    	addSequential(new MoveForwardCommand(0.0, true), 2.3);
    	
    	//Turn Towards Opposite Side of Scale
    	addSequential(new TurnRightCommand(75.0));
    	
    	addSequential(new ForkliftRaiseCommand(), 0.5);
//    	
//    	//Move Forward to Scale Staging Area
    	addParallel(new MoveForwardCommand(0.0, false), 3.5);
    	addParallel(new ForkliftRaiseCommand(), 2.0);
//    	
//    	//Turn towards Switch
    	addSequential(new TurnLeftCommand(80.0));
//    	
//    	//Raise Forklift
    	addSequential(new ForkliftRaiseCommand(), 2.0);
//    	
//    	//Move Towards Scale
//    	addSequential(new MoveForwardCommand(0.0, true), 0.75);
//    	
//    	//Drop Cube
//    	addSequential(new CubeDropCommand(Robot.BOTH_ARM), 0.5);
     	
    }
}
