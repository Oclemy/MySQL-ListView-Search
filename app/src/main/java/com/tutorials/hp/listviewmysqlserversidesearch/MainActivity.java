package com.tutorials.hp.listviewmysqlserversidesearch;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;

import com.tutorials.hp.listviewmysqlserversidesearch.MySQL.SenderReceiver;


public class MainActivity extends AppCompatActivity {

    String urlAddress="http://10.0.2.2/android/searcher.php";
    SearchView sv;
    ListView lv;
    ImageView noDataImg,noNetworkImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        lv= (ListView) findViewById(R.id.lv);
        sv= (SearchView) findViewById(R.id.sv);
        noDataImg= (ImageView) findViewById(R.id.nodataImg);
        noNetworkImg= (ImageView) findViewById(R.id.noserver);


        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                SenderReceiver sr=new SenderReceiver(MainActivity.this,urlAddress,query,lv,noDataImg,noNetworkImg);
                sr.execute();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                SenderReceiver sr=new SenderReceiver(MainActivity.this,urlAddress,query,lv,noDataImg,noNetworkImg);
                sr.execute();

                return false;
            }
        });


    }


}
