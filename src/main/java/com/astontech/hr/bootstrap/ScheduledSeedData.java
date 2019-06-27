package com.astontech.hr.bootstrap;

import com.astontech.hr.services.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ScheduledSeedData implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        saveScheduler();
    }

    @Autowired
    private SchedulerService schedulerService;


    private void saveScheduler(){

    }
}
