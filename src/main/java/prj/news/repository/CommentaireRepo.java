package prj.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import prj.news.model.Commentaire;

public interface CommentaireRepo extends JpaRepository<Commentaire, Long> {

}
