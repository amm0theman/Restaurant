package packageTDD;

import restaurantController.RestaurantController;
import restaurantModel.Restaurant;
import view.RestaurantView;

public class DRIVE {

	public DRIVE() {
		
	}
	
	
	
	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				RestaurantController controller = null;
				Restaurant myRest = null;
				
				myRest = new Restaurant(controller);
				RestaurantView a = new RestaurantView();
				controller = new RestaurantController(myRest, a);
				myRest.updateRef(controller);
				
			}
		});
	}

}
