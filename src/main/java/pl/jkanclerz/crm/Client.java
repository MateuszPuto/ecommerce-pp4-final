package pl.jkanclerz.crm;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {
    @Id
    String id;
    String email;

    Client() { }

    Client(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
