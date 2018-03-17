package org.usfirst.frc.team4290.robot;

import org.usfirst.frc.team4290.robot.commands.ClimbDownCommand;
import org.usfirst.frc.team4290.robot.commands.ClimbUpCommand;
import org.usfirst.frc.team4290.robot.commands.CubeDropCommand;
import org.usfirst.frc.team4290.robot.commands.CubeGrabCommand;
import org.usfirst.frc.team4290.robot.commands.ForkliftHoldCommand;
import org.usfirst.frc.team4290.robot.commands.ForkliftLowerCommand;
import org.usfirst.frc.team4290.robot.commands.ForkliftRaiseCommand;
import org.usfirst.frc.team4290.robot.commands.GearShiftCommand;
import org.usfirst.frc.team4290.robot.commands.MoveForwardCommand;
import org.usfirst.frc.team4290.robot.commands.TurnXDegrees;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public JoystickButton cubeDropButton;
	public JoystickButton cubeGrabButton;
	public JoystickButton cubeForkliftUpButton;
	public JoystickButton cubeForkliftDownButton;
	public JoystickButton climbUpButton;
//	public JoystickButton climberButton;
	public JoystickButton shiftHighButton;
	public JoystickButton shiftLowButton;
	
	public XboxController mainXBoxController;
	public XboxController secondaryXBoxController;
	{
		mainXBoxController = new XboxController(0);
		secondaryXBoxController = new XboxController(1);
		cubeDropButton = new JoystickButton(secondaryXBoxController, 1);
		cubeGrabButton = new JoystickButton(secondaryXBoxController, 2);
//		cubeDropButton = new JoystickButton(mainXBoxController, 9);
//		cubeGrabButton = new JoystickButton(mainXBoxController, 10);
//		Uncomment for competition
//		cubeForkliftUpButton = new JoystickButton(secondaryXBoxController, 1);
//		cubeForkliftDownButton = new JoystickButton(secondaryXBoxController, 0);
		
//		Climber
		climbUpButton = new JoystickButton(secondaryXBoxController, 6);
//		climberButton = new JoystickButton(mainXBoxController, 5);
		
//		Uncomment for testing
//		cubeForkliftUpButton = new JoystickButton(mainXBoxController, 4);
//		cubeForkliftDownButton = new JoystickButton(mainXBoxController, 3);
		cubeForkliftUpButton = new JoystickButton(secondaryXBoxController, 4);
		cubeForkliftDownButton = new JoystickButton(secondaryXBoxController, 3);
		
		shiftHighButton = new JoystickButton(mainXBoxController, 6);
		shiftLowButton = new JoystickButton(mainXBoxController, 5);
//		testGyroDELETE = new JoystickButton(xBoxController, 1);

		//Cube Grabbing
		cubeDropButton.whileHeld(new CubeDropCommand());
		cubeGrabButton.whileHeld(new CubeGrabCommand());
//		
		climbUpButton.whileHeld(new ClimbUpCommand());
//		climberButton.whileHeld(new ClimbDownCommand());
		
		cubeForkliftUpButton.whileHeld(new ForkliftRaiseCommand());
		cubeForkliftDownButton.whileHeld(new ForkliftLowerCommand());
		cubeForkliftDownButton.whenReleased(new ForkliftHoldCommand());
		shiftHighButton.whenPressed(new GearShiftCommand(true));
		shiftLowButton.whenPressed(new GearShiftCommand(false));
//		testGyroDELETE.whileHeld(new MoveForwardCommand());
	}
}

