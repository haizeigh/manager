package com.group5.manager.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author yl
 * @date 2020-06-18
 */
@Component
@Slf4j
public class ScheduleTest {


    @Scheduled(cron = "0/10 * * * * ?")
    public void morningTask(){
        log.info("系统运行中...");
//        subscribeOfficialAccountRecordService.insertOne();

    }

}
