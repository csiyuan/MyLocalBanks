package sg.edu.rpc346.id19016011.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDisplayDBS, tvDisplayOCBC, tvDisplayUOB;
    MenuItem item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplayDBS = findViewById(R.id.buttonDBS);
        registerForContextMenu(tvDisplayDBS);
        tvDisplayOCBC = findViewById(R.id.buttonOCBC);
        registerForContextMenu(tvDisplayOCBC);
        tvDisplayUOB = findViewById(R.id.buttonUOB);
        registerForContextMenu(tvDisplayUOB);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.equals(tvDisplayDBS) == true) {
            menu.add(0, 0, 0, R.string.website);
            menu.add(0, 1, 1, R.string.contact);
        }
        else if(v.equals(tvDisplayOCBC) == true){
            menu.add(1, 2, 0, R.string.website);
            menu.add(1, 3, 1, R.string.contact);
        }
        else if(v.equals(tvDisplayUOB) == true){
            menu.add(2, 4, 0, R.string.website);
            menu.add(2, 5, 1, R.string.contact);
        }
        super.onCreateContextMenu(menu, v, menuInfo);
                }
@Override
public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == 0) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbsweb)));
        startActivity(intent);
        return true;
        }
        else if(item.getItemId() == 1){
        Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.dbshotline)));
        startActivity(intentCall);
        return true;
        }
        else if (item.getItemId() == 2) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcweb)));
        startActivity(intent);
        return true;
        }
        else if(item.getItemId() == 3){
        Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.ocbchotline)));
        startActivity(intentCall);
        return true;
        }
        else if(item.getItemId()==4) {
        Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.uobweb)));
        startActivity(intent);
        return true;
        }
        else if(item.getItemId()==5) {
        Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.uobhotline)));
        startActivity(intentCall);
        return true;
        }
        return super.onContextItemSelected(item);
        }

@Override
public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
        }
@Override
public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == R.id.mnuChinese){
        tvDisplayDBS.setText(R.string.chinesedbs);
        tvDisplayOCBC.setText(R.string.chineseocbc);
        tvDisplayUOB.setText(R.string.chineseuob);
        return true;
        }
        else if(item.getItemId() == R.id.mnuEnglish){
        tvDisplayDBS.setText(R.string.dbs);
        tvDisplayOCBC.setText(R.string.ocbc);
        tvDisplayUOB.setText(R.string.uob);
        return true;
        }
        return super.onOptionsItemSelected(item);

        }

        }

