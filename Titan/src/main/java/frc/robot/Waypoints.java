package frc.robot;

import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;

public class Waypoints {

    //Demo Path1 ===============================================================================
    public static final Pose2d Demo_Path1_start = new Pose2d(0, 0, new Rotation2d(0));

    public static final Translation2d[] Demo_Path1_path = {
        new Translation2d(1.8, 0.0),
        new Translation2d(2, 0.0), 
        new Translation2d(2.5, -0.25),
        new Translation2d(2.75, -0.50),
        new Translation2d(3.00, -0.25),
        new Translation2d(3.25, 0.0),
        new Translation2d(3.50, 0.25),
        new Translation2d(4.00, 0.00)
    };

    public static final Pose2d Demo_Path1_end = new Pose2d(5.0, 0, new Rotation2d(0));
        
    //GalacticSearch_PathA RED===============================================================================
    public static final Pose2d GalacticSearch_PathA_Red_start = new Pose2d(0, 0, new Rotation2d(0));

    public static final Translation2d[] GalacticSearch_PathA_Red_path = {
        new Translation2d(0.8, 0.0),
        new Translation2d(2, 0.0), 
        new Translation2d(2.5, -0.25),
        new Translation2d(2.75, -0.50),
        new Translation2d(3.00, -0.25),
        new Translation2d(3.25, 0.0),
        new Translation2d(3.50, 0.25),
        new Translation2d(4.00, 0.00)
    };

    public static final Pose2d GalacticSearch_PathA_Red_end = new Pose2d(5.0, 0, new Rotation2d(0));

    //===LEG 1
    public static final Pose2d GalacticSearch_PathA_Red_start_Leg1 = new Pose2d(-.20, 0, new Rotation2d(0));

    public static final Translation2d[] GalacticSearch_PathA_Red_path_Leg1 = {
        //new Translation2d(0.75, 0.0)
    };

    public static final Pose2d GalacticSearch_PathA_Red_end_Leg1 = new Pose2d(1.525, 0, new Rotation2d(0));

    //===LEG 2
    public static final Pose2d GalacticSearch_PathA_Red_start_Leg2 = new Pose2d(1.525, 0, new Rotation2d(0));

    public static final Translation2d[] GalacticSearch_PathA_Red_path_Leg2 = {
        //new Translation2d(2.25, -0.50)
    };
    
    public static final Pose2d GalacticSearch_PathA_Red_end_Leg2 = new Pose2d(3.048, -0.762, new Rotation2d(-0.785));
    
    //===LEG 3
    public static final Pose2d GalacticSearch_PathA_Red_start_Leg3 = new Pose2d(3.048, -0.762, new Rotation2d(-0.785));

    public static final Translation2d[] GalacticSearch_PathA_Red_path_Leg3 = {
        new Translation2d(3.348, .0238),
        new Translation2d(3.478, 0.718)
    };

    public static final Pose2d GalacticSearch_PathA_Red_end_Leg3 = new Pose2d(3.81, 1.27, new Rotation2d(0.0));

    //===LEG 3B
    public static final Pose2d GalacticSearch_PathA_Red_start_Leg3b = new Pose2d(3.478, 1.27, new Rotation2d(0));

    public static final Translation2d[] GalacticSearch_PathA_Red_path_Leg3b = {
        //new Translation2d(3.348, .0238),
        //new Translation2d(3.478, 0.718)
    };

    public static final Pose2d GalacticSearch_PathA_Red_end_Leg3b = new Pose2d(4.00, 1.27, new Rotation2d(0));


    //===LEG 4
    public static final Pose2d GalacticSearch_PathA_Red_start_Leg4 = new Pose2d(4.00, 1.27, new Rotation2d(0));

    public static final Translation2d[] GalacticSearch_PathA_Red_path_Leg4 = {
        //new Translation2d(4, 0.75),
        //new Translation2d(4.5, 0.50)
    };

    public static final Pose2d GalacticSearch_PathA_Red_end_Leg4 = new Pose2d(5.41, 0, new Rotation2d(0));

    //===LEG 4b
    public static final Pose2d GalacticSearch_PathA_Red_start_Leg4b = new Pose2d(5.41, 0, new Rotation2d(0));

    public static final Translation2d[] GalacticSearch_PathA_Red_path_Leg4b = {
        //new Translation2d(4, 0.75),
        new Translation2d(5.65, 0.0)
    };

