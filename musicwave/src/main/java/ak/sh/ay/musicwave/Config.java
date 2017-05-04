package ak.sh.ay.musicwave;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;

/**
 * Created by akshay on 5/4/17.
 */

public class Config {
    private int color, startColor, endColor;
    private float thickness;
    private Boolean colorGradient = false;
    private MusicWave musicWave;

    private Paint PaintWave = new Paint();

    public Config(Context context, AttributeSet attrs, MusicWave musicWave) {
        this.musicWave = musicWave;
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MusicWave, 0, 0);
        if (attrs != null) {
            thickness = a.getFloat(R.styleable.MusicWave_waveThickness, 1f);
            color = a.getColor(R.styleable.MusicWave_waveColor, Color.parseColor("#691A40"));
            colorGradient = a.getBoolean(R.styleable.MusicWave_colorGradient, false);
            startColor = a.getColor(R.styleable.MusicWave_startColor, Color.parseColor("#93278F"));
            endColor = a.getColor(R.styleable.MusicWave_endColor, Color.parseColor("#00A99D"));
            a.recycle();
            PaintWave.setStrokeWidth(thickness);
            PaintWave.setAntiAlias(true);
            PaintWave.setStyle(Paint.Style.FILL);
            PaintWave.setColor(color);
            PaintWave.setAlpha(255);
        }
    }

    public int getColor() {
        return color;
    }

    public Config setColor(int color) {
        this.color = color;
        PaintWave.setColor(this.color);
        musicWave.invalidate();
        return this;
    }

    public int getStartColor() {
        return startColor;
    }

    public Config setStartColor(int startColor) {
        this.startColor = startColor;
        musicWave.invalidate();
        return this;
    }

    public int getEndColor() {
        return endColor;
    }

    public Config setEndColor(int endColor) {
        this.endColor = endColor;
        musicWave.invalidate();
        return this;
    }

    public float getThickness() {
        return thickness;
    }

    public Config setThickness(float thickness) {
        this.thickness = thickness;
        PaintWave.setStrokeWidth(this.thickness);
        musicWave.invalidate();
        return this;
    }

    public Boolean getColorGradient() {
        return colorGradient;
    }

    public Config setColorGradient(Boolean colorGradient) {
        this.colorGradient = colorGradient;
        musicWave.invalidate();
        return this;
    }

    public Paint getPaintWave() {
        return PaintWave;
    }

    public Config setPaintWave(Paint paintWave) {
        PaintWave = paintWave;
        musicWave.invalidate();
        return this;
    }

    public Paint setGradients(MusicWave musicWave) {
        PaintWave.setShader(new LinearGradient(0, 0,
                musicWave.getWidth(), 0,
                startColor, endColor, Shader.TileMode.MIRROR));
        musicWave.invalidate();
        return PaintWave;
    }

    public Paint reSetupPaint() {
        PaintWave = new Paint();
        PaintWave.setStrokeWidth(thickness);
        PaintWave.setAntiAlias(true);
        PaintWave.setStyle(Paint.Style.FILL);
        PaintWave.setColor(color);
        PaintWave.setAlpha(255);
        return PaintWave;
    }
}
