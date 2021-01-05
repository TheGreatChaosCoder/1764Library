/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frc1764.math.geometry;

/**
 * Add your docs here.
 */
public class AngleUtil {

    //reduces an angle to an equivalent angle between 0 and 360 degrees
    public static double reduce360Degrees(double degrees){
        return degrees % 360;
    }

    //reduces an angle to an equivalent angle between 0 and 2pi
    public static double reduce2PiRadians(double radians){
        return radians % (2*Math.PI);
    }

    //reduces an angle to an equivalent angle between -180 and 180 degrees
    public static double reduce180Degrees(double degrees){
        //multiplies the reduced angle by the sign of the original since the mod operator is always positive.
        return (degrees % 180) * Math.signum(degrees);
    }

    //reduces an angle to an equivalent angle between -pi and pi
    public static double reducePiRadians(double radians){
        //multiplies the reduced angle by the sign of the original since the mod operator is always positive.
        return (radians % Math.PI) * Math.signum(radians);
    }
}
