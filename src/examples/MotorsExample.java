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

import static net.fustinoni.raspberryPi.pi2Go.Pi2GoLite.getPi2GoLite;
import net.fustinoni.raspberryPi.robot.component.LeftRightMotors;
import net.fustinoni.raspberryPi.robot.device.Motor;

/**
 * https://unpocodejava.wordpress.com/2013/08/15/control-de-motores-con-java-pi4j-en-raspberry-pi/
 * 
 */
public class MotorsExample {
    
    public static void main( String[] args ) throws InterruptedException {

        LeftRightMotors pi2go = getPi2GoLite();
        
        Motor rightMotor = pi2go.getRightMotor();
        Motor leftMotor = pi2go.getLeftMotor();
        
	int count = 1;
	while ( count-- > 0 ) {
		// motor a la derecha al 36%
		System.out.println( "-->36" );
		leftMotor.maveForward(36);
                rightMotor.maveForward(36);
		Thread.sleep( 1000 );

		// motor a la derecha al 96%
		System.out.println( "-->96" );
		leftMotor.maveForward(96);
                rightMotor.maveForward(96);
		Thread.sleep( 1000 );
		
		// motor a la derecha al 60%
		System.out.println( "-->60" );
		leftMotor.maveForward(60);
                rightMotor.maveForward(60);

		Thread.sleep( 1000 );

		// para motor derecha
		System.out.println( "-->0" );
                leftMotor.stop();
                rightMotor.stop();

                Thread.sleep( 1000 );

		// como motor derecha = false/0/low, activa motor izquierda 36%
                System.out.println( "-->36" );
                leftMotor.maveBackward(36);
                rightMotor.maveBackward(36);

                Thread.sleep( 1000 );
		
		// motor izquierda 96%
                System.out.println( "-->96" );
                leftMotor.maveBackward(96);
                rightMotor.maveBackward(96);

                Thread.sleep( 1000 );

		// motor izquierda 60%
                System.out.println( "-->60" );
                leftMotor.maveBackward(60);
                rightMotor.maveBackward(60);

                Thread.sleep( 1000 );

		// parar motor izquierda
                System.out.println( "-->0" );
                leftMotor.stop();
                rightMotor.stop();
                Thread.sleep( 1000 ); 
	}
        
        System.exit(0);
    }
}