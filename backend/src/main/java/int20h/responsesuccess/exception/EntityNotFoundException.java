package int20h.responsesuccess.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException() {
        super("Entity not found");
    }

    public EntityNotFoundException(String entity) {
        super(String.format("%s not found", entity));
    }

    public EntityNotFoundException(String entity, String id) {
        super(String.format("%s with id: %s not found", entity, id));
    }
}
