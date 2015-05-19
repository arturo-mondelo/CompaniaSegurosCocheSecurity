/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author admin1
 */
public class MatriculaValidator implements ConstraintValidator<Matricula,String>{
     @Override
    public void initialize(Matricula constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
//        if(value.isEmpty())
//            return true;
        if(value.matches("[0-9]{4}[a-z A-Z]{3}"))
            return true;
        return false;
    }
}
