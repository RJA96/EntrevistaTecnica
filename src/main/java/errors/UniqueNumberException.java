package errors;

import javax.persistence.PersistenceException;

public class UniqueNumberException extends PersistenceException {

  public UniqueNumberException(String message) {
    super(message);
  }
}
