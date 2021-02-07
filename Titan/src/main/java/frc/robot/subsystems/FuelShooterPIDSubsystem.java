package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpiutil.math.MathUtil;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;

public class FuelShooterPIDSubsystem extends PIDSubsystem {

    private Encoder m_ShooterEncoder = new Encoder(0,1, false, Encoder.EncodingType.k2X);
    private Spark m_ShooterTopMotor = new Spark(0);

    //m_ShooterTopMotor = new Spark(0);

    private double ShooterSpeed = 0.85;

    //P I D Variables
    private static final double kP = 0.0;  
    private static final double kI = 0.0;
    private static final double kD = 0.0;
    private static final double kF = 1.00;

    private double mRate;
    private double maxVelocityTop = 475;
 
    
    public FuelShooterPIDSubsystem() {
        super(new PIDController(kP, kI, kD));
        getController().setTolerance(0.3);

        //Encoder m_ShooterEncoder = new Encoder(0,1, false, Encoder.EncodingType.k2X);
        addChild("Shooter Encoder",m_ShooterEncoder);
        m_ShooterEncoder.setDistancePerPulse(16./256.);
        m_ShooterEncoder.setMaxPeriod((.1));
        m_ShooterEncoder.setMinRate(10);
        m_ShooterEncoder.setReverseDirection(false);
        m_ShooterEncoder.setSamplesToAverage(5);

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
        //setSetpoint(150);
        //enable();

    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        super.periodic();

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    @Override
    public double getMeasurement() {
        mRate = 0;
        
        try {
            mRate = m_ShooterEncoder.getRate();
        } catch (RuntimeException ex) {
            System.out.println("Exception Getting Shooter Rate: " + ex.getMessage());
        }
        
        return mRate;

    }

    @Override
    public void useOutput(double output, double setpoint) {
        output += setpoint*kF;
        double calcV = output/maxVelocityTop;

        //m_ShooterTopMotor.pidWrite(output);
        //m_ShooterTopMotor.set(output/maxVelocityTop);
        if (output >1) { //Max Value
            calcV=1;
        }
        else if (output <0)  //No reversing!
        {
            calcV = 0;
        }

        m_ShooterTopMotor.set(calcV);

        System.out.print(" Output:   " + output);
        System.out.print(" CalcV:    " + calcV);
        System.out.print(" Rate:     " + mRate);
        System.out.println(" Setpoint: " + setpoint);

    }

    public void ShooterOn() {
        m_ShooterTopMotor.set(ShooterSpeed);

    }

    public void ShooterOff() {
        m_ShooterTopMotor.set(0);
    }
 
}
