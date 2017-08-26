#include <jni.h>
#include <stdlib.h>

/*
 * Class:     pub_yanng_reflectionjnidemo_JNI
 * Method:    callbackvoid
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_pub_yanng_reflectionjnidemo_JNI_callbackvoid
  (JNIEnv *env, jobject thiz){
    //找到字节码 findClass第一个参数env 第二个参数 要找的字节码对应类的路径
    //jclass  （*FindClass)(JNIEnv*,const char*);
    jclass clazz = (*env)->FindClass(env,"pub/yanng/reflectionjnidemo/JNI");
    //找到方法
    jmethodID methodID = (*env)->GetMethodID(env,clazz,"onRecall","()V");
    //创建对象（可选）
    //通过对象调用方法
    //第一个参数 JNIEvn
    //第二个参数 要调用的对象
    //第三个参数 要调用的方法的methodid变量
    //...可变参数，调用方法如果有参数，就是后面可变参数，要传入的值
    (*env)->CallVoidMethod(env,thiz,methodID);
  }

/*
 * Class:     pub_yanng_reflectionjnidemo_JNI
 * Method:    callbackInt
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_pub_yanng_reflectionjnidemo_JNI_callbackInt
  (JNIEnv *env, jobject thiz){
    jclass clazz = (*env)->FindClass(env,"pub/yanng/reflectionjnidemo/JNI");
    jmethodID methodID = (*env)->GetMethodID(env,clazz,"add","(II)V");
    //CallIntMethod 调用返回值为int的方法
    //CallVoidMethod 调用返回空的方法
    (*env)->CallVoidMethod(env,thiz,methodID,3,5);
  }

/*
 * Class:     pub_yanng_reflectionjnidemo_JNI
 * Method:    callbackString
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_pub_yanng_reflectionjnidemo_JNI_callbackString
  (JNIEnv *env, jobject thiz){
    jclass clazz = (*env)->FindClass(env,"pub/yanng/reflectionjnidemo/JNI");
    jmethodID methodID = (*env)->GetMethodID(env,clazz,"onRecall","(Ljava/lang/String;)V");
    jstring jstr = (*env)->NewStringUTF(env,"hello,Yan");
    (*env)->CallVoidMethod(env,thiz,methodID,jstr);
  }

/**
* 回调OnCallBackListener中的方法
**/
JNIEXPORT void JNICALL Java_pub_yanng_reflectionjnidemo_JNI_callbackInterface
  (JNIEnv *env, jobject thiz, jobject obj){
    jclass clazz = (*env)->GetObjectClass(env,obj);
    jmethodID methodID = (*env)->GetMethodID(env,clazz,"onCallBack","(Ljava/lang/String;)V");
    jstring jstr = (*env)->NewStringUTF(env,"这是返回的值");
    (*env)->CallVoidMethod(env,obj,methodID,jstr);
}