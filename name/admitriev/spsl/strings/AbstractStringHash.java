package name.admitriev.spsl.strings;


public abstract class AbstractStringHash implements StringHash {
    @Override
    public long hashFrom(int from) {
        return hash(from, length());
    }

    @Override
    public long hash() {
        return hash(0, length());
    }

    @Override
    public long hashTo(int to) {
        return hash(0, to);
    }
}
