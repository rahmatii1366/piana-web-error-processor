package ir.piana.boot.utils.errorprocessor.unauthorized;

import ir.piana.boot.utils.errorprocessor.ApiException;

public final class UserNotAuthenticated extends AbstractUnauthorizedException {
    public static final String code = "user.not.authenticated";

    public UserNotAuthenticated() {
        super(code);
    }

    public static ApiException exception = new UserNotAuthenticated();
}
