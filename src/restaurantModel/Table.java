package restaurantModel;

import java.util.Observable;
import observerForms.*;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class Table extends Observable implements TableState, Observer {

	TableState tableState;					//The tables current state
	int tablePosition;
	TableState readyState;
	TableState inUseState;
	TableState needsCleaningState;
	TableState beingCleanedState;
	
	/*
	** Table starts out clean and ready to use
	** Tables are an observable class, viewed by the busboy
	** States are ReadyTable, InUseTable, NeedsCleaningTable, and BeingCleanedTable
	** States change chronologically in the order above
	*/
	public Table(int tablePosition) {
		readyState = new ReadyTable(this);
		inUseState = new InUseTable(this);
		needsCleaningState = new NeedsCleaningTable(this);
		beingCleanedState = new BeingCleanedTable(this);
		
		tableState = readyState;
	}
	
	/*
	** Moves the tables state to the next one
	** Tables are an observable class, viewed by the busboy
	** States are ReadyTable, InUseTable, NeedCleaningTable, and BeingCleanedTable
	** States change chronologically in the order above
	*/
	public void nextState() {
		tableState.nextState();
		this.setChanged();
		this.notifyObservers(new TableStateNotify(tablePosition, getState().toString()));
	}
	
	/*
	** Handles state of table
	*/
	public void setState(TableState _table) {
		tableState = _table;
	}
	
	/*
	** Returns current state of the table
	*/
	public String getState() {
		return tableState.toString();
	}
	
	/*
	** Returns the state in string format
	*/
	@Override
	public String toString() {
		return tableState.toString();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		//If busboy
		if(arg1.toString().equals("BusBoyStateNotify"))
			tableState.nextState();
		//If from user
		else
			if(tableState.toString().equals("ReadyTable") || tableState.toString().equals("InUseTable"))
				tableState.nextState();
	}

}
