package com.aituling.testuipickerview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aituling.uipickview.TimePickerView;
import com.aituling.uipickview.view.WheelTimeType;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends Activity {
    Button button;
    TextView result_tv;
    private TimePickerView pvTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result_tv = (TextView) findViewById(R.id.result_tv);
    }

    public void pickviewOnclick(View view) {
        Calendar calendar = Calendar.getInstance();
        switch (view.getId()) {
            case R.id.ALLbutton:
                pvTime = new TimePickerView(this, WheelTimeType.ALL);
                pvTime.setTitle("日期时间选择");
                //控制时间范围
                pvTime.setRange(calendar.get(Calendar.YEAR) - 20, calendar.get(Calendar.YEAR) + 20);//要在setTime 之前才有效果哦
                pvTime.setTime(null);
                pvTime.setCyclic(true);
                pvTime.setCancelable(true);
                //时间选择后回调
                pvTime.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date) {
                        SimpleDateFormat format = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
                        result_tv.setText(format.format(date));
                    }
                });
                pvTime.show();
                break;
            case R.id.YMDbutton:
                pvTime = new TimePickerView(this, WheelTimeType.YEAR_MONTH_DAY);
                pvTime.setTitle("年月日选择");
                //控制时间范围
                pvTime.setCyclic(true);
                pvTime.setCancelable(true);
                //时间选择后回调
                pvTime.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date) {
                        SimpleDateFormat format = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
                        result_tv.setText(format.format(date));
                    }
                });
                pvTime.show();
                break;
            case R.id.SJbutton:
                pvTime = new TimePickerView(this, WheelTimeType.HOURS_MINS);
                pvTime.setTitle("时间选择");
                //控制时间范围
                pvTime.setCyclic(true);
                pvTime.setCancelable(true);
                //时间选择后回调
                pvTime.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date) {
                        SimpleDateFormat format = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
                        result_tv.setText(format.format(date));
                    }
                });
                pvTime.show();
                break;
            case R.id.MDTimebutton:
                pvTime = new TimePickerView(this, WheelTimeType.MONTH_DAY_HOUR_MIN);
                pvTime.setTitle("月日时间");
                //控制时间范围
                pvTime.setCyclic(true);
                pvTime.setCancelable(true);
                //时间选择后回调
                pvTime.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date) {
                        SimpleDateFormat format = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
                        result_tv.setText(format.format(date));
                    }
                });
                pvTime.show();
                break;
        }

    }
}
