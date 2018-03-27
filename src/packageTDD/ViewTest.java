package packageTDD;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import view.RestaurantView;

class ViewTest {

	@Test
	void test() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				RestaurantView a = new RestaurantView();
			}
		});
	}

}
