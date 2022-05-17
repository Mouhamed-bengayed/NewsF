package prj.news.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prj.news.model.Client;
import prj.news.model.Commentaire;
import prj.news.repository.CommentaireRepo;

import prj.news.model.News;

@Service
public class CommentaireServiceImpl implements CommentaireService {

    @Autowired
    private CommentaireRepo commentaireRepo;

    @Autowired
    private NewsService newsService;

    @Autowired
    private ClientService clientService;

    @Override
    public Commentaire saveCommentaire(Long idNews, Long idClient, Commentaire commentaire) {
        News news = newsService.getNews(idNews);
        commentaire.setNews(news);
        Client client = clientService.getClient(idClient);
        commentaire.setClient(client);
        return commentaireRepo.save(commentaire);
    }

    @Override
    public Commentaire getCommentaireById(Long id) {
        Optional<Commentaire> commentaire = commentaireRepo.findById(id);
        if (commentaire.isPresent()) {
            return commentaire.get();
        }
        throw new RuntimeException("commentaire is not found for the id " + id);
    }

    @Override

    public List<Commentaire> getAllCommentaires() {

        return commentaireRepo.findAll();
    }

}
