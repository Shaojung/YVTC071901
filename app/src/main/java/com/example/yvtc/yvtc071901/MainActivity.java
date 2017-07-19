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
    ArrayList<HashMap<String, String>> mylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listView);

        mylist = new ArrayList<>();
        int i;
        for (i=0;i<=3;i++)
        {
            HashMap<String, String> m1 = new HashMap<>();
            m1.put("city", cities[i]);
            m1.put("code", codes[i]);
            mylist.add(m1);
        }


        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, mylist, android.R.layout.simple_list_item_2,
                new String[] {"city", "code"}, new int[] {android.R.id.text1, android.R.id.text2});
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, cities[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
