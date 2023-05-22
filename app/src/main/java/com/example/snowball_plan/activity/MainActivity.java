package com.example.snowball_plan.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.snowball_plan.R;
import com.example.snowball_plan.adapter.MyFragmentPagerAdapter;
import com.example.snowball_plan.adapter.MyFragmentStateVPAdapter;
import com.example.snowball_plan.fragment.BlankFragment;
import com.example.snowball_plan.fragment.DayFragment;
import com.example.snowball_plan.fragment.VPYearFragment;
import com.example.snowball_plan.tools.YearDialog;

import java.util.ArrayList;
import java.util.List;

import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //年外fragment参数
    private ViewPager2 mviewPagerYear;
    private LinearLayout llYear,llMonth,llDay;
    private ImageView ivYear,ivMonth,ivDay,ivCurrent;
    private List<Fragment> mFragmentList;

//    private MyDatabaseHelper myDatabaseHelper_t;

    private MyFragmentStateVPAdapter myFragmentStateVPAdapter;
    private EditText year_task_type,year_task_list,year_task_color;

    private CheckBox ione,itwo,ithree,ifour,ifive,isix,iseven,ieight,inine,iten,ieleven,itwelve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //状态栏设置
        setStatusBar();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteStudioService.instance().start(this);

        //logo字体设置
        TextView logo = findViewById(R.id.logo);
        Typeface face_logo = Typeface.createFromAsset(getAssets(), "fonts/mango.otf");
        logo.setTypeface(face_logo);

        //年月日选择器
        mviewPagerYear = findViewById(R.id.vp_year);
        initTabView();
        initPager();

        //新建按钮
        findViewById(R.id.build).setOnClickListener(this::onClickBuild);

    }

    //新建任务
    private void onClickBuild(View view) {

        if(ivCurrent == ivYear){
            YearDialog yearDialog = new YearDialog(this,R.style.BuildDialog);
            yearDialog.show();
        }

        if(ivCurrent == ivDay){
//            DayDialog dayDialog = new DayDialog(this,R.style.BuildDialog);
//            dayDialog.show();
        }

//        myDatabaseHelper = new MyDatabaseHelper(this,"sbp.db",null,1);
////        myDatabaseHelper_t = new MyDatabaseHelper(this,"test.db",null,1);
//        SQLiteDatabase db =myDatabaseHelper.getWritableDatabase();


//
//        ContentValues values_year = new ContentValues();
//        ContentValues values_month = new ContentValues();
//        ContentValues values_task_type = new ContentValues();
//        ContentValues values_task_list = new ContentValues();
//        ContentValues values_task_color = new ContentValues();
//        ContentValues values_task = new ContentValues();
//
//        ione = findViewById(R.id.ione);
//        itwo = findViewById(R.id.itwo);
//        ithree = findViewById(R.id.ithree);
//        ifour = findViewById(R.id.ifour);
//        ifive = findViewById(R.id.ifive);
//        isix = findViewById(R.id.isix);
//        iseven = findViewById(R.id.iseven);
//        ieight = findViewById(R.id.ieight);
//        inine = findViewById(R.id.inine);
//        iten = findViewById(R.id.iten);
//        ieleven = findViewById(R.id.ieleven);
//        itwelve = findViewById(R.id.itwelve);
//
//        String plan_month = "";
//
//        if(ione.isSelected() == true){
//            plan_month += "1月,";
//        }
//        if(itwo.isSelected() == true){
//            plan_month += "2月,";
//        }
//        if(ithree.isSelected() == true){
//            plan_month += "3月,";
//        }
//        if(ifour.isSelected() == true){
//            plan_month += "4月,";
//        }
//        if(ifive.isSelected() == true){
//            plan_month += "5月,";
//        }
//        if(isix.isSelected() == true){
//            plan_month += "6月,";
//        }
//        if(iseven.isSelected() == true){
//            plan_month += "7月,";
//        }
//        if(ieight.isSelected() == true){
//            plan_month += "8月,";
//        }
//        if(inine.isSelected() == true){
//            plan_month += "9月,";
//        }
//        if(iten.isSelected() == true){
//            plan_month += "10月,";
//        }
//        if(ieleven.isSelected() == true){
//            plan_month += "11月,";
//        }
//        if(itwelve.isSelected() == true){
//            plan_month += "12月,";
//        }

        //计划的年份
//        values_year.put("year_type", String.valueOf(myFragmentStateVPAdapter.getItem(R.id.tab_layout_year)));
//        db.insert("year_type",null,values_year);
//
//        //计划月份
//        values_month.put("task_type",plan_month);
//        db.insert("task_type",null,values_month);


//        //计划类别
//        year_task_type = findViewById(R.id.year_task_type);
//        String ytt = String.valueOf(year_task_type.getText());
//        values_task_type.put("task_type",ytt);
//
//        //计划清单
//        year_task_list = findViewById(R.id.year_task_list);
//        String yyl = String.valueOf(year_task_list.getText());
//        values_task_list.put("task_list",yyl);

        //计划颜色
//        YearDialog yearDialog = new YearDialog();
//        year_task_color = findViewById()
    }


    private void initPager() {
        mviewPagerYear = findViewById(R.id.vp_year);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(VPYearFragment.newInstance("年",""));
        fragments.add(BlankFragment.newInstance("月",""));
        fragments.add(DayFragment.newInstance("日",""));

        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),getLifecycle(),fragments);
        mviewPagerYear.setAdapter(myFragmentPagerAdapter);
        mviewPagerYear.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private void initTabView() {
        llYear = findViewById(R.id.id_tab_year);
        llYear.setOnClickListener(this);
        llMonth = findViewById(R.id.id_tab_month);
        llMonth.setOnClickListener(this);
        llDay = findViewById(R.id.id_tab_day);
        llDay.setOnClickListener(this);

        ivYear = findViewById(R.id.tab_iv_year);
        ivMonth = findViewById(R.id.tab_iv_month);
        ivDay = findViewById(R.id.tab_iv_day);

        ivYear.setSelected(true);
        ivCurrent = ivYear;
    }

    private void changeTab(int position) {

        switch (position){
            case 0:
                ivCurrent.setSelected(false);
                ivYear.setSelected(true);
                ivCurrent = ivYear;
                break;
            case 1:
                ivCurrent.setSelected(false);
                ivMonth.setSelected(true);
                ivCurrent = ivMonth;
                break;
            case 2:
                ivCurrent.setSelected(false);
                ivDay.setSelected(true);
                ivCurrent = ivDay;
                break;
        }

    }

    private void judge(int position){

        if(position == R.id.id_tab_year){
            mviewPagerYear.setCurrentItem(0);
        }else if(position == R.id.id_tab_month){
            mviewPagerYear.setCurrentItem(1);
        }else if(position == R.id.id_tab_day){
            mviewPagerYear.setCurrentItem(2);
        }
    }

    @Override
    public void onClick(View v) {
        changeTab(v.getId());
        judge(v.getId());
    }


































    //状态栏设置
    //是否使用特殊的标题栏背景颜色，android5.0以上可以设置状态栏背景色，如果不使用则使用透明色值
    public boolean useThemestatusBarColor = false;
    //是否使用状态栏文字和图标为暗色，如果状态栏采用了白色系，则需要使状态栏和图标为暗色，android6.0以上可以设置
    public boolean useStatusBarColor = true;

    public void setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0及以上
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            //根据上面设置是否对状态栏单独设置颜色
            if (useThemestatusBarColor) {
                getWindow().setStatusBarColor(getResources().getColor(R.color.white));//设置状态栏背景色
            } else {
                getWindow().setStatusBarColor(Color.TRANSPARENT);//透明
            }
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4到5.0
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        } else {
            Toast.makeText(this, "低于4.4的android系统版本不存在沉浸式状态栏", Toast.LENGTH_SHORT).show();
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && useStatusBarColor) {//android6.0以后可以对状态栏文字颜色和图标进行修改
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

    }

}