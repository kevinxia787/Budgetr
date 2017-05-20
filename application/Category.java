package application;

import javafx.beans.property.SimpleStringProperty;

public class Category {
	private final SimpleStringProperty category;
	private double percent;
	private double spending;
	
	public Category (String category, double percent, double spending){
		this.category = new SimpleStringProperty(category);
		this.percent = percent;
		this.spending = spending;
	}
	
	public String getCategory() {
		return category.get();
	}
	
	public void setCategory(String category) {
		this.category.set(category);
	}
	
	public double getPercent() {
		return percent;
	}
	
	public void setPercent(Double percent) {
		this.percent = percent;
	}
	
	public double getSpending() {
		return spending;
	}
	
	public void setSpending(Double spending) {
		this.spending = spending;
	}
	
}
