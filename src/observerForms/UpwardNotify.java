package observerForms;

public class UpwardNotify {

	BusBoyStateNotify busBoyStateNotify;
	public BusBoyStateNotify getBusBoyStateNotify() {
		return busBoyStateNotify;
	}

	public void setBusBoyStateNotify(BusBoyStateNotify busBoyStateNotify) {
		this.busBoyStateNotify = busBoyStateNotify;
	}

	public TableStateNotify getTableStateNotify() {
		return tableStateNotify;
	}

	public void setTableStateNotify(TableStateNotify tableStateNotify) {
		this.tableStateNotify = tableStateNotify;
	}

	TableStateNotify tableStateNotify;
	
	
	public UpwardNotify(BusBoyStateNotify b) {
		busBoyStateNotify = b;
	}
	
	public UpwardNotify(TableStateNotify a) {
		tableStateNotify = a;
	}
	
	@Override
	public String toString() {
		return "UpwardNotify";
	}
}
