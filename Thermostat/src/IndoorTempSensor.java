
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
		//do later
	}
	
	public float getCurrentTemp()
	{
		return currentTemp.get();
	}
}
