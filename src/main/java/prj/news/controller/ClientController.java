package prj.news.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import prj.news.dtos.LoginRequest;
import prj.news.model.Client;
import prj.news.service.ClientService;
import prj.news.service.ClientServiceImpl;

@CrossOrigin
@RestController

@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientServiceImpl clientServiceImpl;

    @PostMapping("/add")
    public String add(@RequestBody Client client) {
        clientService.saveClient(client);
        return "new is client added";
    }

    @GetMapping("/getAll")
    public List<Client> getAlClients() {
        return clientService.getAllClient();
    }

    @GetMapping("/get/{id}")
    public Client getClient(@PathVariable Long id) {
        return clientService.getClient(id);
    }

    @PutMapping("/{id}")
    public Client updatClient(@PathVariable(value = "id") Long id,
            @Validated @RequestBody Client client) {
        return clientService.updateClientById(id, client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategories(@PathVariable(value = "id") Long id) {
        return clientService.deleteClientById(id);
    }

    @PostMapping("/signin")
    public Client signin(@RequestBody @Valid LoginRequest login) {
        return clientServiceImpl.signin(login);
    }
}
