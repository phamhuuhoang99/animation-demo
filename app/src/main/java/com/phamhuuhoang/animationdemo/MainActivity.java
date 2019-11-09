package com.phamhuuhoang.animationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,Animation.AnimationListener {
    Animation animFadeIn;
    Animation animFadeOut;
    Animation animFadeInOut;

    Animation animZoomIn;
    Animation animZoomOut;

    Animation animLeftRight;
    Animation animRightLeft;
    Animation animTopBottom;

    Animation animBounce;
    Animation animFlash;

    Animation animRotateLeft;
    Animation animRotateRight;

    ImageView imageView;
    TextView textStatus;
    Button btnFadeIn;
    Button btnFadeOut;
    Button btnFadeInOut;
    Button zoomIn;
    Button zoomOut;
    Button leftRight;
    Button rightLeft;
    Button topBottom;
    Button bounce;
    Button flash;
    Button rotateLeft;
    Button rotateRight;
    SeekBar seekBarSpeed;
    TextView textSeekerSpeed;
    
    int seekSpeedProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        loadAnimations();
        loadUI();
    }



    private void loadAnimations() {
        Context context;
        animFadeIn=AnimationUtils.loadAnimation(this, R.anim.fade_in);
        animFadeIn.setAnimationListener( this);

        animFadeOut=AnimationUtils.loadAnimation(this, R.anim.fade_out);
        animFadeOut.setAnimationListener( this);

        animFadeInOut=AnimationUtils.loadAnimation(this,R.anim.fade_in_out);
        animFadeInOut.setAnimationListener( this);

        animLeftRight=AnimationUtils.loadAnimation(this, R.anim.left_right);
        animLeftRight.setAnimationListener( this);

        animRightLeft=AnimationUtils.loadAnimation(this, R.anim.right_left);
        animRightLeft.setAnimationListener(this);

        animZoomIn=AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        animZoomIn.setAnimationListener(this);

        animZoomOut=AnimationUtils.loadAnimation(this, R.anim.zoom_out);
        animZoomOut.setAnimationListener(this);

        animTopBottom=AnimationUtils.loadAnimation(this, R.anim.top_bot);
        animTopBottom.setAnimationListener(this);

        animBounce=AnimationUtils.loadAnimation(this, R.anim.bound);
        animFlash=AnimationUtils.loadAnimation(this, R.anim.flash);

        animRotateLeft=AnimationUtils.loadAnimation(this, R.anim.rotate_left);
        animRotateLeft.setAnimationListener(this);

        animRotateRight=AnimationUtils.loadAnimation(this, R.anim.rotate_right);
        animRotateRight.setAnimationListener(this);

    }
    private void loadUI() {
        imageView=findViewById(R.id.imageView);
        textStatus=findViewById(R.id.textStatus);

        btnFadeIn=findViewById(R.id.fadein);
        btnFadeOut=findViewById(R.id.fadeout);
        btnFadeInOut=findViewById(R.id.fadeinout);

        zoomIn=findViewById(R.id.zoomin);
        zoomOut=findViewById(R.id.zoomout);

        leftRight = (Button) findViewById(R.id.leftright);
        rightLeft = (Button) findViewById(R.id.rightleft);
        topBottom = (Button) findViewById(R.id.topbot);
        bounce = (Button) findViewById(R.id.bounce);
        flash = (Button) findViewById(R.id.flash);
        rotateLeft = (Button) findViewById(R.id.rotateleft);
        rotateRight = (Button) findViewById(R.id.rotateright);

        btnFadeIn.setOnClickListener(this);
        btnFadeOut.setOnClickListener( this);
        btnFadeInOut.setOnClickListener(this);

        zoomIn.setOnClickListener(this);
        zoomOut.setOnClickListener(this);
        leftRight.setOnClickListener(this);
        rightLeft.setOnClickListener(this);
        topBottom.setOnClickListener(this);
        bounce.setOnClickListener(this);
        flash.setOnClickListener(this);
        rotateLeft.setOnClickListener(this);
        rotateRight.setOnClickListener(this);

        seekBarSpeed=findViewById(R.id.seekBarSpeed);
        textSeekerSpeed=findViewById(R.id.textSeerSpeed);

        seekBarSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //detects a change in the position
                seekSpeedProgress=i;
                textSeekerSpeed.setText(""+seekSpeedProgress+" of "+seekBarSpeed.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //detects whether the user has start to change the position
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //detects when user has finished using the seek bar

            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fadein:
                animFadeIn.setDuration(seekSpeedProgress);
                animFadeIn.setAnimationListener(this);
                imageView.startAnimation(animFadeIn);
                break;
            case R.id.fadeout:
                animFadeOut.setDuration(seekSpeedProgress);
                animFadeOut.setAnimationListener(this);
                imageView.startAnimation(animFadeOut);
                break;
            case R.id.zoomout:
                animZoomOut.setDuration(seekSpeedProgress);
                animZoomOut.setAnimationListener(this);
                imageView.startAnimation(animZoomOut);
                break;
            case R.id.fadeinout:
                animFadeInOut.setDuration(seekSpeedProgress);
                animFadeInOut.setAnimationListener(this);
                imageView.startAnimation(animFadeInOut);
                break;
            case R.id.zoomin:
                animZoomIn.setDuration(seekSpeedProgress);
                animZoomIn.setAnimationListener(this);
                imageView.startAnimation(animZoomIn);
                break;

            case R.id.leftright:
                animLeftRight.setDuration(seekSpeedProgress);
                animLeftRight.setAnimationListener(this);
                imageView.startAnimation(animLeftRight);
                break;
            case R.id.rightleft:
                animRightLeft.setDuration(seekSpeedProgress);
                animRightLeft.setAnimationListener(this);
                imageView.startAnimation(animRightLeft);
                break;
            case R.id.topbot:
                animTopBottom.setDuration(seekSpeedProgress);
                animTopBottom.setAnimationListener(this);
                imageView.startAnimation(animTopBottom);
                break;
            case R.id.bounce:
/*
Divide seekSpeedProgress by 10 because with
the seekbar having a max value of 5000 it
will make the animations range between
almost instant and half a second
5000 / 10 = 500 milliseconds
*/
                animBounce.setDuration(seekSpeedProgress / 10);
                animBounce.setAnimationListener(this);
                imageView.startAnimation(animBounce);
                break;
            case R.id.flash:
                animFlash.setDuration(seekSpeedProgress / 10);
                animFlash.setAnimationListener(this);
                imageView.startAnimation(animFlash);
                break;
            case R.id.rotateleft:
                animRotateLeft.setDuration(seekSpeedProgress);
                animRotateLeft.setAnimationListener(this);
                imageView.startAnimation(animRotateLeft);
                break;
            case R.id.rotateright:
                animRotateRight.setDuration(seekSpeedProgress);
                animRotateRight.setAnimationListener(this);
                imageView.startAnimation(animRotateRight);
                break;

        }
    }

    @Override
    public void onAnimationStart(Animation animation) {
        textStatus.setText("RUNNING");
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        textStatus.setText("STOP");

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
