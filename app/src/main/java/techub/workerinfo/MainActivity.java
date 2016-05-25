package techub.workerinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((TextView) findViewById(R.id.txtStart)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCamera = new Intent(MainActivity.this, CameraActivity.class);
                startActivity(intentCamera);
            }
        });

        ((TextView) findViewById(R.id.txtSync)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSync = new Intent(MainActivity.this, SyncImageActivity.class);
                startActivity(intentSync);
            }
        });

        ((TextView) findViewById(R.id.txtClear)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentClear = new Intent(MainActivity.this, ClearDataActivity.class);
                startActivity(intentClear);
            }
        });
    }

}
