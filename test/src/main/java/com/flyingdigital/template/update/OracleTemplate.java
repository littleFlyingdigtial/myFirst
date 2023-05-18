package com.flyingdigital.template.update;

import com.flyingdigital.template.entity.DatabaseConfig;

public class OracleTemplate extends AbstractTemplate {
    protected OracleTemplate(DatabaseConfig databaseConfig) {
        super(databaseConfig);
    }

    @Override
    protected void acquireTableDdl() {

    }

    @Override
    protected void acquireIndex() {

    }

    @Override
    protected void acquireView() {

    }
}
