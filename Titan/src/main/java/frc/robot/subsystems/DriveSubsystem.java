// RobotBuilder Version: 3.1
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package frc.robot.subsystems;

import frc.robot.RobotContainer;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

/**
 *
 */
public class DriveSubsystem extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private Talon leftDriveSpeedController;
private Victor rightDriveSpeedController;
//private RobotDrive robotDrive;
private Encoder leftDriveEncoder;
private Encoder rightDriveEncoder;
private AnalogGyro gyro;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private WPI_TalonSRX leftDriveSpeedControl;
    private WPI_TalonSRX rightDriveSpeedControl;

    private WPI_VictorSPX leftDriveSpeedControlFollower;
    private WPI_VictorSPX rightDrriveSpeedControlFollower;

    private DifferentialDrive differentialDrive;

    enum DriveStyle {
        Tank,
        Arcade
    }

    private DriveStyle userDriveStyle = DriveStyle.Tank;
    
    /**
    *
    */
    public DriveSubsystem() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
leftDriveSpeedController = new Talon(4);
 addChild("LeftDriveSpeedController",leftDriveSpeedController);
 leftDriveSpeedController.setInverted(false);

rightDriveSpeedController = new Victor(5);
 addChild("RightDriveSpeedController",rightDriveSpeedController);
 rightDriveSpeedController.setInverted(false);

//robotDrive = new RobotDrive(leftDriveSpeedController, rightDriveSpeedController);
 
// robotDrive.setSafetyEnabled(true);
//robotDrive.setExpiration(0.1);
//robotDrive.setSensitivity(0.5);
//robotDrive.setMaxOutput(1.0);


leftDriveEncoder = new Encoder(2, 3, false, EncodingType.k4X);
 addChild("LeftDriveEncoder",leftDriveEncoder);
 leftDriveEncoder.setDistancePerPulse(1.0);
leftDriveEncoder.setPIDSourceType(PIDSourceType.kRate);

rightDriveEncoder = new Encoder(4, 5, false, EncodingType.k4X);
 addChild("RightDriveEncoder",rightDriveEncoder);
 rightDriveEncoder.setDistancePerPulse(1.0);
rightDriveEncoder.setPIDSourceType(PIDSourceType.kRate);

gyro = new AnalogGyro(0);
 addChild("Gyro",gyro);
 gyro.setSensitivity(0.007);


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        leftDriveSpeedControl = new WPI_TalonSRX(21);
        leftDriveSpeedControl.setInverted(false);

        rightDriveSpeedControl = new WPI_TalonSRX(22);
        rightDriveSpeedControl.setInverted(false);

        leftDriveSpeedControlFollower = new WPI_VictorSPX(11);
        rightDrriveSpeedControlFollower = new WPI_VictorSPX(12);

        //Conigure follower
        leftDriveSpeedControlFollower.follow(leftDriveSpeedControl);
        rightDrriveSpeedControlFollower.follow(rightDriveSpeedControl);

        //Configure Breaking
        leftDriveSpeedControl.setNeutralMode(NeutralMode.Coast);
        rightDriveSpeedControl.setNeutralMode(NeutralMode.Coast);

        //Configure Full Speed take off ramp up
        leftDriveSpeedControl.configOpenloopRamp(0.5);
        rightDriveSpeedControl.configOpenloopRamp(0.5);

        //Config Closed loop
        leftDriveSpeedControl.configClosedloopRamp(0);
        rightDriveSpeedControl.configClosedloopRamp(0);

        //Config Voltage comp
        leftDriveSpeedControl.enableVoltageCompensation(true);
        rightDriveSpeedControl.enableVoltageCompensation(true);

        differentialDrive = new DifferentialDrive(leftDriveSpeedControl, rightDriveSpeedControl);


    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        if (!RobotState.isAutonomous())
        {
            if(userDriveStyle == DriveStyle.Tank) {
                differentialDrive.tankDrive(RobotContainer.getInstance().getDriverJoystick().getY(),
                                            RobotContainer.getInstance().getDriverJoystick().getRawAxis(5));

            }
            else if (userDriveStyle == DriveStyle.Arcade) {
                differentialDrive.arcadeDrive(RobotContainer.getInstance().getDriverJoystick().getRawAxis(5), 
                                              RobotContainer.getInstance().getDriverJoystick().getX());

            }
        }

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void toggleDriveStyle() {
        if (userDriveStyle == DriveStyle.Tank) {
            userDriveStyle = DriveStyle.Arcade;
        } else {
            userDriveStyle = DriveStyle.Tank;
        }

    }

}

