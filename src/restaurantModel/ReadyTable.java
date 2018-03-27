package restaurantModel;

public class ReadyTable implements TableState{
	
	Table myTable;	//For state control
	
	/*
	** Initialize
	*/
	ReadyTable(Table _table) {
		myTable = _table;
	}
	
	/*
	** Changes state to InUseTable
	** This happens from view->controller->restaurant->table after user input on a clean table
	*/
	@Override
	public void nextState() {
		myTable.setState(new InUseTable(myTable));
	}

	/*
	** Returns the tables state in string form
	*/
	@Override
	 public String toString() {
		return "ReadyTable";
	}
}
