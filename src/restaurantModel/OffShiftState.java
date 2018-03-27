package restaurantModel;

public class OffShiftState implements EmployeeState {

	BusBoy busBoy;
	
	/*
	** Passes the busboy into the state 
	*/
	OffShiftState(BusBoy _busBoy) {
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

	@Override
	public void run() {
		//Do nothing, off shift
		System.out.println("Busboy got called into work");
		setState(new CleaningState(busBoy));
	}
	
	@Override
	public String toString() {
		return "OffShiftState";
	}

}
