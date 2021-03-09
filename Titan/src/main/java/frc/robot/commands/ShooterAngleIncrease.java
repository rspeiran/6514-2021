package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.Robot;
import frc.robot.subsystems.FuelDeliverySubSystem;
//import frc.robot.subsystems.FuelShooterPIDSubsystem;

/**
 *
 */
public class ShooterAngleIncrease extends CommandBase {

    private final FuelDeliverySubSystem m_FuelDeliverySubSystem;

    public ShooterAngleIncrease(FuelDeliverySubSystem subsystem) {

        m_FuelDeliverySubSystem = subsystem;
        addRequirements(m_FuelDeliverySubSystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        System.out.println("Shooter Angle Increase");
 
        m_FuelDeliverySubSystem.ShooterAngleIncrease();
 
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        
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
