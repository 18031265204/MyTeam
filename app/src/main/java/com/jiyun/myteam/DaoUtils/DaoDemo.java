package com.jiyun.myteam.DaoUtils;

import android.content.Context;

import com.jiyun.lenovo.app.DaoMaster;
import com.jiyun.lenovo.app.DaoSession;
import com.jiyun.lenovo.app.PeopleBeanDao;


/**
 * Created by lenovo on 2017/9/12.
 */

public class DaoDemo {
    private  static DaoDemo daoDemo;
    private static  final String DB_NAME="stu";
    private final DaoMaster.DevOpenHelper openHelper;

    private DaoDemo(Context context){
        openHelper = new DaoMaster.DevOpenHelper(context, DB_NAME);
    }
    public static synchronized DaoDemo getIentece(Context context){
        if (daoDemo == null){
            daoDemo =new DaoDemo(context);
        }
        return  daoDemo;
    }
    public PeopleBeanDao getDao(){
        DaoMaster daoMaster = new DaoMaster(openHelper.getReadableDb());
        DaoSession daoSession = daoMaster.newSession();
        PeopleBeanDao peopleBeanDao = daoSession.getPeopleBeanDao();
        return peopleBeanDao;
    }
}
