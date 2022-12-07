// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
    
  private final CANSparkMax frontLeft = new CANSparkMax(6, MotorType.kBrushless);
  private final CANSparkMax frontRight = new CANSparkMax(7, MotorType.kBrushless);
  private final CANSparkMax backLeft = new CANSparkMax(8, MotorType.kBrushless);
  private final CANSparkMax backRight = new CANSparkMax(9, MotorType.kBrushless);

  private final RelativeEncoder frontLeftEncoder = frontLeft.getEncoder();
  private final RelativeEncoder frontRightEncoder = frontRight.getEncoder();
  private final RelativeEncoder backLeftEncoder = backLeft.getEncoder();
  private final RelativeEncoder backRightEncoder = backRight.getEncoder();
    
    public void drive(Joystick leftJoystick, Joystick rightJoystick){
        
        double leftPower = leftJoystick.getRawAxis(1);
        double rightPower = rightJoystick.getRawAxis(1);

        // Alter decimal being multiplied to change the power as needed

        frontLeft.set(Math.abs(leftPower) * leftPower);
        backLeft.set(Math.abs(leftPower) * leftPower);
        frontRight.set(Math.abs(rightPower) * rightPower);
        backRight.set(Math.abs(rightPower) * rightPower);
    }

    public void stop() {

        frontLeft.set(0);
        frontRight.set(0);
        backLeft.set(0);
        backRight.set(0);
        
    }
    
    /**
     * Resets encoder values to 0
     */
    public void resetEncoders() {

        frontLeftEncoder.setPosition(0);
        frontRightEncoder.setPosition(0);
        backLeftEncoder.setPosition(0);
        backRightEncoder.setPosition(0);

    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}