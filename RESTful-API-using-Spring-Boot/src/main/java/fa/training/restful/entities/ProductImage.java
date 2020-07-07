package fa.training.restful.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productimages")

public class ProductImage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String path;
	private long productid;
	
	public long getId() {
		
		return id;
	}
	
	public void setId(long id) {
	
		this.id = id;
	}
	
	public String getPath() {
	
		return path;
	}
	
	public void setPath(String path) {
	
		this.path = path;
	}
	
	public long getProductid() {
		
		return productid;
	}
	
	public void setProductid(long productid) {
	
		this.productid = productid;
	}
	
}
