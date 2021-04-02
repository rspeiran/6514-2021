package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.DriveSubsystem.RobotForward;

public class DriveSetForward extends CommandBase {

    private final DriveSubsystem m_driveSubsystem;
    
    private final RobotForward m_RobotForward;

    public DriveSetForward(DriveSubsystem m_driveSubsystem2, RobotForward robotForward) {

        m_driveSubsystem = m_driveSubsystem2;
        addRequirements(m_driveSubsystem);
        m_RobotForward = robotForward;

    }

    @Override
    public void initialize() {
        m_driveSubsystem.ZeroEncoders();
        if (m_RobotForward == RobotForward.Hippo) {
            m_driveSubsystem.SetForwardHippo();
        }
     }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
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
        return true;

    }
}
