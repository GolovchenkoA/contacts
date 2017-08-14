package ua.golovchenko.artem.contacts.web.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.golovchenko.artem.contacts.model.Contact;
import ua.golovchenko.artem.contacts.service.ContactService;

import java.util.Collection;

/**
 * Created by Artem on 14.08.2017.
 */

@Controller
public class ContactsController {
    private static final Logger logger = LoggerFactory.getLogger(ContactsController.class);
    private ContactService service;

    @Autowired
    public void setService(ContactService service) {
        this.service = service;
    }

    @RequestMapping(value = "/hello/contacts",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Contact>> getContactWithFilter(@RequestParam(value="nameFilter") String filter){
        Boolean filterMatcher = false;
        logger.debug("request param. nameFilter : {}, FilterMatcher: {}", filter, filterMatcher);
        Collection<Contact> contacts = service.getByRegexp(filter, filterMatcher);
        return new ResponseEntity<Collection<Contact>>(contacts, HttpStatus.OK);
    }

    @RequestMapping(value = "/hello/contactsAll",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Contact>> getContacts(){
            Collection<Contact> contacts = service.getAll();
            return new ResponseEntity<Collection<Contact>>(contacts, HttpStatus.OK);
    }
}
