
	public class OrderBill {
		
		private int id;
		private double price;
		private int quantity;
		private double totalPrice;
		
		
		public OrderBill(int id, double price, int quantity, double totalPrice) {
			this.id = id;
			this.price = price;
			this.quantity = quantity;
			this.totalPrice = totalPrice;
		}


		public int getId() {
			return id;
		}


		public double getPrice() {
			return price;
		}


		public int getQuantity() {
			return quantity;
		}
		public double gettotalPrice() {
			return (price*quantity);
		}
		
		
		}


