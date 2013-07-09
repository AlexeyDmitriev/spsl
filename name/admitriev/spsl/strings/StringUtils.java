package name.admitriev.spsl.strings;

public class StringUtils {
    public static String join(String delimiter, Object[] array) {
        StringBuilder buffer = new StringBuilder();
        for (Object object : array) {
            buffer.append(delimiter).append(object);
        }
        return buffer.substring(delimiter.length());
    }

    public static String join(char delimiter, Object[] array) {
        return join(String.valueOf(delimiter), array);
    }

    public static String join(Object[] array) {
        return join("", array);
    }

	public static String reverse(String s) {
		StringBuilder sb = new StringBuilder();

		for(int i = s.length() - 1; i >= 0; --i)
			sb.append(s.charAt(i));

		return sb.toString();
	}

}
