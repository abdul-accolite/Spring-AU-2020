package tables;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("speaker")
public class Speaker extends Product{
	private String brand;
	private boolean waterProof;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public boolean isWaterProof() {
		return waterProof;
	}
	public void setWaterProof(boolean waterProof) {
		this.waterProof = waterProof;
	}

}
