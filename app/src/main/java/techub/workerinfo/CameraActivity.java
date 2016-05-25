package techub.workerinfo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by USER on 12/15/2015.
 */
public class CameraActivity extends AppCompatActivity implements View.OnClickListener, CameraSurfaceView.CameraSurfaceCallback {

    private FrameLayout frameCamera;
    private ImageView imvCamera;
    private RelativeLayout containView;
    private TextView txtStep;

    private View view_1;
    private View view_face;
    private LayoutInflater layoutInflater;

    private CameraSurfaceView cameraSurfaceView;

    private String FILE_NAME_1 = "reg_1.png";
    private String FILE_NAME_2 = "reg_2.png";
    private String FILE_NAME_3 = "reg_3.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        String android_id = Settings.Secure.getString(getContentResolver(),
                Settings.Secure.ANDROID_ID);
        String seccond = android_id + "_" + System.currentTimeMillis() + "";
        FILE_NAME_1 = seccond + "_1.png";
        FILE_NAME_2 = seccond + "_2.png";
        FILE_NAME_3 = seccond + "_3.png";

        initView();
        initData();
    }

    private void initView() {
        frameCamera = (FrameLayout) findViewById(R.id.frameCamera);
        imvCamera = (ImageView) findViewById(R.id.imvCamera);
        containView = (RelativeLayout) findViewById(R.id.containView);

        imvCamera.setOnClickListener(this);
    }

    private void initData() {
        cameraSurfaceView = new CameraSurfaceView(this, FILE_NAME_1, this);
        frameCamera.addView(cameraSurfaceView);

        layoutInflater = LayoutInflater.from(this);
        view_1 = layoutInflater.inflate(R.layout.view_reg_camera_1, null);
        view_face = layoutInflater.inflate(R.layout.view_reg_camera_face, null);
        txtStep = (TextView) view_1.findViewById(R.id.txtStep);

        containView.addView(view_face);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imvCamera:
                cameraSurfaceView.TakePicture();
                imvCamera.setClickable(false);
                break;
        }
    }

    @Override
    public void saveImageSuccess(String filename) {
        if (filename.equalsIgnoreCase(FILE_NAME_1)) {
            containView.removeAllViews();
            containView.addView(view_1);
            txtStep.setText("Card Front");
            cameraSurfaceView.setFilename(FILE_NAME_2);
            imvCamera.setClickable(true);
        } else if (filename.equalsIgnoreCase(FILE_NAME_2)) {
            txtStep.setText("Card Back");
            cameraSurfaceView.setFilename(FILE_NAME_3);
            imvCamera.setClickable(true);
        } else if (filename.equalsIgnoreCase(FILE_NAME_3)) {
            Intent intentSave = new Intent(this, SaveActivity.class);
            intentSave.putExtra("img_1", FILE_NAME_1);
            intentSave.putExtra("img_2", FILE_NAME_2);
            intentSave.putExtra("img_3", FILE_NAME_3);
            startActivity(intentSave);
            finish();
        }
    }

    @Override
    public void saveImageFail() {
        imvCamera.setClickable(true);
    }
}
