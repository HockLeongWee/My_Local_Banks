package sg.edu.rp.c346.id20046765.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvBank;
    TextView tvBank2;
    TextView tvBank3;

    String wordClicked="";
    String DBSnumber="18002222121";
    String OCBCnumber="18003633333";
    String UOBnumber="18002222121";
    String DBSwebsite="https://www.dbs.com.sg";
    String OCBCwebsite="https://www.ocbc.com";
    String UOBwebsite="https://www.uob.com.sg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvBank = findViewById(R.id.tvBank);
        tvBank2 = findViewById(R.id.tvBank2);
        tvBank3 = findViewById(R.id.tvBank3);

        registerForContextMenu(tvBank);
        registerForContextMenu(tvBank2);
        registerForContextMenu(tvBank3);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if(v == tvBank){
            wordClicked = "DBS";
            Log.v("Context", "DBS selected");
        }else if(v == tvBank2){
            wordClicked = "OCBC";
            Log.v("Context", "OCBC selected");
        }else if(v == tvBank3){
            wordClicked = "UOB";
            Log.v("Context", "UOB selected");
        }

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (wordClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(DBSwebsite));
                startActivity(intentCall);
            } else if(item.getItemId() == 1){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+DBSnumber));
                startActivity(intentCall);
            }
        } else if (wordClicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(OCBCwebsite));
                startActivity(intentCall);
            } else if(item.getItemId() == 1){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+OCBCnumber));
                startActivity(intentCall);
            }
        } else if (wordClicked.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(UOBwebsite));
                startActivity(intentCall);
            } else if(item.getItemId() == 1){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+UOBnumber));
                startActivity(intentCall);
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
            tvBank.setText("DBS ");
            tvBank2.setText("OCBC");
            tvBank3.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            Toast.makeText(MainActivity.this, "Chinese is chosen", Toast.LENGTH_SHORT).show();
            tvBank.setText("星展银行");
            tvBank2.setText("华侨银行");
            tvBank3.setText("大华银行");
            return true;
        } else if(id == R.id.MalaySelection){
            Toast.makeText(MainActivity.this, "Malay is chosen", Toast.LENGTH_SHORT).show();
            tvBank.setText("DBS");
            tvBank2.setText("OCBC");
            tvBank3.setText("UOB");
        } else if(id == R.id.TamilSelection){
            Toast.makeText(MainActivity.this, "Tamil is chosen", Toast.LENGTH_SHORT).show();
            tvBank.setText("டி.பி.எஸ் வங்கி");
            tvBank2.setText("OCBC வங்கி");
            tvBank3.setText("யுனைடெட் ஓவர்சீஸ் வங்கி");
        }
        else {
            tvBank.setText("Error translation");
            tvBank2.setText("Error translation");
            tvBank3.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }


}