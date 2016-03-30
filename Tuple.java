//Tuple class
public class Tuple
{
	//create variables
	private int id;
	private int timeUnits;
	private int priority;
	private int timeOfArrival;
	//constructor that sets the data
	public Tuple(int id, int timeUnits, int priority, int timeOfArrival)
	{
		this.id = id;
		this.timeUnits = timeUnits;
		this.priority = priority;
		this.timeOfArrival = timeOfArrival;
	}
	//set the timeunits
	public void setTimeUnits(int time)
	{
		timeUnits = time;
	}
	//get the id
	public int getId()
	{
		return id;
	}
	//get the timeunits
	public int getTimeUnits()
	{
		return timeUnits;
	}
	//get the priority
	public int getPriority()
	{
		return priority;
	}
	//get the time of arriaval
	public int getTimeOfArrival()
	{
		return timeOfArrival;
	}
	//toString that returns the information
	public String toString()
	{
		return "(" + id + ", " + timeUnits + ", " + priority + ")";
	}
}
