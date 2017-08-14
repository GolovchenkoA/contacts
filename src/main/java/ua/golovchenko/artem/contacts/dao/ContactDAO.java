package ua.golovchenko.artem.contacts.dao;

import ua.golovchenko.artem.contacts.model.Contact;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Artem on 14.08.2017.
 */
public class ContactDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Contact> searchUser(String regexp) {
/*        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Contact> query = builder.createQuery(Contact.class);
        Root root = query.from(Contact.class);

        CriteriaQuery<Contact> all = query.select(root);
        TypedQuery<Contact> allQuery = builder.createQuery(all);
        return allQuery.getResultList();*/
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Contact> cq = cb.createQuery(Contact.class);
        Root<Contact> rootEntry = cq.from(Contact.class);
        CriteriaQuery<Contact> all = cq.select(rootEntry);
        TypedQuery<Contact> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }
}
