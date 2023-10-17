/*
 * Copyright 2003-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.grails.orm.hibernate.connections;

import java.io.IOException;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;

import org.grails.datastore.gorm.jdbc.connections.DataSourceSettings;
import org.grails.datastore.mapping.core.connections.ConnectionSource;
import org.grails.datastore.mapping.core.connections.DefaultConnectionSource;

/**
 *
 * Implements the {@link org.grails.datastore.mapping.core.connections.ConnectionSource} interface for Hibernate
 *
 * @author Graeme Rocher
 * @since 6.0
 */
public class HibernateConnectionSource extends DefaultConnectionSource<SessionFactory, HibernateConnectionSourceSettings> {

    protected final ConnectionSource<DataSource, DataSourceSettings> dataSource;

    public HibernateConnectionSource(String name, SessionFactory sessionFactory, ConnectionSource<DataSource, DataSourceSettings> dataSourceConnectionSource, HibernateConnectionSourceSettings settings) {
        super(name, sessionFactory, settings);
        this.dataSource = dataSourceConnectionSource;
    }

    @Override
    public void close() throws IOException {
        super.close();
        try {
            SessionFactory sessionFactory = getSource();
            sessionFactory.close();
        }
        finally {
            if (dataSource != null) {
                dataSource.close();
            }
        }
    }

    /**
     * @return The underlying SQL {@link DataSource}
     */
    public DataSource getDataSource() {
        return dataSource.getSource();
    }

}
