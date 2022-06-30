package pl.jkanclerz.crm;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {
    @Id
    String id;
    String email;

    String inquiry;

    Client() { }

    Client(String email) {
        this.email = email;
    }

    Client(String id, String email) {
        this.id = id;
        this.email = email;
    }

    Client(String id, String email, String inquiry) {
        this.id = id;
        this.email = email;
        this.inquiry = inquiry;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getInquiry() {
        return inquiry;
    }
}
