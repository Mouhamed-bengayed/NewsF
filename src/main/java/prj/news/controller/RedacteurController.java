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

import prj.news.model.Redacteur;
import prj.news.service.RedacteurService;

@RestController
@CrossOrigin
@RequestMapping("/redacteur")
public class RedacteurController {
    @Autowired
    private RedacteurService RedacteurService;

    @PostMapping("/add")
    public String add(@RequestBody Redacteur Redacteur) {
        RedacteurService.saveRedacteur(Redacteur);
        return "new is Redacteurrrrr added";
    }

    @GetMapping("/getAll")
    public List<Redacteur> getAlRedacteurs() {
        return RedacteurService.getAllRedacteur();
    }

    @GetMapping("/get/{id}")
    public Redacteur getRedacteur(@PathVariable Long id) {
        return RedacteurService.getRedacteur(id);
    }
}
