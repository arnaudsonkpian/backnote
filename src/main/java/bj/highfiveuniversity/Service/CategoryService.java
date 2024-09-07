package bj.highfiveuniversity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bj.highfiveuniversity.backnote.Models.Category;
import bj.highfiveuniversity.backnote.Repository.CategoryRepository;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll(); 
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category); 
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id); 
    }
}