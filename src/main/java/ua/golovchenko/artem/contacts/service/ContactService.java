package ua.golovchenko.artem.contacts.service;

import ua.golovchenko.artem.contacts.model.Contact;
import java.util.List;

/**
 * Created by Artem on 14.08.2017.
 *
 * @author Artem Golovchenko
 */
public interface ContactService {
    List<Contact> getByRegexp(String regexp, Boolean match);
    List<Contact> getAll();
}
