public class TempControl {
	private Temperature currentTemp;
	private Temperature desiredTemp;
	private HVACDevice myAC;
	private PriHeat myHeater;
	private SecHeat myBackupHeater;
	private Fan myFan;
	private Mode currentMode;

	public TempControl(Temperature currentTemp, Temperature desiredTemp,
			HVACDevice myAC, PriHeat myHeater, SecHeat myBackupHeater, Fan myFan) {
		this.currentTemp = currentTemp;
		this.desiredTemp = desiredTemp;
		this.myAC = myAC;
		this.myHeater = myHeater;
		this.myBackupHeater = myBackupHeater;
		this.myFan = myFan;
		this.currentMode = Mode.OFF;
	}

	public void setMode(Mode nextMode)
	{
		switch (currentMode)
		{

		case OFF:
			switch (nextMode)
			{
			case OFF:
				break;

			case FANONLY:
				myFan.on();
				myAC.off();
				myHeater.off();
				currentMode = nextMode;
				break;

			case AC: case HEAT:
				System.out.println("Error: cannot access this mode from current mode of OFF.");
				break;

			default:
				System.out.println("Error in SetMode - nextMode falls throug switch-case.");
				break;
			}
			break;

		case FANONLY: case HEAT: case AC:
			switch (nextMode)
			{
			case OFF:
				myFan.off();
				myAC.off();
				myHeater.off();
				currentMode = nextMode;
				break;
				
			case FANONLY:
				myFan.on();
				myAC.off();
				myHeater.off();
				currentMode = nextMode;
				break;
				
			case AC:
				myFan.on();
				myHeater.off();
				monitorTemp();
				if (desiredTemp.get() < currentTemp.get())
					myAC.on();
				else
					myAC.off();
				currentMode = nextMode;
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
				{
					myHeater.off();
					myBackupHeater.off();
				}
				currentMode = nextMode;
				break;
			default:
				System.out.println("Error in SetMode - nextMode falls throug switch-case.");
				break;
			}
			break;
		default:
			System.out.println("Error in currentMode -- falls through switch-case.");
			break;
		}
	}

	public void monitorTemp(){
		
	}
	
	public Mode getCurrentMode(){
		return currentMode;
	}
}

