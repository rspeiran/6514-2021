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


    //Bounce Path ===============================================================================

    //Bounce Path Leg 1
    public static final Pose2d bounce_racing_path1_start  = new Pose2d(0, 0, new Rotation2d(0));

    public static final Translation2d[] bounce_racing_path1 = {
        new Translation2d(1, 2),
        new Translation2d(3, 4),
        new Translation2d(5, 6),
        new Translation2d(7, 8)
    };
    
    public static final Pose2d bounce_racing_path1_end  = new Pose2d(9, 10, new Rotation2d(0));

    //Bounce Path Leg 2
    public static final Pose2d bounce_racing_path2_start  = new Pose2d(0, 0, new Rotation2d(0));

    public static final Translation2d[] bounce_racing_path2 = {
        new Translation2d(1, 2),
        new Translation2d(3, 4),
        new Translation2d(5, 6),
        new Translation2d(7, 8)
    };
    
    public static final Pose2d bounce_racing_path2_end  = new Pose2d(9, 10, new Rotation2d(0));


    //Bounce Path Leg 3
    public static final Pose2d bounce_racing_path3_start  = new Pose2d(0, 0, new Rotation2d(0));

    public static final Translation2d[] bounce_racing_path3 = {
        new Translation2d(1, 2),
        new Translation2d(3, 4),
        new Translation2d(5, 6),
        new Translation2d(7, 8)
    };
    
    public static final Pose2d bounce_racing_path3_end  = new Pose2d(9, 10, new Rotation2d(0));
    
}
