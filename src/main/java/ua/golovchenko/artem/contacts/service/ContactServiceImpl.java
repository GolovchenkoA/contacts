package ua.golovchenko.artem.contacts.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.golovchenko.artem.contacts.dao.UserRepository;
import ua.golovchenko.artem.contacts.model.Contact;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by Artem on 14.08.2017.
 */

@Service
public class ContactServiceImpl implements ContactService{
    private static final Logger logger = LoggerFactory.getLogger(ContactServiceImpl.class);
    private UserRepository repository;

    @Autowired
    public ContactServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Contact> getByRegexp(String regexp, Boolean match) {
        logger.debug("Method call getByRegexp({},{})", regexp, match);
        Pattern pattern = Pattern.compile(regexp);
        List<Contact> all = getAll();
        List<Contact> result = new LinkedList<>();

        if(match == true){
            result =  matcher(all,pattern);
        } else if (match == false) {
            List<Contact> matching = matcher(all, pattern);
            all.removeAll(matching);
            result = all;
        }
        return result;
    }

    private List<Contact> matcher(List<Contact> all, Pattern pattern) {
        return all.stream().filter(row -> pattern.matcher(row.toString()).matches()).collect(Collectors.toList());
    }

    @Override
    public List<Contact> getAll() {
        List<Contact> contacts = new LinkedList<>();
        repository.findAll().forEach(contacts::add);
        return contacts;
    }

}
