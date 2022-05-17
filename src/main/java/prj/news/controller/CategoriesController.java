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

import prj.news.model.Categories;
import prj.news.service.CategoriesService;

@RestController
@CrossOrigin
@RequestMapping("/categories")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;

    @PostMapping("/add")
    public String add(@RequestBody Categories categories) {
        categoriesService.saveCategories(categories);
        return "new is Categories added";
    }

    @GetMapping("/getAll")
    public List<Categories> getAlCategories() {
        return categoriesService.getAllCategories();
    }

    @GetMapping("/get/{id}")
    public Categories getCategories(@PathVariable Long id) {
        return categoriesService.getCategories(id);
    }

    @PutMapping("/{id}")
    public Categories updateCategories(@PathVariable(value = "id") Long id,
            @Validated @RequestBody Categories categories) {
        return categoriesService.updateCategoriesById(id, categories);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategories(@PathVariable(value = "id") Long id) {
        return categoriesService.deleteCategoriesById(id);
    }
}
