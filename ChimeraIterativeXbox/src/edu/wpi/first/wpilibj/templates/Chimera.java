/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Chimera extends IterativeRobot {

    int count;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        count = 0;

    }

    /**
     * This function is called periodically during autonomous
     */
    
    public void autonomousInit(){
//                RobotMap.pitcherSlowSpeed = false;    
    }
    
    public void autonomousPeriodic() {
//        count++;
//        RobotMap.commandBase.executeCommand(RobotMap.COMMAND_NUMBER_FIRE);
//              if(count > 2000){
//                 RobotMap.commandBase.executeCommand(RobotMap.COMMAND_NUMBER_PICK_UP_BALL); 
//              }
        
        
        
    }

    public void teleopInit() {
        RobotMap.pitcherSlowSpeed = true;
        RobotMap.hawkSmartDashboard.putDouble(RobotMap.conveyorSpeed, RobotMap.CONVEYORMOTORSPEED);
        RobotMap.hawkSmartDashboard.putString(new String("GOOD LUCK"), new String("GOOD LUCK!"));
        RobotMap.hawkSmartDashboard.putString(new String("Reminder"), new String("PLUG IN JOYSTICKS!"));
        RobotMap.hawkSmartDashboard.putString(new String("Scoring"), new String("go for 2-points"));
        RobotMap.hawkSmartDashboard.putString(RobotMap.pitcherSpeed, new String("Slow Speed"));

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        getWatchdog().feed();
        RobotMap.oi.OI();
    }
}
