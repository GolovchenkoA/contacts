package ua.golovchenko.artem.contacts.dao;

import ua.golovchenko.artem.contacts.model.Contact;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Artem on 14.08.2017.
 */
public interface UserRepository extends CrudRepository<Contact,Long> {
}
