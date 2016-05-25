package techub.workerinfo;

import android.content.Context;
import android.os.Environment;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import greendao.Worker;
import techub.workerinfo.thread.BackgroundThreadExecutor;

/**
 * Created by USER on 12/16/2015.
 */
public class WorkerVolley extends iCallBack {

    public WorkerVolley(Context context) {
        this.backgroundThreadExecutor = BackgroundThreadExecutor.getInstance();
        this.context = context;
    }

    public void uploadWorker(final Worker worker, final WorkerRegisterCallback callback) {

        String url = "http://esworkers.techub.io/worker/push";
        File file_1 = getFile(worker.getFaceImage());
        File file_2 = getFile(worker.getCardFrontImage());
        File file_3 = getFile(worker.getCardBackImage());
        if (file_1 != null && file_2 != null && file_3 != null) {
            RegisterWorkerPhotoRequest registerWorkerPhotoRequest = new RegisterWorkerPhotoRequest(url, worker, file_1, file_2, file_3, new Response.Listener() {
                @Override
                public void onResponse(Object response) {
                    try {
                        JSONObject root = new JSONObject(response.toString());
                        String success = root.getString("success");
                        if (success.equalsIgnoreCase("true")) {
                            callback.onSuccess(true);
                        } else {
                            callback.onSuccess(false);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        callback.onSuccess(false);
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    callback.onError(error.toString());
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    return params;
                }
            };
            registerWorkerPhotoRequest.setRetryPolicy(new DefaultRetryPolicy(40000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            VolleyFactory.getRequestQueue(context).add(registerWorkerPhotoRequest);
        }
    }

    private File getFile(String filename) {
        try {
            File file = new File(filename);
            if (file != null) {

                return file;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
