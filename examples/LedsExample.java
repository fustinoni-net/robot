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

package examples;

import net.fustinoni.raspberryPi.pi2Go.Pi2GoLite;
import static net.fustinoni.raspberryPi.pi2Go.Pi2GoLite.getPi2GoLite;
import net.fustinoni.raspberryPi.robot.device.Led;

/**
 *
 * @author efustinoni
 */
public class LedsExample {
    
    public static void main (String... args) throws InterruptedException{
        
        Pi2GoLite pi2go = getPi2GoLite();
        
        Led ledFront =  pi2go.getFrontLeds();
        Led ledRear = pi2go.getRearLeds();
        
        ledFront.turnOn();
        ledRear.turnOn();
        
        Thread.sleep(2000);
        
        ledRear.turnOff();
        
        for (int i = 0; i < 100; ++i){
            ledFront.toggle();
            ledRear.toggle();
            
            Thread.sleep(50);
        }
        
        ledFront.turnOff();
        ledRear.turnOff();
        
        Thread.sleep(500);

        System.exit(0);
    }
    
    
}