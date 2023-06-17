package android.bai3_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TruyenDetail extends AppCompatActivity {
    ImageView imgTruyenDetail;
    TextView tvTenTruyenDetail, tvNdung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truyen_detail);
        addControls();

        Intent intent = getIntent();
        String ten=intent.getStringExtra("ten");
        int idAnh = intent.getIntExtra("anh",0);
        String nd = intent.getStringExtra("nd");

        imgTruyenDetail.setImageResource(idAnh);
        tvNdung.setText(nd);
        tvTenTruyenDetail.setText(ten);
    }
    public  void addControls()
    {
        imgTruyenDetail=(ImageView) findViewById(R.id.imgTruyenDetail);
        tvTenTruyenDetail=(TextView) findViewById(R.id.tvTenDetail);
        tvNdung=(TextView) findViewById(R.id.tvNdTruyen);
    }
}