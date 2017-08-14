package ua.golovchenko.artem.contacts.service;

import ua.golovchenko.artem.contacts.model.Contact;
import java.util.List;

/**
 * Created by Artem on 14.08.2017.
 */
public interface ContactService {
    List<Contact> getAllExcludeRegexp(String regexp);
    List<Contact> getAll();
}
