package potato.medium.global.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MediumException.class)
    public ResponseEntity<ErrorResponse> handleGlobal(MediumException e) {
        final ErrorCode errorCode = e.getErrorCode();

        ErrorResponse errorResponse = new ErrorResponse(errorCode.getStatus(), e.getMessage());
        log.error(
                errorResponse.toString()
        );

        return ResponseEntity
                .status(e.getErrorCode().getStatus())
                .body(
                        new ErrorResponse(
                                errorCode.getStatus(),
                                errorCode.getMessage()
                        )
                );
    }
}
