package prj.news.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import prj.news.dtos.LoginRequest;
import prj.news.model.Client;

public interface ClientService {

    public Client saveClient(Client client);

    public List<Client> getAllClient();

    public Client getClient(Long id);

    public Client signupClient(Client client);

    public Client updateClientById(Long id, Client client);

    public ResponseEntity<?> deleteClientById(Long id);


}
