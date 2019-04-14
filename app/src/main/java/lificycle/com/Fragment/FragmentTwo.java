package lificycle.com.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import lificycle.com.R;

public class FragmentTwo  extends Fragment implements OnActivityDataListener{

    private  OnGiveData myListenner;

    private EditText editText;
    private TextView textView;
    private Button button;
    public  static int KEY=2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_two,container,false);
        editText=(EditText) view.findViewById(R.id.edit_fragment_two);
        textView=(TextView) view.findViewById(R.id.text_fragment_two);
        button=(Button) view.findViewById(R.id.give_data_fragment_two);
        setupButton();
        return view;
    }

    public void setupButton(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=editText.getText().toString();
                Log.d("Hello",s);
                if(!s.isEmpty()) {
                    ((FragmentActivityMaim) getActivity()).onGiveData(s, KEY);
                    editText.setText(" ");
                }
            }
        });
    }

    @Override
    public void onActivityDataListener(String string) {
        textView.setText(string);
    }
}
