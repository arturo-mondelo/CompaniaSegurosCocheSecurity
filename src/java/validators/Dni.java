/*
 * validar matrícula
 */
package validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author aamondelo
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DniValidator.class)
public @interface Dni {
     String message() default "{comprobarErrorDni}";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default{};
    
}
