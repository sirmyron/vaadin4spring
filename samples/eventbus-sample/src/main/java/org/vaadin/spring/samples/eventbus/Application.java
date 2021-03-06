/*
 * Copyright 2014 The original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.vaadin.spring.samples.eventbus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.vaadin.spring.events.EventBus;
import org.vaadin.spring.events.EventScope;
import org.vaadin.spring.events.annotation.EventBusScope;
import org.vaadin.spring.events.internal.ApplicationContextEventBroker;

/**
 * Main class for the event bus demo application.
 *
 * @author Petter Holmström (petter@vaadin.com)
 */
@EnableAutoConfiguration
@ComponentScan
public class Application {

    @Autowired
    @EventBusScope(EventScope.APPLICATION)
    EventBus applicationEventBus;

    /**
     * Forward {@link org.springframework.context.ApplicationEvent}s to the {@link EventScope#APPLICATION} scoped {@link org.vaadin.spring.events.EventBus}.
     */
    @Bean
    ApplicationContextEventBroker applicationContextEventBroker() {
        return new ApplicationContextEventBroker(applicationEventBus);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }


}
