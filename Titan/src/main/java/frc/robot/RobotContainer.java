// RobotBuilder Version: 3.1
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import frc.robot.subsystems.*;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.RamseteController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import frc.robot.Constants.AutoConstants;
import frc.robot.Constants.DriveConstants;
//import frc.robot.Constants.OIConstants;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import edu.wpi.first.wpilibj.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj.trajectory.constraint.DifferentialDriveVoltageConstraint;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
//import edu.wpi.first.wpilibj2.command.RunCommand;
import java.util.List;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

    private static RobotContainer m_robotContainer = new RobotContainer();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    // The robot's subsystems
    private final LiftSubsystem m_liftSubsystem = new LiftSubsystem();
    private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
    private final ControlPanelSubsystem m_controlPanelSubsystem = new ControlPanelSubsystem();
    private final FuelShooterPIDSubsystem m_fuelShooterPIDSubsystem = new FuelShooterPIDSubsystem();
    private final FuelDeliverySubSystem m_fuelDeliverySubSystem = new FuelDeliverySubSystem();

    //m_liftSubsystem, m_driveSubsystem, m_controlPanelSubsystem, m_fuelShooterPIDSubsystem, m_fuelDeliverySubSystem

    // Joysticks
    private final Joystick shooterJoystick = new Joystick(1);
    private final Joystick driverJoystick = new Joystick(0);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

  
    // A chooser for autonomous commands
    SendableChooser<Command> m_chooser = new SendableChooser<>(); //AUTO
 
    /**
     * The container for the robot.  Contains subsystems, OI devices, and commands.
    */
    private RobotContainer() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
        // Smartdashboard Subsystems

        //m_liftSubsystem, m_driveSubsystem, m_controlPanelSubsystem, m_fuelShooterPIDSubsystem, m_fuelDeliverySubSystem
        // SmartDashboard Buttons  
        //SmartDashboard.putData("Autonomous Command", new AutonomousCommand(m_liftSubsystem, m_driveSubsystem, m_controlPanelSubsystem, m_fuelShooterPIDSubsystem, m_fuelDeliverySubSystem));
        //SmartDashboard.putData("DoNothingDefaultButton", new DoNothingDefaultButton());
        //SmartDashboard.putData("AutoGalacticSearchChallengePathA", new AutoGalacticSearchChallengePathA());
        //SmartDashboard.putData("AutoGalacticSearchChallengePathB", new AutoGalacticSearchChallengePathB());
        //SmartDashboard.putData("AutoBarrelRacingPath", new AutoBarrelRacingPath());
        //SmartDashboard.putData("AutoSlalomPath", new AutoSlalomPath());
        //SmartDashboard.putData("AutoBouncePath", new AutoBouncePath());
        SmartDashboard.putData("ControlPanelClockWise", new ControlPanelClockWise(m_controlPanelSubsystem));
        SmartDashboard.putData("ControlPanelCounterClockwise", new ControlPanelCounterClockwise(m_controlPanelSubsystem));
        SmartDashboard.putData("ControlPanelStop", new ControlPanelStop(m_controlPanelSubsystem));
        SmartDashboard.putData("ControlPanelAuto", new ControlPanelAuto(m_controlPanelSubsystem));
        SmartDashboard.putData("DriveTeleop", new DriveTeleop());
        SmartDashboard.putData("DriveStraight", new DriveStraight(m_driveSubsystem, 1.000, true));
        SmartDashboard.putData("DriveReverse", new DriveStraight(m_driveSubsystem, 1.000, false));
        SmartDashboard.putData("Drive 45 Right", new DriveAngle(m_driveSubsystem, 45.));
        SmartDashboard.putData("Drive -45 Left", new DriveAngle(m_driveSubsystem, -45.));
        SmartDashboard.putData("DriveReset", new DriveReset(m_driveSubsystem));
        SmartDashboard.putData("LiftMotorUp", new LiftMotorUp(m_liftSubsystem));
        SmartDashboard.putData("LiftMotorStop", new LiftMotorStop(m_liftSubsystem));
        SmartDashboard.putData("LiftMotorDown", new LiftMotorDown(m_liftSubsystem));
        SmartDashboard.putData("LiftWinchOn", new LiftWinchOn(m_liftSubsystem));
        SmartDashboard.putData("LiftWinchOff", new LiftWinchOff(m_liftSubsystem));
        SmartDashboard.putData("HippoMechOut", new HippoMechOut(m_fuelDeliverySubSystem));
        SmartDashboard.putData("HippoMechIn", new HippoMechIn(m_fuelDeliverySubSystem));
        SmartDashboard.putData("FuelReleaseExtend", new FuelReleaseExtend(m_fuelDeliverySubSystem));
        SmartDashboard.putData("FuelReleaseRetract", new FuelReleaseRetract(m_fuelDeliverySubSystem));
        SmartDashboard.putData("HippoMotorIn", new HippoMotorIn(m_fuelDeliverySubSystem));
        SmartDashboard.putData("HippoMotorOut", new HippoMotorOut(m_fuelDeliverySubSystem));
        SmartDashboard.putData("HippoMotorStop", new HippoMotorStop(m_fuelDeliverySubSystem));
        SmartDashboard.putData("HippoAutoCollectFuel", new HippoAutoCollectFuel());
        SmartDashboard.putData("ConveyorUp", new ConveyorUp(0.10, m_fuelDeliverySubSystem));
        SmartDashboard.putData("ConveyorDown", new ConveyorDown(0.10, m_fuelDeliverySubSystem));
        SmartDashboard.putData("ShooterOn", new ShooterOn(m_fuelShooterPIDSubsystem));
        SmartDashboard.putData("ShooterOff", new ShooterOff(m_fuelShooterPIDSubsystem));

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
        // Configure the button bindings
        configureButtonBindings();

        // Configure default commands
            // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND

        // Configure autonomous sendable chooser
            // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        m_chooser.setDefaultOption("Auto - Dance", new AutonomousCommand(m_liftSubsystem, m_driveSubsystem, m_controlPanelSubsystem, m_fuelShooterPIDSubsystem, m_fuelDeliverySubSystem));
        m_chooser.addOption("Auto - Demo / Test", new AutoDemoTest(m_liftSubsystem, m_driveSubsystem, m_controlPanelSubsystem, m_fuelShooterPIDSubsystem, m_fuelDeliverySubSystem));
        m_chooser.addOption("Auto - BarrelRacing Path", new AutoBarrelRacingPath());
        m_chooser.addOption("Auto - GalacticSearchChallengeA", new AutoGalacticSearchChallengePathA());
        m_chooser.addOption("Auto - GalacticSearchChallengeB", new AutoGalacticSearchChallengePathB());
        m_chooser.addOption("Auto - Boune Path", new AutoBouncePath());
        m_chooser.addOption("Auto - SalaomPath ", new AutoSlalomPath());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        SmartDashboard.putData("Auto Mode", m_chooser);
    }

    public static RobotContainer getInstance() {
        return m_robotContainer;
    }

    /**
     * Use this method to define your button->command mappings.  Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
     * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */

     private void configureButtonBindings() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
        // Create some buttons

        final JoystickButton shooterJoystickButton10 = new JoystickButton(shooterJoystick, 1);        
        shooterJoystickButton10.whenPressed(new DoNothingDefaultButton() ,true);
        //SmartDashboard.putData("ShooterJoystickButton10",new DoNothingDefaultButton() );

        final JoystickButton shooterJoystickButton9 = new JoystickButton(shooterJoystick, 1);        
        shooterJoystickButton9.whenPressed(new DoNothingDefaultButton() ,true);
        //SmartDashboard.putData("ShooterJoystickButton9",new DoNothingDefaultButton() );

        final JoystickButton shooterJoystickButton8 = new JoystickButton(shooterJoystick, 1);        
        shooterJoystickButton8.whenPressed(new DoNothingDefaultButton() ,true);
        //SmartDashboard.putData("ShooterJoystickButton8",new DoNothingDefaultButton() );

        final JoystickButton shooterJoystickButton7 = new JoystickButton(shooterJoystick, 1);        
        shooterJoystickButton7.whenPressed(new DoNothingDefaultButton() ,true);
        //SmartDashboard.putData("ShooterJoystickButton7",new DoNothingDefaultButton() );

        final JoystickButton shooterJoystickButton6 = new JoystickButton(shooterJoystick, 1);        
        shooterJoystickButton6.whenPressed(new DoNothingDefaultButton() ,true);
        //SmartDashboard.putData("ShooterJoystickButton6",new DoNothingDefaultButton() );

        final JoystickButton shooterJoystickButton5 = new JoystickButton(shooterJoystick, 1);        
        shooterJoystickButton5.whenPressed(new DoNothingDefaultButton() ,true);
        //SmartDashboard.putData("ShooterJoystickButton5",new DoNothingDefaultButton() );

        final JoystickButton shooterJoystickButton4 = new JoystickButton(shooterJoystick, 1);        
        shooterJoystickButton4.whenPressed(new DoNothingDefaultButton() ,true);
        //SmartDashboard.putData("ShooterJoystickButton4",new DoNothingDefaultButton() );

        final JoystickButton shooterJoystickButton3 = new JoystickButton(shooterJoystick, 1);        
        shooterJoystickButton3.whenPressed(new DoNothingDefaultButton() ,true);
        //SmartDashboard.putData("ShooterJoystickButton3",new DoNothingDefaultButton() );

        final JoystickButton shooterJoystickButton2 = new JoystickButton(shooterJoystick, 2);        
        shooterJoystickButton2.whenPressed(new ShooterOff(m_fuelShooterPIDSubsystem) ,true);
        //SmartDashboard.putData("SJ Shooter Off (B)",new ShooterOff(m_fuelDeliverySubSystem) );

        final JoystickButton shooterJoystickButton1 = new JoystickButton(shooterJoystick, 1);        
        shooterJoystickButton1.whenPressed(new ShooterOn(m_fuelShooterPIDSubsystem) ,true);
        //SmartDashboard.putData("SJ Shooter On (A)",new ShooterOn(m_fuelDeliverySubSystem) );

        final JoystickButton driverJoystickButton10 = new JoystickButton(driverJoystick, 1);        
        driverJoystickButton10.whenPressed(new DoNothingDefaultButton() ,true);
        //SmartDashboard.putData("DriverJoystickButton10",new DoNothingDefaultButton() );

        final JoystickButton driverJoystickButton9 = new JoystickButton(driverJoystick, 1);        
        driverJoystickButton9.whenPressed(new DoNothingDefaultButton() ,true);
        //SmartDashboard.putData("DriverJoystickButton9",new DoNothingDefaultButton() );

        final JoystickButton driverJoystickButton8 = new JoystickButton(driverJoystick, 1);        
        driverJoystickButton8.whenPressed(new DoNothingDefaultButton() ,true);
        //SmartDashboard.putData("DriverJoystickButton8",new DoNothingDefaultButton() );

        final JoystickButton driverJoystickButton7 = new JoystickButton(driverJoystick, 1);        
        driverJoystickButton7.whenPressed(new DoNothingDefaultButton() ,true);
        //SmartDashboard.putData("DriverJoystickButton7",new DoNothingDefaultButton() );

        final JoystickButton driverJoystickButton6 = new JoystickButton(driverJoystick, 1);        
        driverJoystickButton6.whenPressed(new DoNothingDefaultButton() ,true);
        //SmartDashboard.putData("DriverJoystickButton6",new DoNothingDefaultButton() );

        final JoystickButton driverJoystickButton5 = new JoystickButton(driverJoystick, 1);        
        driverJoystickButton5.whenPressed(new DoNothingDefaultButton() ,true);
        //SmartDashboard.putData("DriverJoystickButton5",new DoNothingDefaultButton() );

        final JoystickButton driverJoystickButton4 = new JoystickButton(driverJoystick, 1);        
        driverJoystickButton4.whenPressed(new DoNothingDefaultButton() ,true);
        //SmartDashboard.putData("DriverJoystickButton4",new DoNothingDefaultButton() );

        final JoystickButton driverJoystickButton3 = new JoystickButton(driverJoystick, 1);        
        driverJoystickButton3.whenPressed(new DoNothingDefaultButton() ,true);
        //SmartDashboard.putData("DriverJoystickButton3",new DoNothingDefaultButton() );

        final JoystickButton driverJoystickButton2 = new JoystickButton(driverJoystick, 1);        
        driverJoystickButton2.whenPressed(new DoNothingDefaultButton() ,true);
        //SmartDashboard.putData("DriverJoystickButton2",new DoNothingDefaultButton() );

        final JoystickButton driverJoystickButton1 = new JoystickButton(driverJoystick, 1);        
        driverJoystickButton1.whenPressed(new DoNothingDefaultButton() ,true);
        //SmartDashboard.putData("DriverJoystickButton1",new DoNothingDefaultButton() );



        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getDriverJoystick() {
        return driverJoystick;
    }

    public Joystick getShooterJoystick() {
        return shooterJoystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // The selected command will be run in autonomous
        //return m_chooser.getSelected();
        return RamseteCommand_Demo();
    }

    public Command RamseteCommand_Demo() {

        // Create a voltage constraint to ensure we don't accelerate too fast
        var autoVoltageConstraint =
            new DifferentialDriveVoltageConstraint(
                new SimpleMotorFeedforward(
                    DriveConstants.ksVolts,
                    DriveConstants.kvVoltSecondsPerMeter,
                    DriveConstants.kaVoltSecondsSquaredPerMeter),
                DriveConstants.kDriveKinematics,
                10);
    
        // Create config for trajectory
        TrajectoryConfig config =
            new TrajectoryConfig(
                    AutoConstants.kMaxSpeedMetersPerSecond,
                    AutoConstants.kMaxAccelerationMetersPerSecondSquared)
                // Add kinematics to ensure max speed is actually obeyed
                .setKinematics(DriveConstants.kDriveKinematics)
                // Apply the voltage constraint
                .addConstraint(autoVoltageConstraint);
    
        Trajectory exampleTrajectory =
            TrajectoryGenerator.generateTrajectory(
                // Start at the origin facing the +X direction
                new Pose2d(0, 0, new Rotation2d(0)),
                // Pass through these interior waypoints
                List.of(
                    new Translation2d(1.0, 0.0),
                    new Translation2d(1.50, 0.0),
                    //new Translation2d(2.00, 0.0),
                    new Translation2d(2.75, 2.0)),
                // End 3 location and rotation
                new Pose2d(2.75, 2.25, new Rotation2d(0)),
                // Pass config
                config);
    
        RamseteCommand ramseteCommand =
            new RamseteCommand(
                exampleTrajectory,
                m_driveSubsystem::getPose,
                new RamseteController(AutoConstants.kRamseteB, AutoConstants.kRamseteZeta),
                new SimpleMotorFeedforward(
                    DriveConstants.ksVolts,
                    DriveConstants.kvVoltSecondsPerMeter,
                    DriveConstants.kaVoltSecondsSquaredPerMeter),
                DriveConstants.kDriveKinematics,
                m_driveSubsystem::getWheelSpeeds,
                new PIDController(DriveConstants.kPDriveVel, 0, 0),
                new PIDController(DriveConstants.kPDriveVel, 0, 0),
                // RamseteCommand passes volts to the callback
                m_driveSubsystem::tankDriveVolts,
                m_driveSubsystem);
    
        // Reset odometry to the starting pose of the trajectory.
        m_driveSubsystem.resetOdometry(exampleTrajectory.getInitialPose());
    
        // Run path following command, then stop at the end.
        return ramseteCommand.andThen(() -> m_driveSubsystem.tankDriveVolts(0, 0));
    }
    

  

}

