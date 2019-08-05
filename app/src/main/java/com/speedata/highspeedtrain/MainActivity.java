package com.speedata.highspeedtrain;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.speedata.highspeedtrain.login.LoginActivity;
import com.speedata.highspeedtrain.people.PeopleActivity;
import com.speedata.libuhf.IUHFService;
import com.speedata.libuhf.UHFManager;
import com.speedata.libuhf.bean.SpdInventoryData;
import com.speedata.libuhf.interfaces.OnSpdInventoryListener;

public class MainActivity extends AppCompatActivity {

    private IUHFService iuhfService;
    private KProgressHUD kProgressHUD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            iuhfService = UHFManager.getUHFService(MainActivity.this);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "模块不存在", Toast.LENGTH_SHORT).show();
            return;
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        try {
            if (iuhfService != null) {
                kProgressHUD = KProgressHUD.create(MainActivity.this)
                        .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                        .setCancellable(false)
                        .setAnimationSpeed(2)
                        .setLabel("上电中...")
                        .setDimAmount(0.5f)
                        .show();
                int i = iuhfService.OpenDev();
                if (i != 0) {
                    Toast.makeText(this, "上电失败！", Toast.LENGTH_SHORT).show();
                } else {
                    kProgressHUD.dismiss();
                    iuhfService.setOnInventoryListener(new OnSpdInventoryListener() {
                        @Override
                        public void getInventoryData(SpdInventoryData var1) {
                            String epc = var1.getEpc();

                            if (epc.equals("E2005024861401301140A465")) {
                                iuhfService.newInventoryStop();
                                handler.sendMessage(handler.obtainMessage(0,
                                        "找到编号为：" + epc
                                                + "的任务，区间：贵阳-北京西区间上行，站场：001"));
                            } else if (epc.equals("E2005024861501570650D706")) {
                                iuhfService.newInventoryStop();
                                handler.sendMessage(handler.obtainMessage(1,
                                        "找到编号为：" + epc
                                                + "的任务，区间：大连-沈阳区间上行，站场：003"));
                            } else {
                                iuhfService.newInventoryStop();
                                handler.sendMessage(handler.obtainMessage(2,
                                        "找到编号为：" + epc
                                                + "的任务，区间：大连-上海区间上行，站场：003"));
                            }
                        }
                    });
                    iuhfService.newInventoryStart();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        try {
            if (iuhfService != null) {
                iuhfService.newInventoryStop();
                iuhfService.CloseDev();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("提示");
            builder.setMessage(msg.obj + "");
            builder.setCancelable(false);
            builder.setNegativeButton("继续扫描", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    iuhfService.newInventoryStart();
                }
            });
            builder.setPositiveButton("开始工作", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(MainActivity.this, PeopleActivity.class);
                    startActivity(intent);
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    };
}
