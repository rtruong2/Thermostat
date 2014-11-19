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
			break;

		case FANONLY:
			myFan.on();
			myAC.off();
			myHeater.off();
			break;

		case AC:
			myFan.on();
			myHeater.off();
			monitorTemp();
			if (desiredTemp.get() < currentTemp.get())
				myAC.on();
			else
				myAC.off();
			break;

		case HEAT:
			myFan.on();
			myAC.off();
			monitorTemp();
			if (desiredTemp.get() > currentTemp.get())
			{
				myHeater.on();
				//put code for secondary heater here
				//something like, if running for 10 minutes, myBackupHeater.on();
			}
			else
				myHeater.off();
			break;
		
		default:
			System.out.println("Error in SetMode.");
			break;
		}
	}

	public void monitorTemp(){
		//do later
	}
}

