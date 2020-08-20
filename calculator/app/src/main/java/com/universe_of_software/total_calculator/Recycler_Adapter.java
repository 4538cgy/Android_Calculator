package com.universe_of_software.total_calculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Recycler_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Recycler_item> mList = null;

    public Recycler_Adapter(ArrayList<Recycler_item> mList){
        this.mList = mList;
    }

    private OnItemClickListener mListener = null;

    public interface OnItemClickListener{
        void onItemClick(View v, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.mListener = onItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        Context context = parent.getContext();

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (viewType == Recycler_ViewType.ViewType.Only_Text_List){
            view = inflater.inflate(R.layout.z_recycler_item_fragment_unit_menu_recycler,parent,false);
            return new Only_Text_List_ViewHolder(view);
        }else if(viewType == Recycler_ViewType.ViewType.ImageAndText){
            view = inflater.inflate(R.layout.z_recycler_item_activity_calculator_selector_normal_recycler_item,parent,false);
            return new ImageAndText_List_ViewHolder(view);
        }else if(viewType == Recycler_ViewType.ViewType.patchItem){
            view = inflater.inflate(R.layout.z_recycler_item_activity_patch_item,parent,false);
            return new PatchItemViewHolder(view);
        }

        else{
            return null;
        }


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof Only_Text_List_ViewHolder)
        {
            ((Only_Text_List_ViewHolder)holder).titleTextView.setText(mList.get(position).getTitle());
        }else if(holder instanceof ImageAndText_List_ViewHolder ){
            ((ImageAndText_List_ViewHolder)holder).imageView.setImageDrawable(mList.get(position).getDrawable());
            ((ImageAndText_List_ViewHolder)holder).titleTextView2.setText(mList.get(position).getImage_title());
        }else if (holder instanceof PatchItemViewHolder){
            ((PatchItemViewHolder)holder).textView.setText(mList.get(position).getTitle());
        }
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).getViewType();
    }

    public class PatchItemViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        PatchItemViewHolder(View view){
            super(view);

            textView = (TextView)view.findViewById(R.id.recycler_item_activity_patch_textview);


        }
    }

    public class Only_Text_List_ViewHolder extends RecyclerView.ViewHolder{

        TextView titleTextView;
        ViewGroup viewGroup;

        Only_Text_List_ViewHolder(View view){
            super(view);

            titleTextView = (TextView)view.findViewById(R.id.fragment_unit_menu_item_title_textview);
            viewGroup = (ViewGroup)view.findViewById(R.id.fragment_unit_menu_item_group);

            viewGroup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        if (mListener != null){
                            mListener.onItemClick(v,pos);
                        }
                    }
                }
            });

        }

    }

    public class ImageAndText_List_ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView titleTextView2;
        ViewGroup viewGroup;

        ImageAndText_List_ViewHolder(View view){
            super(view);

            imageView = (ImageView)view.findViewById(R.id.selector_normal_menu_imageButton);
            titleTextView2 = (TextView)view.findViewById(R.id.selector_normal_menu_textView);
            viewGroup = (ViewGroup)view.findViewById(R.id.selector_cal_menu_group);

            viewGroup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        if (mListener != null){
                            mListener.onItemClick(v,pos);
                        }
                    }
                }
            });


        }

    }
}
