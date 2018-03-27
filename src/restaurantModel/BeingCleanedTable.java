package restaurantModel;

public class BeingCleanedTable implements TableState {
	
	Table myTable;	//For state control
	
	/*
	** Inits
	*/
	public BeingCleanedTable(Table _table) {
		myTable = _table;
	}

	/*
	** Changes state to ReadyTable
	*/
	@Override
	public void nextState() {
		myTable.setState(new ReadyTable(myTable));
	}

	/*
	** Returns state of obj as a string
	*/
	@Override
	 public String toString() {
		return "BeingCleanedTable";
	}
}
