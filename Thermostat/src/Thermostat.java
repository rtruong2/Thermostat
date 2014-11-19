
public class Thermostat 
{
	private Temperature desiredTemp;
	
	public Thermostat(Temperature desiredTemp) {
		this.desiredTemp = desiredTemp;
	}

	public void setDesiredTemp(float temp)
	{
		desiredTemp.set(temp);
	}
}
