package prj.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import prj.news.model.Redacteur;

public interface RedacteurRepo extends JpaRepository<Redacteur, Long> {

}
