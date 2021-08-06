import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private ArrayList<Order> orderList = new ArrayList<Order>();
	private Order lunchBoxOrder1;
	private Order lunchBoxOrder2;
	private Order lunchBoxOrder3;
	
	public C206_CaseStudyTest() {
		super();
    }
	
	@Before
	public void setUp() throws Exception {
	lunchBoxOrder1 = new Order(1, LocalDate.parse("2021-08-30"), "Carbonara", "Fruit punch", "Watermelon Slice");
	lunchBoxOrder2 = new Order(2, LocalDate.parse("2021-08-24"), "Carbonara", "Fruit punch", "Watermelon Slice");
	lunchBoxOrder3 = new Order(3, LocalDate.parse("2021-08-06"), "Carbonara", "Fruit punch", "Watermelon Slice");
	}


	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

	@Test
	public void testLunchBoxOrder() {
		//Order list is not null, so that can add a new order
		//boundary
		assertNotNull("Check if there is valid lunchBoxOrder arraylist to add to", orderList); 
		
		//Given an empty list, after adding 1 order, the size of the list is 1
		//The order just added is as same as the first order of the list
		//normal
		orderList.add(lunchBoxOrder1);
		assertEquals("Check that orderList size is 1", 1, orderList.size());
		assertSame("Check that lunch box order is added", lunchBoxOrder1, orderList.get(0));
		
		//Add another order
		//Test the size of orderList is 2
		//The order just added is as same as the second order of the list
		//normal
		orderList.add(lunchBoxOrder2);
		assertEquals("Check that orderList size is 2", 2, orderList.size());
		assertSame("Check that lunch box order is added", lunchBoxOrder2, orderList.get(1));
		
		// error
		// Date entered is "2021-08-06"
		boolean ok = (lunchBoxOrder3.getDate().getDayOfYear() - LocalDate.now().getDayOfYear() > 0);
		//Check that new Lunch Box Order date is after today date
		assertFalse("Test that new Lunch Box Order date is before today date ok?", ok);
		
		//Do not add this order. 
		//Test size of the list is 2
		assertEquals("Check that foodItems arraylist size is 2", 2, orderList.size());
		
		// Test if order list is not null but empty
		//boundary
		assertNotNull("Test if there is valid order arraylist to retrieve order to view", orderList);
	
		//Test orderList can view  order
		//C206_CaseStudy.viewLunchBoxOrder(orderList));
		
		//Delete order from orderList
		//Test the size of the list is 1
		//normal
		orderList.remove(1);
		assertEquals("Check that orderList size is 1", 1, orderList.size());
		
		//Delete order from orderList
		//Test the size of the list is 0
		orderList.remove(0);
		assertEquals("Check that orderList size is 1", 0, orderList.size());
		
	}
	
	@After
	public void tearDown() throws Exception {
		lunchBoxOrder1 = null;
		lunchBoxOrder2 = null;
		lunchBoxOrder3 = null;
	}

}
