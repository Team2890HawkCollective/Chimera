/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.MotorSafetyHelper;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Team 2890
 */

//This class is for everything having to do with Joysticks and Buttons.  Within
//the if structures one calls the correlating command by calling CommandBase and
//using either the .start, .execute, or .end commands depending on the situation.
//the autoTargetActivated is used to make it so that you cannot fire or drive 
//while the AutoTarget command is running.  
public class OI extends RobotMap {
    
    /*************************************************************
     * To Adam: 
     * 
     * If you extend this class off of RobotMap you will inherit
     * all of the variables from it; in other words clear up this 
     * code.  Extending it will not break anything, it will just
     * associate this class with the variables of the parent class.
     * Nothing in the rest of the code will have to change,
     * it will just make it so that you don't have to type 
     * RobotMap before everything.
     *                                              -Ryan
     ************************************************************/

    public void OI() {
        if (autoTargetActivated == false) {
            robotDrive.tankDrive(leftDriveJoystick, rightDriveJoystick);
        }
        
        //Run if doing competition style(Two drive joysticks and one assisting joystick)
        
        if (assistingJoystick.getRawButton(BUTTON_CONVEYOR_BELT_RAISE)
                == true) {
            commandBase.initCommand(COMMAND_NUMBER_PICK_UP_BALL);
            commandBase.executeCommand(COMMAND_NUMBER_PICK_UP_BALL);
        }

        if (assistingJoystick.getRawButton(BUTTON_CONVEYOR_BELT_LOWER)
                == true) {
            commandBase.endCommand(COMMAND_NUMBER_PICK_UP_BALL);
        }

        if (assistingJoystick.getRawButton(BUTTON_CONVEYOR_BELT_RAISE) == false
                && assistingJoystick.getRawButton(BUTTON_CONVEYOR_BELT_LOWER) == false) {
            commandBase.defaultCommand(COMMAND_NUMBER_PICK_UP_BALL);
        }

        if (assistingJoystick.getRawButton(BUTTON_FIRE) == true) {
            commandBase.executeCommand(COMMAND_NUMBER_FIRE);
        }

        if (assistingJoystick.getRawButton(BUTTON_FIRE) == false) {
            commandBase.defaultCommand(COMMAND_NUMBER_FIRE);
        }
        
        
        //Run if doing outreach (RightDriveJoystick now shoots and moves conveyor belt)
        // assistingJoystick no longer does anything
        /*
        if (rightDriveJoystick.getRawButton(BUTTON_CONVEYOR_BELT_RAISE)
                == true) {
            commandBase.initCommand(COMMAND_NUMBER_PICK_UP_BALL);
            commandBase.executeCommand(COMMAND_NUMBER_PICK_UP_BALL);
        }

        if (rightDriveJoystick.getRawButton(BUTTON_CONVEYOR_BELT_LOWER)
                == true) {
            commandBase.endCommand(COMMAND_NUMBER_PICK_UP_BALL);
        }

        if (rightDriveJoystick.getRawButton(BUTTON_CONVEYOR_BELT_RAISE) == false
                && rightDriveJoystick.getRawButton(BUTTON_CONVEYOR_BELT_LOWER) == false) {
            commandBase.defaultCommand(COMMAND_NUMBER_PICK_UP_BALL);
        }

        if (rightDriveJoystick.getRawButton(BUTTON_FIRE) == true) {
            commandBase.executeCommand(COMMAND_NUMBER_FIRE);
        }

        if (rightDriveJoystick.getRawButton(BUTTON_FIRE) == false) {
            commandBase.defaultCommand(COMMAND_NUMBER_FIRE);
        }
        */
//------------------------------------------------------------------------------
        
        if (assistingJoystick.getY() > 0.1 || assistingJoystick.getY() < -0.1) {
            commandBase.initCommand(COMMAND_NUMBER_LOWER_BRIDGE);
        } else {
            commandBase.defaultCommand(COMMAND_NUMBER_LOWER_BRIDGE);
        }
        

        if (assistingJoystick.getRawButton(BUTTON_SLOW_SPEED) == true) {
            pitcherSlowSpeed = true;
            hawkSmartDashboard.putString(pitcherSpeed, new String("Slow Speed"));
        }

        if (assistingJoystick.getRawButton(BUTTON_FAST_SPEED) == true) {
            pitcherSlowSpeed = false;
            hawkSmartDashboard.putString(pitcherSpeed, new String("Fast Speed"));
        }

//        if (RobotMap.assistingJoystick.getRawButton(RobotMap.BUTTON_LOWER_ANGLE) == false
//                && RobotMap.assistingJoystick.getRawButton(RobotMap.BUTTON_RAISE_ANGLE) == false) {
//            RobotMap.commandBase.defaultCommand(RobotMap.COMMAND_NUMBER_MOVE_ANGLE);
//        }
//        
//        if (RobotMap.assistingJoystick.getRawButton(RobotMap.BUTTON_AUTO_TARGET) == true) {
//              RobotMap.autoTargetActivated = true;
//                RobotMap.hawkSmartDashboard.putString(new String("Auto target"), new String(
//                        "On"));
//              RobotMap.commandBase.executeCommand(RobotMap.COMMAND_NUMBER_AUTOTARGET);
//        }
//        
//        if (RobotMap.rightDriveJoystick.getRawButton(RobotMap.BUTTON_RAISE_BRIDGE) == true) {
//            RobotMap.commandBase.endCommand(RobotMap.COMMAND_NUMBER_LOWER_BRIDGE);
//        }
//        
//        if (RobotMap.assistingJoystick.getY() < 0.){
//            RobotMap.commandBase.defaultCommand(RobotMap.COMMAND_NUMBER_LOWER_BRIDGE);
//        }
//
//        if (RobotMap.assistingJoystick.getRawButton(RobotMap.BUTTON_RAISE_ANGLE) == true) {
//            RobotMap.commandBase.executeCommand(RobotMap.COMMAND_NUMBER_MOVE_ANGLE);
//        }
//
//        if (RobotMap.assistingJoystick.getRawButton(RobotMap.BUTTON_LOWER_ANGLE) == true) {
//            RobotMap.commandBase.endCommand(RobotMap.COMMAND_NUMBER_MOVE_ANGLE);
//        }
    }
}


