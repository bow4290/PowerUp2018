package org.usfirst.frc.team4290.robot.commands;

import org.usfirst.frc.team4290.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRightToLeftScale extends CommandGroup {

    public AutoRightToLeftScale() {
    	//Grab Cube
    	addSequential(new CubeGrabCommand(Robot.BOTH_ARM), 0.5);
    	
    	//Move Forward to Scale Staging Area
    	addSequential(new MoveForwardCommand(0.0, true), 3); 
    }
}
