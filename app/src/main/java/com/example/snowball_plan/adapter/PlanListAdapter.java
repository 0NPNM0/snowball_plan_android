package com.example.snowball_plan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.snowball_plan.R;
import com.example.snowball_plan.database.DayPlanDBHelper;
import com.example.snowball_plan.entity.DayPlan;
import com.example.snowball_plan.tools.ColorSelector;
import com.example.snowball_plan.tools.ConfirmDialog;
import com.example.snowball_plan.tools.EditDialog;

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

    private void deletePlan(DayPlan dayPlan){
        dayPlanDBHelper = DayPlanDBHelper.getInstance(mContext);
        long res = dayPlanDBHelper.deletePlan(dayPlan.id);
        if(res>0){
            Toast.makeText(mContext,"删除计划成功！",Toast.LENGTH_SHORT).show();
        }
    }

    private void updateTick(DayPlan dayPlan){
        dayPlanDBHelper = DayPlanDBHelper.getInstance(mContext);
        dayPlanDBHelper.updateTick(dayPlan);
    }

    private void updatePlan(DayPlan dayPlan){
        dayPlanDBHelper = DayPlanDBHelper.getInstance(mContext);
        long res = dayPlanDBHelper.updatePlan(dayPlan,dayPlan.id);

        if(res>0){
            Toast.makeText(mContext,"修改计划成功！",Toast.LENGTH_SHORT).show();
        }
    }

    private boolean queryTickId(DayPlan dayPlan){
        dayPlanDBHelper = DayPlanDBHelper.getInstance(mContext);
        return dayPlanDBHelper.queryTickById(dayPlan.id);
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

        public LinearLayout plan;

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
            holder.plan = convertView.findViewById(R.id.plan);

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
                    day.tick = false;
                    updateTick(day);
                }else{
                    holder.tick.setSelected(true);
                    day.tick = true;
                    updateTick(day);
                }
            }
        });

        holder.tick.setSelected(queryTickId(day));

        holder.delete.setOnClickListener(new View.OnClickListener() {
            ConfirmDialog confirmDialog = new ConfirmDialog(mContext);
            private Button yes;
            private Button no;
            @Override
            public void onClick(View v) {
                confirmDialog.show();
                confirmDialog.setContentView(R.layout.confirm_dialog);
                yes = confirmDialog.findViewById(R.id.yes);
                no = confirmDialog.findViewById(R.id.no);

                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        holder.plan.removeAllViews();
                        deletePlan(day);
                        confirmDialog.dismiss();
                    }
                });

                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        confirmDialog.dismiss();
                    }
                });

            }
        });


        holder.edit.setOnClickListener(new View.OnClickListener() {
           EditDialog editDialog = new EditDialog(mContext);

            private TimePicker timepicker_start;
            private TimePicker timepicker_end;

            private  Button yes_day;
            private   Button no_day;

            private EditText day_task_type, day_task_list;

            private TextView tv_date;

            private ColorSelector colorSelector;

            private Button tab1, tab2, tab3, tab4, tab5,
                    tab6, tab7, tab8, tab9, tab10,
                    tab11, tab12, tab13, tab14, tab15,
                    tab16, tab17, tab18, tab19, tab20,
                    tab21, tab22, tab23, tab24, tab25,
                    tab26, tab27, tab28, tab29, tab30,
                    tab31, tab32, tab33, tab34, tab35, isCurrent;
            private boolean hasColor = false;

//            private EditText tv_date;
            @Override
            public void onClick(View v) {
                editDialog.show();
                editDialog.setContentView(R.layout.edit_dialog);

                timepicker_end = editDialog.findViewById(R.id.timepicker_end);
                timepicker_end.setIs24HourView(true);
                String [] et = day.end_time.toString().split(":");
                timepicker_end.setHour(Integer.parseInt(et[0]));
                timepicker_end.setMinute(Integer.parseInt(et[1]));

                timepicker_end.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

                    @Override
                    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                        String time = hourOfDay+":"+minute;
//                Toast.makeText(context,"您选择的时间是："+hourOfDay+"时"+minute+"分!",Toast.LENGTH_SHORT).show();
                    }
                });

                timepicker_start = editDialog.findViewById(R.id.timepicker_start);
                timepicker_start.setIs24HourView(true);
                String [] st = day.start_time.toString().split(":");
                timepicker_start.setHour(Integer.parseInt(st[0]));
                timepicker_start.setMinute(Integer.parseInt(st[1]));


                timepicker_start.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

                    @Override
                    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                        String time = hourOfDay+":"+minute;
//                Toast.makeText(context,"您选择的时间是："+hourOfDay+"时"+minute+"分!",Toast.LENGTH_SHORT).show();
                    }
                });

                yes_day = editDialog.findViewById(R.id.yes_day);
                no_day = editDialog.findViewById(R.id.no_day);


                yes_day.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

