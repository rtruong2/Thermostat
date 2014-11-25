public class HVACDevice {
	private boolean currentMode;
	private long physicalAddress;

	public HVACDevice(long physicalAddress) {
		this.currentMode = false;
		this.physicalAddress = physicalAddress;
	}
	
	public void on()
	{
		currentMode = true;
	}
	public void off()
	{
		currentMode = false;
	}
	public boolean getStatus()
	{
		return currentMode;
	}
}
