/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frc1764.units;

/**
 * Add your docs here.
 */
public class Converter {

    public static final double meterPerInch = 0.0254;

    public static double inchesToMeters(double inches){
        return inches * meterPerInch;
    }

    public static double meterToInches(double meteres){
        return meteres / meterPerInch;
    }
}
