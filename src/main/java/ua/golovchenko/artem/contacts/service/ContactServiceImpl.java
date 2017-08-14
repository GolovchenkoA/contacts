package ua.golovchenko.artem.contacts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.golovchenko.artem.contacts.dao.UserRepository;
import ua.golovchenko.artem.contacts.model.Contact;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Artem on 14.08.2017.
 */

@Service
public class ContactServiceImpl implements ContactService{

    private UserRepository repository;

    @Autowired
    public ContactServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Contact> getAllExcludeRegexp(String regexp) {
        return null;
    }

    @Override
    public List<Contact> getAll() {
        List<Contact> contacts = new LinkedList<>();
        repository.findAll().forEach(contacts::add);
        return contacts;
    }
}
