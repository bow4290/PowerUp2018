package org.usfirst.frc.team4290.robot;

import org.usfirst.frc.team4290.robot.commands.ArmLowerCommand;
import org.usfirst.frc.team4290.robot.commands.ArmRaiseCommand;
import org.usfirst.frc.team4290.robot.commands.ClimbDownCommand;
import org.usfirst.frc.team4290.robot.commands.ClimbUpCommand;
import org.usfirst.frc.team4290.robot.commands.CubeDropCommand;
import org.usfirst.frc.team4290.robot.commands.CubeGrabCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick rightJoystick;
	public Joystick leftJoystick;
	public JoystickButton cubeDropButton;
	public JoystickButton cubeGrabButton;
	public JoystickButton armRaiseButton;
	public JoystickButton armLowerButton;
	public JoystickButton cubeForkliftUpButton;
	public JoystickButton cubeForkliftDownButton;
	public JoystickButton climbUpButton;
	public JoystickButton climbDownButton;

	{
		rightJoystick = new Joystick(0);
		leftJoystick = new Joystick(1);
		cubeDropButton = new JoystickButton(rightJoystick, 5);
		cubeGrabButton = new JoystickButton(rightJoystick, 4);
		armRaiseButton = new JoystickButton(rightJoystick, 3);
		armLowerButton = new JoystickButton(rightJoystick, 2);
		cubeForkliftUpButton = new JoystickButton(leftJoystick,3);
		cubeForkliftDownButton = new JoystickButton(leftJoystick,2);
		climbUpButton = new JoystickButton(rightJoystick,1);
		climbDownButton = new JoystickButton(leftJoystick,1);
		
		//Cube Grabbing
		cubeDropButton.whenPressed(new CubeDropCommand());
		cubeGrabButton.whenPressed(new CubeGrabCommand());
		
		//Cube Arm Raise/Lower
		armRaiseButton.whileHeld(new ArmRaiseCommand());
		armRaiseButton.whileHeld(new ArmLowerCommand());
		
		//Climber
		climbUpButton.whileHeld(new ClimbUpCommand());
		climbDownButton.whileHeld(new ClimbDownCommand());
	}
}

