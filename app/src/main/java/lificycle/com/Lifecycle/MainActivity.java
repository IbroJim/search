package lificycle.com.Lifecycle;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import lificycle.com.R;

public class MainActivity extends AppCompatActivity {

    String TAG="TestMain";
    Button next;
    Context context=MainActivity.this;
    private static final String EXTRA_RESULT="nameActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreatOne");
        setypView();
    }

    private void setypView(){
        next=(Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, TestTwo.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStartOne");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResumeOne");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPauseOne");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStopOne");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroyOne");
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String resulit = data.getStringExtra(EXTRA_RESULT);
            // Log.d(TAG,resulit);
            Toast.makeText(context,resulit,Toast.LENGTH_LONG).show();
        }
    }
}
