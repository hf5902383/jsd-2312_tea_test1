package fanghou.email.admin.content.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;

import javax.validation.Validation;

public class ValidationConfiguration {
    @Bean
    public javax.validation.Validator validator(){
        return Validation.byProvider(HibernateValidator.class)
                .configure()
                .failFast(true)
                .buildValidatorFactory()
                .getValidator();
    }
}
