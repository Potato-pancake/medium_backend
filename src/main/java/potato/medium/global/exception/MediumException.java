package potato.medium.global.exception;

import lombok.Getter;

@Getter
public class MediumException extends RuntimeException {
    private final ErrorCode errorCode;
    private final String message;

    public MediumException(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
