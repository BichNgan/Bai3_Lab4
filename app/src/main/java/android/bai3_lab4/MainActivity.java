package android.bai3_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvTruyen;
    ArrayList<Truyen>arrayListTruyen=new ArrayList<>();
    CusAdapterTruyen adapterTruyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvTruyen=(ListView) findViewById(R.id.lvTruyen);
        //===========================================
        try {
            arrayListTruyen=loadData("dstruyencuoi.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        adapterTruyen=new CusAdapterTruyen(MainActivity.this,R.layout.layout_item_truyen,
                arrayListTruyen);
        lvTruyen.setAdapter(adapterTruyen);

        addEvent();

    }
    public void addEvent()
    {
        lvTruyen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,TruyenDetail.class);
                intent.putExtra("ten",arrayListTruyen.get(position).getTenTruyen());
                intent.putExtra("anh",arrayListTruyen.get(position).getIdAnh());
                intent.putExtra("nd",arrayListTruyen.get(position).getNdTruyen());
                startActivity(intent);
            }
        });
    }

    public ArrayList<Truyen> loadData(String filename) throws IOException {
        ArrayList<Truyen> lsTruyen = new ArrayList<>();
        InputStream inputStream=getResources().getAssets().open(filename);
        int size=inputStream.available();
        byte[]data=new byte[size];

        inputStream.read(data);
        inputStream.close();

        String st=new String(data);
        String[]dsTruyenSauKhiCat = splitString(st,"====");
        for (String s: dsTruyenSauKhiCat  ) {
            Truyen t=new Truyen();
            String[] ttTruyen = splitString(s,";;");
            t.setTenTruyen(ttTruyen[0]);
            ttTruyen[1]=ttTruyen[1].substring(2);
            int idAnh = getResources().getIdentifier(ttTruyen[1],
                    "drawable","android.bai3_lab4");
            t.setIdAnh(idAnh);
            t.setNdTruyen(ttTruyen[2]);
            lsTruyen.add(t);
        }
        return lsTruyen;
    }
    public String[] splitString(String string, String regex)
    {
        return string.split(regex);
    }
}