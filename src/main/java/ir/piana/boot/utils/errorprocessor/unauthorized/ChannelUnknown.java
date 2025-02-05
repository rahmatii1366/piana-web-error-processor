package ir.piana.boot.utils.errorprocessor.unauthorized;

public class ChannelUnknown extends AbstractUnauthorizedException{
    public static final String code = "channel.unknown";

    public ChannelUnknown() {
        super(code);
    }

    public ChannelUnknown(Throwable throwable) {
        super(throwable, code);
    }

    public static void throwsException() {
        throw new ChannelUnknown();
    }

    public static void throwsException(Throwable throwable) {
        throw new ChannelUnknown(throwable);
    }
}
