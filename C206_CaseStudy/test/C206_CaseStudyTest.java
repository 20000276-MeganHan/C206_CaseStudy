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
	private Order lunchBoxOrder4;

	private ArrayList<Account> accountList = new ArrayList<Account>();
	private Account acc1;
	private Account acc2;
	private Account acc3;
	private Account acc4;

	private ArrayList<OrderBill> orderbillList = new ArrayList<OrderBill>();
	private OrderBill ob1;
	private OrderBill ob2;
	private OrderBill ob3;

	private ArrayList<Integer> studentidList = new ArrayList<Integer>();

	private static ArrayList<Menu> menuList = new ArrayList<Menu>();

	private Menu item1;
	private Menu item2;
	private Menu item3;

	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		lunchBoxOrder1 = new Order(1, LocalDate.parse("2021-08-30"), "Carbonara", "Fruit punch", "Watermelon Slice");
		lunchBoxOrder2 = new Order(2, LocalDate.parse("2021-08-24"), "Carbonara", "Fruit punch", "Watermelon Slice");
		lunchBoxOrder3 = new Order(3, LocalDate.parse("2021-08-06"), "Carbonara", "Fruit punch", "Watermelon Slice");
		lunchBoxOrder4 = new Order(4, LocalDate.parse("2021-08-15"), "Carbonara", "Fruit punch", "Watermelon Slice");

		acc1 = new Account("reg234", "12345", "Parent", 20034553, 87832782);
		acc2 = new Account("amanda456", "45677", "Parent", 20029321, 93032983);
		acc3 = new Account("jackxoxo", "78323", "Student", 12345678, 0.0, 90382938); // error
		acc4 = new Account("Lor34d", "90323", "Student", 20931324, 0.0, 81210391);

		ob1 = new OrderBill(7260, 3.00, 2, 6.00);
		ob2 = new OrderBill(5471, 2.50, 3, 7.50);
		ob3 = new OrderBill(1527, 3.00, 1, 3.00);

		studentidList.add(20034553);
		studentidList.add(20029321);
		studentidList.add(20931324);

		item1 = new Menu("Asian", "Chicken Rice", "Milo", "Pear Slice", 4.50);
		item2 = new Menu("Vegeterian", "Vegeterian Bee Hoon", "Apple Juice", "Banana", 3.00);
		item3 = new Menu("Western", "Baked Rice", "Water","Mango", 3.00);

	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	@Test
	public void doAddLunchBoxOrderTest() {
		// Order list is not null, so that can add a new order
		// boundary
		assertNotNull("Check if there is valid lunchBoxOrder arraylist to add to", orderList);

		// Given an empty list, after adding 1 order, the size of the list is 1
		// The order just added is as same as the first order of the list
		// Test that new Lunch Box Order date is after today day - "2021-08-30"
		// normal
		boolean ok = (lunchBoxOrder1.getDate().getDayOfYear() - LocalDate.now().getDayOfYear() > 0);
		assertTrue("Test that new Lunch Box Order date is before today date ok?", ok);
		C206_CaseStudy.addLunchBoxOrder(orderList, lunchBoxOrder1);
		assertEquals("Check that orderList size is 1", 1, orderList.size());
		assertSame("Check that lunch box order is added", lunchBoxOrder1, orderList.get(0));

		// Add another order
		// Test the size of orderList is 2
		// The order just added is as same as the second order of the list
		// Test that new Lunch Box Order date is after today day - "2021-08-24"
		// normal
		ok = (lunchBoxOrder2.getDate().getDayOfYear() - LocalDate.now().getDayOfYear() > 0);
		assertTrue("Test that new Lunch Box Order date is before today date ok?", ok);
		C206_CaseStudy.addLunchBoxOrder(orderList, lunchBoxOrder2);
		assertEquals("Check that orderList size is 2", 2, orderList.size());
		assertSame("Check that lunch box order is added", lunchBoxOrder2, orderList.get(1));

		// error
		// Date entered is "2021-08-06"
		// Check that new Lunch Box Order date is after today date
		ok = (lunchBoxOrder3.getDate().getDayOfYear() - LocalDate.now().getDayOfYear() > 0);
		assertFalse("Test that new Lunch Box Order date is before today date ok?", ok);

		// Do not add this order.
		// Test size of the list is 2
		assertEquals("Check that foodItems arraylist size is 2", 2, orderList.size());
	}

	@Test
	public void doViewLunchBoxOrderTest() {
		// Order list is not null, so that can add a new order
		// boundary
		assertNotNull("Check if there is valid lunchBoxOrder arraylist to add to", orderList);

		// Given an empty list, after adding 1 order, the size of the list is 1
		// normal
		boolean ok = (lunchBoxOrder1.getDate().getDayOfYear() - LocalDate.now().getDayOfYear() > 0);
		assertTrue("Test that new Lunch Box Order date is before today date ok?", ok);
		C206_CaseStudy.addLunchBoxOrder(orderList, lunchBoxOrder1);
		assertEquals("Check that orderList size is 1", 1, orderList.size());

		// Add another order
		// Test the size of orderList is 2
		// normal
		ok = (lunchBoxOrder2.getDate().getDayOfYear() - LocalDate.now().getDayOfYear() > 0);
		assertTrue("Test that new Lunch Box Order date is before today date ok?", ok);
		C206_CaseStudy.addLunchBoxOrder(orderList, lunchBoxOrder2);
		assertEquals("Check that orderList size is 2", 2, orderList.size());

		// Test size of the list is 2
		assertEquals("Check that foodItems arraylist size is 2", 2, orderList.size());

		// Test if order list is not null but empty
		// boundary
		assertNotNull("Test if there is valid order arraylist to retrieve order to view", orderList);

		// Test orderList can view order
		C206_CaseStudy.viewLunchBoxOrder(orderList);
	}

	@Test
	public void doDeleteLunchBoxOrderTest() {
		// Order list is not null, so that can add a new order
		// boundary
		assertNotNull("Check if there is valid lunchBoxOrder arraylist to add to", orderList);

		// Given an empty list, after adding 1 order, the size of the list is 1
		// normal
		boolean ok = (lunchBoxOrder1.getDate().getDayOfYear() - LocalDate.now().getDayOfYear() > 0);
		assertTrue("Test that new Lunch Box Order date is before today date ok?", ok);
		C206_CaseStudy.addLunchBoxOrder(orderList, lunchBoxOrder1);
		assertEquals("Check that orderList size is 1", 1, orderList.size());

		// Add another order
		// Test the size of orderList is 2
		// normal
		ok = (lunchBoxOrder2.getDate().getDayOfYear() - LocalDate.now().getDayOfYear() > 0);
		assertTrue("Test that new Lunch Box Order date is before today date ok?", ok);
		C206_CaseStudy.addLunchBoxOrder(orderList, lunchBoxOrder2);
		assertEquals("Check that orderList size is 2", 2, orderList.size());
		
		// Add another order
		// Test the size of orderList is 3
		// normal
		ok = (lunchBoxOrder4.getDate().getDayOfYear() - LocalDate.now().getDayOfYear() > 0);
		assertTrue("Test that new Lunch Box Order date is before today date ok?", ok);
		C206_CaseStudy.addLunchBoxOrder(orderList, lunchBoxOrder4);
		assertEquals("Check that orderList size is 3", 3, orderList.size());
				
		// Delete order from orderList
		// Test the size of the list is 2
		// normal
		C206_CaseStudy.deleteLunchBoxOrder(orderList, lunchBoxOrder2);
		assertEquals("Check that orderList size is 2", 2, orderList.size());

		// Check that Lunch Box Order date is after today date - "2021-08-30"
		ok = (lunchBoxOrder1.getDate().getDayOfYear() - LocalDate.now().getDayOfYear() > 0);
		assertTrue("Test that new Lunch Box Order date is before today date ok?", ok);

		// Delete order from orderList
		// Test the size of the list is 1
		C206_CaseStudy.deleteLunchBoxOrder(orderList, lunchBoxOrder1);
		assertEquals("Check that orderList size is 1", 1, orderList.size());
		
		// Check that Lunch Box Order date is after today date - "2021-08-15"
		// Today date = "2021-08-15"
		// Test the size of the list is 1
		// error
		ok = (lunchBoxOrder4.getDate().getDayOfYear() - LocalDate.parse("2021-08-15").getDayOfYear() > 0);
		assertFalse("Test that new Lunch Box Order date is before today date ok?", ok);
		assertEquals("Check that orderList size is 1", 1, orderList.size());

	}
	
	@Test
	public void doUpdateLunchBoxOrderTest() {
		// Order list is not null, so that can add a new order
		// boundary
		assertNotNull("Check if there is valid lunchBoxOrder arraylist to add to", orderList);

		// Given an empty list, after adding 1 order, the size of the list is 1
		// normal
		boolean ok = (lunchBoxOrder1.getDate().getDayOfYear() - LocalDate.now().getDayOfYear() > 0);
		assertTrue("Test that new Lunch Box Order date is before today date ok?", ok);
		C206_CaseStudy.addLunchBoxOrder(orderList, lunchBoxOrder1);
		assertEquals("Check that orderList size is 1", 1, orderList.size());

		// Add another order
		// Test the size of orderList is 2
		// normal
		ok = (lunchBoxOrder2.getDate().getDayOfYear() - LocalDate.now().getDayOfYear() > 0);
		assertTrue("Test that new Lunch Box Order date is before today date ok?", ok);
		C206_CaseStudy.addLunchBoxOrder(orderList, lunchBoxOrder2);
		assertEquals("Check that orderList size is 2", 2, orderList.size());
		
		// Add another order
		// Test the size of orderList is 3
		// normal
		ok = (lunchBoxOrder4.getDate().getDayOfYear() - LocalDate.now().getDayOfYear() > 0);
		assertTrue("Test that new Lunch Box Order date is before today date ok?", ok);
		C206_CaseStudy.addLunchBoxOrder(orderList, lunchBoxOrder4);
		assertEquals("Check that orderList size is 3", 3, orderList.size());

		// Check that Lunch Box Order date is after today date - "2021-08-24"
		ok = (lunchBoxOrder2.getDate().getDayOfYear() - LocalDate.now().getDayOfYear() > 0);
		assertTrue("Test that new Lunch Box Order date is before today date ok?", ok);
		
		// Update order from orderList
		// Check the lunch box order is updated in the orderList
		// normal
		C206_CaseStudy.doUpdate(orderList, lunchBoxOrder2.getDate(), "Asian");
		assertSame("Check that lunch box order is updated", lunchBoxOrder2, orderList.get(1));

		// Check that Lunch Box Order date is after today date - "2021-08-30"
		ok = (lunchBoxOrder1.getDate().getDayOfYear() - LocalDate.now().getDayOfYear() > 0);
		assertTrue("Test that new Lunch Box Order date is before today date ok?", ok);

		// Update order from orderList
		// Check the lunch box order is updated in the orderList
		// normal
		C206_CaseStudy.doUpdate(orderList, lunchBoxOrder1.getDate(), "Asian");
		assertSame("Check that lunch box order is updated", lunchBoxOrder1, orderList.get(0));
				
		// Check that Lunch Box Order date is after today date - "2021-08-15"
		// Today date = "2021-08-15"
		// error
		ok = (lunchBoxOrder4.getDate().getDayOfYear() - LocalDate.parse("2021-08-15").getDayOfYear() > 0);
		assertFalse("Test that Lunch Box Order date is before today date ok?", ok);
		assertSame("Check that lunch box order is updated", lunchBoxOrder4, orderList.get(2));
	}


	@Test
	public void doAddAcctTest() {
		// Account list is not null, so that can add a new account
		// boundary
		assertNotNull("Check if there is valid account arraylist to add to?", accountList);

		// Given an empty list, after adding 1 account, the size of the list is 1
		// The account just added is as same as the first order of the list
		// Test that new Account is added valid (for parents valid student id)
		C206_CaseStudy.addAccount(accountList, studentidList, acc1);
		assertEquals("Check if accountList size is 1 upon validating student id", 1, accountList.size());
		assertSame("Check the account has been added successfully", acc1, accountList.get(0));

		// Add another account (normal)
		// Test that the accountList size is 2
		// Test that student id entered is valid
		C206_CaseStudy.addAccount(accountList, studentidList, acc2);
		assertEquals("Check if accountList size is 2 upon validating student id", 2, accountList.size());
		assertSame("Check the account has been added successfully", acc2, accountList.get(1));

		// error
		// The student id entered was invalid
		C206_CaseStudy.addAccount(accountList, studentidList, acc3);

		// check that the accountlist size is still 2 since student id validation failed
		assertEquals("Check if the size of accountList is 2", 2, accountList.size());

	}
	@Test
	public void doViewAcctTest() {
		// Test if AccountList is not null but empty - boundary
		assertNotNull("Test if there is valid Account arrayList to retrieve accounts", accountList);

		// test if the list of accounts retrieved from the SourceCentre is empty -
		// boundary
		String allAccts = C206_CaseStudy.viewAccount(accountList);
		String testOutput = String.format("%-10s %-10s %-10s %-10s %s\n", "Username", "Password", "User", "Student ID",
				"Mobile No");
		assertEquals("Check that viewAllAcct", testOutput, allAccts);

		// Given an empty list, after adding 2 accounts, test if the size of the list is
		// 2 - normal
		C206_CaseStudy.addAccount(accountList, studentidList, acc1);
		C206_CaseStudy.addAccount(accountList, studentidList, acc2);
		assertEquals("Test that Accounts arrayList size is 2", 2, accountList.size());

		// test if the expected output String same as the list of accounts retrieved
		// from the sourceCentre
		allAccts = C206_CaseStudy.viewAccount(accountList);
//		testOutput += String.format("%-10s %-10s %-10s %-10d %d\n", "Username", "Password", "User", "Student ID",
//				"Mobile No");
		testOutput += String.format("%-10s %-10s %-10s %-10d %d\n", "reg234", "12345", "Parent", 20034553, 87832782);
		testOutput += String.format("%-10s %-10s %-10s %-10d %d\n", "amanda456", "45677", "Parent", 20029321, 93032983);

		assertEquals("Test that viewAllAcct", testOutput, allAccts);

	}
	@Test
	public void doDeleteAcctTest() {
		// Account list is not null, so that new order can be added
		assertNotNull("Check if there is valid Account list to add to ", accountList);
		
		//given an empty list, after adding 1 order, the size of the list is 1 - normal 
		C206_CaseStudy.addAccount(accountList, studentidList, acc1);
		assertEquals("Check that accounts list size is 1", 1, accountList.size());
		
		// Add another account and test accounts arrayList is 2
		C206_CaseStudy.addAccount(accountList, studentidList, acc2);
		assertEquals("Check that accounts list size is 2", 2, accountList.size());
		
		//Delete the first order from the arrayList and test if size is reduced to 1
		C206_CaseStudy.deleteAccount(accountList, acc1);
		assertEquals("Check that accounts list size is reduced to 1", 1, accountList.size());
		
		//Test that the correct account was deleted
		assertNotEquals("Check that the correct account was deleted", acc1, accountList.get(0));
	}

	@Test
	public void testAddOrderBill() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid OrderBill arraylist to add to", orderbillList);

		// Given an empty list, after adding 1 item, the size of the list is 1
		orderbillList.add(ob1);
		assertEquals("Test if that orderbill arraylist size is 1?", 1, orderbillList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that orderbill is added same as 1st item of the list?", ob1, orderbillList.get(0));

		// Add another item. test The size of the list is 2?
		orderbillList.add(ob2);
		assertEquals("Test that orderbill arraylist size is 2?", 2, orderbillList.size());
	}

	@Test
	public void testviewOrderBill() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid orderbill arraylist to add to", orderbillList);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		orderbillList.add(ob1);
		orderbillList.add(ob2);
		assertEquals("Test if that orderbill arraylist size is 2?", 2, orderbillList.size());

		// test if the Item list contain items and not null list
		assertNotNull("Test if list contains the item added ", orderbillList);
	}

	@Test
	public void testdeleteOrderBill() {
		// Test to check orderbillList not empty and able to delete items
		assertNotNull("Check if there are items in orderbillList ", orderbillList);


		// Test that after adding to order bill list, able to delete immediately
		orderbillList.add(ob1);
		orderbillList.remove(ob1);
		assertEquals("ob1 is not in the list leaving the list to have 0 order bills ",0,  orderbillList.size());
	}
	
	@Test
	public void doAddMenuItemTest() {
		// MenuItem list is not null, so that can add a new order (boundary)

		assertNotNull("Check if there is valid Menu items arraylist to add to", menuList);

		// Given an empty list, after adding 1 menu item, the size of the list is 1
		// The menu item just added is as same as the first menu item of the list
		// Test that all fields is filled. (valid)

		menuList.add(item1);
		assertEquals("Check that menuList size is 1 after filling in all fields required", 1, menuList.size());
		assertSame("Check that new menu item is added successfully", item1, menuList.get(0));

		// Add another order (normal)
		// Test the size of menuList is now 2

		menuList.add(item2);
		assertEquals("Check that menuList size is 2 after filling in all fields required", 2, menuList.size());
		assertSame("Check that new menu item is added successfully", item2, menuList.get(1));

		// Given menuList is 2 
		// Test that after adding menuList is 3

		menuList.add(item3);

		assertEquals("Check that menuItem arraylist size is 3", 3, menuList.size());
	}
	@Test
	public void doViewMenuItemTest() {
		// Test that menu item list is not null but empty (boundary)
		assertNotNull("Test if there is valid menu item arrayList to retrieve the items", menuList);

		// Given that after adding 2 menu item (normal)
		// Test that the size of list is 2
		menuList.add(item1);
		menuList.add(item2);
		assertEquals("Test menu item arrayList size is 2", 2, menuList.size());

		// Test that menu item arrayList can view items (normal)
		C206_CaseStudy.viewMenuItem(menuList);

	}
	
	@Test
	public void doDeleteMenuItemTest() {
		// MenuItem list is not null, so that can add a new order (boundary)
		menuList.add(item1);
		menuList.add(item2);
		menuList.add(item3);
		assertNotNull("Check if there is valid Menu items arraylist to add to", menuList);
		// Given menuList size is 3 (normal)

		// Test to check menuList not empty and able to delete items
		// Test the size of the list is 2
		menuList.remove(item1);
		assertEquals("Check that menuList size is 2 after delete successful", 2, menuList.size());
		
		// Given menuList size is 2 (normal)
		// Test that menuList size is 1 after delete successful
		menuList.remove(item2);
		assertEquals("Check that menuList size is 1 after delete successful", 1, menuList.size());


		// Given menuList size is 1 (boundary)
		// Test that menuList size is 0 after delete successful
		menuList.remove(item3);
		assertEquals("Check that menuList size is 1 after delete successful", 0, menuList.size());


	}
	


	@After
	public void tearDown() throws Exception {
		lunchBoxOrder1 = null;
		lunchBoxOrder2 = null;
		lunchBoxOrder3 = null;
		lunchBoxOrder4 = null;
		
		item1 = null;
		item2 = null;
		item3 = null;
		
		acc1 = null;
		acc2 = null;
		acc3 = null;
	}

}
