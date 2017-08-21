package com.example.thagadur.android__session9_assignment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Creating objects of List View and CustomAdapter(respective classes)
    ListView listView;
    CustomArrayAdapter adapter;
    //Creating String of names and Phone Numbers
    String[] names={"Rahul","Ezhil","Puneeth","gowtham","shivaraj","chethan"};
    String[] phNumbers={"8970147705","7411915423","96863451060","9865321472","7894561237","9856451237"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialising ListView with respective ID
        listView=(ListView)findViewById(R.id.list_view);
        //Calling the custom adapter which is created in custom adapter class
        adapter=new CustomArrayAdapter(MainActivity.this,names,phNumbers);
        //setting listview with adapter
        listView.setAdapter(adapter);
        //for Context menu we should call registerForContextMenu(listView) to include respective view
        //here it is listview
        registerForContextMenu(listView);

    }

    //this function defines what should happen upon Creating ContextMenu
    //Here we have defined title of context Menu
    //Added 3 Menu items
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose Menu");
        menu.add(0, v.getId(), 0, "Call");
        menu.add(0, v.getId(), 0, "Send SMS");
        menu.add(0, v.getId(), 0, "Browse");
        }

    //this function defines what should happen upon Clicking contextmenu option
    //on clicking a context respective intent is opened
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle()=="Call"){
            //implicit intent-> Dial is opened after executing the two statements
            Intent i =new Intent(Intent.ACTION_DIAL);
            startActivity(i);
        }
        else if (item.getTitle()=="Send SMS"){
            //implicit intent-> Sms is opened after executing the following statements
            Intent i=new Intent(Intent.ACTION_VIEW);
            i.setType("vnd.android-dir/mms-sms");
            startActivity(i);
        }
        return true;
    }
}
