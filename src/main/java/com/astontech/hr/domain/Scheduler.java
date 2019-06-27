package com.astontech.hr.domain;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

@Entity
@Data
    public class Scheduler {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "SchedulerId")
        private Integer id;

        @Version
        private Integer version;

        private double value;




    }


