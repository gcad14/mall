package com.gc.groovyTest;
import org.junit.Test;

public class TestA {

    @Test
    public void aaa(){
        String s = convertScientificNotation(130.546);
        System.out.println(s);
        System.out.println(s);
        System.out.println(s);
        System.out.println(s);
    }

    /**
     * 转换为科学计数法
     * @param num
     * @return
     */
    public String convertScientificNotation(double num){
        String neg="";
        int n=0;
        if (num<0){
            num*=-1;
            neg="-";
            n = (int) Math.log10(num);
        }else if (num>0){
            n = (int) Math.log10(num);
        }else {
            n=0;
        }
        num  = num/Math.pow(10,n);
        //保留两位小数
        int number=1;
        num*=Math.pow(10,number);
        num = Math.round(num);
        num /= Math.pow(10,number);
        String str="";
        if (num<1 && num>-1 && num!=0){
            num*=10;
            --n;
            str = neg + num +"E"+(n>0?"+"+n:n);
        }else {
            str = neg + num +"E"+(n>0?"+"+n:n);
        }
        return str;
    }
}
