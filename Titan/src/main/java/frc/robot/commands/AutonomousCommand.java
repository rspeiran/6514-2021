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
public class AutonomousCommand extends SequentialCommandGroup {

    private final LiftSubsystem m_liftSubsystem;
    private final DriveSubsystem m_driveSubsystem;
    private final ControlPanelSubsystem m_controlPanelSubsystem;
    private final FuelShooterPIDSubsystem m_fuelShooterPIDSubsystem;
    private final FuelDeliverySubSystem m_fuelDeliverySubSystem;

    public AutonomousCommand(LiftSubsystem subsystemLift, 
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
            new HippoMotorIn(m_fuelDeliverySubSystem),
            new WaitCommand(1),
            new HippoMotorStop(m_fuelDeliverySubSystem),
            new WaitCommand(1),
            new HippoMotorOut(m_fuelDeliverySubSystem),
            new WaitCommand(1),
            new HippoMotorStop(m_fuelDeliverySubSystem),
            new WaitCommand(1),
            new ConveyorUp(0.35, m_fuelDeliverySubSystem),
            new WaitCommand(1),
            new ConveyorDown(0.15, m_fuelDeliverySubSystem),
            new WaitCommand(1),
            new FuelReleaseExtend(m_fuelDeliverySubSystem),
            new WaitCommand(1),
            new FuelReleaseRetract(m_fuelDeliverySubSystem),
            new WaitCommand(1),
            new ShooterOn(m_fuelShooterPIDSubsystem, 350),
            new WaitCommand(1),
            new ShooterOff(m_fuelShooterPIDSubsystem),
            new WaitCommand(1),
            new ControlPanelClockWise(m_controlPanelSubsystem),
            new WaitCommand(1),
            new ControlPanelStop(m_controlPanelSubsystem),
            new WaitCommand(1),
            new ControlPanelClockWise(m_controlPanelSubsystem),
            new WaitCommand(1),
            new ControlPanelStop(m_controlPanelSubsystem),
            new WaitCommand(1),
            new LiftMotorUp(m_liftSubsystem),
            new WaitCommand(1),
            new LiftMotorStop(m_liftSubsystem),
            new WaitCommand(1),
            new LiftMotorDown(m_liftSubsystem),
            new WaitCommand(1),
            new LiftMotorStop(m_liftSubsystem),
            new WaitCommand(1),
            new LiftWinchOn(m_liftSubsystem),
            new WaitCommand(1),
            new LiftWinchOff(m_liftSubsystem),
            new WaitCommand(1)

            );
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
