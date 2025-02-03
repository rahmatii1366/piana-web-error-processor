package ir.piana.boot.utils.errorprocessor.unauthorized;

import ir.piana.boot.utils.errorprocessor.ApiException;

public class ChannelUnknown extends AbstractUnauthorizedException{
    public static final String code = "channel.unknown";

    public ChannelUnknown() {
        super(code);
    }

    public static ApiException exception = new ChannelUnknown();
}
