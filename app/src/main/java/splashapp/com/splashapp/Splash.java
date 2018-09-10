package splashapp.com.splashapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.PixelFormat;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.net.NetworkInfo;
import android.widget.VideoView;

public class Splash extends Activity implements Animation.AnimationListener {

    // Animation
    Animation animFadein;
    ImageView img,one,two,three,four,five,six,seven,eight,nine,ten;
    android.support.v7.widget.GridLayout gridLayout ;
    VideoView videoview;
    Uri uri;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        setContentView(R.layout.activity_splash);

        img=(ImageView) findViewById(R.id.logo);

        videoview = (VideoView) findViewById(R.id.videoView);
        uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.innovation);
        videoview.setVideoURI(uri);
        videoview.start();
        /*one=(ImageView) findViewById(R.id.image_one);
        two=(ImageView) findViewById(R.id.image_two);
        three=(ImageView) findViewById(R.id.image_three);
        four=(ImageView) findViewById(R.id.image_four);
        five=(ImageView) findViewById(R.id.image_five);
        six=(ImageView) findViewById(R.id.image_six);
        seven=(ImageView) findViewById(R.id.image_seven);
        eight=(ImageView) findViewById(R.id.image_eight);
        nine=(ImageView) findViewById(R.id.image_nine);
        ten=(ImageView) findViewById(R.id.image_ten);*/

       // gridLayout = (android.support.v7.widget.GridLayout) findViewById(R.id.grid);
        StartAnimations();
        checkInternetConenction();

    }
    /*********************Check Internet connection ***************************/
    private boolean checkInternetConenction() {

        // get Connectivity Manager object to check connection
        ConnectivityManager connec = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        // Check for network connections
        if (connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED
                ||

                connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTING
                || connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING
                || connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED) {
            Toast.makeText(this, " Connected ", Toast.LENGTH_LONG).show();
            /****** Create Thread that will sleep for 5 seconds *************/
           // StartAnimations();
            return true;
        } else if (connec.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED
                || connec.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED) {
            InternetConnectionerror();
            return false;
        }
        return false;
    }

    /************************************************
     * Hardware Back Button
     *******************************************************/
    public void InternetConnectionerror() {
        AlertDialog alert = new AlertDialog.Builder(Splash.this)
                .setTitle("Warning.")
                .setMessage("Check Your Internet Connection ?")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int whichButton) {
                        finish();
                    }
                }).create();

        alert.show();
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

    }

    @Override
    public void onAnimationStart(Animation animation) {
    }

    @Override
    public void onAnimationEnd(Animation animation) {
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }

    public void StartAnimations() {
        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);
       /* Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_back);
        //GridLayoutAnimationController.AnimationParameters anim = (GridLayoutAnimationController.AnimationParameters)();
        GridLayoutAnimationController controller = new GridLayoutAnimationController(animation, .2f, .2f);
        LayoutAnimationController controller1 = new LayoutAnimationController(animation,.2f);
        gridLayout.setLayoutAnimation(controller1);

        gridLayout.setLayoutAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                *//*ColorMatrix matrix = new ColorMatrix();
                matrix.setSaturation(0);

                ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
                one.setColorFilter(filter);
                two.setColorFilter(filter);
                three.setColorFilter(filter);
                four.setColorFilter(filter);
                five.setColorFilter(filter);
                six.setColorFilter(filter);
                seven.setColorFilter(filter);
                eight.setColorFilter(filter);
                nine.setColorFilter(filter);
                ten.setColorFilter(filter);*//*





                animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.fade_in);
                img.setVisibility(View.VISIBLE);
                img.startAnimation(animFadein);




            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });*/

        img.setVisibility(View.VISIBLE);
        // start the animation
        img.startAnimation(animFadein);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i=new Intent(Splash.this,MainActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.open_next, R.anim.close_next);
                finish();
            }
        },3500);

    }




}
