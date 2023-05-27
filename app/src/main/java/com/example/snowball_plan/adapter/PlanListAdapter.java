package com.example.snowball_plan.adapter;

import static androidx.core.app.ActivityCompat.startActivityForResult;
import static androidx.core.app.ActivityCompat.startIntentSenderForResult;
import static androidx.core.content.ContextCompat.startActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.snowball_plan.R;
import com.example.snowball_plan.activity.DayActivity;
import com.example.snowball_plan.activity.MainActivity;
import com.example.snowball_plan.database.DayPlanDBHelper;
import com.example.snowball_plan.entity.DayPlan;
import com.example.snowball_plan.fragment.EveryDayFragment;
import com.example.snowball_plan.tools.ConfirmDialog;
import com.example.snowball_plan.tools.YearDialog;

import java.util.List;

public class PlanListAdapter extends BaseAdapter{

    private final Context mContext;
    private final List<DayPlan> mDayPlanList;
    private DayPlanDBHelper dayPlanDBHelper;

    public PlanListAdapter(Context context, List<DayPlan> dayPlanList) {
        this.mContext = context;
        this.mDayPlanList = dayPlanList;
    }


    @Override
    public int getCount() {
        return mDayPlanList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDayPlanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mDayPlanList.get(position).id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_plan_test,null);
      holder.date = convertView.findViewById(R.id.date);
            holder.start_time = convertView.findViewById(R.id.start_time);
            holder.end_time = convertView.findViewById(R.id.end_time);
            holder.type = convertView.findViewById(R.id.type);
            holder.up_bg = convertView.findViewById(R.id.up_bg);
            holder.list = convertView.findViewById(R.id.list);
            holder.tick = convertView.findViewById(R.id.tick);
            holder.down_bg = convertView.findViewById(R.id.down_bg);
            holder.edit = convertView.findViewById(R.id.edit);
            holder.delete = convertView.findViewById(R.id.delete);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        DayPlan day = mDayPlanList.get(position);
        holder.date.setText(day.date);
        holder.start_time.setText(day.start_time);
        holder.end_time.setText(day.end_time);
        holder.type.setText(day.type);
        holder.up_bg.setBackgroundColor(day.color);
        holder.list.setText(day.list);
        holder.down_bg.setBackgroundColor(day.color);
        holder.tick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.tick.isSelected()){
                    holder.tick.setSelected(false);
                }else{
                    holder.tick.setSelected(true);
                }
            }
        });
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(mContext, DayActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intent);
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfirmDialog confirmDialog = new ConfirmDialog(mContext);
                confirmDialog.show();


            }
        });



        return convertView;
    }


    private void deletePlan(DayPlan dayPlan){
        dayPlanDBHelper = DayPlanDBHelper.getInstance(mContext);
        dayPlanDBHelper.deletePlan(dayPlan.id);
        DayPlan removed = null;
        for(DayPlan d:mDayPlanList){
            removed = d;
            break;
        }
        mDayPlanList.remove(removed);
        Toast.makeText(mContext,"删除计划成功！",Toast.LENGTH_SHORT).show();
    }

    public final class ViewHolder{

        public TextView date;
        public TextView start_time;
        public TextView end_time;
        public TextView type;
        public LinearLayout up_bg;
        public TextView list;
        public ImageButton tick;
        public LinearLayout down_bg;
        public ImageButton edit;
        public ImageButton delete;

//        public void removeView(View v) {
//        }
    }


}
