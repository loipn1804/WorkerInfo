package techub.workerinfo;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;

import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import greendao.Worker;

/**
 * Created by USER on 12/7/2015.
 */
public class RegisterWorkerPhotoRequest extends Request<String> {

    private static final String FILE_PART_NAME_1 = "image_face";
    private static final String FILE_PART_NAME_2 = "image_front";
    private static final String FILE_PART_NAME_3 = "image_back";

    private MultipartEntityBuilder mBuilder = MultipartEntityBuilder.create();
    private final Response.Listener<String> mListener;
    private final File mImageFile_1;
    private final File mImageFile_2;
    private final File mImageFile_3;
    private Worker mWorker;
    protected Map<String, String> headers;

    public RegisterWorkerPhotoRequest(String url, Worker worker, File imageFile_1, File imageFile_2, File imageFile_3, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(Method.POST, url, errorListener);

        mListener = listener;
        mImageFile_1 = imageFile_1;
        mImageFile_2 = imageFile_2;
        mImageFile_3 = imageFile_3;
        mWorker = worker;

        buildMultipartEntity();
    }

    public void setParams(Map<String, String> params) {
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            mBuilder.addTextBody(key, value);
        }

    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = super.getHeaders();

        if (headers == null || headers.equals(Collections.emptyMap())) {
            headers = new HashMap<String, String>();
        }

        headers.put("Accept", "application/json");
        headers.put("Authorization", "Basic ZXNhc2lhOnF3ZTEyMw==");

        return headers;
    }

    private void buildMultipartEntity() {

        /*MultipartEntityBuilder multiPartEntityBuilder = MultipartEntityBuilder.create();
        multiPartEntityBuilder.addPart("profile_file", bin);
        multiPartEntityBuilder.addTextBody("user_id", UserController.getCurrentUser(AccountSettingActivity.this).getUser_id() + "");
        */

        mBuilder.addBinaryBody(FILE_PART_NAME_1, mImageFile_1, ContentType.create("image/*"), mImageFile_1.getName());
        mBuilder.addBinaryBody(FILE_PART_NAME_2, mImageFile_2, ContentType.create("image/*"), mImageFile_2.getName());
        mBuilder.addBinaryBody(FILE_PART_NAME_3, mImageFile_3, ContentType.create("image/*"), mImageFile_3.getName());
        mBuilder.addTextBody("block", mWorker.getBlock());
        mBuilder.addTextBody("level", mWorker.getLevel());
        mBuilder.addTextBody("unit_no", mWorker.getUnit());
        mBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        mBuilder.setLaxMode().setBoundary("xx").setCharset(Charset.forName("UTF-8"));
    }

    @Override
    public String getBodyContentType() {
        String contentTypeHeader = mBuilder.build().getContentType().getValue();
        return contentTypeHeader;
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            mBuilder.build().writeTo(bos);
        } catch (IOException e) {
            VolleyLog.e("IOException writing to ByteArrayOutputStream bos, building the multipart request.");
        }

        return bos.toByteArray();
    }


    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        String parsed;
        try {
            parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        } catch (UnsupportedEncodingException e) {
            parsed = new String(response.data);
        }
        return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
    }

//    @Override
//    protected Response<String> parseNetworkResponse(NetworkResponse response)
//    {
//        String result = null;
//        return Response.success(result, HttpHeaderParser.parseCacheHeaders(response));
//    }

    @Override
    protected void deliverResponse(String response) {
        mListener.onResponse(response);
    }
}
