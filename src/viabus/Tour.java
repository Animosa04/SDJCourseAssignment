package viabus;

import java.util.Date;

public abstract class Tour {
	protected String where;
	protected DateInterval date;
	protected String bus;
	protected String chauffeur;
	
	public Tour(Date dep, Date arr, String place, String bus, String chauffeur)
	{
		date=new DateInterval(dep,arr);
		where=place;
		this.bus=bus;
		this.chauffeur=chauffeur;
	}
	
	public String getBus()
	{
		return this.bus;
	}
	
	public void setBus(String b)
	{
		bus=b;
	}
	
	public String getChauffeur()
	{
		return chauffeur;
	}
	
	public void setChauffeur(String c)
	{
		this.chauffeur=c;
	}
	
	public String getPlace()
	{
		return where;
	}
	
	public void setPlace(String place)
	{
		where=place;
	}
	
	public DateInterval getDates()
	{
		return date;
	}
}
