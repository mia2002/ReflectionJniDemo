package pub.yanng.reflectionjnidemo;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MainActivity extends Activity {

    private JNI jni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jni = new JNI(MainActivity.this);
    }

    public void callVoid(View view){
        jni.callbackvoid();
    }

    public void callInt(View view){
        jni.callbackInt();
    }

    public void callString(View view){
        jni.callbackString();
    }

    /**
     * 回调接口方法 按钮点击事件
     * @param view
     */
    public void callInterface(View view){
        jni.callbackInterface(new OnCallBackListener() {
            @Override
            public void onCallBack(String result) {
                Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void sayHello(View view){

        try {
            //先找到class
//            String packageName = TestModel.class.getPackage().getName();
//            Log.i("sayHello","packageName:"+packageName);
//            Object obj = new TestModel(MainActivity.this);
//            Class clazz = object.getClass();
            Class clazz = Class.forName("pub.yanng.reflectionjnidemo.TestModel");
            //找到方法
            Method method = clazz.getMethod("sayHello",String.class);
            //创建对象
//            Object obj = clazz.newInstance();
            Constructor constructor = clazz.getConstructor(Context.class);
            Object obj = constructor.newInstance(MainActivity.this);
            //调用方法
            method.invoke(obj,"hello,yanyan!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
