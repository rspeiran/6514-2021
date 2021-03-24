package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
//import frc.robot.Robot;
import frc.robot.subsystems.FuelDeliverySubSystem;
//import frc.robot.subsystems.FuelShooterPIDSubsystem;

/**
 *
 */
public class ShooterAngleSetPosition extends CommandBase {

    private final FuelDeliverySubSystem m_FuelDeliverySubSystem;
    private final int m_Angle;

    public ShooterAngleSetPosition(FuelDeliverySubSystem subsystem, int setPosition) {

        m_FuelDeliverySubSystem = subsystem;
        addRequirements(m_FuelDeliverySubSystem);
        m_Angle = setPosition;
 
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        System.out.print("Shooter Angle SetPosition ");
        System.out.println(m_Angle);
 
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        //if (m_FuelDeliverySubSystem.ShooterAngleCounter.get() > m_Angle ) {
        //    m_FuelDeliverySubSystem.ShooterAngleDecrease();
        //} else if (m_FuelDeliverySubSystem.ShooterAngleCounter.get() < m_Angle) {
        //    m_FuelDeliverySubSystem.ShooterAngleIncrease();
        //} else {
        //    m_FuelDeliverySubSystem.ShooterAngleHold();
        //}

        if (m_FuelDeliverySubSystem.ShooterCalculatedCounter <= m_Angle ) {
            m_FuelDeliverySubSystem.ShooterAngleIncrease();
        } else if (m_FuelDeliverySubSystem.ShooterCalculatedCounter >= m_Angle) {
            m_FuelDeliverySubSystem.ShooterAngleDecrease();
        } else {
            m_FuelDeliverySubSystem.ShooterAngleHold();
        }

        System.out.print("ShooterCalculatedCounter ");
        System.out.println(m_FuelDeliverySubSystem.ShooterCalculatedCounter);
 
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        isFinished();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        //if (m_FuelDeliverySubSystem.ShooterAngleCounter.get() > m_Angle) {
        if (m_FuelDeliverySubSystem.ShooterCalculatedCounter == m_Angle) {
            m_FuelDeliverySubSystem.ShooterAngleHold();
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
