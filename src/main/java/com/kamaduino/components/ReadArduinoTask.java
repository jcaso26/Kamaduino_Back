package com.kamaduino.components;

import com.kamaduino.utils.StringsUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ReadArduinoTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(StringsUtil.DATE_PATTERN + StringsUtil.ESPACIO + StringsUtil.TIME_PATTERN);

    @Scheduled(fixedRate = 10000)
    public void performTask() {

        System.out.println("Regular task performed at "
                + dateFormat.format(new Date()));

    }

    @Scheduled(initialDelay = 1000, fixedRate = 10000)
    public void performDelayedTask() {

        System.out.println("Delayed Regular task performed at "
                + dateFormat.format(new Date()));

    }

    @Scheduled(cron = "*/5 * * * * *")
    public void performTaskUsingCron() {

        System.out.println("Regular task performed using Cron at "
                + dateFormat.format(new Date()));

    }
}