//                        DayPlan dayPlan1 = new DayPlan();
//                        holder.date.setText(tv_date.getText());
//                        holder.start_time.setText(timepicker_start.getHour()+":"+timepicker_start.getMinute());
//                        holder.end_time.setText(timepicker_end.getHour()+":"+timepicker_end.getMinute());
//                        holder.type.setText(day_task_type.getText());
//                        ColorSelector colorSelector1 = new ColorSelector();
//                        holder.up_bg.setBackgroundColor(colorSelector1.Selector(isCurrent.getId()));
//                        holder.list.setText(day_task_list.getText());
//                        holder.down_bg.setBackgroundColor(colorSelector1.Selector(isCurrent.getId()));


                        DayPlan day_new = mDayPlanList.get(position);
                        day_new.date = tv_date.getText().toString();
                        day_new.start_time =timepicker_start.getHour()+":"+timepicker_start.getMinute();
                        day_new.end_time =timepicker_end.getHour()+":"+timepicker_end.getMinute();
                        day_new.type = day_task_type.getText().toString();
                        day_new.list = day_task_list.getText().toString();
                        ColorSelector colorSelector1 = new ColorSelector();
                        day_new.color = colorSelector1.Selector(isCurrent.getId());
                        updatePlan(day_new);

                        DayPlan day = mDayPlanList.get(position);
                        holder.date.setText(day.date);
                        holder.start_time.setText(day.start_time);
                        holder.end_time.setText(day.end_time);
                        holder.type.setText(day.type);
                        holder.up_bg.setBackgroundColor(day.color);
                        holder.list.setText(day.list);
                        holder.down_bg.setBackgroundColor(day.color);

                        editDialog.dismiss();
                    }
                });

                no_day.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editDialog.dismiss(); //让对话框消失
                    }
                });

                tv_date = editDialog.findViewById(R.id.tv_date);
                tv_date.setText(holder.date.getText());

                day_task_type = editDialog.findViewById(R.id.day_task_type);
                day_task_type.setText(holder.type.getText());

                day_task_list = editDialog.findViewById(R.id.day_task_list);
                day_task_list.setText(holder.list.getText());


                //颜色选择器
                tab1 = editDialog.findViewById(R.id.one_one);
                tab2 = editDialog.findViewById(R.id.one_two);
                tab3 = editDialog.findViewById(R.id.one_three);
                tab4 = editDialog.findViewById(R.id.one_four);
                tab5 = editDialog.findViewById(R.id.one_five);
                tab6 = editDialog.findViewById(R.id.two_one);
                tab7 = editDialog.findViewById(R.id.two_two);
                tab8 = editDialog.findViewById(R.id.two_three);
                tab9 = editDialog.findViewById(R.id.two_four);
                tab10 = editDialog.findViewById(R.id.two_five);
                tab11 = editDialog.findViewById(R.id.three_one);
                tab12 = editDialog.findViewById(R.id.three_two);
                tab13 = editDialog.findViewById(R.id.three_three);
                tab14 = editDialog.findViewById(R.id.three_four);
                tab15 = editDialog.findViewById(R.id.three_five);
                tab16 = editDialog.findViewById(R.id.four_one);
                tab17 = editDialog.findViewById(R.id.four_two);
                tab18 = editDialog.findViewById(R.id.four_three);
                tab19 = editDialog.findViewById(R.id.four_four);
                tab20 = editDialog.findViewById(R.id.four_five);
                tab21 = editDialog.findViewById(R.id.five_one);
                tab22 = editDialog.findViewById(R.id.five_two);
                tab23 = editDialog.findViewById(R.id.five_three);
                tab24 = editDialog.findViewById(R.id.five_four);
                tab25 = editDialog.findViewById(R.id.five_five);
                tab26 = editDialog.findViewById(R.id.six_one);
                tab27 = editDialog.findViewById(R.id.six_two);
                tab28 = editDialog.findViewById(R.id.six_three);
                tab29 = editDialog.findViewById(R.id.six_four);
                tab30 = editDialog.findViewById(R.id.six_five);
                tab31 = editDialog.findViewById(R.id.seven_one);
                tab32 = editDialog.findViewById(R.id.seven_two);
                tab33 = editDialog.findViewById(R.id.seven_three);
                tab34 = editDialog.findViewById(R.id.seven_four);
                tab35 = editDialog.findViewById(R.id.seven_five);

                if(day.color == 0xFFD84242) isCurrent = tab1;
                if(day.color == 0xFFC85353) isCurrent = tab2;
                if(day.color == 0xFFE08994) isCurrent = tab3;
                if(day.color == 0xFFF8B5BE) isCurrent = tab4;
                if(day.color == 0xFFFFD9DD) isCurrent = tab5;

                if(day.color == 0xFFDF8E00) isCurrent = tab6;
                if(day.color == 0xFFDA9F38) isCurrent = tab7;
                if(day.color == 0xFFE8B968) isCurrent = tab8;
                if(day.color == 0xFFF8D79F) isCurrent = tab9;
                if(day.color == 0xFFFFEAC6) isCurrent = tab10;

                if(day.color == 0xFFE2C602) isCurrent = tab11;
                if(day.color == 0xFFE8D64F) isCurrent = tab12;
                if(day.color == 0xFFE9DA6D) isCurrent = tab13;
                if(day.color == 0xFFF1E8A4) isCurrent = tab14;
                if(day.color == 0xFFFAF6D9) isCurrent = tab15;

                if(day.color == 0xFF008409) isCurrent = tab16;
                if(day.color == 0xFF289B30) isCurrent = tab17;
                if(day.color == 0xFF62BA5B) isCurrent = tab18;
                if(day.color == 0xFF8BD46B) isCurrent = tab19;
                if(day.color == 0xFFBAE3A8) isCurrent = tab20;

                if(day.color == 0xFF2C63C8) isCurrent = tab21;
                if(day.color == 0xFF4E7CD0) isCurrent = tab22;
                if(day.color == 0xFF7D9FDD) isCurrent = tab23;
                if(day.color == 0xFFA5BDEA) isCurrent = tab24;
                if(day.color == 0xFFC2D4F5) isCurrent = tab25;

                if(day.color == 0xFF7E40B4) isCurrent = tab26;
                if(day.color == 0xFF9749D8) isCurrent = tab27;
                if(day.color == 0xFFBD84ED) isCurrent = tab28;
                if(day.color == 0xFFD4A4FB) isCurrent = tab29;
                if(day.color == 0xFFE7C9FF) isCurrent = tab30;

                if(day.color == 0xFF787878) isCurrent = tab31;
                if(day.color == 0xFF9E9999) isCurrent = tab32;
                if(day.color == 0xFFC4C4C4) isCurrent = tab33;
                if(day.color == 0xFFE0E0E0) isCurrent = tab34;
                if(day.color == 0xFFFFFFFF) isCurrent = tab35;

                isCurrent.setSelected(true);
                hasColor = true;

                tab1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab1.setSelected(true);
                            isCurrent = tab1;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab1) {
                                tab1.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab1.setSelected(true);
                                isCurrent = tab1;
                            }
                        }

                    }
                });
                tab2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab2.setSelected(true);
                            isCurrent = tab2;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab2) {
                                tab2.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab2.setSelected(true);
                                isCurrent = tab2;
                            }
                        }
                    }
                });
                tab3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab3.setSelected(true);
                            isCurrent = tab3;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab3) {
                                tab3.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab3.setSelected(true);
                                isCurrent = tab3;
                            }
                        }
                    }
                });
                tab4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab4.setSelected(true);
                            isCurrent = tab4;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab4) {
                                tab4.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab4.setSelected(true);
                                isCurrent = tab4;
                            }
                        }
                    }
                });
                tab5.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab5.setSelected(true);
                            isCurrent = tab5;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab5) {
                                tab5.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab5.setSelected(true);
                                isCurrent = tab5;
                            }
                        }
                    }
                });
                tab6.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab6.setSelected(true);
                            isCurrent = tab6;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab6) {
                                tab6.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab6.setSelected(true);
                                isCurrent = tab6;
                            }
                        }
                    }
                });
                tab7.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab7.setSelected(true);
                            isCurrent = tab7;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab7) {
                                tab7.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab7.setSelected(true);
                                isCurrent = tab7;
                            }
                        }
                    }
                });
                tab8.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab8.setSelected(true);
                            isCurrent = tab8;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab8) {
                                tab8.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab8.setSelected(true);
                                isCurrent = tab8;
                            }
                        }
                    }
                });
                tab9.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab9.setSelected(true);
                            isCurrent = tab9;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab9) {
                                tab9.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab9.setSelected(true);
                                isCurrent = tab9;
                            }
                        }
                    }
                });
                tab10.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab10.setSelected(true);
                            isCurrent = tab10;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab10) {
                                tab10.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab10.setSelected(true);
                                isCurrent = tab10;
                            }
                        }
                    }
                });

                tab11.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab11.setSelected(true);
                            isCurrent = tab11;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab11) {
                                tab11.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab11.setSelected(true);
                                isCurrent = tab11;
                            }
                        }

                    }
                });
                tab12.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab12.setSelected(true);
                            isCurrent = tab12;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab12) {
                                tab12.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab12.setSelected(true);
                                isCurrent = tab12;
                            }
                        }
                    }
                });
                tab13.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab13.setSelected(true);
                            isCurrent = tab13;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab13) {
                                tab13.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab13.setSelected(true);
                                isCurrent = tab13;
                            }
                        }
                    }
                });
                tab14.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab14.setSelected(true);
                            isCurrent = tab14;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab14) {
                                tab14.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab14.setSelected(true);
                                isCurrent = tab14;
                            }
                        }
                    }
                });
                tab15.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab15.setSelected(true);
                            isCurrent = tab15;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab15) {
                                tab15.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab15.setSelected(true);
                                isCurrent = tab15;
                            }
                        }
                    }
                });
                tab16.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab16.setSelected(true);
                            isCurrent = tab16;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab16) {
                                tab16.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab16.setSelected(true);
                                isCurrent = tab16;
                            }
                        }
                    }
                });
                tab17.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab17.setSelected(true);
                            isCurrent = tab17;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab17) {
                                tab17.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab17.setSelected(true);
                                isCurrent = tab17;
                            }
                        }
                    }
                });
                tab18.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab18.setSelected(true);
                            isCurrent = tab18;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab18) {
                                tab18.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab18.setSelected(true);
                                isCurrent = tab18;
                            }
                        }
                    }
                });
                tab19.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab19.setSelected(true);
                            isCurrent = tab19;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab19) {
                                tab19.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab19.setSelected(true);
                                isCurrent = tab19;
                            }
                        }
                    }
                });
                tab20.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab20.setSelected(true);
                            isCurrent = tab20;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab20) {
                                tab20.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab20.setSelected(true);
                                isCurrent = tab20;
                            }
                        }
                    }
                });

                tab21.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab21.setSelected(true);
                            isCurrent = tab21;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab21) {
                                tab21.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab21.setSelected(true);
                                isCurrent = tab21;
                            }
                        }

                    }
                });
                tab22.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab22.setSelected(true);
                            isCurrent = tab22;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab22) {
                                tab22.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab22.setSelected(true);
                                isCurrent = tab22;
                            }
                        }
                    }
                });
                tab23.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab23.setSelected(true);
                            isCurrent = tab23;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab23) {
                                tab23.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab23.setSelected(true);
                                isCurrent = tab23;
                            }
                        }
                    }
                });
                tab24.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab24.setSelected(true);
                            isCurrent = tab24;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab24) {
                                tab24.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab24.setSelected(true);
                                isCurrent = tab24;
                            }
                        }
                    }
                });
                tab25.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab25.setSelected(true);
                            isCurrent = tab25;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab25) {
                                tab25.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab25.setSelected(true);
                                isCurrent = tab25;
                            }
                        }
                    }
                });
                tab26.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab26.setSelected(true);
                            isCurrent = tab26;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab26) {
                                tab26.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab26.setSelected(true);
                                isCurrent = tab26;
                            }
                        }
                    }
                });
                tab27.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab27.setSelected(true);
                            isCurrent = tab27;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab27) {
                                tab27.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab27.setSelected(true);
                                isCurrent = tab27;
                            }
                        }
                    }
                });
                tab28.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab28.setSelected(true);
                            isCurrent = tab28;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab28) {
                                tab28.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab28.setSelected(true);
                                isCurrent = tab28;
                            }
                        }
                    }
                });
                tab29.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab29.setSelected(true);
                            isCurrent = tab29;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab29) {
                                tab29.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab29.setSelected(true);
                                isCurrent = tab29;
                            }
                        }
                    }
                });
                tab30.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab30.setSelected(true);
                            isCurrent = tab30;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab30) {
                                tab30.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab30.setSelected(true);
                                isCurrent = tab30;
                            }
                        }
                    }
                });

                tab31.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab31.setSelected(true);
                            isCurrent = tab31;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab31) {
                                tab31.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab31.setSelected(true);
                                isCurrent = tab31;
                            }
                        }

                    }
                });
                tab32.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab32.setSelected(true);
                            isCurrent = tab32;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab32) {
                                tab32.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab32.setSelected(true);
                                isCurrent = tab32;
                            }
                        }
                    }
                });
                tab33.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab33.setSelected(true);
                            isCurrent = tab33;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab33) {
                                tab33.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab33.setSelected(true);
                                isCurrent = tab33;
                            }
                        }
                    }
                });
                tab34.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab34.setSelected(true);
                            isCurrent = tab34;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab34) {
                                tab34.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab34.setSelected(true);
                                isCurrent = tab34;
                            }
                        }
                    }
                });
                tab35.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if(hasColor == false){
                            tab35.setSelected(true);
                            isCurrent = tab35;
                            hasColor = true;
                        }else{
                            if(isCurrent == tab35) {
                                tab35.setSelected(false);
                                hasColor =false;
                            }
                            else{
                                isCurrent.setSelected(false);
                                tab35.setSelected(true);
                                isCurrent = tab35;
                            }
                        }
                    }
                });
            }
        });


        return convertView;
    }


}
