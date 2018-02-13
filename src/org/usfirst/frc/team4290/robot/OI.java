package org.usfirst.frc.team4290.robot;

import org.usfirst.frc.team4290.robot.commands.ArmLowerCommand;
import org.usfirst.frc.team4290.robot.commands.ArmRaiseCommand;
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
//	public Joystick rightJoystick;
//	public Joystick leftJoystick;
	public JoystickButton cubeDropButton;
	public JoystickButton cubeGrabButton;
	public JoystickButton armRaiseButton;
	public JoystickButton armLowerButton;
	public JoystickButton cubeForkliftUpButton;
	public JoystickButton cubeForkliftDownButton;
	public JoystickButton climbUpButton;
	public JoystickButton climbDownButton;
	public JoystickButton gearShiftButton;
	
	public XboxController xBoxController;
//	public JoystickButton testGyroDELETE;

	{
		xBoxController = new XboxController(0);
//		rightJoystick = new Joystick(0);
//		leftJoystick = new Joystick(1);
//		cubeDropButton = new JoystickButton(xBoxController, 5);
//		cubeGrabButton = new JoystickButton(xBoxController, 4);
//		armRaiseButton = new JoystickButton(xBoxController, 3);
//		armLowerButton = new JoystickButton(xBoxController, 2);
//		cubeForkliftUpButton = new JoystickButton(xBoxController, 3);
//		cubeForkliftDownButton = new JoystickButton(xBoxController, 4);
//		climbUpButton = new JoystickButton(xBoxController, 1);
//		climbDownButton = new JoystickButton(xBoxController, 5);
//		gearShiftButton = new JoystickButton(xBoxController, 10);
//		testGyroDELETE = new JoystickButton(xBoxController, 1);

		//Cube Grabbing
//		cubeDropButton.whenPressed(new CubeDropCommand());
//		cubeGrabButton.whenPressed(new CubeGrabCommand());
//		
		//Cube Arm Raise/Lower
//		armRaiseButton.whileHeld(new ArmRaiseCommand());
//		armRaiseButton.whileHeld(new ArmLowerCommand());
//		.
		//Climber
//		climbUpButton.whileHeld(new ClimbUpCommand());
//		climbDownButton.whileHeld(new ClimbDownCommand());
//		
//		cubeForkliftUpButton.whileHeld(new ForkliftRaiseCommand());
//		cubeForkliftDownButton.whileHeld(new ForkliftLowerCommand());
//		gearShiftButton.whenPressed(new GearShiftCommand());
//		testGyroDELETE.whileHeld(new MoveForwardCommand());
	}
}

