package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Scheduler;
import com.astontech.hr.repositories.SchedulerRepository;
import com.astontech.hr.services.SchedulerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class SchedulerServieImpl implements SchedulerService {

    private static final Logger log = LoggerFactory.getLogger(SchedulerServieImpl.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private SchedulerRepository schedulerRepository;

    @Override
    public Scheduler saveScheduler(Scheduler scheduler) {
        return schedulerRepository.save(scheduler);
    }

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        Scheduler mySchedulerValues = new Scheduler();
        mySchedulerValues.setValue(Math.random());
        saveScheduler(mySchedulerValues);
    }

//    static class Task extends TimerTask {
//        Timer timer = new Timer();
//        @Override
//        public void run() {
//            int delay = (5 + new Random().nextInt(5)) * 1000;
//            timer.schedule(new Task(), delay);
//            System.out.println(new Date());
//        }
//    }
}
