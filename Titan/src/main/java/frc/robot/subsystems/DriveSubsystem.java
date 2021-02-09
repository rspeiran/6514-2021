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
//import frc.robot.commands.*;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotState;
//import edu.wpi.first.wpilibj.SpeedController;
//import edu.wpi.first.wpilibj.Talon;
//import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SPI;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */
public class DriveSubsystem extends SubsystemBase {

    //private RobotDrive robotDrive;
    private Encoder leftDriveEncoder;
    private Encoder rightDriveEncoder;
    private AnalogGyro gyro;
    private AHRS ahrs;


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
        leftDriveEncoder = new Encoder(2, 3, false, EncodingType.k4X);
        addChild("LeftDriveEncoder",leftDriveEncoder);
        //leftDriveEncoder.setDistancePerPulse(1.0);
        //leftDriveEncoder.setPIDSourceType(PIDSourceType.kRate);
        leftDriveEncoder.setDistancePerPulse(19./2048.);
        leftDriveEncoder.setMaxPeriod((.1));
        leftDriveEncoder.setMinRate(10);
        leftDriveEncoder.setReverseDirection(false);
        leftDriveEncoder.setSamplesToAverage(5);


        rightDriveEncoder = new Encoder(4, 5, false, EncodingType.k4X);
        addChild("RightDriveEncoder",rightDriveEncoder);
        //rightDriveEncoder.setDistancePerPulse(1.0);
        //rightDriveEncoder.setPIDSourceType(PIDSourceType.kRate);
        rightDriveEncoder.setDistancePerPulse(19./2048.);
        rightDriveEncoder.setMaxPeriod((.1));
        rightDriveEncoder.setMinRate(10);
        rightDriveEncoder.setReverseDirection(false);
        rightDriveEncoder.setSamplesToAverage(5);
        rightDriveEncoder.setReverseDirection(true);


        gyro = new AnalogGyro(0);
        addChild("Gyro",gyro);
        gyro.setSensitivity(0.007);

        leftDriveSpeedControl = new WPI_TalonSRX(21);
        addChild("leftDriveSpeedController",leftDriveSpeedControl);
        leftDriveSpeedControl.setInverted(false);

        rightDriveSpeedControl = new WPI_TalonSRX(22);
        addChild("rightDriveSpeedControl",rightDriveSpeedControl);
        rightDriveSpeedControl.setInverted(false);

        leftDriveSpeedControlFollower = new WPI_VictorSPX(11);
        rightDrriveSpeedControlFollower = new WPI_VictorSPX(12);

        //Conigure follower Left and Right
        leftDriveSpeedControlFollower.follow(leftDriveSpeedControl);
        rightDrriveSpeedControlFollower.follow(rightDriveSpeedControl);

        //Configure Breaking Left and Right
        leftDriveSpeedControl.setNeutralMode(NeutralMode.Coast);
        rightDriveSpeedControl.setNeutralMode(NeutralMode.Coast);

        //Configure Full Speed take off ramp up Left and Right
        leftDriveSpeedControl.configOpenloopRamp(0.5);
        rightDriveSpeedControl.configOpenloopRamp(0.5);

        //Config Closed loop Left and Right
        leftDriveSpeedControl.configClosedloopRamp(0);
        rightDriveSpeedControl.configClosedloopRamp(0);

        //Config Voltage comp Left andRight
        leftDriveSpeedControl.enableVoltageCompensation(true);
        rightDriveSpeedControl.enableVoltageCompensation(true);

        differentialDrive = new DifferentialDrive(leftDriveSpeedControl, rightDriveSpeedControl);

        //NAVX Start
        ahrs = new AHRS(SPI.Port.kMXP); 
        addChild("NavXAHRS",ahrs);
        
        /* Display 6-axis Processed Angle Data                                      */
        //SmartDashboard.putBoolean(  "IMU_Connected",        ahrs.isConnected());
        //SmartDashboard.putBoolean(  "IMU_IsCalibrating",    ahrs.isCalibrating());
        //SmartDashboard.putNumber(   "IMU_Yaw",              ahrs.getYaw());
        //SmartDashboard.putNumber(   "IMU_Pitch",            ahrs.getPitch());
        //SmartDashboard.putNumber(   "IMU_Roll",             ahrs.getRoll());
        
        /* Display tilt-corrected, Magnetometer-based heading (requires             */
        /* magnetometer calibration to be useful)                                   */
        //SmartDashboard.putNumber(   "IMU_CompassHeading",   ahrs.getCompassHeading());
        
        /* Display 9-axis Heading (requires magnetometer calibration to be useful)  */
        //SmartDashboard.putNumber(   "IMU_FusedHeading",     ahrs.getFusedHeading());

