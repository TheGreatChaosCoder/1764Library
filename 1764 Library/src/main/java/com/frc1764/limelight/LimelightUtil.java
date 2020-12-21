/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frc1764.limelight;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * Add your docs here.
 */
public class LimelightUtil {
    public static NetworkTable limelightTable = NetworkTableInstance.getDefault().getTable("limelight");

    public static double getXDeg(){
        return limelightTable.getEntry("tx").getDouble(0);
    }
  
    public static double getYDeg(){
        return limelightTable.getEntry("ty").getDouble(0);
    }
  
    public static double getSkew(){
      return limelightTable.getEntry("ts").getDouble(0);
    }
  
    public static double getArea(){
      return limelightTable.getEntry("ta").getDouble(0);
    }
  
    public static boolean hasTarget(){
      return Boolean.parseBoolean(limelightTable.getEntry("tv").getString("0"));
    }
  
    public static void turnLEDOn(){
      limelightTable.getEntry("ledMode").setNumber(3);
    }
  
    public static void turnLEDOff(){
      limelightTable.getEntry("ledMode").setNumber(1);
    }
  
    public static boolean isLEDOn(){
      return limelightTable.getEntry("ledMode").getValue().toString().equals("3")? true : false;
    }
  
    public static boolean isLEDOff(){
      return limelightTable.getEntry("ledMode").getValue().toString().equals("1")? true : false;
    }
}
