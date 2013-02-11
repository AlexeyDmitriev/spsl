package strings;

public interface StringHash {
    public long hash();

    public long hash(int from, int to);

    public long hashFrom(int from);

    public long hashTo(int to);

    public int length();

}
