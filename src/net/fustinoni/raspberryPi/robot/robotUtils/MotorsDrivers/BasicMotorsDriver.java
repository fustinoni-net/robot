/**
 * 
 * **********************************************************************
 * This file is part of the PI2GO java library project. 
 *
 * More information about this project can be found here:  
 *   http://robots.fustinoni.net
 * **********************************************************************
 * 
 * Copyright (C) 2015 Enrico Fustinoni
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * 
 **/

package net.fustinoni.raspberryPi.robot.robotUtils.MotorsDrivers;

import net.fustinoni.raspberryPi.robot.component.LeftRightMotors;

/**
 *
 * @author efustinoni
 */
public class BasicMotorsDriver extends BaseMotorsDriver {

    public BasicMotorsDriver(LeftRightMotors robot) {
        super(robot);
    }

    @Override
    public void setMotorsSpeeds(int leftMotorSpeed, int rightMotorSpeed) {
        super.setMotorsSpeeds(leftMotorSpeed, rightMotorSpeed); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stopMotors() {
        super.stopMotors(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
