package observerForms;

public class DownwardNotify {

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
	
	
	public DownwardNotify(BusBoyStateNotify b) {
		busBoyStateNotify = b;
	}
	
	public DownwardNotify(TableStateNotify a) {
		tableStateNotify = a;
	}
	
	@Override
	public String toString() {
		return "UpwardNotify";
	}
}
