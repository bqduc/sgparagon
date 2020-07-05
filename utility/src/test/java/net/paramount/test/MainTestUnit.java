/**
 * 
 */
package net.paramount.test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author ducbq
 *
 */
public class MainTestUnit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testUndefiniteTime();
	}

	protected static void testUndefiniteTime() {
		Calendar decadeAfterCalendar = Calendar.getInstance();
		decadeAfterCalendar.add(Calendar.YEAR, 10);///10 years

		long startedTime = System.currentTimeMillis();
		
		System.out.println(decadeAfterCalendar.getTimeInMillis()-startedTime);
	}
}
