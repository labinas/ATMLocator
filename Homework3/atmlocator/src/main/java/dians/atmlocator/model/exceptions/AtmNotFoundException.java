package dians.atmlocator.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AtmNotFoundException extends RuntimeException{
    public AtmNotFoundException(Long id) {
        super(String.format("Atm with %d id is not found!", id));
    }
}
