public class Fan extends HVACDevice{

	public Fan(long physicalAddress) {
		super(physicalAddress);
	}
	
	public void on()
	{
		super.on();
	}
	public void off()
	{
		super.off();
	}
	public boolean getStatus()
	{
		return(super.getStatus());
	}
}
