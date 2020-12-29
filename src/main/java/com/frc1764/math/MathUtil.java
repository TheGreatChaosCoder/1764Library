package com.frc1764.math;

public class MathUtil {

    public static double threshold(double num, double upperLimit, double lowerLimit){
        if(num >= upperLimit){
            return upperLimit;
        }
        else if(num <= lowerLimit){
            return lowerLimit;
        }
        else{
            return num;
        }
    }
    
    public static double deadbandLower(double num, double lowerLimit){
        if(num>lowerLimit){
            return 0;
        }
        return num;
    }
    
    public static double deadbandUpper(double num, double upperLimit){
        if(num<upperLimit){
            return 0;
        }
        return num;
    }

    public static double deadband(double num, double upperLimit, double lowerLimit){
        if(num<upperLimit && num>lowerLimit){
            return 0;
        }
        return num;
    }
}
