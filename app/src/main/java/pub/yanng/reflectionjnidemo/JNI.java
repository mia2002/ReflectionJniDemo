package pub.yanng.reflectionjnidemo;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Yan on 2017/8/25.
 */

public class JNI {

    static {
        System.loadLibrary("reflect");
    }

    private Context context;

    public JNI(Context context){
        this.context = context;
    }

    /**
     * 回调方法
     */
    public void onRecall(){
        Toast.makeText(context,"我是回调空方法",Toast.LENGTH_SHORT).show();
    }

    /**
     * 带参回调方法
     * @param x
     * @param y
     */
    public void add(int x,int y){
        int result = x+y;
        Toast.makeText(context,result+"",Toast.LENGTH_SHORT).show();
    }

    /**
     * 带String类型参数的回调方法
     * @param str
     */
    public void onRecall(String str){
        Toast.makeText(context, str,Toast.LENGTH_SHORT).show();
    }

    /**
     * 回调onRecall()方法
     */
    public native void callbackvoid();

    /**
     * 回调add(int,int)方法
     */
    public native void callbackInt();

    /**
     * 回调onRecall(String)方法
     */
    public native void callbackString();

    /**
     * 回调OnCallBackListener接口方法
     * @param listener 回调的接口
     */
    public native void callbackInterface(OnCallBackListener listener);

}
