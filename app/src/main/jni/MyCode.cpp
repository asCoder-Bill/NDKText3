#include "com_example_bill_ndktext3_Load.h"
#include <string.h>
//
// Created by Administrator on 2016/9/18 0018.
//
JNIEXPORT jint JNICALL Java_com_example_bill_ndktext3_Load_addInt (JNIEnv *, jobject, jint a, jint b) {
    return a + b; //输入整数，输出整数
}
JNIEXPORT jdouble JNICALL Java_com_example_bill_ndktext3_Load_mulDouble (JNIEnv *, jobject, jdouble a, jdouble b) {
    return a * b; //输入实数，输出实数
}
JNIEXPORT jboolean JNICALL Java_com_example_bill_ndktext3_Load_bigger (JNIEnv *, jobject, jfloat a, jfloat b) {
    return a > b; //输入float型实数，输出布尔值，判断a是否大于b
}
char * JstringToCstr(JNIEnv * env, jstring jstr) { //jstring转换为C++的字符数组指针
    char * pChar = NULL;
    jclass classString = env->FindClass("java/lang/String");
    jstring code = env->NewStringUTF("GB2312");
    jmethodID id = env->GetMethodID(classString, "getBytes", "(Ljava/lang/String;)[B");
    jbyteArray arr = (jbyteArray)env->CallObjectMethod(jstr, id, code);
    jsize size = env->GetArrayLength(arr);
    jbyte * bt = env->GetByteArrayElements(arr, JNI_FALSE);
    if(size > 0) {
        pChar = (char*)malloc(size + 1);
        memcpy(pChar, bt, size);
        pChar[size] = 0;
    }
    env->ReleaseByteArrayElements(arr, bt, 0);
    return pChar;
}
JNIEXPORT jstring JNICALL Java_com_example_bill_ndktext3_Load_addString (JNIEnv * env, jobject, jstring a, jstring b) {
    char * pA = JstringToCstr(env, a); //取得a的C++指针
    char * pB = JstringToCstr(env, b); //取得b的C++指针
    return env->NewStringUTF(strcat(pA, pB)); //输出a+b
}
JNIEXPORT jintArray JNICALL Java_com_example_bill_ndktext3_Load_intArray (JNIEnv * env, jobject, jintArray a) {
    //输入整数数组，将其每个元素加10后输出
    //输入值为a，输出值为b
    int N = env->GetArrayLength(a); //获取a的元素个数
    jint * pA = env->GetIntArrayElements(a, NULL); //获取a的指针
    jintArray b = env->NewIntArray(N); //创建数组b，长度为N
    jint * pB = env->GetIntArrayElements(b, NULL); //获取b的指针
    for (int i = 0; i < N; i++) pB = pA + 10; //把a的每个元素加10，赋值给b中对应的元素
    /*//另一种方法
    env->SetIntArrayRegion(b, 0, N, pA); //b是a的复制品
    for (int j = 0; j < N; j++) pB[j] += 10; //b的每个元素加10
    */
    env->ReleaseIntArrayElements(a, pA, 0); //释放a的内存
    env->ReleaseIntArrayElements(b, pB, 0); //释放b的内存
    return b; //输出b
}
JNIEXPORT jdoubleArray JNICALL Java_com_example_bill_ndktext3_Load_doubleArray (JNIEnv * env, jobject, jdoubleArray a) {
    //输入实数数组，将其每个元素乘2后输出
    //输入值为a，输出值为b
    int N = env->GetArrayLength(a); //获取a的元素个数
    jdouble * pA = env->GetDoubleArrayElements(a, NULL); //获取a的指针
    jdoubleArray b = env->NewDoubleArray(N); //创建数组b，长度为N
    jdouble * pB = env->GetDoubleArrayElements(b, NULL); //获取b的指针
    /*for (int i = 0; i < N; i++) pB = pA * 2; //把a的每个元素乘2，赋值给b中对应的元素*/
    //另一种方法
    env->SetDoubleArrayRegion(b, 0, N, pA); //b是a的复制品
    for (int j = 0; j < N; j++) pB[j] *= 2; //b的每个元素乘2

    env->ReleaseDoubleArrayElements(a, pA, 0); //释放a的内存
    env->ReleaseDoubleArrayElements(b, pB, 0); //释放b的内存
    return b; //输出b
}
JNIEXPORT jobjectArray JNICALL Java_com_example_bill_ndktext3_Load_stringArray (JNIEnv * env, jobject, jobjectArray a) {
    //输入字符串数组，颠倒顺序后输出
    //输入值为a，输出值为b
    int N = env->GetArrayLength(a); //获取a的元素个数
    jobjectArray b = env->NewObjectArray(N, env->FindClass("java/lang/String"), env->NewStringUTF("")); //创建数组b，长度为N
    for (int i = 0; i < N; i++) { //对于a中的每个元素
        jstring ai = (jstring)env->GetObjectArrayElement(a, i); //读出这个元素的值
        env->SetObjectArrayElement(b, N - 1 - i, ai); //赋值给b中倒序对应的元素
        env->DeleteLocalRef(ai);//释放内存
    }
    return b; //输出b
}
