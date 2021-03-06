/*
 * Copyright 2013-2018 the original author or authors.
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

package com.alibaba.cloud.spring.boot.schedulerx.actuate.autoconfigure;

import com.alibaba.cloud.spring.boot.context.env.EdasProperties;
import com.alibaba.cloud.spring.boot.schedulerx.env.SchedulerXProperties;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author xiaolongzuo
 */
@ConditionalOnWebApplication
@ConditionalOnClass(Endpoint.class)
public class SchedulerXEndpointAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnEnabledEndpoint
    public SchedulerXEndpoint schedulerXEndpoint(EdasProperties edasProperties,
                                                 SchedulerXProperties schedulerXProperties) {
        return new SchedulerXEndpoint(edasProperties, schedulerXProperties);
    }

}