        /* These functions are compatible w/the WPI Gyro Class, providing a simple  */
        /* path for upgrading from the Kit-of-Parts gyro to the navx-MXP            */
        //SmartDashboard.putNumber(   "IMU_TotalYaw",         ahrs.getAngle());
        //SmartDashboard.putNumber(   "IMU_YawRateDPS",       ahrs.getRate());

        /* Display Processed Acceleration Data (Linear Acceleration, Motion Detect) */
        //SmartDashboard.putNumber(   "IMU_Accel_X",          ahrs.getWorldLinearAccelX());
        //SmartDashboard.putNumber(   "IMU_Accel_Y",          ahrs.getWorldLinearAccelY());
        //SmartDashboard.putBoolean(  "IMU_IsMoving",         ahrs.isMoving());
        //SmartDashboard.putBoolean(  "IMU_IsRotating",       ahrs.isRotating());

        /* Display estimates of velocity/displacement.  Note that these values are  */
        /* not expected to be accurate enough for estimating robot position on a    */
        /* FIRST FRC Robotics Field, due to accelerometer noise and the compounding */
        /* of these errors due to single (velocity) integration and especially      */
        /* double (displacement) integration.                                       */
        //SmartDashboard.putNumber(   "Velocity_X",           ahrs.getVelocityX());
        //SmartDashboard.putNumber(   "Velocity_Y",           ahrs.getVelocityY());
        //SmartDashboard.putNumber(   "Displacement_X",       ahrs.getDisplacementX());
        //SmartDashboard.putNumber(   "Displacement_Y",       ahrs.getDisplacementY());
        
        /* Display Raw Gyro/Accelerometer/Magnetometer Values                       */
        /* NOTE:  These values are not normally necessary, but are made available   */
        /* for advanced users.  Before using this data, please consider whether     */
        /* the processed data (see above) will suit your needs.                     */
        //SmartDashboard.putNumber(   "RawGyro_X",            ahrs.getRawGyroX());
        //SmartDashboard.putNumber(   "RawGyro_Y",            ahrs.getRawGyroY());
        //SmartDashboard.putNumber(   "RawGyro_Z",            ahrs.getRawGyroZ());
        //SmartDashboard.putNumber(   "RawAccel_X",           ahrs.getRawAccelX());
        //SmartDashboard.putNumber(   "RawAccel_Y",           ahrs.getRawAccelY());
        //SmartDashboard.putNumber(   "RawAccel_Z",           ahrs.getRawAccelZ());
        //SmartDashboard.putNumber(   "RawMag_X",             ahrs.getRawMagX());
        //SmartDashboard.putNumber(   "RawMag_Y",             ahrs.getRawMagY());
        //SmartDashboard.putNumber(   "RawMag_Z",             ahrs.getRawMagZ());
        //SmartDashboard.putNumber(   "IMU_Temp_C",           ahrs.getTempC());
        
        /* Omnimount Yaw Axis Information                                           */
        /* For more info, see http://navx-mxp.kauailabs.com/installation/omnimount  */
        //AHRS.BoardYawAxis yaw_axis = ahrs.getBoardYawAxis();
        //SmartDashboard.putString(   "YawAxisDirection",     yaw_axis.up ? "Up" : "Down" );
        //SmartDashboard.putNumber(   "YawAxis",              yaw_axis.board_axis.getValue() );
        
        /* Sensor Board Information                                                 */
        //SmartDashboard.putString(   "FirmwareVersion",      ahrs.getFirmwareVersion());
        
        /* Quaternion Data                                                          */
        /* Quaternions are fascinating, and are the most compact representation of  */
        /* orientation data.  All of the Yaw, Pitch and Roll Values can be derived  */
        /* from the Quaternions.  If interested in motion processing, knowledge of  */
        /* Quaternions is highly recommended.                                       */
        //SmartDashboard.putNumber(   "QuaternionW",          ahrs.getQuaternionW());
        //SmartDashboard.putNumber(   "QuaternionX",          ahrs.getQuaternionX());
        //SmartDashboard.putNumber(   "QuaternionY",          ahrs.getQuaternionY());
        //SmartDashboard.putNumber(   "QuaternionZ",          ahrs.getQuaternionZ());
        
        /* Connectivity Debugging Support                                           */
        //SmartDashboard.putNumber(   "IMU_Byte_Count",       ahrs.getByteCount());
        //SmartDashboard.putNumber(   "IMU_Update_Count",     ahrs.getUpdateCount());
        //NAVX End


    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        if (!RobotState.isAutonomous())
        {
            if(userDriveStyle == DriveStyle.Tank) {
                differentialDrive.tankDrive(-RobotContainer.getInstance().getDriverJoystick().getRawAxis(5),
                                            RobotContainer.getInstance().getDriverJoystick().getY());

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

