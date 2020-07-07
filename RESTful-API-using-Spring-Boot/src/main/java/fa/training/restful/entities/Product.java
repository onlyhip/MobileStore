package fa.training.restful.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="products")

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private double price;
	private String description;
	private long productgroupid;
	private long usersid;
	
	@OneToMany(

			cascade = CascadeType.ALL,
			orphanRemoval = true
		    )
	@JoinColumn(name = "productid")
	
	private List<ProductImage> productimages = new ArrayList<>();

	@OneToMany(

			cascade = CascadeType.ALL,
			orphanRemoval = true
		    )
	@JoinColumn(name = "productid")
	
	private List<OrderItem> orderitems = new ArrayList<>();
	
	
	public long getId() {
	
		return id;
	}
	
	public void setId(long id) {
	
		this.id = id;
	}
	
	public String getName() {
	
		return name;
	}
	
	public void setName(String name) {
	
		this.name = name;
	}
	
	public double getPrice() {
	
		return price;
	}
	
	public void setPrice(double price) {
	
		this.price = price;
	}
	
	public String getDescription() {
		
		return description;
	}
	
	public void setDescription(String description) {
	
		this.description = description;
	}
	
	public long getProductgroupid() {
		
		return productgroupid;
	}
	
	public void setProductgroupid(long productgroupid) {
	
		this.productgroupid = productgroupid;
	}
	
	public long getUsersid() {
		
		return usersid;
	}
	
	public void setUsersid(long usersid) {
	
		this.usersid = usersid;
	}
	
	
	
	
}
