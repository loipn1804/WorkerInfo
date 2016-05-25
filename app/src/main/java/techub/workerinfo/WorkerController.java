package techub.workerinfo;

import android.content.Context;

import java.util.List;

import greendao.Worker;
import greendao.WorkerDao;

/**
 * Created by USER on 12/16/2015.
 */
public class WorkerController {

    private static WorkerDao getCommentDao(Context c) {
        return ((MyApplication) c.getApplicationContext()).getDaoSession().getWorkerDao();
    }

    public static void insert(Context context, Worker worker) {
        getCommentDao(context).insert(worker);
    }

    public static void update(Context context, Worker worker) {
        getCommentDao(context).update(worker);
    }

    public static List<Worker> getAll(Context context) {
        return getCommentDao(context).loadAll();
    }

    public static List<Worker> getAllNotUploaded(Context context) {
        return getCommentDao(context).queryRaw(" where uploaded=?", "0");
    }

    public static List<Worker> getAllUploaded(Context context) {
        List<Worker> list = getCommentDao(context).queryRaw(" where uploaded=?", "1");
        return list;
    }

    public static void clearById(Context context, Long id) {
        getCommentDao(context).deleteByKey(id);
    }

    public static void clearByObject(Context context, Worker worker) {
        getCommentDao(context).delete(worker);
    }

    public static void clearAll(Context context) {
        getCommentDao(context).deleteAll();
    }
}
