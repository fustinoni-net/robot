/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.fustinoni.raspberryPi.robot.robotUtils.MotorsDrivers;

import net.fustinoni.raspberryPi.robot.component.LeftRightMotors;

/**
 *
 * @author efustinoni
 */
public class CommandLineMotorDriver extends BaseMotorsDriver {

    public CommandLineMotorDriver(LeftRightMotors robot) {
        super(robot);
    }

    @Override
    public void stopMotors() {
        super.stopMotors();
    }

    public void moveForward (int speed){
        setMotorsSpeeds(speed, speed);
    }

    public void moveBackward (int speed){
        setMotorsSpeeds(-speed, -speed);
    }
    
    public void spinRight (int speed){
        setMotorsSpeeds(speed, -speed);
    }
    
    public void spinLeft (int speed){
        setMotorsSpeeds(-speed, speed);
    }
    
    public void moveLeft (int speed, int angle){
        setMotorsSpeeds(speed - speed * angle/100, speed);
    }

    public void moveRight (int speed, int angle){
        setMotorsSpeeds(speed, speed - speed * angle/100);
    }
    
}
