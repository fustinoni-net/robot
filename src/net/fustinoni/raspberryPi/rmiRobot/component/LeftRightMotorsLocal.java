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

package net.fustinoni.raspberryPi.rmiRobot.component;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.fustinoni.raspberryPi.rmiRobot.device.MotorLocal;
import net.fustinoni.raspberryPi.robot.component.LeftRightMotors;
import net.fustinoni.raspberryPi.robot.device.Motor;

/**
 *
 * @author efustinoni
 */
public class LeftRightMotorsLocal implements LeftRightMotors{
    final private LeftRightMotorsRemote motors;

    public LeftRightMotorsLocal(final LeftRightMotorsRemote motors) {
        this.motors = motors;
    }

    @Override
    public Motor getLeftMotor() {
        try {
            return new MotorLocal (motors.getLeftMotor());
        } catch (RemoteException ex) {
            Logger.getLogger(LeftRightMotorsLocal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Motor getRightMotor() {
        try {
            return new MotorLocal(motors.getRightMotor());
        } catch (RemoteException ex) {
            Logger.getLogger(LeftRightMotorsLocal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
