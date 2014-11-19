public class TempControl {
	private Temperature currentTemp;
	private Temperature desiredTemp;
	private HVACDevice myAC;
	private PriHeat myHeater;
	private SecHeat myBackupHeater;
	private Fan myFan;
	
	public TempControl(Temperature currentTemp, Temperature desiredTemp,
			HVACDevice myAC, PriHeat myHeater, SecHeat myBackupHeater, Fan myFan) {
		this.currentTemp = currentTemp;
		this.desiredTemp = desiredTemp;
		this.myAC = myAC;
		this.myHeater = myHeater;
		this.myBackupHeater = myBackupHeater;
		this.myFan = myFan;
	}

	public void setMode(Mode thermMode){
		switch (thermMode){
		
		case OFF:
			myFan.off();
			myAC.off();
			myHeater.off();
			
		case FANONLY:
			myFan.on();
			myAC.off();
			myHeater.off();
			
		case AC:
			myFan.on();
			myHeater.off();
			do {
				monitorTemp();
				if (desiredTemp.get() < currentTemp.get())
					myAC.on();
				else
					myAC.off();
			}
			while(thermMode == Mode.AC);
			
		case HEAT:
			myFan.on();
			myAC.off();
			do {
				monitorTemp();
				if (desiredTemp.get() > currentTemp.get())
				{
					myHeater.on();
					//put code for secondary heater here
					//something like, if running for 10 minutes, myBackupHeater.on();
				}
				else
					myHeater.off();
			}
			while(thermMode == Mode.HEAT);
		}
	}
	
	public void monitorTemp(){
		//do later
	}
}

