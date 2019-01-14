/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.Commands;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.templates.RobotMap;
import java.util.*;

/**
 *
 * @author Kyle Almberg and Drew Gilbert
 */
public class Angle {

    private static double CLOSE_ENOUGH = 0.01;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    double angle, wantedAngle;
    private final double MOTOR_SPEED = DriverStation.getInstance().getAnalogIn(4);

    public double getAngle() {
//        angle = RobotMap.gyro.getAngle();
        return angle;
    }

    public boolean isAngleGood(double WantedAngle) {
        wantedAngle = WantedAngle;
        if (angle == wantedAngle) {
            RobotMap.angleMotor.stopMotor();
            return true;
        } else {
            return false;
        }
    }

    public void changeAngle() {
        if (equalsDouble(angle, wantedAngle)) {
            RobotMap.angleMotor.stopMotor();
            return;
        }
        if (angle > wantedAngle) {
            RobotMap.angleMotor.set(-MOTOR_SPEED);
        }
        if (angle < wantedAngle) {
            RobotMap.angleMotor.set(MOTOR_SPEED);
        }
    }

    boolean equalsDouble(double a, double b) {
        return (Math.abs(a - b) < CLOSE_ENOUGH);
    }

    public void init() {
    }

    public void execute() {
        RobotMap.angleMotor.set(MOTOR_SPEED);
    }

    public void end() {
        RobotMap.angleMotor.set(-MOTOR_SPEED);
    }

    public void defaultCommand() {
        RobotMap.angleMotor.set(0.0);
    }
}