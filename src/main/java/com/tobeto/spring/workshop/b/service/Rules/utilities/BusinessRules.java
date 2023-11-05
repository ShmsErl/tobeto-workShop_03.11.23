package  com.tobeto.spring.workshop.b.service.Rules.utilities;

import com.tobeto.spring.workshop.b.module.Category;
import com.tobeto.spring.workshop.b.repository.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@AllArgsConstructor
@Service
public class BusinessRules implements com.kodlama.io.rentAcar.business.Rules.utilities.IBrandBusinessRules {

    private CategoryRepository categoryRepository;


    @Override
    public void ifCheckCategoryId(int id) throws Exception {

        Optional<Category> result =  this.categoryRepository.getall().stream().filter(c -> c.getId() == id).findFirst();
                if(!result.isEmpty()){
                    throw new Exception("category already exists");

                }

    }

    @Override
    public void ifCheckCategoryName(String name) throws Exception {

        Optional<Category> result =  this.categoryRepository.getall().stream().filter(c -> c.getName() == name).findFirst();
        if(!result.isEmpty()){
            throw new Exception("category already exists");

        }


    }

    @Override
    public void ifCheckDeleteCategoryId(int id) throws Exception {

        Optional<Category> result =  this.categoryRepository.getall().stream().filter(c -> c.getId() == id).findFirst();
        if(result.isEmpty()){
            throw new Exception("category not found!");

        }
    }
}
