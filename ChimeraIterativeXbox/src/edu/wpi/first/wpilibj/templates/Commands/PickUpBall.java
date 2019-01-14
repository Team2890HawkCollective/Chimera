/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.Commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.templates.CommandBase;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Team 2890
 */
public class PickUpBall extends CommandBase {
//    private final double MOTOR_SPEED;
    public void init(){
        
    }
           
    public void execute(){
    RobotMap.conveyorBeltMotor.set(RobotMap.CONVEYORMOTORSPEED);
}
    public void end(){
                RobotMap.conveyorBeltMotor.set(-RobotMap.CONVEYORMOTORSPEED);
    }
    
    public void defaultCommand(){
        RobotMap.conveyorBeltMotor.set(0.0);
    }
}