    public static final Pose2d GalacticSearch_PathA_Red_end_Leg4b = new Pose2d(5.75, 0, new Rotation2d(0));

    
    
    //GalacticSearch_PathB RED===============================================================================
    public static final Pose2d GalacticSearch_PathB_Red_start = new Pose2d(0, 0, new Rotation2d(0));

    public static final Translation2d[] GalacticSearch_PathB_Red_path = {
        new Translation2d(0.8, 0.0),
        new Translation2d(2, 0.0), 
        new Translation2d(2.5, -0.25),
        new Translation2d(2.75, -0.50),
        new Translation2d(3.00, -0.25),
        new Translation2d(3.25, 0.0),
        new Translation2d(3.50, 0.25),
        new Translation2d(4.00, 0.00)
    };

    public static final Pose2d GalacticSearch_PathB_Red_end = new Pose2d(5.0, 0, new Rotation2d(0));

    //===LEG 1
    public static final Pose2d GalacticSearch_PathB_Red_start_Leg1 = new Pose2d(0, 0, new Rotation2d(0));

    public static final Translation2d[] GalacticSearch_PathB_Red_path_Leg1 = {
        new Translation2d(1.31, 0.5715),
        new Translation2d(1.75, 0.762)
    };

    public static final Pose2d GalacticSearch_PathB_Red_end_Leg1 = new Pose2d(2.1875, 0.95, new Rotation2d(0));

    //===LEG 2
    public static final Pose2d GalacticSearch_PathB_Red_start_Leg2 = new Pose2d(2.1875, 0.95, new Rotation2d(0));

    public static final Translation2d[] GalacticSearch_PathB_Red_path_Leg2 = {
        new Translation2d(2.40, 0.52)
    };

    public static final Pose2d GalacticSearch_PathB_Red_end_Leg2 = new Pose2d(3.20, -0.652, new Rotation2d(0));

    //===LEG 3
    public static final Pose2d GalacticSearch_PathB_Red_start_Leg3 = new Pose2d(3.20, -0.652, new Rotation2d(0));

    public static final Translation2d[] GalacticSearch_PathB_Red_path_Leg3 = {
        new Translation2d(3.43, -0.38),
        new Translation2d(3.71, 0.20)
    };

    public static final Pose2d GalacticSearch_PathB_Red_end_Leg3 = new Pose2d(4.672, 0.552, new Rotation2d(0));

    //===LEG 4
    public static final Pose2d GalacticSearch_PathB_Red_start_Leg4 = new Pose2d(4.572, 0.552, new Rotation2d(0));

    public static final Translation2d[] GalacticSearch_PathB_Red_path_Leg4 = {
        //new Translation2d(5.0, 0.35)
    };

    public static final Pose2d GalacticSearch_PathB_Red_end_Leg4 = new Pose2d(5.50, 0, new Rotation2d(0));

    //===LEG 4b
    public static final Pose2d GalacticSearch_PathB_Red_start_Leg4b = new Pose2d(5, 0, new Rotation2d(0));

    public static final Translation2d[] GalacticSearch_PathB_Red_path_Leg4b = {
        //new Translation2d(5.0, 0.35)
    };

    public static final Pose2d GalacticSearch_PathB_Red_end_Leg4b = new Pose2d(5.5, 0, new Rotation2d(0));



    //GalacticSearch_PathA BLUE===============================================================================
    public static final Pose2d GalacticSearch_PathA_BLUE_start = new Pose2d(0, 0, new Rotation2d(0));

    public static final Translation2d[] GalacticSearch_PathA_BLUE_path = {
        new Translation2d(0.8, 0.0),
        new Translation2d(2, 0.0), 
        new Translation2d(2.5, -0.25),
        new Translation2d(2.75, -0.50),
        new Translation2d(3.00, -0.25),
        new Translation2d(3.25, 0.0),
        new Translation2d(3.50, 0.25),
        new Translation2d(4.00, 0.00)
    };

    public static final Pose2d GalacticSearch_PathA_BLUE_end = new Pose2d(5.0, 0, new Rotation2d(0));
        
    //GalacticSearch_PathB BLUE===============================================================================
    public static final Pose2d GalacticSearch_PathB_BLUE_start = new Pose2d(0, 0, new Rotation2d(0));

