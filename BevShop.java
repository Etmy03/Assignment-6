/*
 * Class: CMSC203 
 * Instructor:Farnaz Eivazi
 * Description: This program will process the customers orders at a beverages store. 
 * 				This store sells three types of beverages: coffee, smoothies, and alcohol.
 * Due: 8/11/2022
 * Platform/compiler: Java
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Etmy Barbosa
*/

import java.util.ArrayList;

public class BevShop implements BevShopInterfce{
	private int MIN_AGE_FOR_ALCOHOL = 21;          //Minimum age for offering alcohol drink
	final private int MAX_ORDER_FOR_ALCOHOL= 3;    /*Maximum number of alcohol beverages
													that can be ordered within an order  */
	private int MIN_TIME= 8;				       //earliest time for the order
	private int MAX_TIME= 23;				       //latest  time for the order
	private int MAX_FRUIT = 5;				       //Maximum number of fruits that this shop offers for SMOOTHIE beverage
	
	Beverage b;
	private int numOfAlcohol;
	ArrayList<Order> list = new ArrayList<Order>();
	Order order;
	
	public BevShop() {
		
	}
	
	/**
	 * Checks if the time is valid (between 8 and 23 )
	 * @param time time represents the time 
	 * @return true if times is within the range of 8 to 23 , false otherwise
	 */
	public boolean validTime(int time) {
		if((time >= MIN_TIME) && (time <= MAX_TIME)) {
			return true;
		}
		return false;
	}
	
	/**
	 * checks if the number of alcohol beverages for the current order has reached the maximum
	 * @return true if number of alcohol drinks for the current order has reached the maximum , false otherwise
	 */
	public boolean eligibleForMore() {
		if(order.findNumOfBeveType(TYPE.ALCOHOL) <= MAX_ORDER_FOR_ALCOHOL) {
			return true;
		}
		return false;
	}
	
	/**
	 * check the valid age for the alcohol drink
	 * @param age the age  
	 * @return returns true if age is more than minimum eligible age , false otherwise  
	 */
	public  boolean validAge(int age) {
		if(age <= MIN_AGE_FOR_ALCOHOL) {
			return false;
		}
		return true;
	}
	
	/**
	  * Creates a new order ,  NO BEVERAGE is added to the order yet 
	  * @param time time of the order  
	  * @param day day of the order of type DAY
	  * @param customerName customer name 
	  * @param customerAge customer age
	  */
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		order = new Order(time, day, new Customer(customerName, customerAge));
		list.add(order);
	}
 
	/**
	 * process the Coffee order for the current order by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param extraShot true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup true if the coffee beverage has extra syrup , false otherwise
	 */
	public void processCoffeeOrder( String bevName, SIZE size, boolean extraShot, boolean extraSyrup ) {
		order.addNewBeverage(bevName, size, extraShot, extraSyrup);
		//list.set(list.size()-1, order);
	}
	
	/**
	 * process the Alcohol order for the current order by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 */
	public void  processAlcoholOrder( String bevName, SIZE size ) {
		order.addNewBeverage(bevName, size);
		numOfAlcohol++;
		//list.set(list.size()-1, order);
	}
	
	/**
	 * process the Smoothie order for the current order  by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param numOfFruits number of fruits to be added 
	 * @param addProtien true if protein is added , false otherwise
	 */
	public void processSmoothieOrder( String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		order.addNewBeverage(bevName, size, numOfFruits, addProtien);
		//list.set(list.size()-1, order);
	}
	
	/**
	 * locate an order based on  the order number
	 * @param orderNo the order number
	 * @return the index of the order in the list of Orders  if found or -1 if not found
	 */
	public int findOrder(int orderNo) {
		for(int i=0; i<list.size(); i++) {
			if((list.get(i).getOrderNo()) == orderNo) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * locates an order in the list of orders and returns the total value on the order.
	 * @param orderNo the order number
	 * @returns the calculated price on this order.
	 */
	public double totalOrderPrice(int orderNo) {
		list.add(order);
		double total = 0;
		try {
			total = list.get(findOrder(orderNo)).calcOrderTotal();
		}
		catch(Throwable e) {
			total = 0;
		}
		
		return total;
	}
	
	/**
	 *  Calculates the total sale of all the orders for this beverage shop
	 *  @return the total sale of all the orders 
	 */
	public double totalMonthlySale() {
		sortOrders();
		for (int x=0; x<list.size(); x++) {
			for (int y=x+1; y<list.size(); y++) {
				if(getOrderAtIndex(y).equals(getOrderAtIndex(x))) {
					list.remove(x);
				}
			}
		}
		double total = 0;
		for(int i=0; i<list.size(); i++) {
			total += list.get(i).calcOrderTotal();
		}
		return total;
	}
	
	/**
	 * sorts the orders within this bevShop using the Selection
	 * sort algorithm
	 */
	public  void sortOrders() {
		Order temp;
		int n;
		try {
			for (int x=0; x<list.size(); x++) {
				for (int y=x+1; y<list.size(); y++) {
					if(getOrderAtIndex(y).getOrderNo()<getOrderAtIndex(x).getOrderNo()) {
						temp = list.get(x);
						list.set(x, list.get(y));
						list.set(y, temp);
					}
				}
			}
		}
		catch(Exception e){
			
		}
		
	}
	
	/**
	 * returns Order in the list of orders at the index
	 * Notes: this method returns the shallow copy of the order
	 * @return Order in the list of orders at the index 
	 */
	public Order getOrderAtIndex(int index) {
		return list.get(index);
	}
	
	public boolean isMaxFruit(int numOfFruits) {
		if (MAX_FRUIT < numOfFruits) {
			return true;
		}
		return false;
	}
	
	public int totalNumOfMonthlyOrders() {
		return list.size();
	}

	
	//get/set methods
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	public int getMIN_TIME() {
		return MIN_TIME;
	}

	public int getMAX_TIME() {
		return MAX_TIME;
	}

	public int getMAX_FRUIT() {
		return MAX_FRUIT;
	}

	public int getNumOfAlcoholDrink() {
		return numOfAlcohol;
	}

	public ArrayList<Order> getList() {
		return list;
	}

	public Order getCurrentOrder() {
		return order;
	}

	public void setMIN_AGE_FOR_ALCOHOL(int mIN_AGE_FOR_ALCOHOL) {
		MIN_AGE_FOR_ALCOHOL = mIN_AGE_FOR_ALCOHOL;
	}

	public void setMIN_TIME(int mIN_TIME) {
		MIN_TIME = mIN_TIME;
	}

	public void setMAX_TIME(int mAX_TIME) {
		MAX_TIME = mAX_TIME;
	}

	public void setMAX_FRUIT(int mAX_FRUIT) {
		MAX_FRUIT = mAX_FRUIT;
	}

	public void setNumOfAlcohol(int numOfAlcohol) {
		this.numOfAlcohol = numOfAlcohol;
	}

	public void setList(ArrayList<Order> list) {
		this.list = list;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		String str = "";
		for(int i =0; i<list.size(); i++) {
			str += list.get(i).toString() + " ";
		}
		return "BevShop [order=" + str + ", totalMonthlySale()=" + totalMonthlySale() + "]";
	}

	

	
	
}
