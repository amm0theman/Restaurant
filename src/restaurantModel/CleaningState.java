package restaurantModel;

public class CleaningState implements EmployeeState {
	
	BusBoy busBoy;
	
	/*
	** Passes the busboy into the state 
	*/
	CleaningState(BusBoy _busBoy) {
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

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		boolean cleaningTables = true;
		while(cleaningTables) {
			System.out.println("Bus boy is cleaning table");
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Table cleaned");
			busBoy.notifyObservers(busBoy.tablesToClean.poll());
			if(busBoy.tablesToClean.isEmpty()) {
				cleaningTables = false;
				setState(new BackroomState(busBoy));
			}
		}
	}
	
	@Override
	public String toString() {
		return "CleaningState";
	}

}
