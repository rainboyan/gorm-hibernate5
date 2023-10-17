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
package org.grails.orm.hibernate.support

import javax.sql.DataSource

import org.springframework.beans.factory.FactoryBean

import org.grails.orm.hibernate.AbstractHibernateDatastore
import org.grails.orm.hibernate.connections.HibernateConnectionSource

/**
 * A factory class to retrieve a {@link javax.sql.DataSource} from the Hibernate datastore
 *
 * @author James Kleeh
 */
class DataSourceFactoryBean implements FactoryBean<DataSource> {

    AbstractHibernateDatastore datastore
    String connectionName

    DataSourceFactoryBean(AbstractHibernateDatastore datastore, String connectionName) {
        this.datastore = datastore
        this.connectionName = connectionName
    }

    @Override
    DataSource getObject() throws Exception {
        ((HibernateConnectionSource) datastore.connectionSources.getConnectionSource(connectionName)).dataSource
    }

    @Override
    Class<?> getObjectType() {
        DataSource
    }

    @Override
    boolean isSingleton() {
        true
    }

}
