/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.fustinoni.raspberryPi.robot.robotUtils.MotorsDrivers;

/**
 *
 * @author efustinoni
 */
public abstract class MotorsDriverDecorator implements MotorsDriver{

    MotorsDriver decoratedMotors;
    public MotorsDriverDecorator(MotorsDriver motors) {
        this.decoratedMotors = motors;
    }

    @Override
    public void setMotorsSpeeds(int leftMotorSpeed, int rightMotorSpeed) {
        decoratedMotors.setMotorsSpeeds(leftMotorSpeed, rightMotorSpeed);
    }

    @Override
    public void stopMotors() {
        decoratedMotors.stopMotors();
    }
    
    
    
}
