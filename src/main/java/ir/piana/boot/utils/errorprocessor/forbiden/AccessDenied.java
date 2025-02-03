package ir.piana.boot.utils.errorprocessor.forbiden;

import ir.piana.boot.utils.errorprocessor.ApiException;

public class AccessDenied extends AbstractForbiddenException {
    public static final String code = "access.denied";

    public AccessDenied() {
        super(code);
    }

    public static ApiException exception = new AccessDenied();
}
