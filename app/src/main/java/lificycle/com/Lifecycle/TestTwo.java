package lificycle.com.Lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import lificycle.com.R;

public class TestTwo extends AppCompatActivity {

    private String TAG = "TestMain";
    private Button back, next;
    private Context context = TestTwo.this;
    private static final String EXTRA_RESULT = "nameActivity";
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        Log.d(TAG, "onCreateTwo");
        setypView();
        getLifecycle().addObserver(new MyLifecycle());
    }


    private void setypView() {
        next = (Button) findViewById(R.id.next);
        back = (Button) findViewById(R.id.back);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TestTree.class);
                startActivityForResult(intent, 1);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra( EXTRA_RESULT,"ResuiltActivity=2");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && requestCode == RESULT_OK) {
            String resulit = data.getStringExtra(EXTRA_RESULT);
           // Log.d(TAG,resulit);
            Toast.makeText(context,resulit,Toast.LENGTH_LONG);
        }
    }

    public class MyLifecycle implements LifecycleObserver{

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onStart(){
            Log.d(TAG, "onStartTwo");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public void onResumeListener() {
            Log.d(TAG, "onResumeTwo");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        public void onPauseListener() {
            Log.d(TAG, "onPauseTwo");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public void onStopListener() {
            Log.d(TAG, "onStopTwo");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroyListenner(){
            Log.d(TAG, "onDestroyTwo");
        }
    }

   private void start(){
       LifecycleOwner lifecycleOwner = new LifecycleOwner() {
           @NonNull
           @Override
           public Lifecycle getLifecycle() {
               return null;
           }
       };
       lifecycleOwner.getLifecycle().addObserver(new MyLifecycle());
   }
}

