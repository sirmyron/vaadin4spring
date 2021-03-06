package org.vaadin.spring.samples.mvp.ui.component.listener;

import javax.inject.Inject;

import org.vaadin.spring.annotation.VaadinComponent;
import org.vaadin.spring.annotation.VaadinUIScope;
import org.vaadin.spring.events.EventBus;
import org.vaadin.spring.events.EventScope;
import org.vaadin.spring.events.annotation.EventBusScope;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;

@VaadinUIScope
@VaadinComponent
public class ParticipantSelectedListener implements ValueChangeListener {

    private static final long serialVersionUID = 331391425040065709L;

    @Inject
    @EventBusScope(EventScope.APPLICATION)
    private EventBus eventBus;

    @Override
    public void valueChange(ValueChangeEvent event) {
        // publish AssetOwnerDailyId
        eventBus.publish(this, event.getProperty().getValue());
    }

}
