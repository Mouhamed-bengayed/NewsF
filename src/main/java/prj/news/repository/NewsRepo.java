package prj.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prj.news.model.Categories;
import prj.news.model.News;

import java.util.List;

@Repository
public interface NewsRepo extends JpaRepository<News, Long> {
     List<News> findAllNewsByCategories(Categories categories) ;
}
