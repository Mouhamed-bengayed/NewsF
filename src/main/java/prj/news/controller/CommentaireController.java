package prj.news.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import prj.news.model.Commentaire;
import prj.news.service.CommentaireService;

@CrossOrigin
@RestController

@RequestMapping("/commentaire")
public class CommentaireController {

    @Autowired
    private CommentaireService commentaireService;

    @PostMapping("/add/{idC}/{idN}")
    public String add(@PathVariable(value = "id") Long idC,
            @PathVariable(value = "idN") Long idN,
            @RequestBody Commentaire commentaire) {
        commentaireService.saveCommentaire(idN, idC, commentaire);
        return "new is Commentaire added";
    }

    @GetMapping("/getAll")
    public List<Commentaire> getAllCommentaires() {
        return commentaireService.getAllCommentaires();
    }

    @GetMapping("/get/{id}")
    public Commentaire getCommentaireById(@PathVariable Long id) {
        return commentaireService.getCommentaireById(id);
    }
}
