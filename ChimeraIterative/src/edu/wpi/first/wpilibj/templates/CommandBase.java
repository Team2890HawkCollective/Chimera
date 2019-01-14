/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.templates.Commands.*;

/**
 *
 * @author Team 2890
 */
//This is what calls each of the program's commands.  It uses four methods, 
//init, execute, end, and defaultCommand.  These are called by OI and use an int commandNumber
//to decide what command to launch.  Each command has it's own individual number.
//
public class CommandBase {

    public void initCommand(int commandNumber) {
        switch (commandNumber) {
            case RobotMap.COMMAND_NUMBER_PICK_UP_BALL:
                RobotMap.pickUpBall.init();
                break;
            case RobotMap.COMMAND_NUMBER_FIRE:
                RobotMap.pitcher.init();
                break;
            case RobotMap.COMMAND_NUMBER_LOWER_BRIDGE:
                RobotMap.lowerBridge.execute();
                break;
            case RobotMap.COMMAND_NUMBER_AUTOTARGET:
//                RobotMap.autoTarget.init();
            case RobotMap.COMMAND_NUMBER_MOVE_ANGLE:
                RobotMap.angle.init();
                break;
            default:
        }
    }

    public void executeCommand(int commandNumber) {
        switch (commandNumber) {
            case RobotMap.COMMAND_NUMBER_PICK_UP_BALL:
                RobotMap.pickUpBall.execute();
                break;
            case RobotMap.COMMAND_NUMBER_FIRE:
                RobotMap.pitcher.execute();
                break;
            case RobotMap.COMMAND_NUMBER_LOWER_BRIDGE:
                RobotMap.lowerBridge.execute();
                break;
            case RobotMap.COMMAND_NUMBER_AUTOTARGET:
//                RobotMap.autoTarget.execute();
                break;
            case RobotMap.COMMAND_NUMBER_MOVE_ANGLE:
                RobotMap.angle.execute();
                break;
            default:
        }
    }

    public void endCommand(int commandNumber) {
        switch (commandNumber) {
            case RobotMap.COMMAND_NUMBER_PICK_UP_BALL:
                RobotMap.pickUpBall.end();
                break;
            case RobotMap.COMMAND_NUMBER_FIRE:
                RobotMap.pitcher.end();
                break;
            case RobotMap.COMMAND_NUMBER_LOWER_BRIDGE:
                RobotMap.lowerBridge.end();
                break;
            case RobotMap.COMMAND_NUMBER_AUTOTARGET:
//                RobotMap.autoTarget.end();
                break;
            case RobotMap.COMMAND_NUMBER_MOVE_ANGLE:
                RobotMap.angle.end();
                break;
            default:
        }
    }

    public void defaultCommand(int commandNumber) {
        switch (commandNumber) {
            case RobotMap.COMMAND_NUMBER_PICK_UP_BALL:
                RobotMap.pickUpBall.defaultCommand();
                break;
            case RobotMap.COMMAND_NUMBER_FIRE:
                RobotMap.pitcher.defaultCommand();
                break;
            case RobotMap.COMMAND_NUMBER_LOWER_BRIDGE:
                RobotMap.lowerBridge.defaultCommand();
                break;
            case RobotMap.COMMAND_NUMBER_AUTOTARGET:
//                RobotMap.autoTarget.defaultCommand();
                break;
            case RobotMap.COMMAND_NUMBER_MOVE_ANGLE:
                RobotMap.angle.defaultCommand();
                break;
            default:
        }
    }
}