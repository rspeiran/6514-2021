// RobotBuilder Version: 3.1
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.Robot;
//import frc.robot.subsystems.FuelDeliverySubSystem;
import frc.robot.subsystems.FuelShooterPIDSubsystem;

/**
 *
 */
public class ShooterOn extends CommandBase {

    private final FuelShooterPIDSubsystem m_FuelShooterPIDSubsystem;
    private final double m_Speed;

    public ShooterOn(FuelShooterPIDSubsystem subsystem, double Speed) {

        m_FuelShooterPIDSubsystem = subsystem;
        addRequirements(m_FuelShooterPIDSubsystem);
        m_Speed = Speed;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        System.out.println("Shooter On");
 
        m_FuelShooterPIDSubsystem.ShooterOn();
        m_FuelShooterPIDSubsystem.setSetpoint(m_Speed);
        m_FuelShooterPIDSubsystem.enable();
 
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        //m_fuelDeliverySubSystem.ShooterOn();
        //m_FuelShooterPIDSubsystem.
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        isFinished();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
