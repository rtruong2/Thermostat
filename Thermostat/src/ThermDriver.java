import java.util.*;

public class ThermDriver {

	public static void main(String [] args)
	{
		PriHeat myHeater = new PriHeat(1);
		SecHeat myBackupHeater = new SecHeat(2);
		HVACDevice myAC = new HVACDevice(3);
		Fan myFan = new Fan(4);
		Temperature desiredTemp = new Temperature ();
		Temperature currentTemp = new Temperature (70);
		TempControl myTempControl = new TempControl (currentTemp, desiredTemp, myAC, myHeater, myBackupHeater, myFan);
		Thermostat myThermostat = new Thermostat(desiredTemp);
		IndoorTempSensor myIndoorTemp = new IndoorTempSensor (currentTemp);
		
		
		Scanner scan = new Scanner(System.in);
		
		while (true)
		{
			System.out.println("Enter option for Thermostat. "
					+ "\n1. To turn it off or on."
					+ "\n2. To set a desired temperature and make it run it."
					+ "\n3. To close the program.");
			boolean breaker = false; //breaker is a flag that's intended to break out of the program's otherwise infinite loop of running.
			
			switch(scan.nextInt())
			{
			case 1:
				System.out.format("The system is currently on %s mode."
						+ "\nPress 1 to turn it on."
						+ "\nPress 2 to turn it off.\n", myTempControl.getCurrentMode());
				switch(scan.nextInt())
				{
				case 1:
					myTempControl.setMode(Mode.FANONLY);
					System.out.println("The thermostat is on now.");
					break;
				case 2:
					myTempControl.setMode(Mode.OFF);
					System.out.println("The thermostat is off now.");
					break;
				}
				break;
			case 2:
				System.out.format("Current set temp: %f°\n", desiredTemp.get());
				System.out.println("Press 1 to make the setpoint go up .1 degree."
						+ "\nPress 2 to make the setpoint go down .1 degree."
						+ "\nPress 3 to set the setpoint."
						+ "\nPress 4 to accept setpoint and continue.");
				boolean breakTemp = false;
				while(!breakTemp)
				{
					switch(scan.nextInt())
					{
					case 1:
						desiredTemp.set(desiredTemp.get() + (float).1);
						break;
					case 2:
						desiredTemp.set(desiredTemp.get() - (float).1);
						break;
					case 3:
						desiredTemp.set(scan.nextFloat());
						break;
					case 4:
						breakTemp = true;
					default:
						break;
					}

					System.out.format("\nSet point is is %f.", desiredTemp.get());
				}
				myIndoorTemp.monitorTemp();
				break;
			case 3:
				breaker = true;
				break;
			default:
				System.out.println("Not an option");
				break;
			}
			if(breaker){
				break;
			}
			//print all status information: Mode, setpoint, temp.
		}
		
		scan.close();
		
	}
}