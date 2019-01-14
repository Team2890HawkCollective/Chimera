/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.Commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Team 2890
 */
public class Pitcher {
//    public static double speedPitcherTopMotor = ;
//    public static double speedPitcherBottomMotor = ;

    int count = 0;

    public void init() {
    }

    public void execute() {
        if(RobotMap.pitcherSlowSpeed == true){
            RobotMap.pitcherBottomMotor.set(DriverStation.getInstance().getAnalogIn(1));
            RobotMap.pitcherTopMotor.set(DriverStation.getInstance().getAnalogIn(2));
        }
        if(RobotMap.pitcherSlowSpeed == false){
            RobotMap.pitcherBottomMotor.set(DriverStation.getInstance().getAnalogIn(3));
            RobotMap.pitcherTopMotor.set(DriverStation.getInstance().getAnalogIn(4));
        }
    }

//       2-Point Speeds  topMotor=0.505  bottomMotor=0.605
    
    public void end() {
        RobotMap.pitcherTopMotor.set(0.0);
        RobotMap.pitcherBottomMotor.set(0.0);
    }

    public void defaultCommand() {
        RobotMap.pitcherTopMotor.set(0.0);
        RobotMap.pitcherBottomMotor.set(0.0);
    }
}
