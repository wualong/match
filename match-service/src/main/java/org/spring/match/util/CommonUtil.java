package org.spring.match.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CommonUtil {

    public CommonUtil(){}

    /**
     * yyyy-MM-dd
     */
    public static final SimpleDateFormat DATE_SDF = new SimpleDateFormat(
            "yyyy-MM-dd");


    public static final String CITY_KEY = "city:serial";

    public static final Integer SCL=6;
    /**
     * @Description 随机获取指定范围的系数结果
     * @param minParameter
     * @param maxParameter
     * @return
     */
    public static Double getRandomCoefficient(double minParameter,double maxParameter){
        int pow = (int) Math.pow(10, SCL);//指定小数位
        double result = Math.floor((Math.random() * (maxParameter - minParameter) + minParameter) * pow) / pow;
        return result;
    }

    /**
     * 日期转换为字符串
     *
     * @param date_sdf
     *        日期格式
     * @return 字符串
     */
    public static String date2Str(SimpleDateFormat date_sdf) {
        Date date=new Date();
        if (null == date) {
            return null;
        }
        return date_sdf.format(date);
    }

    /**
     * 随机湖区订单总额系数
     * @return Integer
     */
    public static Integer randomGetOrderMoney(Integer min,Integer max){
        Integer random = new Random().nextInt(max-min)+min;
        return random;
    }

}
