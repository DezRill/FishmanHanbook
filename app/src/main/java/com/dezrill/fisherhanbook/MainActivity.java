package com.dezrill.fisherhanbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private ListView listView;
    private String[] array;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.drawer_button);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        listView=findViewById(R.id.listView);
        array=getResources().getStringArray(R.array.fish_array);
        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>(Arrays.asList(array)));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this, TextContentActivity.class);
                intent.putExtra("TITLE", getTitle());
                intent.addFlags(position);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        setTitle(R.string.menu_fish);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                drawer.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickExit(MenuItem item) {
        finish();
        System.exit(0);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.nav_fish){
            array=getResources().getStringArray(R.array.fish_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            setTitle(R.string.menu_fish);
        }
        if (id==R.id.nav_bait){
            array=getResources().getStringArray(R.array.bait_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            setTitle(R.string.menu_bait);
        }
        if (id==R.id.nav_tackle){
            array=getResources().getStringArray(R.array.tackle_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            setTitle(R.string.menu_tackle);
        }
        if (id==R.id.nav_lure){
            array=getResources().getStringArray(R.array.lure_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            setTitle(R.string.menu_lure);
        }
        if (id==R.id.nav_stories){
            array=getResources().getStringArray(R.array.stories_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            setTitle(R.string.menu_stories);
        }
        if (id==R.id.nav_tips){
            array=getResources().getStringArray(R.array.tips_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            setTitle(R.string.menu_tips);
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}