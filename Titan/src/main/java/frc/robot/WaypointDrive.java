package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.RamseteController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import frc.robot.Constants.AutoConstants;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.OIConstants;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import edu.wpi.first.wpilibj.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj.trajectory.constraint.DifferentialDriveVoltageConstraint;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import java.util.List;

public class WaypointDrive {

    private DriveSubsystem m_driveSubsystem;
    private Pose2d m_startPose;
    private Translation2d[] m_path;
    private Pose2d m_endPose;


    public Command DriveRamset(DriveSubsystem subsystemDrive, Pose2d startPose, Translation2d[] path, Pose2d endPose ) {

    m_driveSubsystem = subsystemDrive;
    m_startPose = startPose;
    m_path = path;
    m_endPose = endPose;    

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
    
        // An example trajectory to follow.  All units in meters.
        // Trajectory exampleTrajectory =
        //     TrajectoryGenerator.generateTrajectory(
        //         // Start at the origin facing the +X direction
        //         new Pose2d(0, 0, new Rotation2d(0)),
        //         //List.of(new Translation2d(2.0, 0.25), new Translation2d(2.25, 0.75)),
        //         List.of(new Translation2d(3, 1.5)),
        //         new Pose2d(3.5, 3.0, new Rotation2d(1.57)),
        //         config);

        // Trajectory exampleTrajectory =
        // TrajectoryGenerator.generateTrajectory(
        //     // Start at the origin facing the +X direction
        //     new Pose2d(0, 0, new Rotation2d(0)),
        //     List.of(new Translation2d(0.8, 0.0),
        //             new Translation2d(2, 0.0), 
        //             new Translation2d(2.5, -0.25),
        //             new Translation2d(2.75, -0.50),
        //             new Translation2d(3.00, -0.25),
        //             new Translation2d(3.25, 0.0),
        //             new Translation2d(3.50, 0.25),
        //             new Translation2d(4.00, 0.00)
        //             ),
        //     new Pose2d(5.0, 0, new Rotation2d(0)),
        //     config);

        Trajectory exampleTrajectory =
        TrajectoryGenerator.generateTrajectory(
            // Start at the origin facing the +X direction
            m_startPose,
            List.of(m_path),
            m_endPose,
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
