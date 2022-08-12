
public class Coffee extends Beverage{
	private boolean extra_shot = false;
	private boolean extra_syrup = false;
	final private double additional_cost = 0.50;
	
	public Coffee(String name, SIZE size, boolean extra_shot, boolean extra_syrup) {
		super(name, TYPE.COFFEE, size); 
		this.extra_shot = extra_shot;
		this.extra_syrup = extra_syrup;
	}
	public Coffee(Coffee coffee) {
		super(coffee.getBevName(), TYPE.COFFEE, coffee.getSize()); 
		this.extra_shot = coffee.getExtraShot();
		this.extra_syrup = coffee.getExtraSyrup();
	}

	@Override
	public double calcPrice() {
		double price = super.getBasePrice();
		if(extra_shot == true) {
			price += additional_cost;
		}
		if(extra_syrup == true) {
			price += additional_cost;
		}
		if(((getSize()).equals(SIZE.MEDIUM)) || ((getSize()).equals(SIZE.LARGE))) {
			price += super.getSizePrice();
			if((getSize()).equals(SIZE.LARGE)) {
				price += super.getSizePrice();
			}
		}
		
		return price;
	}
	
	
	
	@Override
	public String toString() {
		return "Coffee [extra_shot=" + extra_shot + ", extra_syrup=" + extra_syrup + ", calcPrice()=" + calcPrice()
				+ ", getBevName()=" + getBevName() + ", getSize()=" + getSize() + "]";
	}
	public boolean equals(Coffee coffee) {
		if(((super.getBevName()).equals(coffee.getBevName())) && 
		   ((super.getType()).equals(coffee.getType())) && 
		   ((super.getSize()).equals(coffee.getSize())) &&
		   (this.extra_shot == coffee.getExtraShot()) &&
		   (this.extra_syrup == coffee.getExtraSyrup())) {
			return true;
		}
		return false;
	}

	
	public boolean getExtraShot() {
		return extra_shot;
	}

	public boolean getExtraSyrup() {
		return extra_syrup;
	}

	public void setExtra_shot(boolean extra_shot) {
		this.extra_shot = extra_shot;
	}

	public void setExtra_syrup(boolean extra_syrup) {
		this.extra_syrup = extra_syrup;
	}
	
	//override get/set
	
	
}
