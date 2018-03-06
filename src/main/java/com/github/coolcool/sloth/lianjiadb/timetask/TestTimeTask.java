package com.github.coolcool.sloth.lianjiadb.timetask;

import com.github.coolcool.sloth.lianjiadb.common.MyHttpClient;
import com.github.coolcool.sloth.lianjiadb.service.ProcessService;
import com.github.coolcool.sloth.lianjiadb.service.impl.support.LianjiaWebUtil;
import com.github.coolcool.sloth.lianjiadb.service.impl.ProcessServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.Calendar;
import java.util.TimerTask;

@Component
@EnableScheduling
@Service
public class TestTimeTask{

    @Autowired
    private ProcessService processService;

    private static final Logger log = LoggerFactory.getLogger(FetchHouseIndexTimeTask.class);

    /**
     * 根据当天的执行任务，按最小区域（车陂、华景）分页获取房屋链接地址，入库 houseindex
     */
    @Scheduled(cron="0 0/5 * * * ?")   //每5分钟执行一次
    public void exe() {
        log.info("开始执行houseUrlsFetching...");
        try {
            processService.fetchHouseUrls();
            }catch (Throwable t){
                t.printStackTrace();
            }
    }

}
