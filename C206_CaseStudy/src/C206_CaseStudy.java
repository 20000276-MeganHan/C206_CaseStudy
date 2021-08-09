import java.time.LocalDate;
import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_OUT = 4;
	private static ArrayList<Menu> menuList = new ArrayList<Menu>();
	private static ArrayList<Menu> monthlyMenu = new ArrayList<Menu>();
	private static ArrayList<Account> accounts = new ArrayList<Account>();
	private static ArrayList<Order> orderList = new ArrayList<Order>();
	private static ArrayList<OrderBill> orderbillList = new ArrayList<OrderBill>();
	private static ArrayList<Integer> studentidList = new ArrayList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		accounts.add(new Account("Jane123x", "12345", "Parent", 20034561, 94304922));
		accounts.add(new Account("xxRoxy23", "45678", "Student", 20034561, 0.0, 83293821));
		accounts.add(new Account("Regina34", "67805", "Parent", 20093321, 93298320));
		accounts.add(new Account("Bob89", "90234", "Student", 20093321, 0.0, 87873829));

		menuList.add(new Menu("Western", "Carbonara", "Fruit punch", "Watermelon Slice", 5.00));
		menuList.add(new Menu("Asian", "Chicken Rice", "Milo", "Pear Slice", 4.50));
		menuList.add(new Menu("Vegeterian", "Vegeterian Bee Hoon", "Apple Juice", "Banana", 3.00));

		studentidList.add(20034561);
		studentidList.add(20093321);
		studentidList.add(20030291);

		int option = 0;

		while (option != OPTION_OUT) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				C206_CaseStudy.setHeader("Select option to view");
				System.out.println("1. View user account for Parents/Secondary school students");
				System.out.println("2. View menu items");
				System.out.println("3. View monthly menu");
				System.out.println("4. View lunch box order");
				System.out.println("5. View order bill");

				int view = Helper.readInt("Enter option to view selected item > ");
				if (view == 1) { // view accounts
					System.out.println(viewAccount(accounts));
				} else if (view == 2) { // view menu items
					viewMenuItem(menuList);
				} else if (view == 3) { // view monthly menu
					viewMenu(monthlyMenu);
				} else if (view == 4) { // view lunch box order
					viewLunchBoxOrder(orderList);
				} else if (view == 5) { // view order bill
					viewBill(orderbillList);
				}

			} else if (option == 2) {
				C206_CaseStudy.setHeader("Select option to view");
				System.out.println("1. Add user account for Parents/Secondary school students");
				System.out.println("2. Add menu items");
				System.out.println("3. Add monthly menu");
				System.out.println("4. Add lunch box order");
				System.out.println("5. Add order bill");

				int add = Helper.readInt("Enter option to view selected item > ");
				if (add == 1) { // add account
					Account newAcct = inputaddAcct();
					addAccount(accounts, studentidList, newAcct);
				} else if (add == 2) { // add menu item
					addMenuItem(menuList);
				} else if (add == 3) { // add monthly menu
					createMenu(monthlyMenu);
				} else if (add == 4) { // add lunch box order
					addLunchBoxOrder(orderList);
				} else if (add == 5) { // add order bill
					addBill(orderbillList);

				}

			} else if (option == 3) {
				C206_CaseStudy.setHeader("Select option to view");
				System.out.println("1. Delete user account for Parents/Secondary school students");
				System.out.println("2. Delete menu items");
				System.out.println("3. Delete monthly menu");
				System.out.println("4. Delete lunch box order");
				System.out.println("5. Delete order bill");

				int delete = Helper.readInt("Enter option to view selected item > ");
				if (delete == 1) { // delete account
					Account delAcc = inputDelete();
					deleteAccount(accounts, delAcc);
				} else if (delete == 2) { // delete menu items
					deleteMenuItem(menuList);
				} else if (delete == 3) {
					deleteMenu(monthlyMenu);
				} else if (delete == 4) { // delete lunch box order
					deleteLunchBoxOrder(orderList);
				} else if (delete == 5) {
					deleteBill(orderbillList);

				}
			}

		}

		System.out.println("Thank you for using lunch box app");

	}

	public static void menu() {
		// TODO Auto-generated method stub
		C206_CaseStudy.setHeader("Lunch Box Order");
		System.out.println("1. View Inventory");
		System.out.println("2. Add");
		System.out.println("3. Delete");
		System.out.println("4. Quit");

		Helper.line(80, "-");
	}

	public static void setHeader(String header) {
		// TODO Auto-generated method stub
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static Account inputaddAcct() {
		int studentid = 0;
		int mobileNo = 0;
		Account newAcct = null;
		String user = Helper.readString("Are you a student/ parent > ");
		String username = Helper.readString("Enter username > ");
		String password = Helper.readString("Enter password >  ");
		if (user.equalsIgnoreCase("Parent")) {
			studentid = Helper.readInt("Enter child's student id >");
			for (Integer i : studentidList) {
				if (studentid == i) {
					mobileNo = Helper.readInt("Enter your mobile no > ");
					newAcct = new Account(username, password, user, studentid, mobileNo);
				}
			}
		} else {
			studentid = Helper.readInt("Enter your student id > ");
			for (Integer i : studentidList) {
				if (studentid == i) {
					mobileNo = Helper.readInt("Enter your mobile no > ");
					newAcct = new Account(username, password, user, studentid, 0.0, mobileNo);
				}
				

			}
		}
		return newAcct;
	}

	public static void addAccount(ArrayList<Account> accounts, ArrayList<Integer> studentidList, Account newAcct) {
		boolean validSID = false;
		boolean added = false;

		if (newAcct.getUser().equalsIgnoreCase("Parent")) {
			for (Integer i : studentidList) {
				if (newAcct.getStudentID() == i) {
					validSID = true;
					added = true;
				}
			}
		} else {
			for (Integer i : studentidList) {
				if (newAcct.getStudentID() == i) {
					validSID = true;
					added = true;
				}
			}
		}
		if (added == true) {
			accounts.add(newAcct);
			System.out.println("Added account successfully!");
		} else if (validSID == false) {
			System.out.println("Student ID entered invalid");
		}

		if (added == false) {
			System.out.println("Account is not added!");
		}
	}

	public static String viewAccount(ArrayList<Account> accounts) {
		String view = String.format("%-10s %-10s %-10s %-10s %s\n", "Username", "Password", "User", "Student ID",
				"Mobile No");
		Helper.line(60, "-");
		for (Account a : accounts) {
			view += String.format("%-10s %-10s %-10s %-10d %d\n", a.getUsername(), a.getPassword(), a.getUser(), a.getStudentID(),
					a.getMobileNo());
		}
		return view;

	}
	
	public static Account inputDelete() {
		String username = Helper.readString("Enter your username > ");
		Account delAcc = null;
		for (Account a : accounts) {
			if (username.equals(a.getUsername())) {
				delAcc = a;
			}
		}
		return delAcc;
	}

	public static void deleteAccount(ArrayList<Account> accounts, Account delAcct ) {
		accounts.remove(delAcct);
	}

	public static void updateAccount(ArrayList<Account> accounts) {
		String username = Helper.readString("Enter your username > ");
		for (Account a : accounts) {
			if (username.equals(a.getUsername())) {
				int mobileNo = Helper.readInt("Enter new mobile no > ");
				a.setMobileNo(mobileNo);
			}
		}

	}

	public static void addMenuItem(ArrayList<Menu> menuList) {
		String cuisine = Helper.readString("Western / Asian / Vegeterian > ");
		String meal = Helper.readString("Enter meal name: ");
		String drink = Helper.readString("Enter choice of drink: ");
		String fruit = Helper.readString("Enter type of fruit: ");
		Double price = Helper.readDouble("Enter price of meal: ");

		Menu newMenuItem = new Menu(cuisine, meal, drink, fruit, price);
		menuList.add(newMenuItem);

	}

	public static void viewMenuItem(ArrayList<Menu> menuList) {
		String view = String.format("%-10s %-10s %-10s %-10s %s\n", "Cuisine", "Meal", "Drink", "Fruit", "Price");
		Helper.line(60, "-");
		for (Menu m : menuList) {
			view += String.format("%-10s %-10s %-10s %-10s %s\n", m.getCuisine(), m.getMeal(), m.getDrink(),
					m.getFruit(), m.getPrice());
		}
		System.out.println(view);

	}

	public static void deleteMenuItem(ArrayList<Menu> menuList) {
		String meal = Helper.readString("Enter meal name: ");
		for (Menu m : menuList) {
			if (meal.equals(m.getMeal())) {
				menuList.remove(m);
			}

		}
	}
	
	public static void createMenu(ArrayList<Menu>monthlyMenu) {
		String cuisine = Helper.readString("Western / Asian / Vegeterian > ");
		String meal = Helper.readString("Enter meal name: ");
		for (Menu m:monthlyMenu) {
			cuisine += m.getCuisine();
			meal += m.getMeal();
		}
		
		String drink = Helper.readString("Enter choice of drink: ");
		for (Menu m:monthlyMenu) {
			drink += m.getDrink();
		}
		
		String fruit = Helper.readString("Enter type of fruit: ");
		for (Menu m:monthlyMenu) {
			fruit += m.getFruit();
		}
		
		Double price = Helper.readDouble("Enter price of meal: ");
		for (Menu m:monthlyMenu) {
			price += m.getPrice();
		}
		
		monthlyMenu.add(new Menu(cuisine, meal, drink, fruit, price));
	}
	
	public static void viewMenu(ArrayList<Menu>monthlyMenu) {
		String view = String.format("%-10s %-20s %-15s %-18s %s\n", "Cuisine", "Meal", "Drink", "Fruit", "Price");
		Helper.line(60, "=");
		for (Menu m : monthlyMenu) {
			view += String.format("%-10s %-20s %-15s %-18s %s\n", m.getCuisine(), m.getMeal(), m.getDrink(),
					m.getFruit(), m.getPrice());
		}
		System.out.println(view);
	}
	
	public static void deleteMenu(ArrayList<Menu> monthlyMenu) {
		String cuisine = Helper.readString("Enter the cuisine: ");
		for (Menu m:monthlyMenu) {
			if (cuisine.equalsIgnoreCase(m.getCuisine())) {
				monthlyMenu.remove(m);
			}
		}
	}
	
	public static void updateMenuItem(ArrayList<Menu> menuList) {
		String meal = Helper.readString("Enter meal name: ");
		for (Menu m : menuList) {
			if (meal.equals(m.getMeal())) {
				double price = Helper.readDouble("Enter new price for meal > ");
				m.setPrice(price);
			}
		}

	}

	public static void addLunchBoxOrder(ArrayList<Order> orderList) {
		setHeader("ADD LUNCH BOX ORDER");
		String dateOfOrder = Helper.readString("Enter the date to have the lunch box > ");

		if (LocalDate.parse(dateOfOrder).getDayOfYear() - LocalDate.now().getDayOfYear() > 0
				&& LocalDate.parse(dateOfOrder).getMonth() == LocalDate.now().getMonth()) {
			viewMenuItem(menuList);
			String cuisine = Helper.readString("Enter cuisine > ");
			if (!cuisine.isEmpty()) {
				for (Menu m : menuList) {
					if (cuisine.equalsIgnoreCase(m.getCuisine())) {
						orderList.add(new Order(orderList.size() + 1, LocalDate.parse(dateOfOrder), m.getMeal(),
								m.getDrink(), m.getFruit()));
						break;
					} else {
						System.out.println("Please enter an available cuisine");
					}
				}
			} else {
				System.out.println("Please enter a cuisine");
			}
		} else {
			System.out.println("Add Lunch Box Order failed");
		}
	}

	public static void viewLunchBoxOrder(ArrayList<Order> orderList) {
		setHeader("VIEW LUNCH BOX ORDERS");
		System.out.println(String.format("%-5s %-15s %-15s %-15s %s", "ID", "DATE", "MEAL", "DRINK", "FRUIT"));
		for (Order odr : orderList) {
			odr.printInfo();
		}
	}

	public static void updateLunchBoxOrder(ArrayList<Order> orderList) {
		setHeader("UPDATE LUNCH BOX ORDERS");
		String dateOfOrder = Helper.readString("Enter the date > ");
		if (LocalDate.parse(dateOfOrder).getDayOfYear() - LocalDate.now().getDayOfYear() > 0) {
			for (Order odr : orderList) {
				if (LocalDate.parse(dateOfOrder) == odr.getDate()) {
					viewMenuItem(menuList);
					for (Menu m : menuList) {
						String cuisine = Helper.readString("Enter cuisine > ");
						if (!cuisine.isEmpty()) {
							if (cuisine.equalsIgnoreCase(m.getCuisine())) {
								odr.setMeal(m.getMeal());
								odr.setDrink(m.getDrink());
								odr.setFruit(m.getFruit());
							}
						} else {
							System.out.println("Please enter an available cuisine");
						}
					}
				} else {
					System.out.println("No order on this date");
				}
			}
		} else {
			System.out.println("Please enter a cuisine");
		}
	}

	public static void deleteLunchBoxOrder(ArrayList<Order> orderList) {
		setHeader("DELETE LUNCH BOX ORDERS");
		String date = Helper.readString("Enter order date to cancel > ");
		if (LocalDate.parse(date).getDayOfYear() - LocalDate.now().getDayOfYear() > 0) {
			for (Order odr : orderList) {
				if (LocalDate.parse(date) == odr.getDate()) {
					odr.printInfo();
					char check = Helper.readChar("Do you want to cancel order? (Y/N) > ");
					if (check == 'Y') {
						orderList.remove(odr);
						System.out.println("Cancellation Successful");
					} else {
						odr.printInfo();
					}
				}
				System.out.println("No order on this date");
			}
			System.out.println("Cancellation Failed");
		}
	}

	public static void addBill(ArrayList<OrderBill> orderbillList) {

		int id = Helper.readInt("Enter new orderbill ID");
		double price = Helper.readDouble("Enter price!");
		int quantity = Helper.readInt("Enter quantity!");
		double totalPrice = 0.0;

		totalPrice = price * quantity;

		OrderBill newOrderBill = new OrderBill(id, price, quantity, totalPrice);
		orderbillList.add(newOrderBill);

	}

	public static void viewBill(ArrayList<OrderBill> orderbillList) {
		String view = String.format("%-10s %-10s %-10s %s\n", "id", "price", "quantity", "totalPrice");
		Helper.line(50, "-");
		for (OrderBill ob : orderbillList) {
			view += String.format("%-10d %.-2f %-10d %.-2f %s\n", ob.getId(), ob.getPrice(), ob.getQuantity(),
					ob.gettotalPrice());
		}
		System.out.println(view);
	}

	public static void deleteBill(ArrayList<OrderBill> orderbillList) {
		int id = Helper.readInt("Enter orderbill ID to delete ");
		for (OrderBill ob : orderbillList) {
			if (id == ob.getId())
				;
			{
				char confirm = Helper.readChar("Do you want to delete orderBill? (Y/N) > ");
				if (confirm == 'Y') {
					orderbillList.remove(ob);
					System.out.println("Order Bill Deleted!");
				} else {
					System.out.println("Cancelled!");
				}
			}
		}
	}

}

// commenting to check if pushing works.
