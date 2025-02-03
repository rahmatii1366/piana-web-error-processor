package ir.piana.boot.utils.errorprocessor.unauthorized;

import ir.piana.boot.utils.errorprocessor.ApiException;
import ir.piana.boot.utils.errorprocessor.badrequest.InputNotValid;
import org.springframework.http.HttpStatus;

import java.util.Locale;

public abstract class AbstractUnauthorizedException extends ApiException {

    protected AbstractUnauthorizedException(String code, Object... params) {
        this(code, Locale.getDefault(), params);
    }

    protected AbstractUnauthorizedException(String code, Locale locale, Object... params) {
        super(code, locale, params);
    }

    @Override
    public final HttpStatus getStatus() {
        return HttpStatus.UNAUTHORIZED;
    }

    //region exception errors instances
    /*public static AlreadyLoggedIn alreadyLoggedIn = new AlreadyLoggedIn();
    public static ChannelUnknown channelUnknown = new ChannelUnknown();
    public static MaximumNumberOfFailedCredential maximumNumberOfFailedCredential = new MaximumNumberOfFailedCredential();
    public static MaximumNumberOfLoginInHourExceeded maximumNumberOfLoginInHourExceeded = new MaximumNumberOfLoginInHourExceeded();
    public static NewPasswordIsEqualToOldPassword newPasswordIsEqualToOldPassword = new NewPasswordIsEqualToOldPassword();
    public static UsernameOrPasswordIsIncorrect usernameOrPasswordIsIncorrect = new UsernameOrPasswordIsIncorrect();
    public static UserNotAuthenticated userNotAuthenticated = new UserNotAuthenticated();*/
    //endregion
}
