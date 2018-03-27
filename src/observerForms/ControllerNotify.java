package observerForms;

public class ControllerNotify {

	Integer viewUpdate;
	
	public ControllerNotify(ViewNotify v) {
		viewUpdate = v.toInteger();
	}
	
	public Integer toInteger() {
		return viewUpdate;
	}
	
	@Override
	public String toString() {
		return "ControllerNotify";
	}
}
