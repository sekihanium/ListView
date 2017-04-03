package com.aal.sekihan.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    ListView list;
    int j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<String> data = new ArrayList<>();

        data.add("胡椒");
        data.add("ターメリック");
        data.add("コリアンダー");
        data.add("生姜");
        data.add("ニンニク");
        data.add("サフラン");
        int i;
        for(i =0;i<10;i++){
            data.add(String.format("%dや！", i));
        }

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_multiple_choice, data);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> av, View view, int position, long id) {
                        String msg = "選択したのは、";
                        TextView txt = (TextView)findViewById(R.id.txtBox);
                        txt.setText(String.format("%d個選択中", list.getChildCount()));
                        for(int i = 0; i < list.getChildCount() ; i++){
                            CheckedTextView check = (CheckedTextView) list.getChildAt(i);
                            if (check.isChecked()){
                                msg += check.getText() + ",";
                            }
                        }
                        msg = msg.substring(0, msg.length() - 1);
                        Toast.makeText(MainActivity.this, String.format("%d個選択中", list.getChildCount()), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        list.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                        adapter.add("よう気づいたな！");
                        return false;
                    }
                }
        );
    }

    public void btnClick(View view){
        TextView txt = (TextView)findViewById(R.id.txtBox);
        txt.setText(String.format("%d個選択中", list.getChildCount()));
        adapter.add(String.format("後藤 - %d Combo！", j));
        j++;
    }
}
