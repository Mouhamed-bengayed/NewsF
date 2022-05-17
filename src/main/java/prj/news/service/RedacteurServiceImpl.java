package prj.news.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prj.news.model.Redacteur;
import prj.news.repository.RedacteurRepo;

@Service
public class RedacteurServiceImpl implements RedacteurService {

    @Autowired
    private RedacteurRepo RedacteurRepo;

    @Override
    public Redacteur saveRedacteur(Redacteur Redacteur) {

        return RedacteurRepo.save(Redacteur);
    }

    @Override
    public List<Redacteur> getAllRedacteur() {
        return RedacteurRepo.findAll();
    }

    @Override
    public Redacteur getRedacteur(Long id) {
        Optional<Redacteur> Redacteur = RedacteurRepo.findById(id);
        if (Redacteur.isPresent()) {
            return Redacteur.get();
        }
        throw new RuntimeException("Redacteur is not found for the id " + id);
    }
}
