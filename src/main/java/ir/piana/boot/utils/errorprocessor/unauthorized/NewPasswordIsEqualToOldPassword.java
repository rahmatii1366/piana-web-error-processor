package ir.piana.boot.utils.errorprocessor.unauthorized;

import ir.piana.boot.utils.errorprocessor.ApiException;

public class NewPasswordIsEqualToOldPassword extends AbstractUnauthorizedException{
    public static final String code = "newPassword.isEqualTo.oldPassword";

    public NewPasswordIsEqualToOldPassword() {
        super(code);
    }

    public static ApiException exception = new NewPasswordIsEqualToOldPassword();
}
