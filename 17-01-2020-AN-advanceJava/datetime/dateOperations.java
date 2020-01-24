package datetime;

import java.time.temporal.ChronoUnit;

import java.time.LocalDate;

import java.util.Scanner;

import java.time.LocalDateTime;

import java.time.ZoneId;

import java.time.ZonedDateTime;



public class dateOperations {

	public static void main(String []args) {

		Scanner input=new Scanner(System.in);

		System.out.println("Enter your DOB in format yyyy-mm-dd");

		String d1=input.nextLine();

		System.out.println("Enter your sibling DOB in format yyyy-mm-dd");

		String d2=input.nextLine();

		LocalDate l1=LocalDate.parse(d1);

		LocalDate l2=LocalDate.parse(d2);

		LocalDateTime date1=l1.atStartOfDay();

		LocalDateTime date2=l2.atStartOfDay();
		long diff=0;
		try {
		 diff = ChronoUnit.NANOS.between(date1, date2);//gives difference in nanoseconds, if long diff overflows, it catches exception.
		 System.out.println("Difference between the dates in nanoseconds is :"+Math.abs(diff)); 
		}
		 catch(Exception e)
		 {
			 System.out.println(e+" the nanoseconds has overflowed long ");
		 }

		

		ZoneId newYokZone = ZoneId.of("America/New_York");
		ZonedDateTime myDOB = date1.atZone(newYokZone);
		ZonedDateTime sibDOB = date2.atZone(newYokZone);

		 long noOfDays = ChronoUnit.DAYS.between(myDOB, sibDOB);

		System.out.println("Difference between the dates in absolute number of days is :"+Math.abs(noOfDays));

        

	}

}
