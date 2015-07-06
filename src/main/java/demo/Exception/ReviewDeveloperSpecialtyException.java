package demo.Exception;

/**
 * Created by poo2 on 06/07/2015.
 */
public class ReviewDeveloperSpecialtyException extends RuntimeException {
    public ReviewDeveloperSpecialtyException(Long idDeveloper, Long idSpecialty) {
        super("El developer con id: " + idDeveloper + " no esta vinculado a la Specialty con id : " + idSpecialty);
    }
}
