package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.LiftSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ControlPanelSubsystem;
import frc.robot.subsystems.FuelShooterPIDSubsystem;
import frc.robot.subsystems.FuelDeliverySubSystem;

import frc.robot.WaypointDrive;
import frc.robot.Waypoints;

public class AutoGalacticSearchChallengePathA_BLUE extends SequentialCommandGroup {

    private final LiftSubsystem m_liftSubsystem;
    private final DriveSubsystem m_driveSubsystem;
    private final ControlPanelSubsystem m_controlPanelSubsystem;
    private final FuelShooterPIDSubsystem m_fuelShooterPIDSubsystem;
    private final FuelDeliverySubSystem m_fuelDeliverySubSystem;


    public AutoGalacticSearchChallengePathA_BLUE(LiftSubsystem subsystemLift, 
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
        new DriveReset(m_driveSubsystem),
        new FuelReleaseExtend(m_fuelDeliverySubSystem),
        new WaypointDrive().DriveRamset(m_driveSubsystem, Waypoints.Demo_Path1_start, Waypoints.Demo_Path1_path, Waypoints.Demo_Path1_end),
        new FuelReleaseRetract(m_fuelDeliverySubSystem)
        );
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
