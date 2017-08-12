package sasd97.java_blog.xyz.yamblzlightsout.ui;


import xyz.javablog.models.Size;

public class SizeImpl implements Size {

    private int width;
    private int hight;

    public SizeImpl(int width, int hight) {
        this.width = width;
        this.hight = hight;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return hight;
    }
}
