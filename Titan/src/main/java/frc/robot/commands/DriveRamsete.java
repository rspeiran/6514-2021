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
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

import frc.robot.Constants.AutoConstants;
import frc.robot.Constants.DriveConstants;
//import frc.robot.Constants.OIConstants;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import edu.wpi.first.wpilibj.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj.trajectory.constraint.DifferentialDriveVoltageConstraint;
//import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
//import edu.wpi.first.wpilibj2.command.RunCommand;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.RamseteController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import java.util.List;

/**
 *
 */
public class DriveRamsete extends CommandBase {

    private final DriveSubsystem m_driveSubsystem;

    private Trajectory exampleTrajectory;
    private RamseteCommand ramseteCommand;
    private TrajectoryConfig config;

    public DriveRamsete(DriveSubsystem subsystem) {

        m_driveSubsystem = subsystem;
        addRequirements(m_driveSubsystem);

        // Create a voltage constraint to ensure we don't accelerate too fast


    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {

        var autoVoltageConstraint = 
        new DifferentialDriveVoltageConstraint(
            new SimpleMotorFeedforward(
                DriveConstants.ksVolts,
                DriveConstants.kvVoltSecondsPerMeter,
                DriveConstants.kaVoltSecondsSquaredPerMeter),
            DriveConstants.kDriveKinematics,10);

            System.out.println("autoVoltage: " + autoVoltageConstraint);

        // Create config for trajectory
        config = new TrajectoryConfig(
            AutoConstants.kMaxSpeedMetersPerSecond,
            AutoConstants.kMaxAccelerationMetersPerSecondSquared)
            // Add kinematics to ensure max speed is actually obeyed
            .setKinematics(DriveConstants.kDriveKinematics)
            // Apply the voltage constraint
            .addConstraint(autoVoltageConstraint);

            System.out.println("config: " + config);

        // An example trajectory to follow.  All units in meters.
        exampleTrajectory = TrajectoryGenerator.generateTrajectory(
            // Start at the origin facing the +X direction
            new Pose2d(0, 0, new Rotation2d(0)),
            // Pass through these two interior waypoints, making an 's' curve path
            List.of(new Translation2d(1, 1), 
                    new Translation2d(2, -1)),
            // End 3 meters straight ahead of where we started, facing forward
            new Pose2d(3, 0, new Rotation2d(0)),
            // Pass config
            config);

            System.out.println("Trajectory: " + exampleTrajectory);

        ramseteCommand = new RamseteCommand(
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

        //ramseteCommand.execute();

        
        // Reset odometry to the starting pose of the trajectory.
        m_driveSubsystem.resetOdometry(exampleTrajectory.getInitialPose());

        //ramseteCommand.execute();
        //ramseteCommand.withTimeout(60);
        //ramseteCommand.execute();
        ramseteCommand.andThen(() -> m_driveSubsystem.tankDriveVolts(0, 0));
        

    }

    // Called every time the scheduler runs while the command is scheduled.
    //@Override
    //public void execute() {
        // Run path following command, then stop at the end.
        //return ramseteCommand.andThen(() -> m_driveSubsystem.tankDriveVolts(0, 0));
        //ramseteCommand.andThen(() -> m_driveSubsystem.tankDriveVolts(0, 0));
        //ramseteCommand.initialize();
        
    //}


    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_driveSubsystem.tankDriveVolts(0, 0);
    }

    // Returns true when the command should end.
    //@Override
    //public boolean isFinished() {
    //        return ramseteCommand.isFinished();
    //}

    @Override
    public boolean runsWhenDisabled() {
        m_driveSubsystem.tankDriveVolts(0, 0);
        return false;
    }
}
