package pl.jkanclerz.crm;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CrmController {
     ClientRepository clientRepository;

    public CrmController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @CrossOrigin
    @PostMapping("/api/clients")
    void addClient(@RequestBody Client client) {
        client.id = UUID.randomUUID().toString();
        clientRepository.save(client);
    }

    @CrossOrigin
    @GetMapping("/api/clients/{id}")
    Client getClient(@PathVariable String id) {
        return clientRepository.findById(id).get();
    }

    @CrossOrigin
    @GetMapping("/api/clients")
    List<Client> allClient() {
        return clientRepository.findAll();
    }

    @CrossOrigin
    @DeleteMapping("/api/clients/{id}")
    void deleteClient(@PathVariable String id) {
        clientRepository.deleteById(id);
    }
}
