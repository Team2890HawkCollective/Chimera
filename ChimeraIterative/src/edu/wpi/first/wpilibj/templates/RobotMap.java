package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
//import edu.wpi.first.wpilibj.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.templates.Commands.Angle;
import edu.wpi.first.wpilibj.templates.Commands.LowerBridge;
import edu.wpi.first.wpilibj.templates.Commands.PickUpBall;
import edu.wpi.first.wpilibj.templates.Commands.Pitcher;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around. The Game.
 */
//NOTE FROM RYAN:  I have created this RobotMap in the Iterative version of Chimera
//to be the creation place of EVERYTHING!!!  When using the other classes, please
//create the things that are to go between classes here.  Joysticks, Jaguars, Sensors,
//Command Numbers(I'll explain later), etc. etc.
public class RobotMap {
//    Here you will create the constant variables for all things such as ports, side
//    cars, modules, etc.
    public static final String pitcherSpeed = new String("Pitcher Speed");
    public static final String conveyorSpeed = new String("Conveyor Speed");
    
    public static final double CONVEYORMOTORSPEED = 1.0;

    public static final int DIGITAL_SIDE_CAR = 1;
    public static final int ANALOG_MODULE = 1;
    public static final int LEFT_MOTOR_PORT = 2;
    public static final int RIGHT_MOTOR_PORT = 1;
    public static final int ANGLE_MOTOR_PORT = 10;
    public static final int CONVEYOR_MOTOR_PORT = 4;
    public static final int LOWER_BRIDGE_MOTOR_PORT = 5;
    public static final int GYRO_CHANNEL = 1;
    public static final int TOP_SHOOTER_JAGUAR_PORT = 7;
    public static final int BOTTOM_SHOOTER_JAGUAR_PORT = 8;
    public static final int LOWER_BRIDGE_LIMIT_SWITCH_PORT = 4;
    public static final int RAISE_BRIDGE_LIMIT_SWITCH_PORT = 3;
    public static final int LEFT_DRIVE_JOYSTICK = 1;
    public static final int RIGHT_DRIVE_JOYSTICK = 2;
    public static final int ASSISTANCE_JOYSTICK = 3;
    
    
    //put the constants for button numbers here.
    //All of the buttons below are subject to change based on their programmers
    //I am just making them these so that the red line will go away.
    
    public static final int BUTTON_FIRE = 1;
    public static final int BUTTON_CONVEYOR_BELT_LOWER = 2;                 //The trigger
    public static final int BUTTON_CONVEYOR_BELT_RAISE = 3;
    public static final int BUTTON_AUTO_TARGET_ABORT = 6;
    public static final int BUTTON_AUTO_TARGET = 7;
    public static final int BUTTON_LOWER_BRIDGE = 10;
    public static final int BUTTON_RAISE_BRIDGE = 11;
//    public static final int BUTTON_RAISE_ANGLE = 11;
//    public static final int BUTTON_LOWER_ANGLE = 10;
    public static final int BUTTON_SLOW_SPEED = 10;
    public static final int BUTTON_FAST_SPEED = 11;
    
    
    
    
    //create all of your objects here.
    public static Jaguar leftDriveMotor = new Jaguar(DIGITAL_SIDE_CAR,
            LEFT_MOTOR_PORT);
    public static Jaguar rightDriveMotor = new Jaguar(DIGITAL_SIDE_CAR,
            RIGHT_MOTOR_PORT);
    public static Jaguar pitcherBottomMotor = new Jaguar(DIGITAL_SIDE_CAR,
            BOTTOM_SHOOTER_JAGUAR_PORT);
    public static Jaguar pitcherTopMotor = new Jaguar(DIGITAL_SIDE_CAR,
            TOP_SHOOTER_JAGUAR_PORT);
    public static Jaguar angleMotor = new Jaguar(DIGITAL_SIDE_CAR,
            ANGLE_MOTOR_PORT);
    public static Jaguar lowerBridgeMotor = new Jaguar(DIGITAL_SIDE_CAR,
            LOWER_BRIDGE_MOTOR_PORT);
    public static Jaguar conveyorBeltMotor = new Jaguar(DIGITAL_SIDE_CAR,
            CONVEYOR_MOTOR_PORT);
    public static Joystick leftDriveJoystick = new Joystick(LEFT_DRIVE_JOYSTICK);
    public static Joystick rightDriveJoystick = new Joystick(RIGHT_DRIVE_JOYSTICK);
    public static Joystick assistingJoystick = new Joystick(ASSISTANCE_JOYSTICK);
    public static RobotDrive robotDrive = new RobotDrive(leftDriveMotor,
            rightDriveMotor);
    public static DigitalInput lowerBridgeLimitSwitch = new DigitalInput(DIGITAL_SIDE_CAR,
            LOWER_BRIDGE_LIMIT_SWITCH_PORT);
    public static DigitalInput raiseBridgeLimitSwitch = new DigitalInput(DIGITAL_SIDE_CAR,
            RAISE_BRIDGE_LIMIT_SWITCH_PORT);
    
    public static SmartDashboard hawkSmartDashboard = new SmartDashboard();
    
    public static OI oi = new OI();
   
//    create commands and Command Numbers here.
   
    public static CommandBase commandBase = new CommandBase();
   
    public static PickUpBall pickUpBall = new PickUpBall();
    public static final int COMMAND_NUMBER_PICK_UP_BALL = 1;
    
    
    
    public static Pitcher pitcher = new Pitcher();
    public static final int COMMAND_NUMBER_FIRE = 2;
    
    
    public static LowerBridge lowerBridge = new LowerBridge();
    public static final int COMMAND_NUMBER_LOWER_BRIDGE = 3;
//    public static AutoTarget autoTarget = new AutoTarget();
    public static final int COMMAND_NUMBER_AUTOTARGET = 4;
    
    public static Angle angle = new Angle();
    public static final int COMMAND_NUMBER_MOVE_ANGLE = 5;
    
    public static boolean pitcherSlowSpeed = true;
    public static boolean autoTargetActivated = false;

}