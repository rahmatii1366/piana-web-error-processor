package ir.piana.boot.utils.errorprocessor.unauthorized;

public class NewPasswordIsEqualToOldPassword extends AbstractUnauthorizedException {
    public static final String code = "newPassword.isEqualTo.oldPassword";

    public NewPasswordIsEqualToOldPassword() {
        super(code);
    }

    public NewPasswordIsEqualToOldPassword(Throwable throwable) {
        super(throwable, code);
    }

    public static void throwsException() {
        throw new NewPasswordIsEqualToOldPassword();
    }

    public static void throwsException(Throwable throwable) {
        throw new NewPasswordIsEqualToOldPassword(throwable);
    }
}
