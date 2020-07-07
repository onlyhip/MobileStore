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
@Table(name="orders")

public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String address;
	private String city;
	private String zip;
	private String status;
	private String comment;
	private String type;
	private double totalprice;
	
	@OneToMany(

			cascade = CascadeType.ALL,
			orphanRemoval = true
		    )
	@JoinColumn(name = "orderid")
	
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
	
	public String getAddress() {
		
		return address;
	}
	
	public void setAddress(String address) {
	
		this.address = address;
	}
	public String getCity() {
		
		return city;
	}
	
	public void setCity(String city) {
	
		this.city = city;
	}
	
	public String getZip() {
		
		return zip;
	}
	
	public void setZip(String zip) {
	
		this.zip = zip;
	}
	
	public String getStatus() {
		
		return status;
	}
	
	public void setStatus(String status) {
	
		this.status = status;
	}
	
	public String getComment() {
		
		return comment;
	}
	
	public void setComment(String comment) {
	
		this.comment = comment;
	}
	
	
	public String getType() {
		
		return type;
	}
	
	public void setType(String type) {
	
		this.type = type;
	}
	
	
	public double getTotalprice() {
		
		return totalprice;
	}
	
	public void setTotalprice(double totalprice) {
		
		this.totalprice = totalprice;
	}
	
}