    public static final Translation2d[] GalacticSearch_PathB_BLUE_path = {
        new Translation2d(0.8, 0.0),
        new Translation2d(2, 0.0), 
        new Translation2d(2.5, -0.25),
        new Translation2d(2.75, -0.50),
        new Translation2d(3.00, -0.25),
        new Translation2d(3.25, 0.0),
        new Translation2d(3.50, 0.25),
        new Translation2d(4.00, 0.00)
    };

    public static final Pose2d GalacticSearch_PathB_BLUE_end = new Pose2d(5.0, 0, new Rotation2d(0));
    

    //Barrel Racing Path ===============================================================================
    public static final Pose2d barrel_racing_path_start = new Pose2d(0, 0, new Rotation2d(0));

    public static final Translation2d[] barrel_racing_path = {
        new Translation2d(1, 2),
        new Translation2d(3, 4),
        new Translation2d(5, 7),
        new Translation2d(7, 8)
    };

    public static final Pose2d barrel_racing_path_end = new Pose2d(9, 10, new Rotation2d(0));

    //Leg 1
    public static final Pose2d barrel_racing_path_start_Leg01 = new Pose2d(0, 0, new Rotation2d(0));

    public static final Translation2d[] barrel_racing_path_Leg01 = {
        //new Translation2d(7, 8)
    };

    public static final Pose2d barrel_racing_path_end_Leg01 = new Pose2d(3.048, 0, new Rotation2d(0));

    //Leg 2
    public static final Pose2d barrel_racing_path_start_Leg02 = new Pose2d(3.048, 0, new Rotation2d(0));

    public static final Translation2d[] barrel_racing_path_Leg02 = {
    //new Translation2d(7, 8)
    };

    public static final Pose2d barrel_racing_path_end_Leg02 = new Pose2d(3.6, -1.00, new Rotation2d(-2.15));


    //Leg 3
    public static final Pose2d barrel_racing_path_start_Leg03 = new Pose2d(3.6, -1.00, new Rotation2d(-3.14));

    public static final Translation2d[] barrel_racing_path_Leg03 = {
    //new Translation2d(7, 8)
    };

    public static final Pose2d barrel_racing_path_end_Leg03 = new Pose2d(2.300, -1.10, new Rotation2d(-3.30));


    //Leg 4
    public static final Pose2d barrel_racing_path_start_Leg04 = new Pose2d(2.3, -1.10, new Rotation2d(-3.925));

    public static final Translation2d[] barrel_racing_path_Leg04 = {
    //new Translation2d(7, 8)
    };

    public static final Pose2d barrel_racing_path_end_Leg04 = new Pose2d(2.10, -0.381, new Rotation2d(1.57));


    //Leg 5
    public static final Pose2d barrel_racing_path_start_Leg05 = new Pose2d(2.1, -0.381, new Rotation2d(1.57));

    public static final Translation2d[] barrel_racing_path_Leg05 = {
    //new Translation2d(7, 8)
    };

    public static final Pose2d barrel_racing_path_end_Leg05 = new Pose2d(6.25, 0.25, new Rotation2d(1.57));


    //Leg6
    public static final Pose2d barrel_racing_path_start_Leg06 = new Pose2d(6.25, 0.25, new Rotation2d(1.57));

    public static final Translation2d[] barrel_racing_path_Leg06 = {
    //new Translation2d(7, 8)
    };

    public static final Pose2d barrel_racing_path_end_Leg06 = new Pose2d(4.50, 1.15, new Rotation2d(3.14));


    //Leg 7
    public static final Pose2d barrel_racing_path_start_Leg07 = new Pose2d(4.50, 1.15, new Rotation2d(3.14));

    public static final Translation2d[] barrel_racing_path_Leg07 = {
    //new Translation2d(7, 8)
    };

    public static final Pose2d barrel_racing_path_end_Leg07 = new Pose2d(3.9624, 0.762, new Rotation2d(-1.00));


    //Leg 8
    public static final Pose2d barrel_racing_path_start_Leg08 = new Pose2d(3.9624, 0.762, new Rotation2d(-1.00));

    public static final Translation2d[] barrel_racing_path_Leg08 = {
    //new Translation2d(7, 8)
    };

    public static final Pose2d barrel_racing_path_end_Leg08 = new Pose2d(6.50, -0.90, new Rotation2d(0));


    //Leg 9
    public static final Pose2d barrel_racing_path_start_Leg09 = new Pose2d(6.50, -0.90, new Rotation2d(0));

