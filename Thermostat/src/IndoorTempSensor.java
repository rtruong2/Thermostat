import java.util.*;

public class IndoorTempSensor {
	private long rawSensorValue;
	private Temperature currentTemp = new Temperature ((float) rawSensorValue);	

	public IndoorTempSensor(Temperature currentTemp) 
	{
		this.rawSensorValue = 0;
		this.currentTemp = currentTemp;
	}

	public void monitorTemp()
	{
		Scanner scan = new Scanner (System.in);

		boolean breaker = false;
		while(!breaker)
		{
			System.out.println("Press 1 to make the temperature go up .1 degree."
					+ "\nPress 2 to make the temperature go down .1 degree."
					+ "\nPress 3 to set the Temperature."
					+ "\nPress 4 to exit out of monitorTemp.");

			switch(scan.nextInt())
			{
			case 1:
				currentTemp.set(currentTemp.get() + (float).1);
				break;
			case 2:
				currentTemp.set(currentTemp.get() - (float).1);
				break;
			case 3:
				System.out.println("Input temp.");
				currentTemp.set(scan.nextFloat());
				break;
			case 4:
				breaker = true;
				break;
			default:
				break;
			}

			System.out.format("\ncurrentTemp is %f.", this.getCurrentTemp());
		}
		scan.close();
		System.out.format("Temp is now %f.", this.getCurrentTemp());
	}

	public float getCurrentTemp()
	{
		return currentTemp.get();
	}
}
