package et.savon.fi.chessmate;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;

import java.util.ArrayList;
import java.util.List;

public class CustomDrawableView extends View {
    private List<Drawable> board = new ArrayList<Drawable>();
    int height = 800;
    int width = 640;
    ViewTreeObserver vto = this.getViewTreeObserver();
    public CustomDrawableView(Context context) {
        super(context);

        board = BoardBuilder.buildBoard(height, width);
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                updateBounds();

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    //yeah no need to remove it cause of layout switching
                    //   vto.removeOnGlobalLayoutListener(this);
                }
            }

        });
    }

    private void updateBounds(){
        height = this.getMeasuredHeight();
        width = this.getMeasuredWidth();
        board = BoardBuilder.buildBoard(height, width);

        this.invalidate();
    }

    @Override
    public void onWindowFocusChanged (boolean hasFocus) {
        height = this.getMeasuredHeight();
        width = this.getMeasuredWidth();
        board = BoardBuilder.buildBoard(height, width);

        this.invalidate();
    }

    protected void onDraw(Canvas canvas) {
        for(Drawable cell : board){
            cell.draw(canvas);
        }
    }
}