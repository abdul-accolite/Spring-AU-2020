package tables;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;




@Entity
@DiscriminatorValue("Laptop")

public class Laptop extends Product {

	
	private String brand;
	private String processor;
	  
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	
}
