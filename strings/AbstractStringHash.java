package strings;

/**
 * Created with IntelliJ IDEA.
 * User: riad
 */
public abstract class AbstractStringHash implements StringHash {
    @Override
    public long hashFrom(int from) {
        return hash(from, length() - 1);
    }

    @Override
    public long hash() {
        return hash(0, length() - 1);
    }

    @Override
    public long hashTo(int to) {
        return hash(0, to);
    }
}
