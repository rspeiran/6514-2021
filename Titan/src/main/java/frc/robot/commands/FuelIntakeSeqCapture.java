package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.FuelDeliverySubSystem;

public class FuelIntakeSeqCapture extends SequentialCommandGroup {

    private final DriveSubsystem m_driveSubsystem;
    private final FuelDeliverySubSystem m_fuelDeliverySubSystem;

    public FuelIntakeSeqCapture(
                DriveSubsystem subsystemDrive, 
                FuelDeliverySubSystem subsystemFuelDelivery){
        
        m_driveSubsystem = subsystemDrive;
        m_fuelDeliverySubSystem = subsystemFuelDelivery;

        addRequirements(m_driveSubsystem);
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
            new HippoMotorIn(m_fuelDeliverySubSystem),
            new HippoMechIn(m_fuelDeliverySubSystem),
            new WaitCommand(0.40),
            new HippoMechOut(m_fuelDeliverySubSystem),
            new WaitCommand(0.25),
            new HippoMechIn(m_fuelDeliverySubSystem),
            new WaitCommand(0.25),
            new HippoMotorOut(m_fuelDeliverySubSystem), //Free the fuel
            new WaitCommand(0.15),
            new HippoMotorIn(m_fuelDeliverySubSystem),
            new HippoMechOut(m_fuelDeliverySubSystem),
            new WaitCommand(0.15),
            new HippoMechIn(m_fuelDeliverySubSystem),
            new WaitCommand(0.25),
            new HippoMotorStop(m_fuelDeliverySubSystem)

        );
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
