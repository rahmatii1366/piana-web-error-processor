package ir.piana.boot.utils.errorprocessor.unauthorized;

import ir.piana.boot.utils.errorprocessor.ApiException;

public class UsernameOrPasswordIsIncorrect extends AbstractUnauthorizedException {
    public static final String code = "usernameOrPassword.incorrect";

    public UsernameOrPasswordIsIncorrect() {
        super(code);
    }

    public static ApiException exception = new UsernameOrPasswordIsIncorrect();
}
