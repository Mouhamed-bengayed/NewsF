package prj.news.service;

import java.util.List;

import prj.news.model.Commentaire;

public interface CommentaireService {

    public Commentaire saveCommentaire(Long idNews, Long idClient, Commentaire commentaire);

    public Commentaire getCommentaireById(Long id);

    public List<Commentaire> getAllCommentaires();

}
