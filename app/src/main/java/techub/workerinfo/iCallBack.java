package techub.workerinfo;

import android.content.Context;

import techub.workerinfo.thread.BackgroundThreadExecutor;

/**
 * Created by HuynhBinh on 10/5/15.
 */
public class iCallBack {

    //region VARIABLE
    // background thread to handle data in a separate thread from UI
    // will not lock the UI thread for improve performance
    public BackgroundThreadExecutor backgroundThreadExecutor;
    //region VARIABLE
    public Context context;
    //endregion

    public interface WorkerRegisterCallback {
        void onSuccess(boolean dataOk);

        void onError(String error);
    }
}
