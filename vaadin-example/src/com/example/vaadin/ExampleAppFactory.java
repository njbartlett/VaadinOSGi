package com.example.vaadin;

import java.util.concurrent.atomic.AtomicReference;

import org.example.utils.vaadinbridge.ApplicationFactory;
import org.osgi.service.log.LogService;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;

import com.vaadin.Application;
import com.vaadin.Application.SystemMessages;

@Component(properties = "alias=vaadin-example")
public class ExampleAppFactory implements ApplicationFactory {
    
    AtomicReference<LogService> logRef = new AtomicReference<LogService>(null);
    
    @Reference(dynamic = true, optional = true)
    public void setLogService(LogService log) {
        logRef.set(log);
    }
    public void unsetLogService(LogService log) {
        logRef.compareAndSet(log, null);
    }

    public String getApplicationCSSClassName() {
        return "ExampleApplication";
    }

    public SystemMessages getSystemMessages() {
        return null;
    }

    public Application newInstance() {
        return new ExampleApplication(this);
    }
}