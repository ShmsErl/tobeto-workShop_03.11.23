package com.kodlama.io.rentAcar.business.Rules.utilities;

public interface IBrandBusinessRules {

    void ifCheckCategoryId(int id) throws Exception;
    void ifCheckCategoryName(String name) throws Exception;
}
