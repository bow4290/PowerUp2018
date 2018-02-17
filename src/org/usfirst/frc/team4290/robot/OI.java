package org.usfirst.frc.team4290.robot;

import org.usfirst.frc.team4290.robot.commands.ClimbDownCommand;
import org.usfirst.frc.team4290.robot.commands.ClimbUpCommand;
import org.usfirst.frc.team4290.robot.commands.CubeDropCommand;
import org.usfirst.frc.team4290.robot.commands.CubeGrabCommand;
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
	public JoystickButton climbDownButton;
	public JoystickButton gearShiftButton;
	
	public XboxController mainXBoxController;
	public XboxController secondaryXBoxController;
	{
		mainXBoxController = new XboxController(0);
		secondaryXBoxController = new XboxController(1);
		cubeDropButton = new JoystickButton(mainXBoxController, 6);
		cubeGrabButton = new JoystickButton(mainXBoxController, 5);
//		Uncomment for competition
//		cubeForkliftUpButton = new JoystickButton(secondaryXBoxController, 1);
//		cubeForkliftDownButton = new JoystickButton(secondaryXBoxController, 0);
		
//		Climber
		climbUpButton = new JoystickButton(mainXBoxController, 4);
		climbDownButton = new JoystickButton(mainXBoxController, 3);
		
//		Uncomment for testing
		cubeForkliftUpButton = new JoystickButton(mainXBoxController, 2);
		cubeForkliftDownButton = new JoystickButton(mainXBoxController, 1);
		
		gearShiftButton = new JoystickButton(mainXBoxController, 9);
//		testGyroDELETE = new JoystickButton(xBoxController, 1);

		//Cube Grabbing
		cubeDropButton.whenPressed(new CubeDropCommand());
		cubeGrabButton.whenPressed(new CubeGrabCommand());
//		
		climbUpButton.whileHeld(new ClimbUpCommand());
		climbDownButton.whileHeld(new ClimbDownCommand());
		
		cubeForkliftUpButton.whileHeld(new ForkliftRaiseCommand());
		cubeForkliftDownButton.whileHeld(new ForkliftLowerCommand());
		gearShiftButton.whenPressed(new GearShiftCommand());
//		testGyroDELETE.whileHeld(new MoveForwardCommand());
	}
}

