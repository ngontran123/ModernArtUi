package com.example.modernartui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.view.*;
public class MainActivity extends AppCompatActivity {
public RelativeLayout frame;
public SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frame=(RelativeLayout) this.findViewById(R.id.frame);
        seekBar=(SeekBar) this.findViewById(R.id.seekBarItem);
        final View view_one=findViewById(R.id.rec1);
        final View view_two=findViewById(R.id.rec2);
        final View view_three=findViewById(R.id.rec3);
        final View view_five=findViewById(R.id.rec5);
        view_one.setBackgroundColor(Color.rgb(102,102,255));
        view_two.setBackgroundColor(Color.rgb(255,153,204));
        view_three.setBackgroundColor(Color.rgb(155,0,0));
        view_five.setBackgroundColor(Color.rgb(0,0,204));
      /*seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
          @Override
          public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
         for(int i=0;i<frame.getChildCount();i++)
         {
             View child=frame.getChildAt(i);
             long originColor= Color.parseColor((String) child.getTag());
             long invertColor = (0x00FFFFFF - (originColor | 0xFF000000))
                     | (originColor & 0xFF000000);
             Log.d("origin:",Long.toString(originColor));
             Log.d("invert",Long.toString(invertColor));
             if(getResources().getColor(R.color.white)!=originColor&&getResources().getColor(R.color.grey)!=originColor)
             {
                 long originRed= (originColor >> 16) & 0x000000FF;
                 long originGreen=(originColor >>8)& 0x000000FF;
                 long originBlue=(originColor&0x000000FF);
                 long invertRed= (invertColor >> 16) & 0x000000FF;
                 long invertGreen=(invertColor >>8)& 0x000000FF;
                 long invertBlue=(invertColor&0x000000FF);
                 Log.d("originRed",Long.toString(originRed));
                 Log.d("originBlue",Long.toString(originBlue));
                 Log.d("originGreen",Long.toString(originGreen));
                 Log.d("invertRed",Long.toString(invertRed));
                 Log.d("invertBlue",Long.toString(invertBlue));
                 Log.d("invertGreen",Long.toString(invertGreen));
                 child.setBackgroundColor(Color.rgb((int)(
                         originRed+(invertRed-originRed)*(progress/100f)
                         ),(int)(
                                 originGreen+(invertGreen-originGreen)*(progress/100f)
                         ),(int)(
                                 originBlue+(invertBlue-originBlue)*(progress/100f)
                         )
                 ));
                 child.invalidate();
             }

         }
          }

          @Override
          public void onStartTrackingTouch(SeekBar seekBar) {

          }

          @Override
          public void onStopTrackingTouch(SeekBar seekBar) {

          }
      });*/
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int increment, boolean fromUser) {
                view_one.setBackgroundColor(Color.rgb(102+increment,102+increment,255));
                view_two.setBackgroundColor(Color.rgb(255,153+(153/100)*increment,204-(204/100)*increment));
                view_three.setBackgroundColor(Color.rgb(155-increment,0,0+increment));
                view_five.setBackgroundColor(Color.rgb(0+increment+100,0+increment,204));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
     getMenuInflater().inflate(R.menu.menu_main,menu);
     return true;
    }
    public void showDialog(MenuItem menuItem)
    {
        final customDialog dialog=new customDialog(this);
        dialog.show();
    }
}