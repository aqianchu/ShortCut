package com.scu.shortcut;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtView = (TextView)findViewById(R.id.textView);
        findViewById(R.id.btn_add).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (TextUtils.isEmpty(action)) {
                super.onNewIntent(intent);
                return;
            }
            txtView.setText(action);
        }
        super.onNewIntent(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                Parcelable parcelable = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
                Utils.createFavLinkShortCut(this,"星星","www.so.com",parcelable,true,true);
                break;
        }
    }
}
