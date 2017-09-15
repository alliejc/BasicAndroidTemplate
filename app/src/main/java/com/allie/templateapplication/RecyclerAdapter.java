package com.allie.templateapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by acaldwell on 9/14/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private List<String> mList;
    private Context mContext;

    public RecyclerAdapter(List list, Context context) {
        this.mList = list;
        this.mContext = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.recyclerview_item, parent, false);
        RecyclerViewHolder holder = new RecyclerViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        //set the text for each cell in the recyclerview from the list
        holder.headerText.setText(mList.get(position));
        holder.subText1.setText(mList.get(position));
        holder.subText2.setText(mList.get(position));
        holder.subText3.setText(mList.get(position));

    }

    //we probably need a method to add item to the recyclerview dynamically


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        public TextView headerText;
        public TextView subText1;
        public TextView subText2;
        public TextView subText3;
        public ImageButton deleteButton;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            headerText = (TextView) itemView.findViewById(R.id.text_view_header_item);
            subText1 = (TextView) itemView.findViewById(R.id.text_view_subheader1_item);
            subText2 = (TextView) itemView.findViewById(R.id.text_view_subheader2_item);
            subText3 = (TextView) itemView.findViewById(R.id.text_view_subheader3_item);
            deleteButton = (ImageButton) itemView.findViewById(R.id.delete_button);
        }

        //this might be a good place to add your onClickListener for the delete button
    }
}
