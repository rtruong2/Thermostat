public class ThermDriver {

	public static void main(String [] args)
	{
		PriHeat myHeater = new PriHeat(1);
		SecHeat myBackupHeater = new SecHeat(2);
		HVACDevice myAC = new HVACDevice(3);
		Fan myFan = new Fan(4);
		Temperature desiredTemp = new Temperature ();
		Temperature currentTemp = new Temperature ();
		TempControl myTempControl = new TempControl (currentTemp, desiredTemp, myAC, myHeater, myBackupHeater, myFan);
		Thermostat myThermostat = new Thermostat(desiredTemp);
		IndoorTempSensor myIndoorTemp = new IndoorTempSensor (currentTemp);
	}
}