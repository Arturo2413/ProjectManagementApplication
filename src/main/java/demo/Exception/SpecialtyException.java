package demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by poo2 on 06/07/2015.
 */
@ResponseStatus( value = HttpStatus.NOT_FOUND)
public class SpecialtyException extends RuntimeException {

    public SpecialtyException(Long id) {
        super("Specialty con id: " + id + " no existe");
    }

}
