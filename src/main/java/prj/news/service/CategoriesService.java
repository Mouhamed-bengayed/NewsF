package prj.news.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import prj.news.model.Categories;

public interface CategoriesService {
    public Categories saveCategories(Categories categories);

    public List<Categories> getAllCategories();

    public Categories getCategories(Long id);

    public Categories upCategories(Long id, Categories categories);

    public ResponseEntity<?> deleteCategoriesById(Long id);

    public Categories updateCategoriesById(Long id, Categories categories);
}
