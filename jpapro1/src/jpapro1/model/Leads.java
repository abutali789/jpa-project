package jpapro1.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Leads
 *
 */
@NamedQuery(name="Leads.findById", query="select f from Leads f where f.id=:id")
@Entity

public class Leads implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	public Leads() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;

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

}
