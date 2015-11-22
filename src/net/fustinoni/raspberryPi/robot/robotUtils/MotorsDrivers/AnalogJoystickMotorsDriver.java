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
public class AnalogJoystickMotorsDriver extends BaseMotorsDriver {

    
    public AnalogJoystickMotorsDriver(final LeftRightMotors robot) {
        super (robot);
    }

    @Override
    public void stopMotors() {
        super.stopMotors();
    }
    
    public void jostickImput (int x, int y, int xMin, int xMax, int yMin, int yMax, int xCenter, int yCenter){
        
        System.out.print(x+","+y + " ");
        y= (y > (yCenter-10) && y < (yCenter+10))? yCenter : y;
        x= (x > (xCenter-5 ) && x < (xCenter+5) )? xCenter : x;
        
        if (x==xCenter && y==yCenter){
            stopMotors();
            System.out.println("0,0");
        }
        else if (x==xCenter && y>yCenter){
            int fs = (y-yCenter)*100/(yMax-yCenter);
            setMotorsSpeeds(fs, fs);
            System.out.println(fs+","+fs);
        }
        else if (x==xCenter && y<yCenter){
            int fs = (y-yCenter)*100/(yMax-yCenter);
            setMotorsSpeeds(fs, fs);
            System.out.println(fs+","+fs);
        }
        else if(x<xCenter && y==yCenter){
            int d =(xCenter - x)*100 / (xCenter-xMin);
            setMotorsSpeeds(0, d);
            System.out.println("0," + d);
        }
        else if(x>xCenter && y==yCenter){
            int s = (x-xCenter)*100/(xMax-xCenter);
            setMotorsSpeeds( s, 0);
            System.out.println(s+",0");
        }
        else if(x<xCenter && y>yCenter){
            int fs = (y-yCenter)*100/(yMax-yCenter);
            float tp = (float)(xCenter - x) /(float) (xCenter-xMin);
            int l = (int) (fs - fs*tp);
            int r = fs;

            //int l = (y-yCenter)*100/(yMax-yCenter);
            //int d = l - (xCenter-x)*100/(xCenter-xMin);
            setMotorsSpeeds(l, r);
            System.out.println(l+","+r + " tp:" + tp);
        }
        else if(x>xCenter && y>yCenter){
            int fs = (y-yCenter)*100/(yMax-yCenter);
            float tp = (float)(x - xCenter) /(float) (xMax-xCenter);
            int l = fs;
            int r = (int) (fs - fs*tp);

            //int l = (y-yCenter)*100/(yMax-yCenter);
            //int d = l - (xCenter-x)*100/(xCenter-xMin);
            setMotorsSpeeds(l, r);
            System.out.println(l+","+r + " tp:" + tp);
        }
        else if(x<xCenter && y<yCenter){
            int fs = (y-yCenter)*100/(yMax-yCenter);
            float tp = (float)(xCenter - x) /(float) (xCenter-xMin);
            int l = (int) (fs - fs*tp);
            int r = fs;

            //int l = (y-yCenter)*100/(yMax-yCenter);
            //int d = l - (xCenter-x)*100/(xCenter-xMin);
            setMotorsSpeeds(l, r);
            System.out.println(l+","+r + " tp:" + tp);
        }
        else if(x>xCenter && y<yCenter){
            int fs = (y-yCenter)*100/(yMax-yCenter);
            float tp = (float)(x - xCenter) /(float) (xMax-xCenter);
            int l = fs;
            int r = (int) (fs - fs*tp);

            //int l = (y-yCenter)*100/(yMax-yCenter);
            //int d = l - (xCenter-x)*100/(xCenter-xMin);
            setMotorsSpeeds(l, r);
            System.out.println(l+","+r + " tp:" + tp);
        }
        else{
            stopMotors();
            System.out.println("stop " + x + ", " + y);
        }
    }
}
