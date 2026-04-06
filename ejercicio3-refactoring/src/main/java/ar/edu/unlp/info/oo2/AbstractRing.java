package ar.edu.unlp.info.oo2;
public abstract class AbstractRing {
    protected int idx;

    public AbstractRing() {
        this.idx = 0;
    }

    protected int nextIndex(int length) {
        if (idx >= length) {
            idx = 0;
        }
        return idx++;
    }
}
