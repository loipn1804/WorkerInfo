package techub.workerinfo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.List;

import greendao.Worker;

/**
 * Created by USER on 12/16/2015.
 */
public class ClearDataActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtClear;
    private TextView txtTotal;
    private TextView txtNotSync;
    private TextView txtSync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clear_data);

        initView();
        initData();
    }

    private void initView() {
        txtClear = (TextView) findViewById(R.id.txtClear);
        txtTotal = (TextView) findViewById(R.id.txtTotal);
        txtNotSync = (TextView) findViewById(R.id.txtNotSync);
        txtSync = (TextView) findViewById(R.id.txtSync);

        txtClear.setOnClickListener(this);
    }

    private void initData() {
        updateStatus();
    }

    private void updateStatus() {
        int total = WorkerController.getAll(this).size();
        int notUpdated = WorkerController.getAllNotUploaded(this).size();
        int updated = WorkerController.getAllUploaded(this).size();
        txtTotal.setText(total + "");
        txtNotSync.setText(notUpdated + "");
        txtSync.setText(updated + "");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtClear:
                DeleteAsyn deleteAsyn = new DeleteAsyn();
                deleteAsyn.execute();
                break;
        }
    }

    private class DeleteAsyn extends AsyncTask<Void, Void, Void> {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(ClearDataActivity.this);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            List<Worker> list = WorkerController.getAllUploaded(ClearDataActivity.this);
            for (Worker worker : list) {
                delete_file(worker.getFaceImage());
                delete_file(worker.getCardFrontImage());
                delete_file(worker.getCardBackImage());
                WorkerController.clearByObject(ClearDataActivity.this, worker);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressDialog.dismiss();
            Toast.makeText(ClearDataActivity.this, "Clear successfully", Toast.LENGTH_SHORT).show();
            updateStatus();
        }
    }

    private void delete_file(String filename) {
        File file = new File(filename);
        file.delete();

        sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(new File(filename))));
    }
}
