package potato.medium.global.error.exception;

import lombok.Getter;
@Getter
public class MediumException extends RuntimeException {
    private final ErrorCode errorCode;

    public MediumException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
