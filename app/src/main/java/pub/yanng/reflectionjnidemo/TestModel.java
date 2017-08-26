package pub.yanng.reflectionjnidemo;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Yan on 2017/8/25.
 */

public class TestModel {

    private Context context;

    public TestModel(Context context){
        this.context = context;
    }

    public void sayHello(String word){
        Toast.makeText(context,word,Toast.LENGTH_SHORT).show();
    }

    public int plusNum(int x,int y){
        return x+y;
    }

    public void setValue(String value){
        Toast.makeText(context,"your value is "+value,Toast.LENGTH_SHORT).show();
    }

}
