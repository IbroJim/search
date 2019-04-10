package lificycle.com.SearchProject;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import lificycle.com.R;

public class SearchActivity extends AppCompatActivity {

    private Button setting;
    private EditText search;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private AdapterRecycler adapter;
    private LinearLayout linearLayout;
    private boolean chekSearch=true;
    private TextView textOutput;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setupView();
        setupTypeFiltrBook();

    }

    private void setupView(){
        final int color= ContextCompat.getColor(this,R.color.colorWhite);
        setting = (Button) findViewById(R.id.seting);
        search = (EditText) findViewById(R.id.search_edit);
        linearLayout=(LinearLayout) findViewById(R.id.my_linear);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count>0){
                    linearLayout.setBackgroundColor(color);
                }
                if (chekSearch==true){setupFiltr(s.toString(), count);
                }
                else {
                    setupFiltrLastName(s.toString(), count);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    private void setupFiltr(String  word, int count) {
        ArrayList<String> sortName = new ArrayList<>();
        ArrayList<String> nameList = MyData.string();
        String name = firstUpperCase(word);
            for (int i = 0; i < nameList.size(); i++) {
                if (nameList.get(i).length() >=count) {
                    if (nameList.get(i).substring(0, count).equals(name.substring(0, count))) {
                        sortName.add(nameList.get(i));

                    } else {
                    }
                }

            }
            setupRecyclerList(sortName);
        }
    private String firstUpperCase(String word){
        String name;
        if(word == null || word.isEmpty()) return "";//или return word;
        name= word.substring(0, 1).toUpperCase() + word.substring(1);
        return name;
    }
    private void setupRecyclerList(ArrayList<String> name){
        recyclerView=(RecyclerView) findViewById(R.id.recycler_view);
        layoutManager=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        adapter=new AdapterRecycler(name,SearchActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    private void setupFiltrLastName(String word,int count){
        ArrayList<String> sortLastName = new ArrayList<>();
        ArrayList<String> nameList = MyData.string();
        String name = firstUpperCase(word);
        int lastNameCount=0;
        String t=" ";

        for(int i=0;i<nameList.size();i++){

              //  int a=nameList.get(i).length();
                //a--;
               // Log.d("Hello"," "+a);
                for (int j = 0; j<nameList.get(i).length()-1; j++) {
                        if (nameList.get(i).substring(j).contains(t)) {
                            lastNameCount = j+1;
                        }
                }
               if (nameList.get(i).length() >=count+lastNameCount) {
                     Log.d("Hello"," "+lastNameCount);
                    if (nameList.get(i).substring(lastNameCount, lastNameCount+count).equals(name.substring(0, count))) {
                        sortLastName.add(nameList.get(i));
                    }

            }
        }
        setupRecyclerList(sortLastName);
    }
    private void setupTypeFiltrBook(){
       setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(SearchActivity.this);
                builder.setTitle("Выберите тип поиска");
                builder.setSingleChoiceItems(R.array.search, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                chekSearch=true;
                                break;
                            case 1:
                                chekSearch=false;
                                break;
                        }

                    }
                });
                builder.setPositiveButton("Готово", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog mDialog=builder.create();
                mDialog.show();
            }
        });
    }

}






