package com.ismael.uedcontrol.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ismael.uedcontrol.R;
import com.ismael.uedcontrol.model.Activitys;
import com.ismael.uedcontrol.repositories.ActivitiesRepository;

import java.util.ArrayList;
import java.util.List;


public class ActAdapter extends RecyclerView.Adapter<ActAdapter.ActivityViewHolder>{

    private List<Activitys> activities;
    public static boolean ASC = false;

    public ActAdapter(){
        activities = new ArrayList<Activitys>(ActivitiesRepository.getInstance().subList(0, ActivitiesRepository.getInstance().size()));
    }

    @Override
    public ActivityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activity, null);
        return new ActivityViewHolder(item);
    }
    @Override
    public void onBindViewHolder(ActivityViewHolder holder, int position) {
        // holder.product_image.setImageResource(contacts.get(position).getmImage());
        holder.txvTitle.setText(activities.get(position).toString());


    }

    @Override
    public int getItemCount() {
        return activities.size();
    }

    public static class ActivityViewHolder extends RecyclerView.ViewHolder{

        TextView txvTitle;


        public ActivityViewHolder(View item) {
            super(item);

            txvTitle = (TextView) item.findViewById(R.id.txvInfoActivity);

        }
    }


    public List<Activitys> getAllActivities(){
        return activities;
    }

    public void getActivitiesOrder( ){
        ASC = !ASC;
        activities.clear();
        activities.addAll(ActivitiesRepository.getInstance().getActivities(ASC));
        notifyDataSetChanged();
    }


}
