package com.aituling.testuipickerview;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aituling.uipickview.OptionsPickerView;
import com.aituling.uipickview.TimePickerView;
import com.aituling.uipickview.view.WheelTimeType;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import jsonutils.AssetsUtils;
import jsonutils.JsonUtils;

import static jsonutils.JsonUtils.*;

public class MainActivity extends Activity {
    Button button;
    TextView result_tv;
    private TimePickerView pvTime;
    private OptionsPickerView opPickView;
    private ArrayList<ProvinceCityBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<ProvinceCityBean>> options2Items = new ArrayList<>();
    private List<CodeBean> codeBeanArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result_tv = (TextView) findViewById(R.id.result_tv);
        String jsonStr = AssetsUtils.getStringDataFromAssets(this, "area_code.txt");
        Log.d("jsonStr=", jsonStr);
        codeBeanArrayList = getListData(jsonStr, CodeBean.class);
        for (int i = 0; i < codeBeanArrayList.size(); i++) {
            ProvinceCityBean provinceCityBean = new ProvinceCityBean();
            CodeBean codeBean = codeBeanArrayList.get(i);
            provinceCityBean.setId(codeBean.getId());
            provinceCityBean.setName(codeBean.getName());
            options1Items.add(provinceCityBean);
            ArrayList<ProvinceCityBean> sonItems = new ArrayList<>();
            for (int j = 0; j < codeBean.getSon().size(); j++) {
                CodeBean.SonBean sonBean = codeBean.getSon().get(j);
                ProvinceCityBean provinceCityBean2 = new ProvinceCityBean();
                provinceCityBean2.setId(sonBean.getId());
                provinceCityBean2.setName(sonBean.getName());
                sonItems.add(provinceCityBean2);
            }
            options2Items.add(sonItems);

        }


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
            case R.id.Optinsbutton:
                opPickView = new OptionsPickerView(this);
                opPickView.setWheelTextSize(14);//文字默认大小为16 ，大小设置要在setPicker之前设置
                opPickView.setPicker(options1Items, options2Items, true);
                opPickView.setLabels("省", "市");
                opPickView.setCyclic(false, false, false);
                opPickView.setSelectOptions(1, 1);
                opPickView.setTitle("选择城市");
                opPickView.setWheelOptionsColors(this.getResources().getColor(android.R.color.black),
                        this.getResources().getColor(android.R.color.holo_red_light),
                        this.getResources().getColor(android.R.color.holo_red_light));
                opPickView.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        result_tv.setText(options1Items.get(options1).getPickViewText() +
                                options2Items.get(options1).get(option2).getPickViewText());
                    }
                });
                opPickView.show();
                break;
        }

    }
}
