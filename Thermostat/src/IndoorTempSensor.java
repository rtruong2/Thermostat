
public class IndoorTempSensor {
	private long rawSensorValue = 70;
	private Temperature currentTemp = new Temperature ((float) rawSensorValue);
	
		
	public IndoorTempSensor(long rawSensorValue, Temperature currentTemp) 
	{
		this.rawSensorValue = rawSensorValue;
		this.currentTemp = currentTemp;
	}

	public void monitorTemp()
	{
		//do later
	}
	
	public float getCurrentTemp()
	{
		return currentTemp.get();
	}
}
