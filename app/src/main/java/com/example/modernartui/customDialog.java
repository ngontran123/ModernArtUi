package com.example.modernartui;
import android.app.Dialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.os.Bundle;
import android.view.*;
public class customDialog extends Dialog {
    public Context context;
    public Button buttonOk;
    public Button buttonCancel;
   public customDialog(Context context)
    {
        super(context);
        this.context=context;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_custom);
        this.buttonOk=(Button)this.findViewById(R.id.button2);
        this.buttonCancel=(Button)this.findViewById(R.id.button1);
        this.buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonOk();
            }
        });
        this.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonCancel();
            }
        });
    }
    public void buttonOk()
    {  String url="https://google.com";
        Intent t=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        this.context.startActivity(t);
    }
    public void buttonCancel()
    {
     this.dismiss();
    }
}
