package jpapro1.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import jpapro1.model.Leads;

/**
 * Session Bean implementation class LeadsServices
 */
@Stateless
@LocalBean
public class LeadsServices {

	/**
	 * Default constructor.
	 */
	public LeadsServices() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "jpapro1")
	EntityManager em;

	public void addLeads(Leads l) {
		em.persist(l);
	}
	
	public List<Leads> searchLeads(){
		TypedQuery<Leads> query=em.createQuery("select l from Leads l", Leads.class);
		List<Leads> allListData=query.getResultList();
		return allListData;
	}

}
