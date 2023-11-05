package com.tobeto.spring.workshop.b.service.concretes;

import com.tobeto.spring.workshop.b.module.Category;
import com.tobeto.spring.workshop.b.repository.abstracts.CategoryRepository;
import com.tobeto.spring.workshop.b.service.Rules.utilities.BusinessRules;
import com.tobeto.spring.workshop.b.service.abstracts.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryManager implements CategoryService {
   public  final CategoryRepository categories;
   public final BusinessRules businessRules;

    @Autowired
    public CategoryManager(CategoryRepository categoryRepository,BusinessRules  businessRules) {
        this.categories = categoryRepository;
        this.businessRules = businessRules;
    }

    @Override
    public List<Category> getall() {
        return categories.getall();
    }

    @Override
    public Category getById(int id) {
        return categories.getById(id);
    }

    @Override
    public String add(Category category) throws Exception {
        businessRules.ifCheckCategoryId(category.getId());
        businessRules.ifCheckCategoryName(category.getName());
        return categories.add(category);
    }

    @Override
    public String delete(int id) throws Exception {
        this.businessRules.ifCheckDeleteCategoryId(id);
        return categories.delete(id);
    }

    @Override
    public String updateCategory(int id, Category updatedCategory) {
        return categories.updateCategory(id, updatedCategory);
    }
}
