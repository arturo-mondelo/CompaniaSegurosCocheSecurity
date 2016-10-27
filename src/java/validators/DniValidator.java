/*
 *validar el dni introducido cumple un minimo...
 */
package validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author amondelo
 */
public class DniValidator implements ConstraintValidator<Dni,String>{

    @Override
    public void initialize(Dni constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
//        if(value.isEmpty())
//            return true;
        if(value.matches("[0-9]{8}[a-z A-Z]"))
            return true;
        return false;
    }
    
}
