package strings;

/**
 * Created with IntelliJ IDEA.
 * User: riad
 */
public class StringUtils {
    public static String join(String delimiter, Object[] array) {
        StringBuilder buffer = new StringBuilder();
        for (Object object : array) {
            buffer.append(delimiter).append(object);
        }
        return buffer.substring(delimiter.length());
    }

    public static String join(char delimiter, String[] array) {
        return join(String.valueOf(delimiter), array);
    }

    public static String join(String[] array) {
        return join("", array);
    }

}
