// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Chasis;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import ma5951.utils.motor.MA_Falcon;
import ma5951.utils.RobotConstants;
import ma5951.utils.subsystem.MotorSubsystem;

public class ChasisLeft implements MotorSubsystem {
  /** Creates a new Chasis. */
  // private MA_Falcon RightFront;
  // private MA_Falcon RightBack;
  private MA_Falcon LeftFront;
  private MA_Falcon LeftBack;
  public static ChasisLeft chasisleft;

  public ChasisLeft() {
    // Use addRequirements() here to declare subsystem dependencies.
    // RightFront = new MA_Falcon(3, true, NeutralMode.Coast);
    // RightBack = new MA_Falcon(5, true, NeutralMode.Coast);
    LeftFront = new MA_Falcon(2, true, NeutralMode.Coast);
    LeftBack = new MA_Falcon(4, true, NeutralMode.Coast);
  }

  @Override
  public boolean canMove() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public void setVoltage(double Voltage) {
    // TODO Auto-generated method stub
    // RightFront.setVoltage(Voltage);
    // RightBack.setVoltage(Voltage);
    LeftFront.setVoltage(Voltage);
    LeftBack.setVoltage(Voltage);
  }

  public static ChasisLeft getinstance(){
    if (chasisleft == null){
      chasisleft = new ChasisLeft();
    }
    return chasisleft;
  }
}
