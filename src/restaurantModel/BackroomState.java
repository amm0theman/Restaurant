package restaurantModel;

public class BackroomState implements EmployeeState {
	
	BusBoy busBoy;
	
	/*
	** Passes the busboy into the state 
	*/
	BackroomState(BusBoy _busBoy) {
		busBoy = _busBoy;
	}

	/*
	** sets the state of the object 
	*/
	@Override
	public void setState(EmployeeState _state) {
		if(_state.toString().equals("OffShiftState"))
		{
			busBoy.busBoyState = busBoy.offShiftState;
		}
		if(_state.toString().equals("CleaningState"))
		{
			busBoy.busBoyState = busBoy.cleaningState;
		}
		if(_state.toString().equals("BackroomState"))
		{
			busBoy.busBoyState = busBoy.backroomState;
		}
	}

	/*
	 * Continue cleaning kitchen until job comes up then after finishing whatever doing in kitchen
	 * switch to cleaning state
	 */
	@Override
	public void run() {
		boolean busBoyNothingToDoButCleanKitchen = true;
		while(busBoyNothingToDoButCleanKitchen) {
			System.out.println("Bus boy is cleaning kitchen");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!busBoy.tablesToClean.isEmpty()) {
				busBoyNothingToDoButCleanKitchen = false;
				setState(new CleaningState(busBoy));
			}
		}
	}
	
	@Override
	public String toString() {
		return "BackroomState";
	}

}
