// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.climb;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import ma5951.utils.motor.MA_Falcon;
import ma5951.utils.subsystem.MotorSubsystem;

public class ClimbRotation implements MotorSubsystem {
  /** Creates a new ClimbRotation. */
  private MA_Falcon RotationMotor1;
  private MA_Falcon RotationMotor2;
  private static ClimbRotation climbRotation;  

  public ClimbRotation() {
    RotationMotor1 = new MA_Falcon(12, true, NeutralMode.Coast);
    RotationMotor2 = new MA_Falcon(13, false, NeutralMode.Coast);
    RotationMotor2.follow(RotationMotor1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public boolean canMove() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public void setVoltage(double voltage) {
    // TODO Auto-generated method stub
    RotationMotor1.setVoltage(voltage);
  }
}
