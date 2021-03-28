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

/**
 *
 */
public class DriveStraight extends CommandBase {

    private final DriveSubsystem m_driveSubsystem;

    //private final double kP = .0255;
    private final double kPbyAngle = 0.0255;
    private double Speed;
    private double distanceToTravel;

    //private double leftValue;
    //private double rightValue;
    //private double error;
    //private double correction;

    private double errorByAngle;
    private double correctionByAngle;
   
    enum Direction {
        Forward,
        Reverse
    }
    private Boolean driveDirection;

    public DriveStraight(DriveSubsystem subsystem, double traveldistance, boolean DriveForward) {

        m_driveSubsystem = subsystem;
        addRequirements(m_driveSubsystem);

        distanceToTravel = traveldistance;
        driveDirection = DriveForward;

        
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_driveSubsystem.ZeroEncoders();
        Speed = 0.75;
        
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        // Assuming no wheel slip, the difference in encoder distances is proportional to the heading error
        //leftValue =  m_driveSubsystem.leftDriveEncoder.getDistance();
        //rightValue =  m_driveSubsystem.rightDriveEncoder.getDistance();
        //error = leftValue - rightValue;
        //correction = (kP * error);

        errorByAngle = m_driveSubsystem.getHeading();
        correctionByAngle = kPbyAngle * errorByAngle;

        if (correctionByAngle > 0.25) {
            correctionByAngle = 0.25;
        }
        if (correctionByAngle < -0.25) {
            correctionByAngle = -0.25;
        }

        //Slow down near the end.
        //if ((Math.abs(distanceToTravel) - Math.abs(m_driveSubsystem.leftDriveEncoder.getDistance()) < 0.5)
        //    || (Math.abs(distanceToTravel) - Math.abs(m_driveSubsystem.rightDriveEncoder.getDistance()) < 0.5)) {
        //        Speed = 0.45;
        //}
        //if (Speed < 0) {
        //    Speed = 0;
        //}

        // Drives forward continuously at half speed, using the encoders to stabilize the heading
        //What if moving backwards?

        if(driveDirection) {
            //m_driveSubsystem.TankDriveControl(Speed + correction, Speed - correction);
            m_driveSubsystem.TankDriveControl(Speed-correctionByAngle, Speed + correctionByAngle);
        }else {
            //m_driveSubsystem.TankDriveControl(-1*(Speed + correction), -1*(Speed - correction));
            m_driveSubsystem.TankDriveControl(-1 * (Speed + correctionByAngle), -1 * (Speed - correctionByAngle));

        }

        //System.out.print("Final Left Speed " + (Speed + correction));
        //System.out.print(" Right Speed " + (Speed - correction));
        //System.out.println(" Correction " + correction);

        System.out.print("Final Left: " + (Speed + correctionByAngle));
        System.out.print(" Right: " + (Speed - correctionByAngle));
        System.out.println(" Correction: " + correctionByAngle);

        


    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {

    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if (Math.abs(m_driveSubsystem.leftDriveEncoder.getDistance()) >= distanceToTravel || 
            Math.abs(m_driveSubsystem.rightDriveEncoder.getDistance()) >= distanceToTravel) {
            // || Math.abs(error) >= .25) {
            return true;
        }
        else {
            return false;
        }
        
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
