package potato.medium.global.error.exception;

import potato.medium.global.error.ErrorCode;
import potato.medium.global.error.MediumException;

public class UserNotFoundException extends MediumException {

    public static final MediumException EXCEPTION = new UserNotFoundException();

    public static final MediumException EXCEPTION() {
        return new UserNotFoundException();
    }

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
