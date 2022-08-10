// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.climb;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import ma5951.utils.motor.MA_Falcon;
import ma5951.utils.subsystem.MotorSubsystem;

public class ClimbExtention implements MotorSubsystem {
  /** Creates a new Climb. */
  private MA_Falcon ExtentionMotor;
  private static ClimbExtention climbExtention;

  public ClimbExtention() {
    ExtentionMotor = new MA_Falcon(11, true, NeutralMode.Coast);
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
    ExtentionMotor.setVoltage(voltage);
    
  }
  public static ClimbExtention getinstance(){
    if (climbExtention == null){
      climbExtention = new ClimbExtention();
    }
    return climbExtention;
  }
}
