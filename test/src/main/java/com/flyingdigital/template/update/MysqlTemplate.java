package com.flyingdigital.template.update;

import com.flyingdigital.template.entity.DatabaseConfig;

public class MysqlTemplate extends AbstractTemplate{
    public MysqlTemplate(DatabaseConfig databaseConfig) {
        super(databaseConfig);
    }

    @Override
    protected void acquireTableDdl() {
        // todo 获取mysql建表ddl的具体实现
    }

    @Override
    protected void acquireIndex() {
        // todo 获取mysql建表Index的具体实现
    }

    @Override
    protected void acquireView() {
        // todo 获取mysql建表View的具体实现
    }
}
