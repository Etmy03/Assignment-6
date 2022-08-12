
public class Alcohol extends Beverage{
	private boolean isWeekend;
	final private double additionalIsWeekend = 0.60;
	
	public Alcohol(String name, SIZE size, boolean isWeekend) {
		super(name, TYPE.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}
	public Alcohol(Alcohol alcohol) {
		super(alcohol.getBevName(), TYPE.ALCOHOL, alcohol.getSize());
		this.isWeekend = alcohol.isWeekend();
	}
	
	@Override
	public double calcPrice() {
		double price = super.getBasePrice();
		if(isWeekend == true) {
			price += additionalIsWeekend;
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
		return "Alcohol [isWeekend=" + isWeekend + ", calcPrice()=" + calcPrice() + ", getBevName()=" + getBevName()
				+ ", getSize()=" + getSize() + "]";
	}
	public boolean equals(Alcohol alcohol) {
		if(((super.getBevName()).equals(alcohol.getBevName())) && 
		   ((super.getType()).equals(alcohol.getType())) && 
		   ((super.getSize()).equals(alcohol.getSize()))) {
			return true;
		}
		return false;
	}

	public boolean isWeekend() {
		return isWeekend;
	}

	public double getAdditionalIsWeekend() {
		return additionalIsWeekend;
	}

	
}
