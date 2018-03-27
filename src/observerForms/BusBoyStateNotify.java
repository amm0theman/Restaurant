package observerForms;

import restaurantModel.EmployeeState;

public class BusBoyStateNotify {
	public String busBoyState;
	public EmployeeState state;
	
	public String getBusBoyState() {
		return busBoyState;
	}

	public void setBusBoyState(String busBoyState) {
		this.busBoyState = busBoyState;
	}

	public BusBoyStateNotify(String _busBoyState) {
		busBoyState = _busBoyState;
	}
	
	@Override
	public String toString() {
		return "busBoyStateNotify";
	}
}
