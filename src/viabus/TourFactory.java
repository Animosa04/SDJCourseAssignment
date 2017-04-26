package viabus;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TourFactory {
	public static Tour getTour(String where, Date dep, Date arr, String bus, String chauffeur)
	{
		Tour resTour=null;
		GregorianCalendar depCal=new GregorianCalendar(dep.getYear(),dep.getMonth(),dep.getDate());
		GregorianCalendar arrCal=new GregorianCalendar(arr.getYear(),arr.getMonth(),arr.getDate());
		int days=0;
		
		//Deleting all unit time not used
		depCal.clear(Calendar.MILLISECOND);
		depCal.clear(Calendar.SECOND);
		depCal.clear(Calendar.MINUTE);
		depCal.clear(Calendar.HOUR_OF_DAY);
		arrCal.clear(Calendar.MILLISECOND);
		arrCal.clear(Calendar.SECOND);
		arrCal.clear(Calendar.MINUTE);
		arrCal.clear(Calendar.HOUR_OF_DAY);
		//Checking how many days separate the two dates
		while(depCal.before(arrCal) && days<7)
		{
			depCal.add(Calendar.DATE, 1);
			days++;
		}
		//Now that we have the number of days between the two dates we can know if it's a trip or a travel
		if(days<7)
		{
			resTour=new Trip(dep,arr, where, bus, chauffeur);
		}
		else
		{
			resTour=new Travel(dep,arr,where,bus,chauffeur);
		}
		return resTour;
	}
}