import java.time.LocalDate;

public class Order {
	private int id;
	private LocalDate date;
	private String meal;
	private String drink;
	private String fruit;
	
	public Order(int id, LocalDate date, String meal, String drink, String fruit) {
		this.id = id;
		this.date = date;
		this.meal = meal;
		this.drink = drink;
		this.fruit = fruit;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public String getFruit() {
		return fruit;
	}

	public void setFruit(String fruit) {
		this.fruit = fruit;
	}

	public int getId() {
		return id;
	}

	public LocalDate getDate() {
		return date;
	}
	
	public void printInfo() {
		String output = String.format("%-5d %-10s %-10s %-10s %s", id, date, meal, drink, fruit);
		System.out.println(output);
	}
}
