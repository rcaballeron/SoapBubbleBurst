package es.caballero.soapbubbleburst;

import android.graphics.drawable.Drawable;

import android.widget.FrameLayout;
import android.widget.ImageView;


import java.util.Random;

/**
 * Created by caballer on 12.08.2015.
 */
public class Bubble {
    private final static int LIFETIME = 1000;
    private float x, y, vx, vy, size;
    private int lifetime;
    private ImageView view;

    private Bubble(FrameLayout container, float vMax, float sizeMax,
                   Random rnd, Drawable drawable) {
        lifetime = LIFETIME;
        size = (0.5f + rnd.nextFloat() / 2) * sizeMax;
        x = rnd.nextFloat() * (container.getWidth() - size);
        y = rnd.nextFloat() * (container.getHeight() - size);
        vx = rnd.nextFloat() * vMax * (rnd.nextBoolean() ? 1 : -1);
        vy = rnd.nextFloat() * vMax * (rnd.nextBoolean() ? 1 : -1);
        view = new ImageView(container.getContext());
        view.setImageDrawable(drawable);
        container.addView(view);
        move();

    }

    public void move() {
    }
}
