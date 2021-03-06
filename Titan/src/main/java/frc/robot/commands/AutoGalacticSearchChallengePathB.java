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

public class AutoGalacticSearchChallengePathB extends SequentialCommandGroup {

    private final LiftSubsystem m_liftSubsystem;
    private final DriveSubsystem m_driveSubsystem;
    private final ControlPanelSubsystem m_controlPanelSubsystem;
    private final FuelShooterPIDSubsystem m_fuelShooterPIDSubsystem;
    private final FuelDeliverySubSystem m_fuelDeliverySubSystem;


    public AutoGalacticSearchChallengePathB(LiftSubsystem subsystemLift, 
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
                new DriveSetForward(m_driveSubsystem, RobotForward.Hippo),
                new FuelReleaseExtend(m_fuelDeliverySubSystem),

                new HippoMechOut(m_fuelDeliverySubSystem),
                new HippoMotorIn(m_fuelDeliverySubSystem),
                new WaypointDrive().DriveRamset(m_driveSubsystem, Waypoints.GalacticSearch_PathB_Red_start_Leg1, Waypoints.GalacticSearch_PathB_Red_path_Leg1, Waypoints.GalacticSearch_PathB_Red_end_Leg1),
                new DriveWait(m_driveSubsystem),
                new FuelIntakeSeqCapture(m_driveSubsystem, m_fuelDeliverySubSystem),
                new ConveyorUp(0.25, m_fuelDeliverySubSystem),
                
                new HippoMechOut(m_fuelDeliverySubSystem),
                new HippoMotorIn(m_fuelDeliverySubSystem),
                new WaypointDrive().DriveRamset(m_driveSubsystem, Waypoints.GalacticSearch_PathB_Red_start_Leg2, Waypoints.GalacticSearch_PathB_Red_path_Leg2, Waypoints.GalacticSearch_PathB_Red_end_Leg2),
                new DriveWait(m_driveSubsystem),
                new FuelIntakeSeqCapture(m_driveSubsystem, m_fuelDeliverySubSystem),
                new ConveyorUp(0.25, m_fuelDeliverySubSystem),
                
                new HippoMechOut(m_fuelDeliverySubSystem),
                new HippoMotorIn(m_fuelDeliverySubSystem),
                new WaypointDrive().DriveRamset(m_driveSubsystem, Waypoints.GalacticSearch_PathB_Red_start_Leg3, Waypoints.GalacticSearch_PathB_Red_path_Leg3, Waypoints.GalacticSearch_PathB_Red_end_Leg3),
                new DriveWait(m_driveSubsystem),
                new FuelIntakeSeqCapture(m_driveSubsystem, m_fuelDeliverySubSystem),
                
                new WaypointDrive().DriveRamset(m_driveSubsystem, Waypoints.GalacticSearch_PathB_Red_start_Leg4, Waypoints.GalacticSearch_PathB_Red_path_Leg4, Waypoints.GalacticSearch_PathB_Red_end_Leg4),
                new FuelReleaseRetract(m_fuelDeliverySubSystem)
        
        );
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
