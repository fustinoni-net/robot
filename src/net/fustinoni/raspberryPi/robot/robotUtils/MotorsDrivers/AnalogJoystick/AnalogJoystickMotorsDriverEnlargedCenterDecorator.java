package net.fustinoni.raspberryPi.robot.robotUtils.MotorsDrivers.AnalogJoystick;

/**
 *
 * @author efustinoni
 */
public class AnalogJoystickMotorsDriverEnlargedCenterDecorator extends AnalogJoystickMotorsDriverDecorator{

    public AnalogJoystickMotorsDriverEnlargedCenterDecorator(AnalogJoystickMotorsDriver analogJoystickMotorsDriver) {
        super(analogJoystickMotorsDriver);
    }

    @Override
    public void jostickImput(int x, int y, int xMin, int xMax, int yMin, int yMax, int xCenter, int yCenter) {
        y= (y > (yCenter-5) && y < (yCenter+5))? yCenter : y;
        x= (x > (xCenter-5 ) && x < (xCenter+5) )? xCenter : x;
        super.jostickImput(x, y, xMin, xMax, yMin, yMax, xCenter, yCenter);
    }
    
    
}
