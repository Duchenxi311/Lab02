package com.qin.imagezxlingdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class UnLock extends Activity implements View.OnClickListener, LocusPassWordView.OnCompleteListener {

    private TextView mExplainTv;
    private Button mConfirmBtn;
    private LocusPassWordView mPwdView;

    private String UnLockPassword;
    String password;
    private boolean isFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_un_lock);
        Intent i = getIntent();
        password = i.getStringExtra("password");
        initViews();
    }

    private void initViews() {
        mExplainTv = (TextView) findViewById(R.id.tv_explain_unlock);
        mConfirmBtn = (Button) findViewById(R.id.btn_confirm_unlock);
        mPwdView = (LocusPassWordView) findViewById(R.id.mPassWordView_unlock);

        mConfirmBtn.setOnClickListener(this);
        mPwdView.setOnCompleteListener(this);
        initChoose();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_confirm_unlock:
                confirm(UnLockPassword);
                break;
        }
    }

    private void confirm(String Unlockpassword) {
        if(Unlockpassword.equals(password))
            Toast.makeText(UnLock.this,"success", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(UnLock.this,"try again", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onComplete(String password) {
        if (isFirst) {
            firstChoose(password);
        }
    }

    @Override
    public void onPrompt(String prompt) {
        mExplainTv.setText(prompt);
    }

    private void initChoose() {
        isFirst = true;
        UnLockPassword = "";
        mPwdView.setFirstPassword("");
        mConfirmBtn.setVisibility(View.GONE);
    }

    private void firstChoose(String password) {
        isFirst = false;
        mPwdView.setFirstPassword(password);
        mPwdView.clearPassword(0);
        mConfirmBtn.setEnabled(true);
        UnLockPassword = password;
        mConfirmBtn.setVisibility(View.VISIBLE);
    }
}
