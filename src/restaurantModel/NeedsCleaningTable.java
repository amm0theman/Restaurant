package restaurantModel;

public class NeedsCleaningTable implements TableState {
	
	Table myTable;	//For state control
	
	/*
	** Inits NeedsCleaningTable with tableState as a NeedsCleaningTable
	*/
	public NeedsCleaningTable(Table _table) {
		myTable = _table;
	}

	/*
	** Changes state to BeingCleanedTable
	*/
	@Override
	public void nextState() {
		myTable.setState(new BeingCleanedTable(myTable));
	}

	/*
	** Returns the current state as a string
	*/
	@Override
	 public String toString() {
		return "NeedsCleaningTable";
	}
}
