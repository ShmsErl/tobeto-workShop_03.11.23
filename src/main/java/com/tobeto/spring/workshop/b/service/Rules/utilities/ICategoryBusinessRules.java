package   com.tobeto.spring.workshop.b.service.Rules.utilities;

public interface ICategoryBusinessRules {

    void ifCheckCategoryId(int id) throws Exception;
    void ifCheckCategoryName(String name) throws Exception;

    void ifCheckDeleteCategoryId(int id) throws Exception;
}
