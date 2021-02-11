// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.frc1764.pathing;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.RamseteCommand;

import java.io.IOException;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryUtil;

public class Pathweaver {

    private String directory;

    public Pathweaver(String directoryToJSON){
        directory = directoryToJSON;
    }

    public Trajectory getTrajectory(){
        Trajectory trajectory = new Trajectory();
        try {
         trajectory = TrajectoryUtil.fromPathweaverJson(Filesystem.getDeployDirectory().toPath().resolve(directory));
        } catch (IOException ex) {
            DriverStation.reportError("Unable to open trajectory: " + directory, ex.getStackTrace());
        }

        return trajectory;
    }

    public CommandBase getRamseteCommand(){
        return null;
    }

    public String getDirectory(){
        return directory;
    }
}
