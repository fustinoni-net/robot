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

package net.fustinoni.raspberryPi.pi2Go.device;

import net.fustinoni.raspberryPi.robot.device.Motor;
import com.pi4j.io.gpio.Pin;
import com.pi4j.wiringpi.SoftPwm;
import net.fustinoni.raspberryPi.robot.component.RobotGPIO;

/**
 *
 * @author efustinoni
 */
public class MotorImpl implements Motor {
    private boolean forward ;
    final Pin forwardPin;
    final Pin backwardPin;

    public MotorImpl(final RobotGPIO pi2goGPIO, final Pin forwardPin, final Pin backwardPin) {
        forward = true;
        this.forwardPin = forwardPin;
        this.backwardPin = backwardPin;
        SoftPwm.softPwmCreate( forwardPin.getAddress(), 0, 100 );
	SoftPwm.softPwmCreate( backwardPin.getAddress(), 0, 100 );
    }

    @Override
    public void moveForward (int speed){

        if (!forward){
            SoftPwm.softPwmWrite( backwardPin.getAddress(), 0 );
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                ;
            }
        }

        SoftPwm.softPwmWrite( forwardPin.getAddress(), speed );

        forward = true;
    }
    
    @Override
    public void moveBackward (int speed){

        if (forward){
            SoftPwm.softPwmWrite( forwardPin.getAddress(), 0 );
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                ;
            }
        }

        SoftPwm.softPwmWrite( backwardPin.getAddress(), speed );

        forward = false;
    }
    
    @Override
    public void stop(){
        SoftPwm.softPwmWrite( forwardPin.getAddress(), 0 );
        SoftPwm.softPwmWrite( backwardPin.getAddress(), 0 );
        try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            ;
        }
    }

}
