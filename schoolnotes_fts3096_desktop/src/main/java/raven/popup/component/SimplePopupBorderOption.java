package raven.popup.component;

public class SimplePopupBorderOption {

    protected boolean useScroll;
    protected int width = 400;
    protected int roundBorder = 20;
    protected boolean opaque;
    public SimplePopupBorderOption useScroll() {
        useScroll = true;
        return this;
    }

    public SimplePopupBorderOption setWidth(int width) {
        this.width = width;
        return this;
    }

    public SimplePopupBorderOption setOpaque(boolean opaque) {
        this.opaque = opaque;
        return this;
    }

    public SimplePopupBorderOption setRoundBorder(int roundBorder) {
        this.roundBorder = roundBorder;
        return this;
    }
}
