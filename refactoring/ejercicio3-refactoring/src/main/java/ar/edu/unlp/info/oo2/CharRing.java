package ar.edu.unlp.info.oo2;

public class CharRing extends AbstractRing {
    private char[] source;

    public CharRing(String src) {
        super();
        source = src.toCharArray();
    }

    public char next() {
        return source[nextIndex(source.length)];
    }
}
