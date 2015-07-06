package demo.Exception;

/**
 * Created by poo2 on 06/07/2015.
 */
public class ReviewProjectSpecialtyException extends RuntimeException {
    public ReviewProjectSpecialtyException(Long idProject, Long idSpecialty) {
        super("La Specialty con id: " + idSpecialty + "no esta vinculado al project con id : " + idProject);

    }
}
