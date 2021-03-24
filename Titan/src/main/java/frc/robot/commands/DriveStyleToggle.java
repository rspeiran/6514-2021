package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

/**
 *
 */
public class DriveStyleToggle extends CommandBase {

    private final DriveSubsystem m_DriveSubsystem;

    public DriveStyleToggle(DriveSubsystem subsystem) {

        m_DriveSubsystem = subsystem;
        addRequirements(m_DriveSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_DriveSubsystem.toggleDriveStyle();
 
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
