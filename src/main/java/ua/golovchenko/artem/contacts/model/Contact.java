package ua.golovchenko.artem.contacts.model;

/**
 * Created by Artem on 14.08.2017.
 */
public class Contact {
    Long id;
    String name;

    public Contact(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
