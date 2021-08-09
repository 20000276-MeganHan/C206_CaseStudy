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
	
	private ArrayList<Account> accountList = new ArrayList<Account>();
	private Account acc1;
	private Account acc2;
	private Account acc3;
	private Account acc4;
	
	private ArrayList<Integer> studentidList = new ArrayList<Integer>();
	
	public C206_CaseStudyTest() {
		super();
    }
	
	@Before
	public void setUp() throws Exception {
	lunchBoxOrder1 = new Order(1, LocalDate.parse("2021-08-30"), "Carbonara", "Fruit punch", "Watermelon Slice");
	lunchBoxOrder2 = new Order(2, LocalDate.parse("2021-08-24"), "Carbonara", "Fruit punch", "Watermelon Slice");
	lunchBoxOrder3 = new Order(3, LocalDate.parse("2021-08-06"), "Carbonara", "Fruit punch", "Watermelon Slice");
	
	acc1 = new Account("reg234", "12345", "Parent", 20034553, 87832782);
	acc2 = new Account("amanda456", "45677", "Parent", 20029321, 93032983);
	acc3 = new Account("jackxoxo", "78323", "Student", 20034553, 0.0, 90382938); // error
	acc4 = new Account("Lor34d", "90323", "Student", 20931324, 0.0, 81210391);
	
	studentidList.add(20034553);
	studentidList.add(20029321);
	studentidList.add(20931324);

	}


	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	@Test
	public void doAddLunchBoxOrderTest() {
		//Order list is not null, so that can add a new order
		//boundary
		assertNotNull("Check if there is valid lunchBoxOrder arraylist to add to", orderList); 
				
		//Given an empty list, after adding 1 order, the size of the list is 1
		//The order just added is as same as the first order of the list
		//Test that new Lunch Box Order date is after today day - "2021-08-30"
		//normal
		boolean ok = (lunchBoxOrder1.getDate().getDayOfYear() - LocalDate.now().getDayOfYear() > 0);
		assertTrue("Test that new Lunch Box Order date is before today date ok?", ok);
		orderList.add(lunchBoxOrder1);
		assertEquals("Check that orderList size is 1", 1, orderList.size());
		assertSame("Check that lunch box order is added", lunchBoxOrder1, orderList.get(0));
				
		//Add another order
		//Test the size of orderList is 2
		//The order just added is as same as the second order of the list
		//Test that new Lunch Box Order date is after today day - "2021-08-24"
		//normal
		ok = (lunchBoxOrder2.getDate().getDayOfYear() - LocalDate.now().getDayOfYear() > 0);
		assertTrue("Test that new Lunch Box Order date is before today date ok?", ok);
		orderList.add(lunchBoxOrder2);
		assertEquals("Check that orderList size is 2", 2, orderList.size());
		assertSame("Check that lunch box order is added", lunchBoxOrder2, orderList.get(1));
		
		// error
		// Date entered is "2021-08-06"
		//Check that new Lunch Box Order date is after today date
		ok = (lunchBoxOrder3.getDate().getDayOfYear() - LocalDate.now().getDayOfYear() > 0);
		assertFalse("Test that new Lunch Box Order date is before today date ok?", ok);
				
		//Do not add this order. 
		//Test size of the list is 2
		assertEquals("Check that foodItems arraylist size is 2", 2, orderList.size());
	}

	@Test
	public void doViewLunchBoxOrderTest() {
		//Order list is not null, so that can add a new order
		//boundary
		assertNotNull("Check if there is valid lunchBoxOrder arraylist to add to", orderList); 
				
		//Given an empty list, after adding 1 order, the size of the list is 1
		//normal
		boolean ok = (lunchBoxOrder1.getDate().getDayOfYear() - LocalDate.now().getDayOfYear() > 0);
		assertTrue("Test that new Lunch Box Order date is before today date ok?", ok);
		orderList.add(lunchBoxOrder1);
		assertEquals("Check that orderList size is 1", 1, orderList.size());
						
		//Add another order
		//Test the size of orderList is 2
		//normal
		ok = (lunchBoxOrder2.getDate().getDayOfYear() - LocalDate.now().getDayOfYear() > 0);
		assertTrue("Test that new Lunch Box Order date is before today date ok?", ok);
		orderList.add(lunchBoxOrder2);
		assertEquals("Check that orderList size is 2", 2, orderList.size());
				
		//Do not add this order. 
		//Test size of the list is 2
		assertEquals("Check that foodItems arraylist size is 2", 2, orderList.size());
		
		// Test if order list is not null but empty
		//boundary
		assertNotNull("Test if there is valid order arraylist to retrieve order to view", orderList);
	
		//Test orderList can view  order
		//C206_CaseStudy.viewLunchBoxOrder(orderList));
	}
	
	@Test
	public void doDeleteLunchBoxOrderTest() {
		//Order list is not null, so that can add a new order
		//boundary
		assertNotNull("Check if there is valid lunchBoxOrder arraylist to add to", orderList); 
						
		//Given an empty list, after adding 1 order, the size of the list is 1
		//normal
		boolean ok = (lunchBoxOrder1.getDate().getDayOfYear() - LocalDate.now().getDayOfYear() > 0);
		assertTrue("Test that new Lunch Box Order date is before today date ok?", ok);
		orderList.add(lunchBoxOrder1);
		assertEquals("Check that orderList size is 1", 1, orderList.size());
						
		//Add another order
		//Test the size of orderList is 2
		//normal
		ok = (lunchBoxOrder2.getDate().getDayOfYear() - LocalDate.now().getDayOfYear() > 0);
		assertTrue("Test that new Lunch Box Order date is before today date ok?", ok);
		orderList.add(lunchBoxOrder2);
		assertEquals("Check that orderList size is 2", 2, orderList.size());
				
		//Check that new Lunch Box Order date is after today date - "2021-08-24"
		ok = (lunchBoxOrder2.getDate().getDayOfYear() - LocalDate.now().getDayOfYear() > 0);
		assertTrue("Test that new Lunch Box Order date is before today date ok?", ok);
				
		//Delete order from orderList
		//Test the size of the list is 1
		//normal
		orderList.remove(1);
		assertEquals("Check that orderList size is 1", 1, orderList.size());
		
		//Check that new Lunch Box Order date is after today date - "2021-08-30"
		ok = (lunchBoxOrder1.getDate().getDayOfYear() - LocalDate.now().getDayOfYear() > 0);
		assertTrue("Test that new Lunch Box Order date is before today date ok?", ok);
		
		//Delete order from orderList
		//Test the size of the list is 0
		orderList.remove(0);
		assertEquals("Check that orderList size is 1", 0, orderList.size());
		
	}
	
	public void doAddAcct() {
		// Account list is not null, so that can add a new account 
		// boundary 
		assertNotNull("Check if there is valid account arraylist to add to?", accountList);
		
		// Given an empty list, after adding 1 account, the size of the list is 1
		// The account just added is as same as the first order of the list 
		// Test that new Account is added valid (for parents valid student id) 
		accountList.add(acc1);
		assertEquals("Check if accountList size is 1 upon validating student id", 1, accountList.size());
		assertSame("Check the account has been added successfully", acc1, accountList.get(0));
		
		//Add another account (normal) 
		//Test that the accountList size is 2
		//Test that student id entered is valid 
		accountList.add(acc2);
		assertEquals("Check if accountList size is 2 upon validating student id", 2, accountList.size());
		assertSame("Check the account has been added successfully", acc2, accountList.get(1));
		
		// error 
		// The student id entered was invalid 
		accountList.add(acc3);
		
		// check that the accountlist size is still 2 since student id validation failed
		assertEquals("Check if the size of accountList is 2", 2, accountList.size());

	}
	
	@After
	public void tearDown() throws Exception {
		lunchBoxOrder1 = null;
		lunchBoxOrder2 = null;
		lunchBoxOrder3 = null;
	}

}
