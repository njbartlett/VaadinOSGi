package com.example.vaadin;

import org.osgi.service.log.LogService;

import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SuppressWarnings("serial")
class ExampleApplication extends Application {
    
    private final ExampleAppFactory factory;

    ExampleApplication(ExampleAppFactory factory) {
        this.factory = factory;
    }

    @Override
    public void init() {
        GridLayout layout = new GridLayout(1, 1);
        setMainWindow(new Window("Example", layout));
        
        Button button = new Button("Send Log Message");
        layout.addComponent(button);
        
        button.addListener(new ClickListener() {
            public void buttonClick(ClickEvent event) {
                LogService log = factory.logRef.get();
                if(log != null)
                    log.log(LogService.LOG_INFO, "The Button Was Clicked!");
            }
        });
    }

}
