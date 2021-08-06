import java.time.LocalDate;
import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_OUT = 4;
	private static ArrayList<Menu> menuList = new ArrayList<Menu>();
	private static ArrayList<Account> accounts = new ArrayList<Account>();
	private static ArrayList<Order> orderList = new ArrayList<Order>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		accounts.add(new Account("Jane123x", "12345", "Parent"));
		accounts.add(new Account("xxRoxy23", "45678", "Student"));
		accounts.add(new Account("Regina34", "67805", "Parent"));
		accounts.add(new Account("Bob89", "90234", "Student"));

		menuList.add(new Menu("Western", "Carbonara", "Fruit punch", "Watermelon Slice", 5.00));
		menuList.add(new Menu("Asian", "Chicken Rice", "Milo", "Pear Slice", 4.50));
		menuList.add(new Menu("Vegeterian", "Vegeterian Bee Hoon", "Apple Juice", "Banana", 3.00));

		int option = 0;

		while (option != OPTION_OUT) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				C206_CaseStudy.setHeader("Select option to view");
				System.out.println("1. View user account for Parents/Secondary school students");
				System.out.println("2. View menu items");
				System.out.println("3. View monthly menu");
				System.out.println("4. View lunch box menu");
				System.out.println("5. View brder bill");

				int view = Helper.readInt("Enter option to view selected item > ");
				if (view == 1) {
					viewAccount(accounts);
				}else if (view == 2) {
					viewMenuItem(menuList);
				}else if (view == 3) {
					
				}else if (view == 4) {
					viewLunchBoxOrder(orderList);
				}else if (view == 5) {
					
				}

			} else if (option == 2) {
				C206_CaseStudy.setHeader("Select option to view");
				System.out.println("1. Add user account for Parents/Secondary school students");
				System.out.println("2. Add menu items");
				System.out.println("3. Add monthly menu");
				System.out.println("4. Add lunch box menu");
				System.out.println("5. Add brder bill");

				int add = Helper.readInt("Enter option to view selected item > ");
				if (add == 1) {
					addAccount(accounts);
				} else if (add == 2) {
					addMenuItem(menuList);
				} else if (add == 3) {

				} else if (add == 4) {
					addLunchBoxOrder(orderList);
				} else if (add == 5) {

				}

			} else if (option == 2) {
				C206_CaseStudy.setHeader("Select option to view");
				System.out.println("1. Delete user account for Parents/Secondary school students");
				System.out.println("2. Delete menu items");
				System.out.println("3. Delete monthly menu");
				System.out.println("4. Delete lunch box menu");
				System.out.println("5. Delete brder bill");

				int delete = Helper.readInt("Enter option to view selected item > ");
				if (delete == 1) {
					deleteAccount(accounts);
				}else if (delete == 2) {
					deleteMenuItem(menuList);
				}else if (delete == 3) {
					
				}else if (delete ==4) {
					deleteLunchBoxOrder(orderList);
				}else if (delete == 5) {
					
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

	public static void addAccount(ArrayList<Account> accounts) {
		String user = Helper.readString("Are you a student/ parent > ");
		String username = Helper.readString("Enter username: ");
		String password = Helper.readString("Enter password: ");

		Account newAcct = new Account(username, password, user);
		accounts.add(newAcct);
	}

	public static void viewAccount(ArrayList<Account> accounts) {
		String view = String.format("%-10s %-10s %s\n", "Username", "Password", "User");
		Helper.line(60, "-");
		for (Account a : accounts) {
			view += String.format("%-10s %-10s %s\n", a.getUsername(), a.getPassword(), a.getUser());
		}
		System.out.println(view);
	}

	public static void deleteAccount(ArrayList<Account> accounts) {
		String username = Helper.readString("Enter your username > ");
		for (Account a : accounts) {
			if (username.equals(a.getUsername())) {
				accounts.remove(a);
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
	public static void addLunchBoxOrder(ArrayList<Order> orderList) {
        setHeader("ADD LUNCH BOX ORDER");
        String dateOfOrder = Helper.readString("Enter the date to have the lunch box > ");
       
        if (LocalDate.parse(dateOfOrder).getDayOfYear() - LocalDate.now().getDayOfYear() > 0 && LocalDate.parse(dateOfOrder).getMonth() == LocalDate.now().getMonth()) {
            viewMenuItem(menuList);
            for (Menu m : menuList) {
            	viewMenuItem(menuList);
                String cuisine = Helper.readString("Enter cuisine > ");
                if (!cuisine.isEmpty()){
                    if (cuisine.equalsIgnoreCase(m.getCuisine())) {
                        orderList.add(new Order(orderList.size()+1, LocalDate.parse(dateOfOrder), m.getMeal(), m.getDrink(), m.getFruit()));
                    } else {
                        System.out.println("Please enter an available cuisine");
                    }
                } else {
                    System.out.println("Please enter a cuisine");
                }
            }
        } else {
            System.out.println("Add Lunch Box Order failed");
        }
    }
   
    public static void viewLunchBoxOrder(ArrayList<Order> orderList) {
        setHeader("VIEW LUNCH BOX ORDERS");
        System.out.println(String.format("%-5s %-10s %-10s %-10s %s", "ID", "DATE", "MEAL", "DRINK", "FRUIT"));
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
                        if (!cuisine.isEmpty()){
                            if (cuisine.equalsIgnoreCase(m.getCuisine())) {
                                odr.setMeal(m.getMeal());
                                odr.setDrink(m.getDrink());
                                odr.setFruit(m.getFruit());
                            }
                        } else {
                            System.out.println("Please enter an available cuisine");
                        }
                    }
                }else {
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
}

// commenting to check if pushing works
