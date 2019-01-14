//
//package edu.wpi.first.wpilibj.templates;
//
//import edu.wpi.first.wpilibj.DriverStationLCD;
//import edu.wpi.first.wpilibj.IterativeRobot;
//import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj.camera.AxisCamera;
//import edu.wpi.first.wpilibj.command.Scheduler;
//import edu.wpi.first.wpilibj.image.*;
//import edu.wpi.first.wpilibj.templates.CommandBase;
//
///**
// * Sample program to use NIVision to find rectangles in the scene that are illuminated
// * by a red ring light (similar to the model from FIRSTChoice). The camera sensitivity
// * is set very low so as to only show light sources and remove any distracting parts
// * of the image.
// * 
// * The CriteriaCollection is the set of criteria that is used to filter the set of
// * rectangles that are detected. In this example we're looking for rectangles with
// * a minimum width of 30 pixels and maximum of 400 pixels. Similar for height (see
// * the addCriteria() methods below.
// * 
// * The algorithm first does a color threshold operation that only takes objects in the
// * scene that have a significant red color component. Then removes small objects that
// * might be caused by red reflection scattered from other parts of the scene. Then
// * a convex hull operation fills all the rectangle outlines (even the partially occluded
// * ones). Finally a particle filter looks for all the shapes that meet the requirements
// * specified in the criteria collection.
// *
// * Look in the VisionImages directory inside the project that is created for the sample
// * images as well as the NI Vision Assistant file that contains the vision command
// * chain (open it with the Vision Assistant)
// */
//public class HawkCamera extends IterativeRobot {
//    
//    AxisCamera camera;          // the axis camera object (connected to the switch)
//    BinaryImage sensorimage;
//    CriteriaCollection cc;      // the criteria for doing the particle filter operation
////    SmartDashboard sDashboard;
//    
//    public void robotInit() {
//        String camip = "10.28.90.11";
//        camera = AxisCamera.getInstance(camip);  // get an instance of the camera
//        camera.writeResolution(AxisCamera.ResolutionT.k640x480);
//        camera.writeRotation(AxisCamera.RotationT.k180);
//        cc = new CriteriaCollection();      // create the criteria for the particle filter
//        cc.addCriteria(NIVision.MeasurementType.IMAQ_MT_BOUNDING_RECT_WIDTH, 30, 400, false);
//        cc.addCriteria(NIVision.MeasurementType.IMAQ_MT_BOUNDING_RECT_HEIGHT, 40, 400, false);
////        sDashboard = new SmartDashboard(SmartDashboard.);
//    
//
////    public void autonomous() {
//        while(true){
//            try {
//                /** 
//                 * Do the image capture with the camera and apply the algorithm described above. This
//                 * sample will either get images from the camera or from an image file stored in the top
//                 * level directory in the flash memory on the cRIO. The file name in this case is "10ft2.jpg"
//                 */
//                ColorImage image;
////                image = camera.getImage();     // comment if using stored images
//                       // next 2 lines read image from flash on cRIO
//                image =  new RGBImage("/10ft2.jpg");
////                image.write("10:28:90:9:C:\\Users\\Team 2890\\Desktop\\Pics\\Test.png");
////                BinaryImage thresholdImage = image.thresholdRGB(25, 255, 0, 45, 0, 47);   // keep only red objects
//                BinaryImage thresholdImage = image.thresholdRGB(0, 0, 0, 0,  0, 0);   // keep only black objects
//                //BinaryImage thresholdImage = image.thresholdRGB(0, 40, 25, 255, 0, 40);
//                BinaryImage bigObjectsImage = thresholdImage.removeSmallObjects(false, 2);  // remove small artifacts
//                BinaryImage convexHullImage = bigObjectsImage.convexHull(true);          // fill in occluded rectangles
//                BinaryImage filteredImage = convexHullImage.particleFilter(cc);           // find filled in rectangles
//                
//                ParticleAnalysisReport[] reports = filteredImage.getOrderedParticleAnalysisReports();  // get list of results
//                for (int i = 0; i < reports.length; i++) {                                // print results
//                    ParticleAnalysisReport r = reports[i];
//                    System.out.println("Particle: " + i + ":  Center of mass x: " + r.center_mass_x);
//                    
//                    DriverStationLCD.getInstance().println(DriverStationLCD.Line.kMain6, 1, 
//                            "Particle: " + i + ": Center of mass x: " + r.center_mass_x);
//                    DriverStationLCD.getInstance().updateLCD();
//                }
//                System.out.println(filteredImage.getNumberParticles() + "  " + Timer.getFPGATimestamp());
//
//                DriverStationLCD.getInstance().println(DriverStationLCD.Line.kMain6, 1, 
//                        filteredImage.getNumberParticles() + " " + Timer.getFPGATimestamp());
//                DriverStationLCD.getInstance().updateLCD();
//                /**
//                 * all images in Java must be freed after they are used since they are allocated out
//                 * of C data structures. Not calling free() will cause the memory to accumulate over
//                 * each pass of this loop.
//                 */
//                filteredImage.free();
//                convexHullImage.free();
//                bigObjectsImage.free();
//                thresholdImage.free();
//                image.free();
//                
////            } catch (AxisCameraException ex) {        // this is needed if the camera.getImage() is called
////                ex.printStackTrace();
//            } 
//            catch (NIVisionException ex) {
//                ex.printStackTrace();
//            }
//        }
//        // freeing the image. A.K.A letting the image go so we can have more images
//        
//        //sensorimage = camera.getImage();
//
//}
//
//    /**
//     * This function is called once each time the robot enters operator control.
//     */
//    public void autonomousInit() {
//        //schedule the autonomous command (example)
//        //autonomousCommand.start();
//    }
//        
//    /**
//     * This function is called periodically during autonomous
//     */
//    public void autonomousPeriodic(){
//        
//    }
//
//    public void teleopInit(){
//        //This makes sure that the autonomous stops running when
//        //teleop starts running. If you want the autonomous to
//        //continue until interrupted by another command, remove
//        //this line or comment it out.
//        //autonomousCommand.cancel();
//    }
//    
//    
//    
//    public void teleopPeriodic(){
// 
//    }
//}
//        