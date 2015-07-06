package demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by poo2 on 06/07/2015.
 */

@ResponseStatus( value = HttpStatus.NOT_FOUND)
public class ReviewException extends RuntimeException {
    public ReviewException(Long id) {
        super("Review con id: " + id + " no existe");
    }
}
