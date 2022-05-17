package prj.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import prj.news.model.Categories;

public interface CategoriesRepo extends JpaRepository<Categories, Long> {

}
