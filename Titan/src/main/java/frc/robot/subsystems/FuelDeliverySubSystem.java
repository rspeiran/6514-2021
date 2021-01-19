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


import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Ultrasonic;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

/**
 *
 */
public class FuelDeliverySubSystem extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private Compressor compressor;
private PowerDistributionPanel powerDistributionPanel;
private DoubleSolenoid hippoDoubleSolenoid;
private PWMVictorSPX hippoSpeedController;
private PWMVictorSPX conveyorSpeedController;
private DoubleSolenoid fuelReleaseDoubleSolenoid;
private Ultrasonic fuelDetectorUltrasonic;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private Solenoid fuelReleaseSolenoid;

    private double HippoIntakeSpeed = .45;
    private double HippoMotorStop = 0;
  
    // 0.43 speed
    //private double ShooterTopMotorSpeed = 0.65;//0.50; //Start .42
    //private double ShooterBottomMotorSpped = 0.65; //0.60; //Start 0.42  //Start .46
  
    private double ConveyorMotorSpeed = 1.00;
  
    /**
    *
    */
    public FuelDeliverySubSystem() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
compressor = new Compressor(0);
 addChild("Compressor",compressor);
 

powerDistributionPanel = new PowerDistributionPanel(0);
 addChild("PowerDistributionPanel",powerDistributionPanel);
 

DoubleSolenoid hippoDoubleSolenoid = new DoubleSolenoid(0, 0, 1);
 addChild("HippoDoubleSolenoid",hippoDoubleSolenoid);
 

hippoSpeedController = new PWMVictorSPX(0);
 addChild("HippoSpeedController",hippoSpeedController);
 hippoSpeedController.setInverted(false);

conveyorSpeedController = new PWMVictorSPX(1);
 addChild("ConveyorSpeedController",conveyorSpeedController);
 conveyorSpeedController.setInverted(false);

DoubleSolenoid fuelReleaseDoubleSolenoid = new DoubleSolenoid(0, 2, 3);
 addChild("FuelReleaseDoubleSolenoid",fuelReleaseDoubleSolenoid);
 

fuelDetectorUltrasonic = new Ultrasonic(6, 7);
 addChild("FuelDetectorUltrasonic",fuelDetectorUltrasonic);
 


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void HippoExtendMech() {
        hippoDoubleSolenoid.set(Value.kReverse);
    }
  
    public void HippoRetractMech() {
        hippoDoubleSolenoid.set(Value.kForward);
  
    }
    public void HippoMotorForward() {
        hippoSpeedController.set(HippoIntakeSpeed * 1);
    }
    public void HippoMotorReverse() {
        hippoSpeedController.set(HippoIntakeSpeed * -1);
    }
  
    public void HippoMotorStop() {
        hippoSpeedController.set(0);
    }
  
    public void HippoReverseMotor() {
  
        // Protect the gear box
        final double currentSpeed = hippoSpeedController.get();
        
        if (currentSpeed > 0.03) {
            hippoSpeedController.set(HippoMotorStop);
        }
        else if (currentSpeed < -0.03) {
            hippoSpeedController.set(HippoMotorStop);
        }
        else {
            hippoSpeedController.set(HippoIntakeSpeed * -1);
        }
  
    }
  
    //public void ActivateShooter() {
    //    compressor.stop();
    //    shooterTopMotor.set(ShooterTopMotorSpeed);
    //    shooterBottomMotor.set(ShooterBottomMotorSpped);
    //    shooterVictor.set(ControlMode.PercentOutput, ShooterTopMotorSpeed);
    //    cameraForwardLight.set(Relay.Value.kForward);
    //}
  
    /**
     * Adjust Shooter Speed
     *
     * @param topMotor  Speed in range [-1,1]
     * @param bottomMotor Speed in range [-1,1]
     */
    //public void AdjustShooterSpeed(double topMotor, double bottomMotor){
    //    shooterTopMotor.set(topMotor);
    //    shooterBottomMotor.set(bottomMotor);
    //    shooterVictor.set(ControlMode.PercentOutput, ShooterTopMotorSpeed);
    //
    //}
  
    //public void StopShooter() {
    //    PopCornRetract();
    //    shooterTopMotor.set(HippoMotorStop);
    //    shooterBottomMotor.set(HippoMotorStop);
    //    shooterVictor.set(ControlMode.PercentOutput, HippoMotorStop);
  
    //    compressor.start();
    //    cameraForwardLight.set(Relay.Value.kOff);
    //}
  
    public void ConveyorOn() {
        conveyorSpeedController.set(ConveyorMotorSpeed);
    }
    public void ConveyorOff() {
        conveyorSpeedController.set(0);
    }
  
    public void ConveyorDown() {
        conveyorSpeedController.set(-1 * ConveyorMotorSpeed);
    }
  
    public void PopCornRetract() {
        fuelReleaseSolenoid.set(false);
  
    }
    public void PopCornExtend() {
        fuelReleaseSolenoid.set(true);
  
    }
  


}

