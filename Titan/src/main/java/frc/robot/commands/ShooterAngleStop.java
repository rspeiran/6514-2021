package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.Robot;
import frc.robot.subsystems.FuelDeliverySubSystem;
//import frc.robot.subsystems.FuelShooterPIDSubsystem;

/**
 *
 */
public class ShooterAngleStop extends CommandBase {

    private final FuelDeliverySubSystem m_fuelDeliverySubSystem;

    public ShooterAngleStop(FuelDeliverySubSystem subsystem) {

        m_fuelDeliverySubSystem = subsystem;
        addRequirements(m_fuelDeliverySubSystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        System.out.println("Shooter Angle Stop");
        m_fuelDeliverySubSystem.ShooterAngleHold();
        
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
