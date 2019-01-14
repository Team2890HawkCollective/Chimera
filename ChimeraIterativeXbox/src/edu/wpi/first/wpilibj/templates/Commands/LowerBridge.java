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
public class LowerBridge {

    private final double MOTOR_SPEED = 0.5;

    public void init() {
    }

    public void end() {

    }
    
    public void defaultCommand() {
        RobotMap.lowerBridgeMotor.set(0.0);
    }
    
    public void execute() {
        RobotMap.lowerBridgeMotor.set(RobotMap.assistingJoystick.getY());
    }

    public void executeXbox() {
        RobotMap.lowerBridgeMotor.set(MOTOR_SPEED);
    }
}
