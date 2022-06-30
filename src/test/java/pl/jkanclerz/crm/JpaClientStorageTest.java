package pl.jkanclerz.crm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JpaClientStorageTest {

    @Autowired
    ClientRepository repository;

    @Test
    void itCreatesNewStorage() {
        JpaClientStorage storage = new JpaClientStorage(repository);

        assertEquals(JpaClientStorage.class, storage.getClass());
    }

    @Test
    void itSavesClient() {
        JpaClientStorage storage = new JpaClientStorage(repository);

        storage.save(new Client("123", "email@domain.com"));

        assertEquals(1, storage.count());
    }

    @Test
    void itSavesAndLoadsMultipleClients() {
        JpaClientStorage storage = new JpaClientStorage(repository);

        storage.save(new Client("569", "john@site.com"));
        storage.save(new Client("304", "amelia@site2.pl"));

        List<Client> clients = storage.findAll();

        assertEquals(2, clients.toArray().length);
    }

    @Test
    void itDeletesSpecifiedClient() {
        JpaClientStorage storage = new JpaClientStorage(repository);

        storage.save(new Client("123", "email@domain.com"));
        storage.deleteById("123");

        assertEquals(0, storage.count());
    }
}