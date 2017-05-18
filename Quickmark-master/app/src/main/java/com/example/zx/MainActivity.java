package com.example.zx;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    /**
     * 扫描跳转Activity RequestCode
     */
    public static final int REQUEST_CODE = 111;
    public static final int REQUEST_CODE2 = 222;

    /**
     * 扫描跳转按钮
     */
    private Button btn=null;
    private Button btn2=null;
    EditText text1=null;
    EditText text2=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=(Button)findViewById(R.id.mybtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });

        btn2=(Button)findViewById(R.id.mybtn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
//                text1=(EditText)findViewById(R.id.mytext);
//                text1.setText("clicked ".toString());
                Intent intent2 = new Intent(MainActivity.this, CaptureActivity.class);
                startActivityForResult(intent2,REQUEST_CODE2);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /**
         * 处理二维码扫描结果
         */
        if (requestCode == REQUEST_CODE) {
            text1 = (EditText) findViewById(R.id.mytext2);
            text1.setText("request happend!");
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    //用默认浏览器打开扫描得到的地址
//                   EditText text1=null;
//                    text1=(EditText)findViewById(R.id.mytext);
//                    text1.setText(result);
//                    Intent intent = new Intent();
//                    intent.setAction("android.intent.action.VIEW");
//                    Uri content_url = Uri.parse(result.toString());
//                    intent.setData(content_url);
//                    startActivity(intent);
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }else if(requestCode == REQUEST_CODE2){
            text1 = (EditText) findViewById(R.id.mytext);
            text1.setText("request no happend!!");
        }
    }
}
