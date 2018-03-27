package packageTDD;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import restaurantModel.*;

class BusBoyTests {

	//Tests bus boy and also tests table notification
	@Test
	void test() {
		Table[] myTables = new Table[5];
		for(int i = 0; i < myTables.length; i++) {
			myTables[i] = new Table(i);
		}
		BusBoy busBoy = new BusBoy(myTables);
		System.out.println(myTables[0]);
		assert(myTables[0].toString().equals("ReadyTable"));
		myTables[0].nextState();
		assert(myTables[0].toString().equals("InUseTable"));
		myTables[0].nextState();
		System.out.println(busBoy.tablesToClean.peek());
		System.out.println(myTables[0]);
		assertEquals(busBoy.tablesToClean.peek(), myTables[0]);
		myTables[0].nextState();
		assert(myTables[0].toString().equals("BeingCleanedTable"));
	}

}
