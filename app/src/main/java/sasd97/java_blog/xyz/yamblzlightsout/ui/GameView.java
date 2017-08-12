package sasd97.java_blog.xyz.yamblzlightsout.ui;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import xyz.javablog.models.Point;
import xyz.javablog.models.Size;

public class GameView extends View {
    private GestureDetector gestureDetector;
    private Bitmap bitmap;
    private Canvas canvas;
    private Paint paint, bitmapPaint;
    private float canvasSize;
    private Size size;
    private int horizontalCountOfCells;
    private int verticalCountOfCells;
    private int cellX;
    private int cellY;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        canvasSize = Math.min(width, height);
    }

    public GameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        gestureDetector = new GestureDetector(context, new MyGestureDetector());

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        canvasSize = display.getWidth();

        bitmap = Bitmap.createBitmap((int) canvasSize, (int) canvasSize, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        bitmapPaint = new Paint(Paint.DITHER_FLAG);

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(0xffff0505);
        paint.setStrokeWidth(5f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);

    }


    public void setNewSize(Size size) {
        horizontalCountOfCells = size.getWidth();
        verticalCountOfCells = size.getHeight();
    }


    @Override
    protected void onDraw(Canvas canvas) {

        for (int x = 0; x < horizontalCountOfCells + 1; x++)
            canvas.drawLine((float) x * canvasSize / horizontalCountOfCells, 0, (float) x * canvasSize / horizontalCountOfCells, canvasSize, paint);
        for (int y = 0; y < verticalCountOfCells + 1; y++)
            canvas.drawLine(0, (float) y * canvasSize / verticalCountOfCells, canvasSize, (float) y * canvasSize / verticalCountOfCells, paint);

        canvas.drawBitmap(bitmap, 0, 0, bitmapPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return true;
    }

    public class MyGestureDetector extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onSingleTapConfirmed(MotionEvent event) {

            cellX = (int) ((event.getX() + getScrollX()));
            cellY = (int) ((event.getY() + getScrollY()));

            Log.d(this.getClass().getName(), "onSingleTapConfirmed: " + cellX + " " + cellY);

            getTapPoint();
            return true;
        }
    }

    public Point getTapPoint(){
        Point point;
        int x = -1;
        int y = -1;

        int cellSize = (int) (canvasSize / horizontalCountOfCells);

        x = (int) Math.ceil(cellX / cellSize);
        y = (int) Math.ceil(cellY / cellSize);

        point = new PointImpl(x, y);
        return point;
    }
}
