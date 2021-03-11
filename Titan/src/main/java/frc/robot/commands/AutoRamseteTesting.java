package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.LiftSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ControlPanelSubsystem;
import frc.robot.subsystems.FuelShooterPIDSubsystem;
import frc.robot.subsystems.FuelDeliverySubSystem;
/**
 *
 */
public class AutoRamseteTesting extends SequentialCommandGroup {

    private final LiftSubsystem m_liftSubsystem;
    private final DriveSubsystem m_driveSubsystem;
    private final ControlPanelSubsystem m_controlPanelSubsystem;
    private final FuelShooterPIDSubsystem m_fuelShooterPIDSubsystem;
    private final FuelDeliverySubSystem m_fuelDeliverySubSystem;

    public AutoRamseteTesting(LiftSubsystem subsystemLift, 
                DriveSubsystem subsystemDrive, 
                ControlPanelSubsystem subsystemControlPanel, 
                FuelShooterPIDSubsystem subsystemFuelPid, 
                FuelDeliverySubSystem subsystemFuelDelivery){
        
        m_liftSubsystem = subsystemLift;
        m_driveSubsystem = subsystemDrive;
        m_controlPanelSubsystem = subsystemControlPanel;
        m_fuelShooterPIDSubsystem = subsystemFuelPid;
        m_fuelDeliverySubSystem = subsystemFuelDelivery;

        addRequirements(m_liftSubsystem);
        addRequirements(m_driveSubsystem);
        addRequirements(m_controlPanelSubsystem);
        addRequirements(m_fuelShooterPIDSubsystem);
        addRequirements(m_fuelDeliverySubSystem);

        
        addCommands(
            // Add Commands here:
            // Also add parallel commands using the
            //
            // addCommands(
            //      new command1(argsN, subsystem),
            //      parallel(
            //          new command2(argsN, subsystem),
            //          new command3(argsN, subsystem)
            //      )    
            //  );
            new HippoMechOut(m_fuelDeliverySubSystem),
            new WaitCommand(1),
            new HippoMechIn(m_fuelDeliverySubSystem),
            new WaitCommand(1),
            new DriveRamsete(m_driveSubsystem),
            new WaitCommand(1)

            );
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
