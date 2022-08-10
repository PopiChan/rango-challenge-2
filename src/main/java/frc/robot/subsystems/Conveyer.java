// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import ma5951.utils.motor.MA_TalonSRX;
import ma5951.utils.motor.MA_Falcon;
import ma5951.utils.subsystem.MotorSubsystem;
// import ma5951.utils.subsystem.SensorSubsystem;

public class Conveyer implements MotorSubsystem{
  /** Creates a new conveyer. */
  private MA_Falcon ConveyerTop;
  private MA_TalonSRX ConveyerButtom;
  private DigitalInput ConveyerIrTop;
  private DigitalInput ConveyerIrButtom;

  private static Conveyer conveyer;

  public Conveyer() {
    ConveyerTop = new MA_Falcon(8, true, NeutralMode.Coast);
    ConveyerButtom = new MA_TalonSRX(7, true, true);
    ConveyerIrTop = new DigitalInput(2);
    ConveyerIrButtom = new DigitalInput(0);
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
    if (ConveyerIrButtom.get() == true && ConveyerIrTop.get() == false){
      while (ConveyerIrTop.get() == false){
        ConveyerTop.setVoltage(voltage);
        ConveyerButtom.setVoltage(voltage);
      }
    }
  }
  public static Conveyer getinstance(){
    if (conveyer == null){
      conveyer = new Conveyer();
    }
    return conveyer;
  }
}
