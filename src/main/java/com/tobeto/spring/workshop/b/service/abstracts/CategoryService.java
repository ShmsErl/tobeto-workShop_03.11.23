package com.tobeto.spring.workshop.b.service.abstracts;

import com.tobeto.spring.workshop.b.module.Category;
import java.util.List;

public interface CategoryService {
    String add(Category category) throws Exception;

    List<Category> getall();

    String delete(int id) throws Exception;

    String updateCategory(int id, Category updatedCategory);

    Category getById(int id);
}
