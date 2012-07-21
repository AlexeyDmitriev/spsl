package strings;

/**
 * Created with IntelliJ IDEA.
 * User: riad
 */
public class SubstringHash extends AbstractStringHash {
    int from, to;
    StringHash fullHash;

    public SubstringHash(StringHash fullHash, int from, int to) {
        this.fullHash = fullHash;
        this.from = from;
        this.to = to;
    }

    @Override
    public long hash() {
        return fullHash.hash(from, to);
    }

    @Override
    public long hash(int from, int to) {
        return fullHash.hash(this.from + from, this.from + to);
    }

    @Override
    public int length() {
        return to - from + 1;
    }
}
