/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.fustinoni.raspberryPi.robot.robotUtils.MotorsDrivers.AnalogJoystick;

/**
 *
 * @author efustinoni
 */
public abstract class AnalogJoystickMotorsDriverDecorator implements AnalogJoystickMotorsDriver{

    AnalogJoystickMotorsDriver decoratedAnalogJoystickMotorsDriver;
    
    public AnalogJoystickMotorsDriverDecorator(AnalogJoystickMotorsDriver analogJoystickMotorsDriver) {
        decoratedAnalogJoystickMotorsDriver = analogJoystickMotorsDriver;
    }

    @Override
    public void jostickImput(int x, int y, int xMin, int xMax, int yMin, int yMax, int xCenter, int yCenter) {
        decoratedAnalogJoystickMotorsDriver.jostickImput(x, y, xMin, xMax, yMin, yMax, xCenter, yCenter);
    }

    @Override
    public void stopMotors() {
        decoratedAnalogJoystickMotorsDriver.stopMotors();
    }
    
}
