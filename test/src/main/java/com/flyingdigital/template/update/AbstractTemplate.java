package com.flyingdigital.template.update;

import com.flyingdigital.template.entity.DatabaseConfig;

import java.sql.Connection;

public abstract class AbstractTemplate {

    // 子类共用
    protected Connection connection;


    protected AbstractTemplate(DatabaseConfig databaseConfig){
        // todo 通过databaseConfig来初始化 connection
        this.connection = null;
    }

    /**
     * 对外只暴露acquire接口
     */
    public void acquire(){
        try {
            // todo 考虑多线程 并发处理
            acquireTableDdl();
            acquireIndex();
            acquireView();
        } catch (Exception e){
            // todo 处理异常
        } finally {
            // todo 关闭自愿等
        }
    }

    /**
     * 获取实体的一些步骤 子类具体实现
     */
    protected abstract void acquireTableDdl();

    protected abstract void acquireIndex();

    protected abstract void acquireView();
}
