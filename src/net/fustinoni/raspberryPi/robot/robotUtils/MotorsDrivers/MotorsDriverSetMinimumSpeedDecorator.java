/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.fustinoni.raspberryPi.robot.robotUtils.MotorsDrivers;


public class MotorsDriverSetMinimumSpeedDecorator extends MotorsDriverDecorator {

    public MotorsDriverSetMinimumSpeedDecorator(MotorsDriver motors) {
        super(motors);
    }

    @Override
    public void setMotorsSpeeds(int leftMotorSpeed, int rightMotorSpeed) {
        leftMotorSpeed = (leftMotorSpeed> -10 && leftMotorSpeed < 10) ? 0 : leftMotorSpeed;
        rightMotorSpeed = (rightMotorSpeed> -10 && rightMotorSpeed < 10) ? 0 : rightMotorSpeed;
        decoratedMotors.setMotorsSpeeds(leftMotorSpeed, rightMotorSpeed);
    }

    @Override
    public void stopMotors() {
        decoratedMotors.stopMotors();
    }
    
}