    public static final Translation2d[] barrel_racing_path_Leg09 = {
    //new Translation2d(7, 8)
    };

    public static final Pose2d barrel_racing_path_end_Leg09 = new Pose2d(7.200, -0.80, new Rotation2d(1.57));


    //Leg 10
    public static final Pose2d barrel_racing_path_start_Leg10 = new Pose2d(7.200, -0.80, new Rotation2d(1.75));

    public static final Translation2d[] barrel_racing_path_Leg10 = {
    //new Translation2d(7, 8)
    };

    public static final Pose2d barrel_racing_path_end_Leg10 = new Pose2d(6.4, -0.30, new Rotation2d(3.14));

    //Leg 11
    public static final Pose2d barrel_racing_path_start_Leg11 = new Pose2d(6.4, 0, new Rotation2d(3.14));

    public static final Translation2d[] barrel_racing_path_Leg11 = {
        //new Translation2d(7, 8)
    };

    public static final Pose2d barrel_racing_path_end_Leg11 = new Pose2d(0.40, 0.500, new Rotation2d(3.14));


    //Slalom Path ===============================================================================
    public static final Pose2d slalom_racing_path_start = new Pose2d(0, 0, new Rotation2d(0));

    public static final Translation2d[] slalom_racing_path = {
        new Translation2d(0.75, 0.0),
        new Translation2d(0.85, 0.50),
        new Translation2d(0.95, 0.75),
        new Translation2d(1.00, 1.00),
        new Translation2d(1.50, 1.00),
        new Translation2d(2.25, 1.00),
        new Translation2d(4.25, 0.50),
        new Translation2d(4.50, 0.25),
        new Translation2d(4.75, 0.0),
        new Translation2d(4.50, -0.25)
    };

    public static final Pose2d slalom_racing_path_end = new Pose2d(5.00, -0.50, new Rotation2d(0));

    //LEG 1
    public static final Pose2d slalom_racing_path_Start_Leg1 = new Pose2d(0, 0, new Rotation2d(0));

    public static final Translation2d[] slalom_racing_path_Leg1 = {
        new Translation2d(0.83, 0.35),
        new Translation2d(1.5, 1.00),
        new Translation2d(2.5, 1.15)

    };
    
    public static final Pose2d slalom_racing_path_End_Leg1 = new Pose2d(5.75, 1.15, new Rotation2d(0));

    //LEG 2
    public static final Pose2d slalom_racing_path_Start_Leg2 = new Pose2d(5.75, 1.15, new Rotation2d(0));

    public static final Translation2d[] slalom_racing_path_Leg2 = {
        //new Translation2d(6.25, -0.25),
    };
    
    public static final Pose2d slalom_racing_path_End_Leg2 = new Pose2d(6.45, 0.00, new Rotation2d(-0.785));

    //LEG 3
    public static final Pose2d slalom_racing_path_Start_Leg3 = new Pose2d(6.45, 0.0, new Rotation2d(-0.785));

    public static final Translation2d[] slalom_racing_path_Leg3 = {
        //new Translation2d(7.00, -0.60)
    };
    
    public static final Pose2d slalom_racing_path_End_Leg3 = new Pose2d(7.45, 0.15, new Rotation2d(1.57));

    //LEG 3b
    public static final Pose2d slalom_racing_path_Start_Leg3b = new Pose2d(7.45, 0.15, new Rotation2d(1.57));

    public static final Translation2d[] slalom_racing_path_Leg3b = {
        //new Translation2d(7.00, -0.60)
    };
    
    public static final Pose2d slalom_racing_path_End_Leg3b = new Pose2d(7.00, 0.90, new Rotation2d(3.14));
    
    //LEG 4
    public static final Pose2d slalom_racing_path_Start_Leg4 = new Pose2d(7.00, 0.90, new Rotation2d(3.14));

    public static final Translation2d[] slalom_racing_path_Leg4 = {
        new Translation2d(6.30, 0.00)
    };
    
    public static final Pose2d slalom_racing_path_End_Leg4 = new Pose2d(5.525, -0.25, new Rotation2d(3.14));

    //LEG 5
    public static final Pose2d slalom_racing_path_Start_Leg5 = new Pose2d(5.525, -0.25, new Rotation2d(3.14));

    public static final Translation2d[] slalom_racing_path_Leg5 = {
        //new Translation2d(3.0, -0.25),
        //new Translation2d(1.5, 0.00),
        //new Translation2d(1.00, 0.60)
    };
    
