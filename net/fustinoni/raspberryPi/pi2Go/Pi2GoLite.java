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

package net.fustinoni.raspberryPi.pi2Go;

import net.fustinoni.raspberryPi.pi2Go.device.MotorImpl;
import net.fustinoni.raspberryPi.pi2Go.sensor.Hcsr04;
import net.fustinoni.raspberryPi.pi2Go.sensor.IRSensorImpl;
import net.fustinoni.raspberryPi.pi2Go.sensor.SwitchImpl;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.fustinoni.raspberryPi.robot.component.FrontLeds;
import net.fustinoni.raspberryPi.robot.component.RearLeds;
import net.fustinoni.raspberryPi.robot.device.Led;
import net.fustinoni.raspberryPi.robot.device.Motor;
import net.fustinoni.raspberryPi.robot.device.Servo;
import net.fustinoni.raspberryPi.pi2Go.device.LedImpl;
import net.fustinoni.raspberryPi.pi2Go.device.ServoImpl;
import net.fustinoni.raspberryPi.robot.sensor.IRSensor;
import net.fustinoni.raspberryPi.robot.sensor.Switch;
import net.fustinoni.raspberryPi.robot.sensor.UltraSoundSensor;
import net.fustinoni.raspberryPi.util.ExecuteFromJar;

/**
 *
 * @author efustinoni
 */
public class Pi2GoLite extends Pi2GoBase implements FrontLeds, RearLeds {

    private final Pin SWITCH_PIN = RaspiPin.GPIO_14;

    private final Pin LEFT_IR_SENSOR_PIN = RaspiPin.GPIO_07;
    private final Pin RIGHT_IR_SENSOR_PIN = RaspiPin.GPIO_00;
    private final Pin LINE_LEFT_IRSENSOR_PIN = RaspiPin.GPIO_02;
    private final Pin LINE_RIGHT_IRSENSOR_PIN = RaspiPin.GPIO_01;

    private final Pin FRONT_LEDS_PIN = RaspiPin.GPIO_03;
    private final Pin REAR_LEDS_PIN = RaspiPin.GPIO_04;

    private final Pin ULTRA_SOUND_SENSOR_PIN = RaspiPin.GPIO_15;

    private final Pin FORWARD_RIGHT_MOTOR_PIN = RaspiPin.GPIO_12;
    private final Pin BACKWARD_RIGHT_MOTOR_PIN = RaspiPin.GPIO_13;
    private final Pin FORWARD_LEFT_MOTOR_PIN = RaspiPin.GPIO_11;
    private final Pin BACKWARD_LEFT_MOTOR_PIN = RaspiPin.GPIO_10;

    private final Pin PAN_SERVO_PIN = RaspiPin.GPIO_05;
    private final Pin TILT_SERVO_PIN = RaspiPin.GPIO_06;

    
    private static Pi2GoLite pi2go;
    private SwitchImpl button;
    private IRSensorImpl leftIRSensor;
    private IRSensorImpl rightIRSensor;
    private IRSensorImpl lineLeftIRSensor;
    private IRSensorImpl lineRightIRSensor;
    private Led frontLeds;
    private Led rearLeds;
    private Hcsr04 ultraSoundSensor;
    private Motor rightMotor;
    private Motor leftMotor;
    private Servo panServo;
    private Servo tiltServo;

    private String servoBlasterFileName;
    
    @Override
    protected void setSafeGPIOPinStart() {
        try {
            servoBlasterFileName = ExecuteFromJar.executeFromClasspath("/lib/servod", "--idle-timeout=20000 --p1pins=18,22");
            
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    try {
                        ExecuteFromJar.execute("killall",servoBlasterFileName);
                    } catch (IOException ex) {
                        Logger.getLogger(Pi2GoLite.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Pi2GoLite.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(Pi2GoLite.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pi2GoLite.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private Pi2GoLite() {
        super();
    }

    public synchronized static Pi2GoLite getPi2GoLite() {
        if (pi2go == null) {
            pi2go = new Pi2GoLite();
        }
        return pi2go;
    }
    
    @Override
    public synchronized final Switch getSwitch() {
        if (button == null) {
            button = new SwitchImpl(getRobotGPIO(), SWITCH_PIN);
        }
        return button;
    }

    @Override
    public synchronized final IRSensor getLeftIRSensor() {
        if (leftIRSensor == null) {
            leftIRSensor = new IRSensorImpl(getRobotGPIO(), LEFT_IR_SENSOR_PIN);
        }
        return leftIRSensor;
    }

    @Override
    public synchronized final IRSensor getRightIRSensor() {
        if (rightIRSensor == null) {
            rightIRSensor = new IRSensorImpl(getRobotGPIO(), RIGHT_IR_SENSOR_PIN);
        }
        return rightIRSensor;
    }


    @Override
    public synchronized final IRSensor getLineLeftIRSensor() {
        if (lineLeftIRSensor == null) {
            lineLeftIRSensor = new IRSensorImpl(getRobotGPIO(), LINE_LEFT_IRSENSOR_PIN);
        }
        return lineLeftIRSensor;
    }

    @Override
    public synchronized final IRSensor getLineRightIRSensor() {
        if (lineRightIRSensor == null) {
            lineRightIRSensor = new IRSensorImpl(getRobotGPIO(), LINE_RIGHT_IRSENSOR_PIN);
        }
        return lineRightIRSensor;
    }

    @Override
    public synchronized final Led getFrontLeds() {
        if (frontLeds == null) {
            frontLeds = new LedImpl(getRobotGPIO(), FRONT_LEDS_PIN, false);
        }
        return frontLeds;
    }

    @Override
    public synchronized final Led getRearLeds() {
        if (rearLeds == null) {
            rearLeds = new LedImpl(getRobotGPIO(), REAR_LEDS_PIN, false);
        }
        return rearLeds;
    }

    @Override
    public synchronized final UltraSoundSensor getUltraSoundSensor() {
        if (ultraSoundSensor == null) {
            ultraSoundSensor = new Hcsr04(getRobotGPIO(), ULTRA_SOUND_SENSOR_PIN);
        }
        return ultraSoundSensor;
    }

    @Override
    public synchronized final Motor getRightMotor() {
        if (rightMotor == null) {
            rightMotor = new MotorImpl(getRobotGPIO(), FORWARD_RIGHT_MOTOR_PIN, BACKWARD_RIGHT_MOTOR_PIN);
        }
        return rightMotor;
    }

    @Override
    public synchronized final Motor getLeftMotor() {
        if (leftMotor == null) {
            leftMotor = new MotorImpl(getRobotGPIO(), FORWARD_LEFT_MOTOR_PIN, BACKWARD_LEFT_MOTOR_PIN);
        }
        return leftMotor;
    }

    @Override
    public synchronized final Servo getPanServo() {
        if (panServo == null) {
            try {
                panServo = new ServoImpl(getRobotGPIO(), PAN_SERVO_PIN);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        return panServo;
    }

    @Override
    public synchronized final Servo getTiltServo() {
        if (tiltServo == null) {
            try {
                tiltServo = new ServoImpl(getRobotGPIO(), TILT_SERVO_PIN);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        return tiltServo;
    }

}
