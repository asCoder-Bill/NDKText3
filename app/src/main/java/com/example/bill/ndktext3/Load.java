package com.example.bill.ndktext3;

/**
 * 作者：Bill on 2016/9/18 0018 01:34
 * 备注：
 */
public class Load {
    static {
        System.loadLibrary("myTttt");
    }

    public native int addInt(int a, int b); //输入整数，输出整数
    public native double mulDouble(double a, double b); //输入实数，输出实数
    public native boolean bigger(float a, float b); //输入float型实数，输出布尔值
    public native String addString(String a, String b); //输入字符串，输出字符串
    public native int[] intArray(int[] a); //输入整数数组，输出整数数组
    public native double[] doubleArray(double[] a); //输入实数数组，输出实数数组
    public native String[] stringArray(String[] a); //输入字符串数组，输出字符串数组
}