//            _____                    _____                    _____                            _____                   _______                           _____                    _____                    _____                           
//           /\    \                  /\    \                  /\    \                          /\    \                 /::\    \                         /\    \                  /\    \                  /\    \                           
//          /::\    \                /::\____\                /::\    \                        /::\    \               /::::\    \                       /::\    \                /::\    \                /::\____\                      
//         /::::\    \              /:::/    /               /::::\    \                      /::::\    \             /::::::\    \                     /::::\    \              /::::\    \              /:::/    /               
//        /::::::\    \            /:::/    /               /::::::\    \                    /::::::\    \           /::::::::\    \                   /::::::\    \            /::::::\    \            /:::/    /               
//       /:::/\:::\    \          /:::/    /               /:::/\:::\    \                  /:::/\:::\    \         /:::/~~\:::\    \                 /:::/\:::\    \          /:::/\:::\    \          /:::/    /                
//      /:::/__\:::\    \        /:::/    /               /:::/__\:::\    \                /:::/__\:::\    \       /:::/    \:::\    \               /:::/  \:::\    \        /:::/__\:::\    \        /:::/____/                 
//     /::::\   \:::\    \      /:::/    /                \:::\   \:::\    \              /::::\   \:::\    \     /:::/    / \:::\    \             /:::/    \:::\    \      /::::\   \:::\    \      /::::\    \               
//    /::::::\   \:::\    \    /:::/    /      _____    ___\:::\   \:::\    \            /::::::\   \:::\    \   /:::/____/   \:::\____\           /:::/    / \:::\    \    /::::::\   \:::\    \    /::::::\    \   _____    
//   /:::/\:::\   \:::\    \  /:::/____/      /\    \  /\   \:::\   \:::\    \          /:::/\:::\   \:::\____\ |:::|    |     |:::|    |         /:::/    /   \:::\ ___\  /:::/\:::\   \:::\    \  /:::/\:::\    \ /\    \ 
//  /:::/  \:::\   \:::\____\|:::|    /      /::\____\/::\   \:::\   \:::\____\        /:::/  \:::\   \:::|    ||:::|____|     |:::|    |        /:::/____/     \:::|    |/:::/  \:::\   \:::\____\/:::/  \:::\    /::\____\
//  \::/    \:::\   \::/    /|:::|____\     /:::/    /\:::\   \:::\   \::/    /        \::/   |::::\  /:::|____| \:::\    \   /:::/    /         \:::\    \     /:::|____|\::/    \:::\  /:::/    /\::/    \:::\  /:::/    /  
//   \/____/ \:::\   \/____/  \:::\    \   /:::/    /  \:::\   \:::\   \/____/          \/____|:::::\/:::/    /   \:::\    \ /:::/    /           \:::\    \   /:::/    /  \/____/ \:::\/:::/    /  \/____/ \:::\/:::/    /   
//            \:::\    \       \:::\    \ /:::/    /    \:::\   \:::\    \                    |:::::::::/    /     \:::\    /:::/    /             \:::\    \ /:::/    /            \::::::/    /            \::::::/    /        
//             \:::\____\       \:::\    /:::/    /      \:::\   \:::\____\                   |::|\::::/    /       \:::\__/:::/    /               \:::\    /:::/    /              \::::/    /              \::::/    /           
//              \::/    /        \:::\__/:::/    /        \:::\  /:::/    /                   |::| \::/____/         \::::::::/    /                 \:::\  /:::/    /               /:::/    /               /:::/    /              
//               \/____/          \::::::::/    /          \:::\/:::/    /                    |::|  ~|                \::::::/    /                   \:::\/:::/    /               /:::/    /               /:::/    /                 
//                                 \::::::/    /            \::::::/    /                     |::|   |                 \::::/    /                     \::::::/    /               /:::/    /               /:::/    /                    
//                                  \::::/    /              \::::/    /                      \::|   |                  \::/____/                       \::::/    /               /:::/    /               /:::/    /                       
//                                   \::/____/                \::/    /                        \:|   |                   ~~                              \::/____/                \::/    /                \::/    /                          
//                                    ~~                       \/____/                          \|___|                                                    ~~                       \/____/                  \/____/                             
                                                                                                                                                                                                                                            