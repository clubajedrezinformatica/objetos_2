package ar.edu.unlp.info.oo2;

public class IntRing extends AbstractRing {
    private int[] source;

    public IntRing(int[] src) {
        super();
        source = src;
    }

    public int next() {
        return source[nextIndex(source.length)];
    }
}