package prj.news.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import prj.news.model.News;

public interface NewsService {

    public News saveNews(Long idR, News news);

    public List<News> getAllNews();

    public News getNews(Long id);

    public News updateNewsById(Long id, News news);

    public ResponseEntity<?> deleteNewsById(Long id);

}
