package techub.workerinfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import greendao.Worker;

/**
 * Created by USER on 12/16/2015.
 */
public class SyncImageActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtStatus;
    private TextView txtStart;
    private TextView txtStop;
    private ProgressBar progressBar;

    private boolean isStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync_image);

        isStop = false;

        initView();
        initData();
    }

    private void initView() {
        txtStatus = (TextView) findViewById(R.id.txtStatus);
        txtStart = (TextView) findViewById(R.id.txtStart);
        txtStop = (TextView) findViewById(R.id.txtStop);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        txtStart.setOnClickListener(this);
        txtStop.setOnClickListener(this);

        txtStop.setVisibility(View.INVISIBLE);
    }

    private void initData() {
        updateStatus();
    }

    private void updateStatus() {
        int total = WorkerController.getAll(this).size();
        int updated = WorkerController.getAllUploaded(this).size();
        txtStatus.setText(updated + "/" + total);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtStart:
                isStop = false;
                txtStart.setVisibility(View.INVISIBLE);
                txtStop.setVisibility(View.VISIBLE);
                startUpload();
                break;
            case R.id.txtStop:
                isStop = true;
                txtStart.setVisibility(View.VISIBLE);
                txtStop.setVisibility(View.INVISIBLE);
                break;
        }
    }

    private void startUpload() {
        if (!isStop) {
            progressBar.setVisibility(View.VISIBLE);
            List<Worker> workers = WorkerController.getAllNotUploaded(this);
            if (workers.size() > 0) {
                final Worker worker = workers.get(0);
                WorkerVolley workerVolley = new WorkerVolley(this);
                workerVolley.uploadWorker(worker, new iCallBack.WorkerRegisterCallback() {
                    @Override
                    public void onSuccess(boolean dataOk) {
                        if (dataOk) {
                            worker.setUploaded(1);
                            WorkerController.update(SyncImageActivity.this, worker);
                            updateStatus();
                            startUpload();
                        } else {
                            isStop = true;
                            txtStart.setVisibility(View.VISIBLE);
                            txtStop.setVisibility(View.INVISIBLE);
                        }
                    }

                    @Override
                    public void onError(String error) {
                        Toast.makeText(SyncImageActivity.this, error, Toast.LENGTH_SHORT).show();
                        isStop = true;
                        txtStart.setVisibility(View.VISIBLE);
                        txtStop.setVisibility(View.INVISIBLE);
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                });
            } else {
                Toast.makeText(this, "Uploaded all", Toast.LENGTH_SHORT).show();
                txtStart.setVisibility(View.VISIBLE);
                txtStop.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
            }
        } else {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }
}
