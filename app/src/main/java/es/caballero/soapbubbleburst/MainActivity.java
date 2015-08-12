package es.caballero.soapbubbleburst;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import es.caballero.tools.BaseGameActivity;
import es.caballero.tools.SimpleAnimationListener;

public class MainActivity extends BaseGameActivity implements View.OnClickListener {
    private static final String TYPEFACE_TITLE = "FantasticFont";
    private ViewGroup container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addTypeface(TYPEFACE_TITLE);

        container = (ViewGroup) findViewById(R.id.container);

        showStartFragment();

    }

    private void showStartFragment() {
        container.removeAllViews();
        View start = getLayoutInflater().inflate(R.layout.start, null);
        setTypeface((TextView) start.findViewById(R.id.title), TYPEFACE_TITLE);
        start.findViewById(R.id.start).setOnClickListener(this);
        container.addView(start);
        Animation a = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        start.startAnimation(a);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.start) {
            Animation a = AnimationUtils.loadAnimation(this, R.anim.pulse);
            a.setAnimationListener(new SimpleAnimationListener() {
                @Override
                public void onAnimationEnd(Animation animation) {
                    startGame();
                }
            });
            v.startAnimation(a);
        }
    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
