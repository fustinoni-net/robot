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

package net.fustinoni.raspberryPi.rmiRobot.sensor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import net.fustinoni.raspberryPi.rmiRobot.listener.SwitchListenerLocal;
import net.fustinoni.raspberryPi.rmiRobot.listener.SwitchListenerRemote;
import net.fustinoni.raspberryPi.robot.sensor.Switch;

/**
 *
 * @author efustinoni
 */
public class SwitchRemoteImpl extends UnicastRemoteObject implements SwitchRemote{
    
    private final Switch baseSwitch;

    public SwitchRemoteImpl(final Switch baseSwitch) throws RemoteException  {
        this.baseSwitch = baseSwitch;
    }

    @Override
    public void addListener(SwitchListenerRemote listener) throws RemoteException {
        baseSwitch.addListener(new SwitchListenerLocal(listener));
    }

    @Override
    public long getLastPressionMillisec() throws RemoteException {
        return baseSwitch.getLastPressionMillisec();
    }

    @Override
    public boolean isPushed() throws RemoteException {
        return baseSwitch.isPushed();
    }

    @Override
    public void removeListener(SwitchListenerRemote listener) throws RemoteException {
        baseSwitch.removeListener(new SwitchListenerLocal(listener));
    }
}
