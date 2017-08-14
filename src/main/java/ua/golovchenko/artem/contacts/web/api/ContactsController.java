package ua.golovchenko.artem.contacts.web.api;

import org.apache.commons.lang3.RandomStringUtils;
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
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Artem on 14.08.2017.
 */

@Controller
public class ContactsController {
    private ContactService service;

    @Autowired
    public void setService(ContactService service) {
        this.service = service;
    }

    private static Long nextId = 0L;
    private static Map<Long,Contact> contactMap ;

    static {
        contactMap = new HashMap<>();
        Contact contact1 = getNewAccount("Artem");
        contactMap.put(contact1.getId(), contact1);
        for (Long i = 2L; i < 1000; i++){
            Contact contact = getNewAccount(null);
            contactMap.put(contact.getId(),contact);
        }
    }

    @RequestMapping(value = "/hello/contacts",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Contact>> getContactWithFilter(@RequestParam(value="nameFilter") String filter){
        Collection<Contact> contacts = service.getAllExcludeRegexp(filter);
        return new ResponseEntity<Collection<Contact>>(contacts, HttpStatus.OK);
    }

    @RequestMapping(value = "/hello/contactsAll",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Contact>> getContacts(){
            //Collection<Contact> contacts = contactMap.values();
            Collection<Contact> contacts = service.getAll();
            return new ResponseEntity<Collection<Contact>>(contacts, HttpStatus.OK);
    }

    private static Contact getNewAccount(String name) {
        if(name == null)
            return new Contact(++nextId, RandomStringUtils.randomAlphanumeric(4));
        else
            return new Contact(++nextId,name);
    }

}
