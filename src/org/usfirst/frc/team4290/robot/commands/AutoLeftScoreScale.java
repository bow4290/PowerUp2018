package org.usfirst.frc.team4290.robot.commands;

import org.usfirst.frc.team4290.robot.Robot;
import org.usfirst.frc.team4290.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeftScoreScale extends CommandGroup {

    public AutoLeftScoreScale() {
      
    	// TODO: Add Sequence
    	
    	//Grab Cube
    	addSequential(new CubeGrabCommand(Robot.BOTH_ARM), 0.5);
    	
    	//Move Forward to Scale Staging Area
    	addParallel(new MoveForwardCommand(0.0, true), 3.75);
    	addParallel(new ForkliftRaiseCommand(), 2.0);
    	
    	//Turn to Face Scale
    	addSequential(new TurnRightCommand(75.0));
    	
    	//Raise Forklift
    	addSequential(new ForkliftRaiseCommand(), 3.0);
    	
    	//Move Towards Scale
    	addSequential(new MoveForwardCommand(0.0), 0.85);
    	
    	//Drop Cube in Scale
    	addSequential(new CubeDropCommand(Robot.BOTH_ARM), 0.5);
    	
    	//Move Away from Scale
    	addSequential(new MoveBackwardCommand(), 0.75);
    	//Lower Forklift at Same Time
    	addSequential(new ForkliftLowerCommand(), 4.0);
    	
    	//Turn Towards Alliance Switch
    	addSequential(new TurnRightCommand(75.0));
    	
    	//Move Towards Alliance Switch
    	addSequential(new MoveForwardCommand(0.0, true), 1.5);
    	

     
    }
}
