package org.usfirst.frc.team4290.robot;

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
	
	public OI()
	{
		rightJoystick = new Joystick(0);
		leftJoystick = new Joystick(1);
		cubeDropButton = new JoystickButton(rightJoystick, 5);
		cubeGrabButton = new JoystickButton(rightJoystick, 4);
		
		//Cube Grabbing
		cubeDropButton.whenPressed(new CubeDropCommand());
		cubeGrabButton.whenPressed(new CubeGrabCommand());
		
		
	}
}

