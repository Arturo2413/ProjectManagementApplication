package demo.Exception;

/**
 * Created by poo2 on 06/07/2015.
 */
public class ReviewDeveloperProjectException extends RuntimeException {
    public ReviewDeveloperProjectException(Long idProject, Long idDeveloper) {
        super("El developer con la id: " + idDeveloper + "no esta vinculado al project con id : " + idProject);
    }
}
