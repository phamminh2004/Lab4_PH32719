package com.minhpt.lab4_ph32719;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bai2_1 extends AppCompatActivity {
    public static String KEY_NAMEBOOK = "name_book";

    public boolean ischuoi(String str) {
        return str.matches("[a-z A-Z 0-9]+");
    }

    TextView txtgia;
    ActivityResultLauncher<Intent> getdata = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == 10) {
                        Intent intent = result.getData();
                        if (intent != null) {
                            Bundle bundle = intent.getExtras();
                            String gia = bundle.getString("price");
                            txtgia.setText(gia);
                        }
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai2_1);
        txtgia = findViewById(R.id.txtgia);
        EditText edtname_book = findViewById(R.id.edtten);
        Button btngui_gia = findViewById(R.id.btngui);

        btngui_gia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_book = edtname_book.getText().toString();
                if (name_book.trim().isEmpty()) {
                    Toast.makeText(Bai2_1.this, "Không được bỏ trống", Toast.LENGTH_SHORT).show();
                } else if (!ischuoi(name_book)) {
                    Toast.makeText(Bai2_1.this, "Nhập sai định dạng tên", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(Bai2_1.this, Bai2_2.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_NAMEBOOK, name_book);
                    intent.putExtras(bundle);
                    getdata.launch(intent);
                }
            }
        });
    }
}
