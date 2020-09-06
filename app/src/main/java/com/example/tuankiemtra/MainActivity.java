package com.example.tuankiemtra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtCMND, edtBosung;
    RadioGroup radioGroupBang;
    AppCompatCheckBox cbBao,cbSach,cbCode;
    Button btn_commit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edt_name);
        edtCMND = findViewById(R.id.edt_cmnd);
        edtBosung = findViewById(R.id.edt_bosung);
        radioGroupBang = findViewById(R.id.radioGroup_bangcap);
        cbBao = findViewById(R.id.cb_doc_bao);
        cbSach = findViewById(R.id.cb_doc_sach);
        cbCode = findViewById(R.id.cb_doc_code);
        btn_commit  = findViewById(R.id.btn_commit);
        btn_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog);
                dialog.setTitle("Thông tin cá nhân");

                // set the custom dialog components - text, image and button
                TextView tvName = (TextView) dialog.findViewById(R.id.tv_name);
                TextView tvCMND = (TextView) dialog.findViewById(R.id.tv_cmnd);
                TextView tvBang= (TextView) dialog.findViewById(R.id.tv_bangcap);
                TextView tvSothich = (TextView) dialog.findViewById(R.id.tv_sothich);
                TextView tvBosung = (TextView) dialog.findViewById(R.id.tv_extra);

                String name = edtName.getText().toString();
                String CMND = edtCMND.getText().toString();
                String bosung = edtBosung.getText().toString();
                String sothich = "";
                if(cbBao.isChecked()){
                    sothich+=cbBao.getText();
                }
                if(cbSach.isChecked()){
                    sothich+=cbSach.getText();
                }
                if(cbCode.isChecked()){
                    sothich+=cbCode.getText();
                }
                int selectedBang = radioGroupBang.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(selectedBang);


                tvName.setText(name);
                tvCMND.setText(CMND);
                tvBang.setText(radioButton.getText());
                tvBosung.setText(bosung);
                tvSothich.setText(sothich);



                Button dialogButton = dialog.findViewById(R.id.btn_close);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }
}