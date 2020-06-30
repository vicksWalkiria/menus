package com.walkiriaapps.menusapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        //////////////////////////////////CONTEXT MENU ///////////////////////////////////////////
        registerForContextMenu(textView);
        //////////////////////////////////CONTEXT MENU ///////////////////////////////////


        //////////////////////////////////POPUP MENU /////////////////////////////////////

        //Shop popup menu when user makes simple click in textView
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this, textView);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.game_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.new_game:
                                Toast.makeText(MainActivity.this, "New game clicked PopUp Menu", Toast.LENGTH_LONG).show();
                                return true;
                            case R.id.help:
                                Toast.makeText(MainActivity.this, "Help clicked PopUp Menu", Toast.LENGTH_LONG).show();
                                return true;
                        }
                        return false;
                    }
                });
                popup.show();
            }
        });

    }

    //////////////////////////////////CONTEXT MENU ///////////////////////////////////
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_game:
                Toast.makeText(MainActivity.this, "New game clicked Context Menu", Toast.LENGTH_LONG).show();
                return true;
            case R.id.help:
                Toast.makeText(MainActivity.this, "Help clicked Context Menu", Toast.LENGTH_LONG).show();
                return true;
        }
        return super.onContextItemSelected(item);
    }

    /////////////////////////////////////////CONTEXT MENU /////////////////////////////////////////////

    ////////////////////////////////////////// OPTIONS MENU //////////////////////////////////////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //CREATE MENU TO INFLATE
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_game:
                Toast.makeText(MainActivity.this, "New game clicked Options Menu", Toast.LENGTH_LONG).show();
                return true;
            case R.id.help:
                Toast.makeText(MainActivity.this, "Help clicked Options menu", Toast.LENGTH_LONG).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //////////////////////////////////////////////OPTIONS MENU /////////////////////////////////////////////////////////////
}