    public static final Pose2d slalom_racing_path_End_Leg5 = new Pose2d(2.60, 0, new Rotation2d(2.220));

    //LEG 6
    public static final Pose2d slalom_racing_path_Start_Leg6 = new Pose2d(2.60, 0, new Rotation2d(2.20));

    public static final Translation2d[] slalom_racing_path_Leg6 = {
        //new Translation2d(3.0, -0.25),
        //new Translation2d(1.5, 0.00),
        //new Translation2d(1.0, 0.0)
    };
    
    public static final Pose2d slalom_racing_path_End_Leg6 = new Pose2d(0, 1.00, new Rotation2d(3.14));
    

    //Bounce Path ===============================================================================

    //Bounce Path Leg 1
    public static final Pose2d bounce_racing_path_start_Leg01  = new Pose2d(0, 0, new Rotation2d(0));

    public static final Translation2d[] bounce_racing_path_Leg01 = {
        //new Translation2d(7, 8)
    };
    
    public static final Pose2d bounce_racing_path_end_01  = new Pose2d(0.762, 0, new Rotation2d(0));

    //Bounce Path Leg 2
    public static final Pose2d bounce_racing_path_start_Leg02  = new Pose2d(0.762, 0, new Rotation2d(0));

    public static final Translation2d[] bounce_racing_path_Leg02 = {
        //new Translation2d(7, 8)
    };
    
    public static final Pose2d bounce_racing_path_end_02  = new Pose2d(0.9144, 1.524, new Rotation2d(1.57));

    //Bounce Path Leg 3
    public static final Pose2d bounce_racing_path_start_Leg03  = new Pose2d(0, 0, new Rotation2d(0));

    public static final Translation2d[] bounce_racing_path_Leg03 = {
        //new Translation2d(7, 8)
    };
    
    public static final Pose2d bounce_racing_path_end_03  = new Pose2d(9, 10, new Rotation2d(0));

    //Bounce Path Leg 4
    public static final Pose2d bounce_racing_path_start_Leg04  = new Pose2d(0, 0, new Rotation2d(0));

    public static final Translation2d[] bounce_racing_path_Leg04 = {
        //new Translation2d(7, 8)
    };
    
    public static final Pose2d bounce_racing_path_end_04  = new Pose2d(9, 10, new Rotation2d(0));

    //Bounce Path Leg 5
    public static final Pose2d bounce_racing_path_start_Leg05  = new Pose2d(0, 0, new Rotation2d(0));

    public static final Translation2d[] bounce_racing_path_Leg05 = {
        //new Translation2d(7, 8)
    };
    
    public static final Pose2d bounce_racing_path_end_05  = new Pose2d(9, 10, new Rotation2d(0));

    //Bounce Path Leg 6
    public static final Pose2d bounce_racing_path_start_Leg06  = new Pose2d(0, 0, new Rotation2d(0));

    public static final Translation2d[] bounce_racing_path_Leg06 = {
        //new Translation2d(7, 8)
    };
    
    public static final Pose2d bounce_racing_path_end_06  = new Pose2d(9, 10, new Rotation2d(0));

    //Bounce Path Leg 7
    public static final Pose2d bounce_racing_path_start_Leg07  = new Pose2d(0, 0, new Rotation2d(0));

    public static final Translation2d[] bounce_racing_path_Leg07 = {
        //new Translation2d(7, 8)
    };
    
    public static final Pose2d bounce_racing_path_end_07  = new Pose2d(9, 10, new Rotation2d(0));

    //Bounce Path Leg 8
    public static final Pose2d bounce_racing_path_start_Leg08  = new Pose2d(0, 0, new Rotation2d(0));

    public static final Translation2d[] bounce_racing_path_Leg08 = {
        //new Translation2d(7, 8)
    };
    
    public static final Pose2d bounce_racing_path_end_08  = new Pose2d(9, 10, new Rotation2d(0));

    //Bounce Path Leg 9
    public static final Pose2d bounce_racing_path_start_Leg09  = new Pose2d(0, 0, new Rotation2d(0));

    public static final Translation2d[] bounce_racing_path_Leg09 = {
        //new Translation2d(7, 8)
    };
    
    public static final Pose2d bounce_racing_path_end_09  = new Pose2d(9, 10, new Rotation2d(0));

