package lificycle.com.Lifecycle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import lificycle.com.R;

public class TestTree extends AppCompatActivity {

    String TAG="TestMain";
    Button back;
    Context context=TestTree.this;
    private static final String EXTRA_RESULT="nameActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree);
        Log.d(TAG,"onStartTree");
        setypView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStartTree");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResumeTree");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPauseTree");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStopTree");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroyTree");
    }

    private void setypView(){
        back=(Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent();
               intent.putExtra( EXTRA_RESULT,"ResuiltActivity=3");
               setResult(RESULT_OK,intent);
               finish();
            }
        });
    }


}
