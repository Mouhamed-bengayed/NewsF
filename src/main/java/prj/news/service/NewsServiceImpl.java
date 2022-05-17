package prj.news.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import prj.news.model.Categories;
import prj.news.model.News;
import prj.news.model.Redacteur;
import prj.news.repository.CategoriesRepo;
import prj.news.repository.NewsRepo;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsRepo newsRepo;

    @Autowired
    private RedacteurService redacteurService;
    @Autowired
    private CategoriesRepo categoriesRepo;

    @Override
    public News saveNews(Long idR, News news) {
        Redacteur redacteur = redacteurService.getRedacteur(idR);
        news.setRedacteur(redacteur);
        return newsRepo.save(news);
    }

    @Override
    public List<News> getAllNews() {
        return newsRepo.findAll();
    }

    @Override
    public News getNews(Long id) {
        Optional<News> news = newsRepo.findById(id);
        if (news.isPresent()) {
            return news.get();
        }
        throw new RuntimeException("News is not found for the id " + id);
    }

    @Override
    public News updateNewsById(Long id, News newsRequ) {
        News news = getNews(id);

        news.setTitle(newsRequ.getTitle());
        news.setText(newsRequ.getText());
        news.setDate(newsRequ.getDate());

        return newsRepo.save(news);
    }

    @Override
    public ResponseEntity<?> deleteNewsById(Long id) {
        News news = getNews(id);
        newsRepo.delete(news);
        return ResponseEntity.ok().build();
    }

    public  List<News> getAllNewsByCategory(Long idCategory){
        Optional<Categories> Categories=this.categoriesRepo.findById(idCategory);
        if(Categories.isPresent()){
            return newsRepo.findAllNewsByCategories(Categories.get());
        }
        return new ArrayList<>();
    }
}
