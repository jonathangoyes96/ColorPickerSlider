package com.optic.colorpickerslider;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{


    private SeekBar mSeekBarGreen;
    private SeekBar mSeekBarRed;
    private SeekBar mSeekBarBlue;
    private SeekBar mSeekBarAlpha;
    private TextView mTextViewRedValue;
    private TextView mTextViewBlueValue;
    private TextView mTextViewGreenValue;
    private TextView mTextViewAlphaValue;
    private View mViewColor;
    private int progressSeekGreen;
    private int progressSeekRed;
    private int progressSeekBlue;
    private int progressSeekAlpha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSeekBarGreen = (SeekBar) findViewById(R.id.seekbarGreen);
        mSeekBarBlue = (SeekBar) findViewById(R.id.seekbarBlue);
        mSeekBarRed = (SeekBar) findViewById(R.id.seekbarRed);
        mSeekBarAlpha = (SeekBar) findViewById(R.id.seekbarAlpha);
        mTextViewRedValue = (TextView) findViewById(R.id.textViewRedValue);
        mTextViewBlueValue = (TextView) findViewById(R.id.textViewBlueValue);
        mTextViewGreenValue = (TextView) findViewById(R.id.textViewGreenValue);
        mTextViewAlphaValue = (TextView) findViewById(R.id.textViewAlphaValue);
        mViewColor = (View) findViewById(R.id.viewColor);

        mSeekBarRed.setOnSeekBarChangeListener(this);
        mSeekBarGreen.setOnSeekBarChangeListener(this);
        mSeekBarBlue.setOnSeekBarChangeListener(this);
        mSeekBarAlpha.setOnSeekBarChangeListener(this);

        updateBackground();

    }



    public void updateBackground() {
        progressSeekRed = mSeekBarRed.getProgress();
        progressSeekGreen = mSeekBarGreen.getProgress();
        progressSeekBlue = mSeekBarBlue.getProgress();
        progressSeekAlpha = mSeekBarAlpha.getProgress();

        mTextViewRedValue.setText(String.valueOf(progressSeekRed));
        mTextViewBlueValue.setText(String.valueOf(progressSeekBlue));
        mTextViewGreenValue.setText(String.valueOf(progressSeekGreen));
        mTextViewAlphaValue.setText(String.valueOf(progressSeekAlpha));

        int color = Color.argb(progressSeekAlpha, progressSeekRed, progressSeekGreen, progressSeekBlue);
        mViewColor.setBackgroundColor(color);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        updateBackground();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
