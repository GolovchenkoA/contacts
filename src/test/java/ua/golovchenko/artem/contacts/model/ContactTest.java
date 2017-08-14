package ua.golovchenko.artem.contacts.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContactTest {
    private static Long id;
    private static String name;

    @Before
    public void init(){
        id = 1L;
        name = "name";
    }

    @Test
    public void testCreateContactDefaultConstructor(){
        Contact contact = new Contact();
        assertEquals(null,contact.getId());
        assertEquals(null, contact.getName());
    }

    @Test
    public void testCreateContactWithParams(){
        Contact contact = new Contact(id, name);
        assertEquals(id,contact.getId());
        assertEquals(name,contact.getName());
    }

    @Test
    public void testGettersAndSetters(){
        Contact contact = new Contact();
        contact.setId(id);
        contact.setName(name);

        assertEquals(id,contact.getId());
        assertEquals(name, contact.getName());
    }



}