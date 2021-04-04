package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
//import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.LiftSubsystem;
import frc.robot.subsystems.DriveSubsystem.RobotForward;
import frc.robot.subsystems.DriveSubsystem;

import frc.robot.subsystems.ControlPanelSubsystem;
import frc.robot.subsystems.FuelShooterPIDSubsystem;
import frc.robot.subsystems.FuelDeliverySubSystem;


//import frc.robot.RobotContainer;
import frc.robot.WaypointDrive;
import frc.robot.Waypoints;


public class AutoSlalomPath extends SequentialCommandGroup {

    private final LiftSubsystem m_liftSubsystem;
    private final DriveSubsystem m_driveSubsystem;
    private final ControlPanelSubsystem m_controlPanelSubsystem;
    private final FuelShooterPIDSubsystem m_fuelShooterPIDSubsystem;
    private final FuelDeliverySubSystem m_fuelDeliverySubSystem;

    public AutoSlalomPath(LiftSubsystem subsystemLift, 
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
            //new WaypointDrive().DriveRamset(m_driveSubsystem, Waypoints.slalom_racing_path_start, Waypoints.slalom_racing_path, Waypoints.slalom_racing_path_end),
            new WaypointDrive().DriveRamset(m_driveSubsystem, Waypoints.slalom_racing_path_Start_Leg1, Waypoints.slalom_racing_path_Leg1, Waypoints.slalom_racing_path_End_Leg1),
            new WaypointDrive().DriveRamset(m_driveSubsystem, Waypoints.slalom_racing_path_Start_Leg2, Waypoints.slalom_racing_path_Leg2, Waypoints.slalom_racing_path_End_Leg2),
            new WaypointDrive().DriveRamset(m_driveSubsystem, Waypoints.slalom_racing_path_Start_Leg3, Waypoints.slalom_racing_path_Leg3, Waypoints.slalom_racing_path_End_Leg3),
            new WaypointDrive().DriveRamset(m_driveSubsystem, Waypoints.slalom_racing_path_Start_Leg3b, Waypoints.slalom_racing_path_Leg3b, Waypoints.slalom_racing_path_End_Leg3b),
            new WaypointDrive().DriveRamset(m_driveSubsystem, Waypoints.slalom_racing_path_Start_Leg4, Waypoints.slalom_racing_path_Leg4, Waypoints.slalom_racing_path_End_Leg4),
            new WaypointDrive().DriveRamset(m_driveSubsystem, Waypoints.slalom_racing_path_Start_Leg5, Waypoints.slalom_racing_path_Leg5, Waypoints.slalom_racing_path_End_Leg5),
            new WaypointDrive().DriveRamset(m_driveSubsystem, Waypoints.slalom_racing_path_Start_Leg6, Waypoints.slalom_racing_path_Leg6, Waypoints.slalom_racing_path_End_Leg6),

            new FuelReleaseRetract(m_fuelDeliverySubSystem)

        );
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
