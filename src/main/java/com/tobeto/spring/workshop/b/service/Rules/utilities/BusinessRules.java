package  com.tobeto.spring.workshop.b.service.Rules.utilities;

import com.tobeto.spring.workshop.b.repository.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class BusinessRules implements com.kodlama.io.rentAcar.business.Rules.utilities.IBrandBusinessRules {

    private CategoryRepository categoryRepository;


    @Override
    public void ifCheckCategoryId(int id) throws Exception {

    }

    @Override
    public void ifCheckCategoryName(String name) throws Exception {

    }
}
