package potato.medium.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    BAD_REQUEST(400, "잘못된 파라미터입니다."),
    UNAUTHORIZED(401, "로그인이 필요합니다."),
    FORBIDDEN(403, "권한이 없습니다."),
    NOT_FOUND(404, "페이지를 찾을 수 없습니다."),
    INTERNAL_SERVER(500, "서버 에러가 발생했습니다."),

    INVALID_TOKEN(403, "잘못된 토큰입니다."),
    EXPIRED_TOKEN(403, "만료된 토큰입니다."),

    USER_NOT_FOUND(404, "유저를 찾을 수 없습니다."),
    USER_ALREADY_REGISTERED(409, "이미 가입된 유저입니다.");

    private final int status;
    private final String message;
}
