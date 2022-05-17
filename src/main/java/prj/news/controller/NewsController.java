package prj.news.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prj.news.model.News;
import prj.news.service.NewsService;
import prj.news.service.NewsServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @Autowired
    NewsServiceImpl newsServiceImpl;

    @PostMapping("/add/{idR}")
    public String add(@PathVariable(value = "idR") Long idN, @RequestBody News news) {
        newsService.saveNews(idN, news);
        return "new is news added";
    }

    @GetMapping("/getAll")
    public List<News> getAlNews() {
        return newsService.getAllNews();
    }

    @GetMapping("/get/{id}")
    public News getNews(@PathVariable Long id) {
        return newsService.getNews(id);
    }

    @PutMapping("/update/{id}")
    public News updatePatient(@PathVariable(value = "id") Long idN,
            @Validated @RequestBody News news) {
        return newsService.updateNewsById(idN, news);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNews(@PathVariable(value = "id") Long id) {
        return newsService.deleteNewsById(id);
    }

    @GetMapping("/get-news-by-category/{idCategory}")
    public List<News> getNewsByCategory(@PathVariable("idCategory") Long idCategory) {
        return newsServiceImpl.getAllNewsByCategory(idCategory);
    }
}
