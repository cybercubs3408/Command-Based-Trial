package frc.robot.commands;

import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveMotion extends CommandBase {
    private final CANSparkMax frontLeft, frontRight, backLeft, backRight;
    private final RelativeEncoder frontLeftEncoder, frontRightEncoder, backLeftEncoder, backRightEncoder;

    private final DrivetrainSubsystem m_subsystem;




    public DriveMotion (DrivetrainSubsystem subsystem){
        m_subsystem = subsystem;
    
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        
        m_subsystem.drive(leftJoystick, rightJoystick);

    }

    @Override 
    public void end(){
        
        m_subsystem.stop();
        m_subsystem.resetEncoders();

    }

@Override public boolean isFinished(){
    return true;
}



}