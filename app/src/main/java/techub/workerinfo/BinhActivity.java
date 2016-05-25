package techub.workerinfo;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

/**
 * Created by HuynhBinh on 12/15/15.
 */
public class BinhActivity extends Activity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        showDialogBlocks(onClickListener);
        showDialogLevels(onClickListener1);
        showDialogUnits(onClickListener2);
    }

    View.OnClickListener onClickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            TextView textView = (TextView) view;

            String data = textView.getText().toString().trim();

        }
    };


    View.OnClickListener onClickListener1 = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            TextView textView = (TextView) view;

            String data = textView.getText().toString().trim();
        }
    };


    View.OnClickListener onClickListener2 = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            TextView textView = (TextView) view;

            String data = textView.getText().toString().trim();

        }
    };


    public void showDialogLevels(View.OnClickListener listener)
    {
        // custom dialog
        final Dialog dialog = new Dialog(this);

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


    public void showDialogBlocks(View.OnClickListener listener)
    {
        // custom dialog
        final Dialog dialog = new Dialog(this);

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


    public void showDialogUnits(View.OnClickListener listener)
    {
        // custom dialog
        final Dialog dialog = new Dialog(this);

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
