# UIpickerview
时间日期选择器

# 项目中引用
  android studio 直接complie
  
  compile 'com.aituling.uipickview:uipickview:1.0.2'
# 用法

  ### 创建一个时间-日期选择器
               
                ALL, YEAR_MONTH_DAY, HOURS_MINS, MONTH_DAY_HOUR_MIN, YEAR_MONTH
                // 四种选择模式，年月日时分，年月日，时分，月日时分
                TimePickerView  pvTime = new TimePickerView(this, WheelTimeType.ALL);
                pvTime.setTitle("日期时间选择");
                //控制时间范围，要在setTime 之前才有效果哦，可以不设置
                pvTime.setRange(calendar.get(Calendar.YEAR) - 20, calendar.get(Calendar.YEAR) + 20);
                pvTime.setTime(null);//设置默认的时间，null表示当前 如果设置了range就一定要设置time
                pvTime.setCyclic(true); //设置是否可循环
                pvTime.setCancelable(true);//设置窗口是否可以取消
                //时间选择后回调
                pvTime.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date) {
                        SimpleDateFormat format = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
                        result_tv.setText(format.format(date));
                    }
                });
                pvTime.show();
                
 ### 创建一个条件选择器
 
                OptionsPickerView  opPickView = new OptionsPickerView(this);
                opPickView.setWheelTextSize(14);//文字默认大小为16 ，大小设置要在setPicker之前设置
                //设置数据 ，及数据是否进行关联
                opPickView.setPicker(options1Items, options2Items, true); 
                opPickView.setLabels("省", "市");
                //设置是否可以循环
                opPickView.setCyclic(false, false, false);
                //设置默认选中
                opPickView.setSelectOptions(1, 1);
                opPickView.setTitle("选择城市");
                //设置主体颜色
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
# end
 原来是github开源的项目，在其基础上进行拓展 ，感谢原作者 使用过程中有bug或好的建议qq1227328817
