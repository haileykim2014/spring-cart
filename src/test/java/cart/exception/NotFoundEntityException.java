package cart.exception;

public class NotFoundEntityException extends Throwable {
  public NotFoundEntityException(String entity) {
    super("해당 " + entity + "을(를) 찾을 수 없습니다.");
  }
}
