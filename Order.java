import java.util.ArrayList;

public class Order implements OrderInterface, Comparable<Order>{
	private int number;
	private int time;
	private DAY day;
	private Customer customer = new Customer("a",3);
	ArrayList<Beverage> beverages = new ArrayList<Beverage>();
	
	
	public Order(int time, DAY day, Customer c) {
		this.time = time;
		this.day = day;
		this.customer = new Customer(c);
		this.number = ran();
		}
	public Order(Order order) {
		this.time = order.getOrderTime();
		this.day = order.getOrderDay();
		this.customer = new Customer(order.getCustomer());
		this.number = ran();
		}
	
	public int ran() {
		int min = 10000;
		int max = 90000;
		return (int)(Math.floor(Math.random()*(max-min+1)+min));
		//return number;
	}
	
	public void  addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
	}
	public void  addNewBeverage( String bevName,SIZE size,int numOfFruits,boolean addPRotien) {
		beverages.add(new Smoothie(bevName , size, numOfFruits, addPRotien));
	}
	public void  addNewBeverage( String bevName, SIZE size) {
		beverages.add(new Alcohol(bevName, size, false));
	}

	

	@Override
	public String toString() {
		return "Order [number=" + number + ", time=" + time + ", day=" + day + ", beverages=" + beverages
				+ ", getCustomerAge()=" + getCustomerAge() + ", getCustomerName()=" + getCustomerName()
				+ ", calcOrderTotal()=" + calcOrderTotal() + "]";
	}

	public int compareTo(Order otherOrder) {
		int myNum = 2;
		if(this.number == (otherOrder.getOrderNo())) {
			myNum = 0;
		}
		else if(this.number > (otherOrder.getOrderNo())) {
			myNum = 1;
		}
		else if(this.number < (otherOrder.getOrderNo())) {
			myNum = -1;
		}
		return myNum;
	}

	public int getOrderNo() {
		return number;
	}

	public int getOrderTime() {
		return time;
	}

	public DAY getOrderDay() {
		return day;
	}

	public Customer getCustomer() {
		return new Customer(customer);
	}
	public int getCustomerAge() {
		return customer.getAge();
	}
	public String getCustomerName() {
		return customer.getName();
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void setDay(DAY day) {
		this.day = day;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	//interface methods 
	public boolean isWeekend() {
		if(((getOrderDay()).equals(DAY.SATURDAY)) || ((getOrderDay()).equals(DAY.SUNDAY))) {
			return true;
		}
		return false;
	}
	public Beverage getBeverage(int itemNo) {
		TYPE myType = beverages.get(itemNo).getType();
		
		if(myType.equals(TYPE.COFFEE)) {
			return new Coffee((Coffee)beverages.get(itemNo));
		}
		else if(myType.equals(TYPE.SMOOTHIE)) {
			return new Smoothie((Smoothie)beverages.get(itemNo));
		}
		else if(myType.equals(TYPE.ALCOHOL)) {
			 return new Alcohol((Alcohol)beverages.get(itemNo));
		}
		return null;
		
	}
	public double calcOrderTotal() {
		double total = 0.0;
		for(int i=0; i<beverages.size(); i++) {
			total += getBeverage(i).calcPrice();
		}
		if(isWeekend() && ((findNumOfBeveType(TYPE.ALCOHOL))>0)) {
			total+=0.6;
		}
		return total;
	}
	public int findNumOfBeveType(TYPE type) {
		int num = 0;
		for(int i=0; i<beverages.size(); i++) {
			if(((beverages.get(i)).getType()).equals(type)) {
				num++;
			}
			
		}
		return num;
	}
	
	public int getTotalItems() {
		return beverages.size();
	}
	
}
