package com.flyingdigital.template.update;

import com.flyingdigital.template.entity.DatabaseConfig;

/**
 * 实体创建 工厂
 */
public class Factory {
    public AbstractTemplate createTemplate(DatabaseConfig databaseConfig, String type) {
        if ("mysql".equalsIgnoreCase(type)) {
            return new MysqlTemplate(databaseConfig);
        } else if ("sqlserver".equalsIgnoreCase(type)) {
            return new SqlserverTemplate(databaseConfig);
        } else if ("oracle".equalsIgnoreCase(type)) {
            return new OracleTemplate(databaseConfig);
        } else {
            return null;
        }
    }
}
