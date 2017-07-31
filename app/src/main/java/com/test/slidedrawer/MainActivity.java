package com.test.slidedrawer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.SlidingDrawer;
import android.widget.TextView;

/**
 * @author MagicLon
 */
public class MainActivity extends Activity {
    private SlidingDrawer mdrawer;//定义一个抽屉控件
    private ImageButton mbutton;
    private TextView mtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findview();
        drawerlistener();
    }
    private void findview(){
        mdrawer = (SlidingDrawer)findViewById(R.id.slidingdrawer);
        mbutton = (ImageButton)findViewById(R.id.handle);
        mtext = (TextView)findViewById(R.id.TextView01);
    }

    private void drawerlistener(){
//这个事件是当抽屉打开时触发的事件，这里所指的“打开”是当抽屉完全到达顶部触发的事件，我们在这里改变了ImageButton按钮的图片
        mdrawer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener()
        {
            @Override
            public void onDrawerOpened() {
                mbutton.setImageResource(R.mipmap.ic_launcher_round);
            }

        });
        //这个事件当然就是和上面相对应的事件了。当抽屉完全关闭时触发的事件，我们将ImageButton的图片又变回了最初状态
        mdrawer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener(){
            @Override
            public void onDrawerClosed() {
                mbutton.setImageResource(R.mipmap.ic_launcher);
            }

        });
        //这个事件是抽屉的拖动事件，当抽屉在开始拖动和结束拖动时分别触发onScrollStarted() 和onScrollEnded() 事件
        mdrawer.setOnDrawerScrollListener(new SlidingDrawer.OnDrawerScrollListener(){
            //当手指离开抽屉头时触发此事件（松开ImageButton触发）
            @Override
            public void onScrollEnded() {
                mtext.setText("结束拖动");
            }

            //当按下抽屉头时触发此事件（按下ImageButton触发）
            @Override
            public void onScrollStarted() {
                mtext.setText("开始拖动");
            }

        });

    }
}
