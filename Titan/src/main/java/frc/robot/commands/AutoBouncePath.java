package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.LiftSubsystem;
import frc.robot.subsystems.DriveSubsystem.RobotForward;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ControlPanelSubsystem;
import frc.robot.subsystems.FuelShooterPIDSubsystem;
import frc.robot.subsystems.FuelDeliverySubSystem;

import frc.robot.WaypointDrive;
import frc.robot.Waypoints;

public class AutoBouncePath extends SequentialCommandGroup {

    private final LiftSubsystem m_liftSubsystem;
    private final DriveSubsystem m_driveSubsystem;
    private final ControlPanelSubsystem m_controlPanelSubsystem;
    private final FuelShooterPIDSubsystem m_fuelShooterPIDSubsystem;
    private final FuelDeliverySubSystem m_fuelDeliverySubSystem;


    public AutoBouncePath(LiftSubsystem subsystemLift, 
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
        new DriveSetForward(m_driveSubsystem, RobotForward.Hippo),
        new DriveReset(m_driveSubsystem),
        new FuelReleaseExtend(m_fuelDeliverySubSystem),
        new WaypointDrive().DriveRamset(m_driveSubsystem, Waypoints.bounce_racing_path_start_Leg01, Waypoints.bounce_racing_path_Leg_01, Waypoints.bounce_racing_path_end_01),
        new WaypointDrive().DriveRamset(m_driveSubsystem, Waypoints.bounce_racing_path_start_Leg02, Waypoints.bounce_racing_path_Leg_02, Waypoints.bounce_racing_path_end_02),
        new WaypointDrive().DriveRamset(m_driveSubsystem, Waypoints.bounce_racing_path_start_Leg03, Waypoints.bounce_racing_path_Leg_03, Waypoints.bounce_racing_path_end_03),
        //new WaypointDrive().DriveRamset(m_driveSubsystem, Waypoints.bounce_racing_path_start_Leg04, Waypoints.bounce_racing_path_Leg_04, Waypoints.bounce_racing_path_end_03),
        //new WaypointDrive().DriveRamset(m_driveSubsystem, Waypoints.bounce_racing_path_start_Leg05, Waypoints.bounce_racing_path_Leg_05, Waypoints.bounce_racing_path_end_03),
        //new WaypointDrive().DriveRamset(m_driveSubsystem, Waypoints.bounce_racing_path_start_Leg06, Waypoints.bounce_racing_path_Leg_06, Waypoints.bounce_racing_path_end_03),
        //new WaypointDrive().DriveRamset(m_driveSubsystem, Waypoints.bounce_racing_path_start_Leg07, Waypoints.bounce_racing_path_Leg_07, Waypoints.bounce_racing_path_end_03),
        //new WaypointDrive().DriveRamset(m_driveSubsystem, Waypoints.bounce_racing_path_start_Leg08, Waypoints.bounce_racing_path_Leg_08, Waypoints.bounce_racing_path_end_03),
        //new WaypointDrive().DriveRamset(m_driveSubsystem, Waypoints.bounce_racing_path_start_Leg09, Waypoints.bounce_racing_path_Leg_09, Waypoints.bounce_racing_path_end_03),

        new FuelReleaseRetract(m_fuelDeliverySubSystem)
        );
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
