package observerForms;

public class ViewNotify {

	Integer myInt;
	
	public Integer getMyInt() {
		return myInt;
	}

	public void setMyInt(Integer myInt) {
		this.myInt = myInt;
	}

	ViewNotify(Integer _myInt) {
		myInt = _myInt;
	}
	
	@Override
	public String toString() {
		return "ViewNotify";
	}
	
	public Integer toInteger() {
		return myInt;
	}
}
