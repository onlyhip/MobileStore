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
@Table(name="groupvariants")

public class GroupVariant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private long productgroupid;
	
	@OneToMany(

			cascade = CascadeType.ALL,
			orphanRemoval = true
		    )
	@JoinColumn(name = "groupvariantid")
	
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

	public long getProductgroupid() {
		
		return productgroupid;
	}
	
	public void setProductgroupid(long productgroupid) {
	
		this.productgroupid = productgroupid;
	}
	
}
