package prj.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prj.news.model.Client;

import java.util.Optional;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {




    Optional<Client> findByEmailAndPassword(String email, String password);
}
