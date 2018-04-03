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
	public JoystickButton shiftHighButton;
	public JoystickButton shiftLowButton;
	
	public XboxController mainXBoxController;
	public XboxController secondaryXBoxController;
	{
		//Main Driver Controller
		mainXBoxController = new XboxController(0);
		
//		Cube Grabber Buttons
//		Drop Cube Button
		cubeDropButton = new JoystickButton(mainXBoxController, 6);
		cubeDropButton.whileHeld(new CubeDropCommand());
//		Grab Cube Button
		cubeGrabButton = new JoystickButton(mainXBoxController, 5);
		cubeGrabButton.whileHeld(new CubeGrabCommand());

//		Gear Shift Buttons
//		Shift To High Gear
		shiftHighButton = new JoystickButton(mainXBoxController, 8);
		shiftHighButton.whenPressed(new GearShiftCommand(true));
//		Shift To Low Gear
		shiftLowButton = new JoystickButton(mainXBoxController, 7);
		shiftLowButton.whenPressed(new GearShiftCommand(false));

		//Secondary Driver Controller
		secondaryXBoxController = new XboxController(1);

//		Climber Button
		climbUpButton = new JoystickButton(secondaryXBoxController, 6);		
		climbUpButton.whileHeld(new ClimbUpCommand());

//		Forklift Buttons
//		Forklift Up
		cubeForkliftUpButton = new JoystickButton(secondaryXBoxController, 4);
		cubeForkliftUpButton.whileHeld(new ForkliftRaiseCommand());
//		Forklift Down
		cubeForkliftDownButton = new JoystickButton(secondaryXBoxController, 3);
		cubeForkliftDownButton.whileHeld(new ForkliftLowerCommand());

	}
}

