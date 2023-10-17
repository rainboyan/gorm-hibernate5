/*
 * Copyright 2011-2023 the original author or authors.
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
package org.grails.orm.hibernate.query;

/**
 * Constants used for query arguments etc.
 *
 * @since 3.0.7
 * @author Graeme Rocher
 */
public interface HibernateQueryConstants {

    String ARGUMENT_FETCH_SIZE = "fetchSize";

    String ARGUMENT_TIMEOUT = "timeout";

    String ARGUMENT_READ_ONLY = "readOnly";

    String ARGUMENT_FLUSH_MODE = "flushMode";

    String ARGUMENT_MAX = "max";

    String ARGUMENT_OFFSET = "offset";

    String ARGUMENT_ORDER = "order";

    String ARGUMENT_SORT = "sort";

    String ORDER_DESC = "desc";

    String ORDER_ASC = "asc";

    String ARGUMENT_FETCH = "fetch";

    String ARGUMENT_IGNORE_CASE = "ignoreCase";

    String ARGUMENT_CACHE = "cache";

    String ARGUMENT_LOCK = "lock";

    String CONFIG_PROPERTY_CACHE_QUERIES = "grails.hibernate.cache.queries";

    String CONFIG_PROPERTY_OSIV_READONLY = "grails.hibernate.osiv.readonly";

    String CONFIG_PROPERTY_PASS_READONLY_TO_HIBERNATE = "grails.hibernate.pass.readonly";

}
