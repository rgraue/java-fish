package fishapp.utils;

public class UUID {
    private static final int MAX = Integer.MAX_VALUE;

    public static int getUUID () {
        return (int) (Math.random() * MAX);
    }
}
