package lificycle.com.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import lificycle.com.R;

public class FragmentActivityMaim extends FragmentActivity implements OnGiveData{

    private FragmentManager fragmentManager;
    private Fragment fragmentOne, fragmentTwo;
    private OnActivityDataListener myListenner;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        setupFragmentManager();
    }

    public void setupFragmentManager(){
        fragmentManager=getSupportFragmentManager();
        fragmentOne=fragmentManager.findFragmentById(R.id.fragmentContainerOne);
        fragmentTwo=fragmentManager.findFragmentById(R.id.fragmentContainerTwo);
        fragmentOne=new FragmentOne();
        fragmentTwo=new FragmentTwo();
        fragmentManager.beginTransaction().add(R.id.fragmentContainerOne,fragmentOne).add(R.id.fragmentContainerTwo,fragmentTwo).commit();
    }

    @Override
    public void onGiveData(String string,int key) {
        if (key == FragmentOne.KEY) {
            myListenner=(OnActivityDataListener) fragmentTwo;
            myListenner.onActivityDataListener(string);
        }else if  (key == FragmentTwo.KEY) {
            myListenner=(OnActivityDataListener) fragmentOne;
            myListenner.onActivityDataListener(string);
        }else {

        }

    }

}
