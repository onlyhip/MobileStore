package fa.training.restful.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orderitems")

public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private double price;
	private long orderid;
	private long productid;
	private long groupvariantid;
	
	
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
	
	public long getOrderid() {
		
		return orderid;
	}
	
	public void setOrderid(long orderid) {
	
		this.orderid = orderid;
	}
	
	public long getProductid() {
		
		return productid;
	}
	
	public void setProductid(long productid) {
	
		this.productid = productid;
	}

	public long getGroupVariantId() {
		
		return groupvariantid;
	}
	
	public void setGroupVariantId(long groupvariantid) {
	
		this.groupvariantid = groupvariantid;
	}
}
