// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.climb;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import ma5951.utils.RobotConstants.ENCODER;
import ma5951.utils.RobotConstants.LIMIT_SWITCH;
import ma5951.utils.motor.MA_SparkMax;
import ma5951.utils.subsystem.MotorSubsystem;

public class ClimbClamp implements MotorSubsystem {
  /** Creates a new ClimbClamp. */
  private MA_SparkMax ClampMotor;
  private static ClimbClamp climbClamp;

  public ClimbClamp() {
    ClampMotor = new MA_SparkMax(14, true, true, LIMIT_SWITCH.forward, ENCODER.Encoder, MotorType.kBrushless);

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
    ClampMotor.setVoltage(voltage);
  }

  public static ClimbClamp getinstance(){
    if (climbClamp == null){
      climbClamp = new ClimbClamp();
    }
    return climbClamp;
  }
}
