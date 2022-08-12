
public abstract class Beverage {
	private String bevName;
	private TYPE type;
	private SIZE size;
	final private double basePrice = 2.0;
	final private double sizePrice = 1.0;
	
	public Beverage(String bevName, TYPE type, SIZE size) {
		this.bevName = bevName;
		this.type = type;
		this.size = size;
	}
	public Beverage() {
		
	}
	public Beverage(Beverage beverage) {
		this.bevName = beverage.getBevName();
		this.type = beverage.getType();
		this.size = beverage.getSize();
	}
	
	public abstract double calcPrice();
	
	@Override
	public String toString() {
		return "Beverage [name=" + bevName + ", size=" + size + "]";
	}
	
	public boolean equals(String n, TYPE t, SIZE s) {
		if(((this.bevName).equals(n)) && 
		   ((this.type).equals(t)) && 
		   ((this.size).equals(s))) {
			return true;
		}
		return false;
	}
	
	public String getBevName() {
		return bevName;
	}
	public TYPE getType() {
		return type;
	}
	public SIZE getSize() {
		return size;
	}
	public double getBasePrice() {
		return basePrice;
	}
	public double getSizePrice() {
		return sizePrice;
	}
	public void setName(String bevName) {
		this.bevName = bevName;
	}
	public void setType(TYPE type) {
		this.type = type;
	}
	public void setSize(SIZE size) {
		this.size = size;
	}
	
}
