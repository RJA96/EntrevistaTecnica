package errors;

import javax.persistence.NoResultException;

public class NotFoundException extends NoResultException {

  public NotFoundException(String msg) {
    super(msg);
  }
}
