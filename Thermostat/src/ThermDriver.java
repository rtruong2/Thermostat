
public class ThermDriver {

	private PriHeat myHeater = new PriHeat(1);
	private SecHeat myBackupHeater = new SecHeat(2);
	private HVACDevice myAC = new HVACDevice(3);
	private Fan myFan = new Fan(4);
	private Temperature desiredTemp = new Temperature ();
	private Temperature currentTemp = new Temperature ();
	private TempControl myTempControl = new TempControl (currentTemp, desiredTemp, myAC, myHeater, myBackupHeater, myFan);
	private Thermostat MyThermostat = new Thermostat(desiredTemp);
	private IndoorTempSensor myIndoorTemp = new IndoorTempSensor (10, currentTemp);
	
	public static void main(String [] args)
	{
			//drives the system	; vroom vroom
		System.out.println("Print.");
	}
}
