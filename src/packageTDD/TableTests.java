package packageTDD;

import restaurantModel.*;

import org.junit.jupiter.api.Test;

class TableTests {

	@Test
	void test() {
		Table table1 = new Table(0);
		assert(table1.toString().equals("ReadyTable"));
		table1.nextState();
		assert(table1.toString().equals("InUseTable"));
		table1.nextState();
		assert(table1.toString().equals("NeedsCleaningTable"));
		table1.nextState();
		assert(table1.toString().equals("BeingCleanedTable"));
	}

}
