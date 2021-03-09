package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.subsystems.FuelShooterPIDSubsystem;
import frc.robot.subsystems.FuelDeliverySubSystem;

/**
 *
 */
public class ShooterAngleDecrease extends CommandBase {

    private final FuelDeliverySubSystem m_FuelDeliverySubSystem;

    public ShooterAngleDecrease(FuelDeliverySubSystem subsystem) {

        // m_subsystem = subsystem;
        // addRequirements(m_subsystem);    

        m_FuelDeliverySubSystem = subsystem;
        addRequirements(m_FuelDeliverySubSystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_FuelDeliverySubSystem.ShooterAngleDecrease();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
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
