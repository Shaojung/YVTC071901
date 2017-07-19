package com.example.yvtc.yvtc071901;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    String cities[] = {"台北", "台中", "台南", "高雄"};
    String codes[] = {"02", "04", "06", "07"};
    int imgs[] = {R.drawable.tpe, R.drawable.tc, R.drawable.tn, R.drawable.kh};
    ArrayList<HashMap<String, Object>> mylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listView);

        mylist = new ArrayList<>();
        int i;
        for (i=0;i<=3;i++)
        {
            HashMap<String, Object> m1 = new HashMap<>();
            m1.put("city", cities[i]);
            m1.put("code", codes[i]);
            m1.put("img", imgs[i]);
            mylist.add(m1);
        }


        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, mylist, R.layout.myitem,
                new String[] {"city", "code", "img"}, new int[] {R.id.textView, R.id.textView2, R.id.imageView});
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, cities[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
