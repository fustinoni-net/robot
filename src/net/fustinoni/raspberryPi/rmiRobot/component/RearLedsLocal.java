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
import net.fustinoni.raspberryPi.rmiRobot.device.LedLocal;
import net.fustinoni.raspberryPi.robot.component.RearLeds;
import net.fustinoni.raspberryPi.robot.device.Led;

/**
 *
 * @author efustinoni
 */
public class RearLedsLocal implements RearLeds{
    private final RearLedsRemote leds;

    public RearLedsLocal(final RearLedsRemote leds) {
        this.leds = leds;
    }

    @Override
    public Led getRearLeds() {
        try {
            return new LedLocal(leds.getRearLeds());
        } catch (RemoteException ex) {
            Logger.getLogger(RearLedsLocal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
