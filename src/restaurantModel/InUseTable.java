package restaurantModel;

public class InUseTable implements TableState {
	
	Table myTable;	//For state control
	
	/*
	** Inits InUseTable with myTable as the parent thing holding state
	*/
	public InUseTable(Table _table) {
		myTable = _table;
	}

	/*
	** changes state to needs cleaning table
	** told this by restaurant, which will be told by controller by user input
	*/
	@Override
	public void nextState() {
		myTable.setState(new NeedsCleaningTable(myTable));
	}
	
	/*
	** Returns the state of the table in string form
	*/
	@Override
	 public String toString() {
		return "InUseTable";
	}

}
