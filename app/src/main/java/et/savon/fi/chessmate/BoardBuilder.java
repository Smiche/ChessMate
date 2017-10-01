package et.savon.fi.chessmate;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SW1 on 1.10.2017.
 */

public class BoardBuilder {

    public BoardBuilder(){

    }

    public static List<Drawable> buildBoard(int height, int width){
        int cellWidth = width/8;
        int cellHeight = height/8;

        List<Drawable> rows = new ArrayList<Drawable>();
        for(int i = 0;i <8; i++){
            for(int j = 0;j<8; j++){
                ShapeDrawable cell = new ShapeDrawable(new RectShape());
                cell.getPaint().setColor(((i+j)%2 == 0)? Color.RED:Color.BLACK);
                if(cellHeight >= cellWidth){
                    cell.setBounds(i*cellWidth,j*cellWidth, i*cellWidth + cellWidth, j*cellWidth + cellWidth);
                } else {
                    cell.setBounds(i*cellHeight,j*cellHeight, i*cellHeight + cellHeight, j*cellHeight + cellHeight);
                }
                rows.add(cell);
            }
        }

        return rows;
    }
}
