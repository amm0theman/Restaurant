package observerForms;

public class TableStateNotify {
	
	public int tablePosition;
	public String tableState;
	
	public int getTablePosition() {
		return tablePosition;
	}

	public void setTablePosition(int tablePosition) {
		this.tablePosition = tablePosition;
	}

	public String getTableState() {
		return tableState;
	}

	public void setTableState(String tableState) {
		this.tableState = tableState;
	}
	
	public TableStateNotify(int _tablePosition, String _tableState) {
		tablePosition = _tablePosition;
		tableState = _tableState;
	}
	
	@Override
	public String toString() {
		return "tableStateNotify";
	}
}
