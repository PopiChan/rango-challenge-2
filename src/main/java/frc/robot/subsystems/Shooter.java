// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import ma5951.utils.RobotConstants.ENCODER;
import ma5951.utils.RobotConstants.LIMIT_SWITCH;
import ma5951.utils.commands.ControlCommandPID;
import ma5951.utils.motor.MA_SparkMax;
import ma5951.utils.subsystem.MotorSubsystem;

public class Shooter implements MotorSubsystem{
  /** Creates a new Shooter. */
  private MA_SparkMax ShooterMotor1;
  private MA_SparkMax ShooterMotor2;
  private static Shooter shooter;


  public Shooter() {
    ShooterMotor1 = new MA_SparkMax(7, true, true, LIMIT_SWITCH.forward, ENCODER.Encoder, MotorType.kBrushless);
    ShooterMotor2 = new MA_SparkMax(7, true, true, LIMIT_SWITCH.forward, ENCODER.Encoder, MotorType.kBrushless);
    ShooterMotor2.follow(ShooterMotor1);
    
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
    ShooterMotor1.setVoltage(voltage);
  }
  public static Shooter getinstance(){
    if (shooter == null){
      shooter = new Shooter();
    }
    return shooter;
  }
}
