package restaurantModel;

import java.util.Observable;
import java.util.Observer;
import restaurantController.RestaurantController;

@SuppressWarnings("deprecation")
public class Restaurant extends Observable implements Observer {
	
	/*
	** 5 tables in total in the restaurant
	** Tables are an observable class, viewed by the busboy
	** States are Ready, InUse, NeedCleaning, and BeingCleaned
	** States change chronologically in the order above
	*/
	private Table[] tables;
	
	/*
	** busBoy observes the tables, changes their state  
	*/
	private BusBoy busBoy;
	Thread busThread;
	
	/* 
	** Initialization
	** Parameters: Controller so object can communicate with view
	*/
	public Restaurant(RestaurantController _c) {
		//Initializing tables
		tables = new Table[5];
		for(int i = 0; i < tables.length; i++) {
			tables[i] = new Table(i);
			tables[i].addObserver(this);
		}
		
		//Initialize busBoy
		busBoy = new BusBoy(tables);
		busBoy.addObserver(this);
		
		busThread = new Thread(busBoy);
		busBoy.run();
		
	}

	public void updateRef(RestaurantController a) {
		this.addObserver(a);
	}
	
	/*
	** For observer implementation
	** Checks on models and updates the views
	*/
	@Override
	public void update(Observable arg0, Object arg1) {
		//update from controller (and therefore view)
		if(arg1.toString().equals("ControllerNotify")) {
			this.setChanged();
			this.notifyObservers(arg1);
		}
		//update from busboy
		if(arg1.toString().equals("BusBoyStateNotify")) {
			this.setChanged();
			this.notifyObservers(arg1);
		}
		//update from table
		if(arg1.toString().equals("TableStateNotify")) {
			this.setChanged();
			this.notifyObservers(arg1);
		}
	}
	
}
