/*
 * validar la matrícula
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
 * @author amondelo
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MatriculaValidator.class)
public @interface Matricula {
    String message() default "{comprobarMatricula}";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default{};
    
}
