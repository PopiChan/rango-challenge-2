// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.Conveyer;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.conveyer;
import frc.robot.subsystems.Chasis.ChasisRight;
import frc.robot.subsystems.climb.ClimbClamp;
import frc.robot.subsystems.climb.ClimbExtention;
import frc.robot.subsystems.climb.ClimbRotation;
import ma5951.utils.JoystickContainer;
import ma5951.utils.commands.ControlCommandPID;
import ma5951.utils.commands.MotorCommand;
import ma5951.utils.commands.PistonCommand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import ma5951.utils.controllers.PIDControllerConstants;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings(
    );
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //intake \/
    JoystickContainer.AButton.whileActiveContinuous(new SequentialCommandGroup(
                                                    new PistonCommand(Intake.getinstance(), true),
                                                    new ParallelCommandGroup(
                                                    new MotorCommand(Intake.getinstance(), -0.8)),
                                                    new MotorCommand(Conveyer.getinstance(), 0.6))).
                                       whenInactive(new PistonCommand(Intake.getinstance(), false));
    //intake /\

    //conveyer \/
    JoystickContainer.AButton.whileActiveContinuous(new MotorCommand(Conveyer.getinstance(), 0.8));
    //conveyer /\

    JoystickContainer.BButton.whileActiveContinuous(new ControlCommandPID(Shooter.getinstance(), 3600, new PIDControllerConstants(150, 0.000001, 0, 0.000, 0.0003, 1, -1), false));
  
    //climb \/
    JoystickContainer.LB.whileActiveContinuous(new MotorCommand(ClimbExtention.getinstance(), 0.8));
    JoystickContainer.RB.whileActiveContinuous(new MotorCommand(ClimbExtention.getinstance(), -0.8));
    
    JoystickContainer.triggerL.whileActiveContinuous(new MotorCommand(ClimbRotation.getinstance(), 0.8));
    JoystickContainer.triggerL.whileActiveContinuous(new MotorCommand(ClimbRotation.getinstance(), -0.8));
    
    JoystickContainer.POVDown.whileActiveContinuous(new MotorCommand(ClimbClamp.getinstance(), 0.5));
    JoystickContainer.POVDown.whileActiveContinuous(new MotorCommand(ClimbClamp.getinstance(), -0.5));
    //climb /\
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
