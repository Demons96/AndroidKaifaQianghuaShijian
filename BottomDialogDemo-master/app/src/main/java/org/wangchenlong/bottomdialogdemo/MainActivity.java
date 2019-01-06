package org.wangchenlong.bottomdialogdemo;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 显示底部Dialog
    public void showBottomDialog(View view) {
        BottomDialogFragment editNameDialog = new BottomDialogFragment();
        editNameDialog.show(fm, "fragment_bottom_dialog");
    }

    /**
     * AlertDialog
     * @param view
     */
    public void myAlertDialog(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog
                .Builder(MainActivity.this)
                .setTitle("这是AlertDialog")
                .setMessage("这是消息")
                .setCancelable(false)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
                    }
                });

        alertDialog.show();
    }

    /**
     * 进度条弹框
     * @param view
     */
    public void myProgressDialog(View view) {
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("这是progressDialog");
        progressDialog.setMessage("这是消息");
        progressDialog.setCancelable(true);
        progressDialog.show();
    }

    public void myDialogFragment(View view) {
        MyBottomDialogFragment dialogFragment = new MyBottomDialogFragment();
        dialogFragment.show(fm, "myDialog");
    }
}
