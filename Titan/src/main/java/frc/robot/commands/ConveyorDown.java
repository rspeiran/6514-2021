// RobotBuilder Version: 3.1
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.WaitCommand;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import frc.robot.subsystems.FuelDeliverySubSystem;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class ConveyorDown extends WaitCommand {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
        private final FuelDeliverySubSystem m_fuelDeliverySubSystem;
    private double m_timeout;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS


    public ConveyorDown(double timeout, FuelDeliverySubSystem subsystem) {
        super(timeout);
        m_timeout = timeout;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        m_fuelDeliverySubSystem = subsystem;
        addRequirements(m_fuelDeliverySubSystem);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    public void initialize() {
        super.initialize();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    public void execute() {
        m_fuelDeliverySubSystem.ConveyorDown();
    }


    // Called once after isFinished returns true
    @Override
    public void end(boolean interrupted) {
        m_fuelDeliverySubSystem.ConveyorOff();
        super.end(interrupted);
    }

    @Override
    public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
        return false;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    }

}
