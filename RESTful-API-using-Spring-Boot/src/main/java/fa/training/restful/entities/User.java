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
@Table(name="users")

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String username;
	private String password;
	
	@OneToMany(

			cascade = CascadeType.ALL,
			orphanRemoval = true
		    )
	@JoinColumn(name = "usersid")
	private List<Product> products = new ArrayList<>();
	
	public long getId() {
	
		return id;
	}
	
	public void setId(long id) {
	
		this.id = id;
	}
	
	public String getUsername() {
	
		return username;
	}
	
	public void setUsername(String username) {
	
		this.username = username;
	}
	
	public String getPassword() {
	
		return password;
	}
	
	public void setPassword(String password) {
	
		this.password = password;
	}
	
}
