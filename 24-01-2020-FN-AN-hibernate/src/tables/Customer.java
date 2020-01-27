package tables;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {

	@Id
    @Column(name = "custId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String mobile;
    @Embedded
    @AttributeOverrides({
    	@AttributeOverride(name = "number", column = @Column(name = "home_number")),
    	@AttributeOverride(name="street", column=@Column(name="home_street")),
    	@AttributeOverride(name="area", column=@Column(name="home_area")),
    	@AttributeOverride(name="city", column=@Column(name="home_city"))
})
    private Address homeAddress;
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "number", column = @Column(name = "shipping_number")),
        @AttributeOverride(name = "street", column = @Column(name = "shipping_street")),
        @AttributeOverride(name = "area", column = @Column(name = "shipping_area")),
        @AttributeOverride(name = "city", column = @Column(name = "shipping_city"))
})
    private Address officeAddress;
    public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	@OneToMany
    @JoinTable(name = "customerProducts", joinColumns = @JoinColumn(name = "custId"), inverseJoinColumns = @JoinColumn(name = "productId"))
    private List<Product> ordersList;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartId")
    private Cart cart;
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
    
    
}
