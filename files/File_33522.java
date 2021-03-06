package com.example.jingbin.cloudreader.data.room;

import android.support.annotation.NonNull;

import com.example.jingbin.cloudreader.utils.AppExecutors;
import com.example.jingbin.cloudreader.utils.DebugUtil;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author jingbin
 * @data 2018/4/19
 * @Description
 */

public class UserDataBaseSource {

    private static volatile UserDataBaseSource INSTANCE;
    private UserDao mUserDao;
    private AppExecutors mAppExecutors;

    private UserDataBaseSource(@NonNull AppExecutors mAppExecutors, @NonNull UserDao mUserDao) {
        this.mAppExecutors = mAppExecutors;
        this.mUserDao = mUserDao;
    }

    public static UserDataBaseSource getInstance(@NonNull AppExecutors appExecutors,
                                                 @NonNull UserDao tasksDao) {
        if (INSTANCE == null) {
            synchronized (UserDataBaseSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserDataBaseSource(appExecutors, tasksDao);
                }
            }
        }
        return INSTANCE;
    }

    /**
     * 查找任何的bean(没有数�?�时会报错�?)：
     * 如果数�?�库里有一�?�数�?�就返回这�?�数�?�
     * 如果有多�?�信�?�，则返回第一�?�数�?�
     */
    public void getSingleBean(UserDataCallback callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    User user = mUserDao.findSingleBean();
                    mAppExecutors.mainThread().execute(new Runnable() {
                        @Override
                        public void run() {
                            if (user == null) {
                                callback.onDataNotAvailable();
                            } else {
                                callback.getData(user);
                            }
                        }
                    });
                } catch (Exception e) {
                    DebugUtil.error(e.getMessage());
                }
            }
        };
        mAppExecutors.diskIO().execute(runnable);
    }

    /**
     * 先删除�?��?添加: �?新登录时
     */
    public void addData(@NonNull User user) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    int success = mUserDao.deleteAll();
                    DebugUtil.error("----success:" + success);
                    mUserDao.addUser(user);
                } catch (Exception e) {
                    DebugUtil.error(e.getMessage());
                }
            }
        };
        mAppExecutors.diskIO().execute(runnable);
    }


    /**
     * 更新数�?�
     */
    public void updateData(@NonNull User user) {
        Runnable saveRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    mUserDao.addUser(user);
                } catch (Exception e) {
                    DebugUtil.error(e.getMessage());
                }
            }
        };
        mAppExecutors.diskIO().execute(saveRunnable);
    }

    /**
     * 清除数�?�库
     */
    public void deleteAllData() {
        Runnable saveRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    mUserDao.deleteAll();
                } catch (Exception e) {
                    DebugUtil.error(e.getMessage());
                }
            }
        };
        mAppExecutors.diskIO().execute(saveRunnable);
    }

    /**
     * 获�?�数�?�集�?�
     */
    public void getAll() {
        UserDataBase.getDatabase().waitDao().findAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<User>>() {
                    @Override
                    public void accept(List<User> users) throws Exception {
//                        DebugUtil.error("----waitList.size():" + waits.size());
//                        DebugUtil.error("----waitList:" + waits.toString());
                    }
                });
    }
    /**
     * 获�?�全部数�?�集�?�
     */
    public void getAllData() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    List<User> waits = mUserDao.findUsers();
                    mAppExecutors.mainThread().execute(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });
                } catch (Exception e) {
                    DebugUtil.error(e.getMessage());
                }
            }
        };
        mAppExecutors.diskIO().execute(runnable);
    }
}
