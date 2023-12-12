package potato.medium.global.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MediumException.class)
    public ResponseEntity<ErrorResponse> handleGlobal(MediumException e) {
        final ErrorCode errorCode = e.getErrorCode();

        ErrorResponse errorResponse = new ErrorResponse(errorCode.getSTATUS(), e.getMessage());
        log.error(
                errorResponse.toString()
        );

        return new ResponseEntity<>(
                errorResponse,
                HttpStatus.valueOf(errorCode.getSTATUS())
        );
    }
}
