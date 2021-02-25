package frc.robot;

import edu.wpi.first.wpilibj.geometry.Translation2d;

public class Waypoints {

    //Barrel Racing Path

    //public static final barrel_racing new Pose2d(0, 0, new Rotation2d(0))
    public static final Translation2d[] barrel_racing_path_start = {new Translation2d(0, 0)};

    public static final Translation2d[] barrel_racing_path = {
        new Translation2d(1, 2),
        new Translation2d(3, 4),
        new Translation2d(5, 6)
    };

    public static final Translation2d[] barrel_racing_path_end = {new Translation2d(0, 0)};


   //Slalom Path
   
   public static final Translation2d[] slalom_racing_path_start = {new Translation2d(0, 0)};

    public static final Translation2d[] slalom_racing_path = {
        new Translation2d(1, 2),
        new Translation2d(3, 4),
        new Translation2d(5, 6),
        new Translation2d(7, 88)
    };

    public static final Translation2d[] slalom_racing_path_emd = {new Translation2d(0, 0)};


    //Bounce Path

    //Leg 1
    public static final Translation2d[] bounce_racing_path1_start  = {new Translation2d(0, 0)};

    public static final Translation2d[] bounce_racing_path1 = {
        new Translation2d(1, 2),
        new Translation2d(3, 4),
        new Translation2d(5, 6),
        new Translation2d(7, 88)
    };
    
    public static final Translation2d[] bounce_racing_path1_end  = {new Translation2d(0, 0)};

    //Leg 2
    public static final Translation2d[] bounce_racing_path2_start  = {new Translation2d(0, 0)};

    public static final Translation2d[] bounce_racing_path2 = {
        new Translation2d(1, 2),
        new Translation2d(3, 4),
        new Translation2d(5, 6),
        new Translation2d(7, 88)
    };
    
    public static final Translation2d[] bounce_racing_path2_end  = {new Translation2d(0, 0)};


        //Leg 3
    public static final Translation2d[] bounce_racing_path3_start  = {new Translation2d(0, 0)};

    public static final Translation2d[] bounce_racing_path3 = {
        new Translation2d(1, 2),
        new Translation2d(3, 4),
        new Translation2d(5, 6),
        new Translation2d(7, 88)
    };
    
    public static final Translation2d[] bounce_racing_path3_end  = {new Translation2d(0, 0)};
    
}
