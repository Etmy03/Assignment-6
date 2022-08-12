
public class Smoothie extends Beverage{
	
	private int numOfFruits;
	private boolean addProtien;
	final private double additionalFruits = 0.50;
	final private double additionalPowder = 1.50;
	
	public Smoothie(String name, SIZE size, int numOfFruits, boolean addPRotien) {
		super(name, TYPE.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.addProtien = addPRotien;
	}
	public Smoothie(Smoothie smoothie) {
		super(smoothie.getBevName(), TYPE.SMOOTHIE, smoothie.getSize());
		this.numOfFruits = smoothie.getNumOfFruits();
		this.addProtien = smoothie.getAddProtein();
	}
	
	@Override
	public double calcPrice() {
		double price = super.getBasePrice();
		if(addProtien == true) {
			price += additionalPowder;
		}
		if(numOfFruits > 0) {
			price += (additionalFruits*numOfFruits);
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
		return "Smoothie [numOfFruits=" + numOfFruits + ", addProtien=" + addProtien + ", calcPrice()=" + calcPrice()
				+ ", getBevName()=" + getBevName() + ", getSize()=" + getSize() + "]";
	}
	public boolean equals(Smoothie smoothie) {
		if(((super.getBevName()).equals(smoothie.getBevName())) && 
		   ((super.getType()).equals(smoothie.getType())) && 
		   ((super.getSize()).equals(smoothie.getSize())) &&
		   (numOfFruits == smoothie.getNumOfFruits()) &&
		   (addProtien == smoothie.getAddProtein())) {
			return true;
		}
		return false;
	}



	public int getNumOfFruits() {
		return numOfFruits;
	}

	public boolean getAddProtein() {
		return addProtien;
	}

	public void setNumOfFruits(int numOfFruits) {
		this.numOfFruits = numOfFruits;
	}

	public void setProteinPowder(boolean addPRotien) {
		this.addProtien = addPRotien;
	}
	

}
