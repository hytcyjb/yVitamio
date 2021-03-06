package yy.yjbo.showdialogfragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import yy.yjbo.yutil.BottomDialog;
import yy.yjbo.R;

/**
 * 引用：https://github.com/shaohui10086/BottomDialog.git
 * @author yjbo
 * @time 2017/4/17 23:02
 */
public class ShowFragmentActivity extends AppCompatActivity {
    /**
     * dialog.isVisible()这个属性可以判断是否dialog是否显示和隐藏；
     * @author yjbo  @time 2017/4/17 22:28
     */
    private EditTextDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //取消标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        try {
            //会出现空指针的状态
            getSupportActionBar().hide();
        } catch (Exception ex) {
//            ex.printStackTrace();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_show);

        shareDialog();

        findViewById(R.id.show_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        findViewById(R.id.show_dialog2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareDialog();

            }
        });
    }
    
    private void shareDialog() {
        //ShareBottomDialog dialog = new ShareBottomDialog();
        //dialog.show(getSupportFragmentManager());
         dialog = new EditTextDialog();
        dialog.show(getSupportFragmentManager());

        dialog.setCancelable(false);

        boolean cancelOutside = dialog.getCancelOutside();
        System.out.println("==00==0="+ dialog.isVisible()
                +"-----"+dialog.isHidden()+"==是否可以取消外边=="+cancelOutside);


//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if (dialog != null){
//                System.out.println("==00==1="+ dialog.isVisible()
//                        +"-----"+dialog.isHidden()+"===");
//                dialog.dismiss();
//                }
//            }
//        },5*1000);
//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if (dialog != null){
//                System.out.println("==00==2="+ dialog.isVisible()
//                        +"-----"+dialog.isHidden()+"===");
//                }
//            }
//        },6*1000);
    }

    private void showDialog() {
        BottomDialog.create(getSupportFragmentManager())
                .setViewListener(new BottomDialog.ViewListener() {
                    @Override
                    public void bindView(View v) {
                        initView(v);
                    }
                })
                .setLayoutRes(R.layout.dialog_layout)
                .setDimAmount(0.9f)
                .setTag("BottomDialog")
                .show();
    }

    private void initView(final View view) {
        //final EditText editText = (EditText) view.findViewById(R.id.edit_text);
        //editText.post(new Runnable() {
        //    @Override
        //    public void run() {
        //        InputMethodManager inputMethodManager =
        //                (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        //        inputMethodManager.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
        //    }
        //});
        //editText.setText("Hello world");
    }
    Handler mHandler = new Handler();

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        System.out.println("==00==2="+ dialog.isVisible()
                +"-----"+dialog.isHidden()+"===");

//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            if (dialog != null) {
//                dialog.dismiss();
//            }
//        }
        return super.onKeyDown(keyCode, event);
    }
}
