package prj.news.service;

import java.util.List;

import prj.news.model.Redacteur;

public interface RedacteurService {
    public Redacteur saveRedacteur(Redacteur Redacteur);

    public List<Redacteur> getAllRedacteur();

    public Redacteur getRedacteur(Long id);

}
