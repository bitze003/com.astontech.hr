package com.astontech.hr.services;

import com.astontech.hr.domain.Scheduler;
import com.astontech.hr.repositories.SchedulerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface SchedulerService {

    Scheduler saveScheduler(Scheduler scheduler);
}
