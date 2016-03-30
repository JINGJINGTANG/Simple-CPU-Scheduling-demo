//HeapDemo class
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class HeapDemo
{
	public static void main(String [] args) throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		//ask user to enter the path of a file to read
		System.out.print("Enter the filename to read from: ");
		String filename = keyboard.nextLine();
		//create a heap of the type tuple
		Heap<Tuple> pHeap = new Heap<Tuple>();
		//create an arraylist to record each process
		ArrayList<Tuple> process = new ArrayList<Tuple>();
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		int count = 0;
		//read the file and write the data to an arraylist
		while (inputFile.hasNext())
		{
			int id = inputFile.nextInt();
			int timeUnits = inputFile.nextInt();
			count += timeUnits;
			int priority = inputFile.nextInt();
			int timeOfArrival = inputFile.nextInt();
			Tuple tuple = new Tuple(id, timeUnits, priority, timeOfArrival);
			process.add(tuple);
		}
		inputFile.close();
		System.out.print("Enter the amount of time the CPU holds on to: ");
		int amount = keyboard.nextInt();
		System.out.println("Time Step\t\tHeap\t\t\t\t\tCPU");
		int timeStep = 1;
		Tuple cpu = null;
		//while loop to keep the process going
		while (timeStep <= count)
		{
			System.out.print(timeStep + "\t\t");
			//use a for loop to decide when to add the process at the right time
			for (int i = 0; i < process.size(); i++)
			{
				if (process.get(i).getTimeOfArrival() == timeStep)
					pHeap.add(process.get(i));
			}
			//enumerate the heap
			pHeap.enumerate();
			//print the process that is currently in process
			if (cpu == null)
			{
				cpu = pHeap.deleteMax();
				//System.out.print("\t" + cpu);
			}
			if (cpu.getTimeUnits() != 1)
			{
				System.out.print("\t" + cpu);
				cpu.setTimeUnits(cpu.getTimeUnits() - 1);
				if (cpu.getTimeUnits() == amount)
				{
					pHeap.add(cpu);
					cpu = null;
				}
			}
			//stop the process if it is done
			else if (cpu.getTimeUnits() == 1)
			{
				System.out.print("\tdone!");
				cpu = null;
			}
			System.out.println();
			timeStep++;
		}
		
	}
}
