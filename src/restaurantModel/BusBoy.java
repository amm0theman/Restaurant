package restaurantModel;

import java.util.Observable;
import java.util.Observer;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import observerForms.TableStateNotify;

@SuppressWarnings("deprecation")
public class BusBoy extends Observable implements Observer, Runnable, EmployeeState {

	Table[] tables;							//Table array, busBoy will change states of tables
	public Queue<Table> tablesToClean = new ArrayBlockingQueue<Table>(6);				//Queue for tables that need to be cleaned
	
	public EmployeeState busBoyState;		//The state the busBoy is in
	
	public EmployeeState offShiftState;		//For state control
	public EmployeeState cleaningState;		//For state control
	public EmployeeState backroomState;		//For state control
	
	/*
	** BusBoy constructor
	** Parameters:
	** _tables
	** array of tables, all tables are observable
	** busBoy will change the tables states
	** 
	** Function:
	** inits tables
	** inits employee states
	*/
	public BusBoy(Table[] _tables) {
		//Init tables
		tables = _tables;
		
		//Register with the tables
		for(int i = 0; i < tables.length; i++) {
			tables[i].addObserver(this);
			this.addObserver(tables[i]);
		}
		
		//Init employee states
		busBoyState = new OffShiftState(this);
		offShiftState = new OffShiftState(this);
		cleaningState = new CleaningState(this);
		backroomState = new BackroomState(this);
	}

	/*
	** Update functions to fulfill Observer interface
	** Listens to tables, when table becomes dirty add it to queue
	** If not dirty, do nothing
	*/
	@Override
	public void update(Observable arg0, Object arg1) {
		//if from table
		if(arg1.toString().equals("TableStateNotify")) {
			tablesToClean.add(tables[((TableStateNotify) arg1).tablePosition]);
		}
		else
			//if something else only update if in a capable state
			if(busBoyState.toString().equals("OffShiftState"))
				setState(backroomState);
	}

	@Override
	public void run() {
		busBoyState.run();
	}

	@Override
	public void setState(EmployeeState _state) {
		busBoyState.setState(this);
	}

}
