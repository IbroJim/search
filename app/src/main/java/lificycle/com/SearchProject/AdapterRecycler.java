package lificycle.com.SearchProject;

import android.content.ComponentName;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import lificycle.com.R;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.MyViewHolder> {

    private ArrayList<String> listName;
    private Context context;


    public AdapterRecycler(ArrayList<String> listName,Context context) {
        this.listName = listName;
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View view=inflater.inflate(R.layout.item_list,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.textName.setText(listName.get(i));

    }

    @Override
    public int getItemCount() {
        return listName.size();
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textName=(TextView) itemView.findViewById(R.id.title_item);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            String name=listName.get(position);
            Toast.makeText(context,"Имя "+name,Toast.LENGTH_SHORT).show();
        }
    }
}
