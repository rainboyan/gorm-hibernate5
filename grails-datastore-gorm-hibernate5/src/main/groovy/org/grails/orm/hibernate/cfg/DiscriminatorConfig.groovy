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
package org.grails.orm.hibernate.cfg

import groovy.transform.CompileStatic
import groovy.transform.builder.Builder
import groovy.transform.builder.SimpleStrategy

/**
 * Configurations the discriminator** @author Graeme Rocher* @since 6.1
 */
@CompileStatic
@Builder(builderStrategy = SimpleStrategy, prefix = '')
class DiscriminatorConfig {

    /**
     * The discriminator value
     */
    String value

    /**
     * The column configuration
     */
    ColumnConfig column

    /**
     * The type
     */
    Object type

    /**
     * Whether it is insertable
     */
    Boolean insertable

    /**
     * The formula to use
     */
    String formula

    /**
     * Whether it is insertable** @param insertable True if it is insertable
     */
    void setInsert(boolean insertable) {
        this.insertable = insertable
    }

    /**
     * Configures the column* @param columnConfig The column config* @return This discriminator config
     */
    DiscriminatorConfig column(@DelegatesTo(ColumnConfig) Closure columnConfig) {
        column = new ColumnConfig()
        columnConfig.setDelegate(column)
        columnConfig.setResolveStrategy(Closure.DELEGATE_ONLY)
        columnConfig.call()
        return this
    }

}
