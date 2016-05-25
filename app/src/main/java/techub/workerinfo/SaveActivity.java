package techub.workerinfo;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import greendao.Worker;

/**
 * Created by USER on 12/15/2015.
 */
public class SaveActivity extends AppCompatActivity implements View.OnClickListener {

    private String FOLDER = "WorkerInfo";

    private TextView txtBlock;
    private TextView txtLevel;
    private TextView txtUnit;
    private TextView txtCancel;
    private TextView txtSave;
    private ImageView imv1;
    private ImageView imv2;
    private ImageView imv3;

    private Dialog dialog;

    private String FILENAME_1 = "";
    private String FILENAME_2 = "";
    private String FILENAME_3 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        initView();
        initData();
    }

    private void initView() {
        txtBlock = (TextView) findViewById(R.id.txtBlock);
        txtLevel = (TextView) findViewById(R.id.txtLevel);
        txtUnit = (TextView) findViewById(R.id.txtUnit);
        txtCancel = (TextView) findViewById(R.id.txtCancel);
        txtSave = (TextView) findViewById(R.id.txtSave);
        imv1 = (ImageView) findViewById(R.id.imv1);
        imv2 = (ImageView) findViewById(R.id.imv2);
        imv3 = (ImageView) findViewById(R.id.imv3);

        txtCancel.setOnClickListener(this);
        txtSave.setOnClickListener(this);
        txtBlock.setOnClickListener(this);
        txtLevel.setOnClickListener(this);
        txtUnit.setOnClickListener(this);
    }

    private void initData() {
        if (getIntent().hasExtra("img_1")) {
            try {
                String root = Environment.getExternalStorageDirectory().toString();
                String filename_1 = root + "/" + FOLDER + "/" + getIntent().getStringExtra("img_1");
                File file_1 = new File(filename_1);
                Uri contentUri_1 = Uri.fromFile(file_1);
                imv1.setImageURI(contentUri_1);

                String filename_2 = root + "/" + FOLDER + "/" + getIntent().getStringExtra("img_2");
                File file_2 = new File(filename_2);
                Uri contentUri_2 = Uri.fromFile(file_2);
                imv2.setImageURI(contentUri_2);

                String filename_3 = root + "/" + FOLDER + "/" + getIntent().getStringExtra("img_3");
                File file_3 = new File(filename_3);
                Uri contentUri_3 = Uri.fromFile(file_3);
                imv3.setImageURI(contentUri_3);

                FILENAME_1 = filename_1;
                FILENAME_2 = filename_2;
                FILENAME_3 = filename_3;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtCancel:
                finish();
                break;
            case R.id.txtSave:
                save();
                break;
            case R.id.txtBlock:
                showDialogBlocks(onClickListener);
                break;
            case R.id.txtLevel:
                showDialogLevels(onClickListener1);
                break;
            case R.id.txtUnit:
                showDialogUnits(onClickListener2);
                break;
        }
    }

    private void save() {
        String block = txtBlock.getText().toString();
        String level = txtLevel.getText().toString();
        String unit = txtUnit.getText().toString();
        if (block.length() == 0) {
            Toast.makeText(this, "Please choose block", Toast.LENGTH_SHORT).show();
        } else if (level.length() == 0) {
            Toast.makeText(this, "Please choose level", Toast.LENGTH_SHORT).show();
        } else if (unit.length() == 0) {
            Toast.makeText(this, "Please choose unit no.", Toast.LENGTH_SHORT).show();
        } else {
            Worker worker = new Worker();
            worker.setBlock(block);
            worker.setLevel(level);
            worker.setUnit(unit);
            worker.setFaceImage(FILENAME_1);
            worker.setCardFrontImage(FILENAME_2);
            worker.setCardBackImage(FILENAME_3);
            worker.setUploaded(0);
            WorkerController.insert(this, worker);
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView textView = (TextView) view;

            String data = textView.getText().toString().trim();

            txtBlock.setText(data);
            dialog.dismiss();
        }
    };


    View.OnClickListener onClickListener1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView textView = (TextView) view;

            String data = textView.getText().toString().trim();

            txtLevel.setText(data);
            dialog.dismiss();
        }
    };


    View.OnClickListener onClickListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView textView = (TextView) view;

            String data = textView.getText().toString().trim();

            txtUnit.setText(data);
            dialog.dismiss();
        }
    };

    public void showDialogLevels(View.OnClickListener listener) {
        // custom dialog
        dialog = new Dialog(this);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(R.layout.dialog_levels);


        TextView txt1 = (TextView) dialog.findViewById(R.id.txt1);
        TextView txt2 = (TextView) dialog.findViewById(R.id.txt2);
        TextView txt3 = (TextView) dialog.findViewById(R.id.txt3);
        TextView txt4 = (TextView) dialog.findViewById(R.id.txt4);
        TextView txt5 = (TextView) dialog.findViewById(R.id.txt5);
        TextView txt6 = (TextView) dialog.findViewById(R.id.txt6);
        TextView txt7 = (TextView) dialog.findViewById(R.id.txt7);
        TextView txt8 = (TextView) dialog.findViewById(R.id.txt8);
        TextView txt9 = (TextView) dialog.findViewById(R.id.txt9);
        TextView txt10 = (TextView) dialog.findViewById(R.id.txt10);


        txt1.setOnClickListener(listener);
        txt2.setOnClickListener(listener);
        txt3.setOnClickListener(listener);
        txt4.setOnClickListener(listener);
        txt5.setOnClickListener(listener);
        txt6.setOnClickListener(listener);
        txt7.setOnClickListener(listener);
        txt8.setOnClickListener(listener);
        txt9.setOnClickListener(listener);
        txt10.setOnClickListener(listener);


        dialog.show();
    }


    public void showDialogBlocks(View.OnClickListener listener) {
        // custom dialog
        dialog = new Dialog(this);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(R.layout.dialog_blocks);


        TextView txtA = (TextView) dialog.findViewById(R.id.txtA);
        TextView txtB = (TextView) dialog.findViewById(R.id.txtB);
        TextView txtC = (TextView) dialog.findViewById(R.id.txtC);
        TextView txtD = (TextView) dialog.findViewById(R.id.txtD);
        TextView txtE = (TextView) dialog.findViewById(R.id.txtE);
        TextView txtF = (TextView) dialog.findViewById(R.id.txtF);
        TextView txtG = (TextView) dialog.findViewById(R.id.txtG);
        TextView txtH = (TextView) dialog.findViewById(R.id.txtH);
        TextView txtI = (TextView) dialog.findViewById(R.id.txtI);
        TextView txtJ = (TextView) dialog.findViewById(R.id.txtJ);
        TextView txtK = (TextView) dialog.findViewById(R.id.txtK);
        TextView txtL = (TextView) dialog.findViewById(R.id.txtL);
        TextView txtM = (TextView) dialog.findViewById(R.id.txtM);
        TextView txtN = (TextView) dialog.findViewById(R.id.txtN);
        TextView txtO = (TextView) dialog.findViewById(R.id.txtO);
        TextView txtP = (TextView) dialog.findViewById(R.id.txtP);
        TextView txtQ = (TextView) dialog.findViewById(R.id.txtQ);
        TextView txtR = (TextView) dialog.findViewById(R.id.txtR);
        TextView txtS = (TextView) dialog.findViewById(R.id.txtS);
        TextView txtT = (TextView) dialog.findViewById(R.id.txtT);
        TextView txtU = (TextView) dialog.findViewById(R.id.txtU);
        TextView txtV = (TextView) dialog.findViewById(R.id.txtV);
        TextView txtW = (TextView) dialog.findViewById(R.id.txtW);
        TextView txtX = (TextView) dialog.findViewById(R.id.txtX);
        TextView txtY = (TextView) dialog.findViewById(R.id.txtY);
        TextView txtZ = (TextView) dialog.findViewById(R.id.txtZ);


        txtA.setOnClickListener(listener);
        txtB.setOnClickListener(listener);
        txtC.setOnClickListener(listener);
        txtD.setOnClickListener(listener);
        txtE.setOnClickListener(listener);
        txtF.setOnClickListener(listener);
        txtG.setOnClickListener(listener);
        txtH.setOnClickListener(listener);
        txtI.setOnClickListener(listener);
        txtJ.setOnClickListener(listener);
        txtK.setOnClickListener(listener);
        txtL.setOnClickListener(listener);
        txtM.setOnClickListener(listener);
        txtN.setOnClickListener(listener);
        txtO.setOnClickListener(listener);
        txtP.setOnClickListener(listener);
        txtQ.setOnClickListener(listener);
        txtR.setOnClickListener(listener);
        txtS.setOnClickListener(listener);
        txtT.setOnClickListener(listener);
        txtU.setOnClickListener(listener);
        txtV.setOnClickListener(listener);
        txtW.setOnClickListener(listener);
        txtX.setOnClickListener(listener);
        txtY.setOnClickListener(listener);
        txtZ.setOnClickListener(listener);

        dialog.show();
    }


    public void showDialogUnits(View.OnClickListener listener) {
        // custom dialog
        dialog = new Dialog(this);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(R.layout.dialog_units);


        TextView txt1 = (TextView) dialog.findViewById(R.id.txt1);
        TextView txt2 = (TextView) dialog.findViewById(R.id.txt2);
        TextView txt3 = (TextView) dialog.findViewById(R.id.txt3);
        TextView txt4 = (TextView) dialog.findViewById(R.id.txt4);
        TextView txt5 = (TextView) dialog.findViewById(R.id.txt5);
        TextView txt6 = (TextView) dialog.findViewById(R.id.txt6);
        TextView txt7 = (TextView) dialog.findViewById(R.id.txt7);
        TextView txt8 = (TextView) dialog.findViewById(R.id.txt8);
        TextView txt9 = (TextView) dialog.findViewById(R.id.txt9);
        TextView txt10 = (TextView) dialog.findViewById(R.id.txt10);

        TextView txt11 = (TextView) dialog.findViewById(R.id.txt11);
        TextView txt12 = (TextView) dialog.findViewById(R.id.txt12);
        TextView txt13 = (TextView) dialog.findViewById(R.id.txt13);
        TextView txt14 = (TextView) dialog.findViewById(R.id.txt14);
        TextView txt15 = (TextView) dialog.findViewById(R.id.txt15);
        TextView txt16 = (TextView) dialog.findViewById(R.id.txt16);
        TextView txt17 = (TextView) dialog.findViewById(R.id.txt17);
        TextView txt18 = (TextView) dialog.findViewById(R.id.txt18);
        TextView txt19 = (TextView) dialog.findViewById(R.id.txt19);
        TextView txt20 = (TextView) dialog.findViewById(R.id.txt20);

        TextView txt21 = (TextView) dialog.findViewById(R.id.txt21);
        TextView txt22 = (TextView) dialog.findViewById(R.id.txt22);
        TextView txt23 = (TextView) dialog.findViewById(R.id.txt23);
        TextView txt24 = (TextView) dialog.findViewById(R.id.txt24);
        TextView txt25 = (TextView) dialog.findViewById(R.id.txt25);
        TextView txt26 = (TextView) dialog.findViewById(R.id.txt26);
        TextView txt27 = (TextView) dialog.findViewById(R.id.txt27);
        TextView txt28 = (TextView) dialog.findViewById(R.id.txt28);
        TextView txt29 = (TextView) dialog.findViewById(R.id.txt29);
        TextView txt30 = (TextView) dialog.findViewById(R.id.txt30);

        TextView txt31 = (TextView) dialog.findViewById(R.id.txt31);
        TextView txt32 = (TextView) dialog.findViewById(R.id.txt32);
        TextView txt33 = (TextView) dialog.findViewById(R.id.txt33);
        TextView txt34 = (TextView) dialog.findViewById(R.id.txt34);
        TextView txt35 = (TextView) dialog.findViewById(R.id.txt35);
        TextView txt36 = (TextView) dialog.findViewById(R.id.txt36);
        TextView txt37 = (TextView) dialog.findViewById(R.id.txt37);
        TextView txt38 = (TextView) dialog.findViewById(R.id.txt38);
        TextView txt39 = (TextView) dialog.findViewById(R.id.txt39);
        TextView txt40 = (TextView) dialog.findViewById(R.id.txt40);

        TextView txt41 = (TextView) dialog.findViewById(R.id.txt41);
        TextView txt42 = (TextView) dialog.findViewById(R.id.txt42);
        TextView txt43 = (TextView) dialog.findViewById(R.id.txt43);
        TextView txt44 = (TextView) dialog.findViewById(R.id.txt44);
        TextView txt45 = (TextView) dialog.findViewById(R.id.txt45);


        txt1.setOnClickListener(listener);
        txt2.setOnClickListener(listener);
        txt3.setOnClickListener(listener);
        txt4.setOnClickListener(listener);
        txt5.setOnClickListener(listener);
        txt6.setOnClickListener(listener);
        txt7.setOnClickListener(listener);
        txt8.setOnClickListener(listener);
        txt9.setOnClickListener(listener);
        txt10.setOnClickListener(listener);

        txt11.setOnClickListener(listener);
        txt12.setOnClickListener(listener);
        txt13.setOnClickListener(listener);
        txt14.setOnClickListener(listener);
        txt15.setOnClickListener(listener);
        txt16.setOnClickListener(listener);
        txt17.setOnClickListener(listener);
        txt18.setOnClickListener(listener);
        txt19.setOnClickListener(listener);
        txt20.setOnClickListener(listener);

        txt21.setOnClickListener(listener);
        txt22.setOnClickListener(listener);
        txt23.setOnClickListener(listener);
        txt24.setOnClickListener(listener);
        txt25.setOnClickListener(listener);
        txt26.setOnClickListener(listener);
        txt27.setOnClickListener(listener);
        txt28.setOnClickListener(listener);
        txt29.setOnClickListener(listener);
        txt30.setOnClickListener(listener);

        txt31.setOnClickListener(listener);
        txt32.setOnClickListener(listener);
        txt33.setOnClickListener(listener);
        txt34.setOnClickListener(listener);
        txt35.setOnClickListener(listener);
        txt36.setOnClickListener(listener);
        txt37.setOnClickListener(listener);
        txt38.setOnClickListener(listener);
        txt39.setOnClickListener(listener);
        txt40.setOnClickListener(listener);

        txt41.setOnClickListener(listener);
        txt42.setOnClickListener(listener);
        txt43.setOnClickListener(listener);
        txt44.setOnClickListener(listener);
        txt45.setOnClickListener(listener);


        dialog.show();
    }
}
