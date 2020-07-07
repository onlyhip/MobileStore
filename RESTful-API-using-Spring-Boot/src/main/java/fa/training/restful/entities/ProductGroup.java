package fa.training.restful.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.JoinColumn;

@Entity
@Table(name="productgroups")

public class ProductGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private double price;
	
	@OneToMany(

			cascade = CascadeType.ALL,
			orphanRemoval = true
		    )
	@JoinColumn(name = "productgroupid")
	
	private List<Product> products = new ArrayList<>();
	
	@OneToMany(

			cascade = CascadeType.ALL,
			orphanRemoval = true
		    )
	@JoinColumn(name = "productgroupid")
	
	private List<GroupVariant> groupvariants = new ArrayList<>();
	
	
	
	public long getId() {
		
		return id;
	}
	
	public void setId(long id) {
	
		this.id = id;
	}
	
	public double getPrice() {
	
		return price;
	}
	
	public void setPrice(double price) {
		
		this.price = price;
	}
	public String getName() {
		
		return name;
	}
	
	public void setName(String name) {
	
		this.name = name;
	}
	
	
}
