package ir.piana.boot.utils.errorprocessor.unauthorized;

import ir.piana.boot.utils.errorprocessor.ApiException;

public class AlreadyLoggedIn extends AbstractUnauthorizedException{
    public static final String code = "login.loggedIn.already";

    public AlreadyLoggedIn() {
        super(code);
    }

    public static ApiException exception = new AlreadyLoggedIn();
}
