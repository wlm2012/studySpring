package com.spring.webmagic.pipeline;

import com.spring.webmagic.BO.Spider;
import com.spring.webmagic.entity.SpiderUpdate;
import com.spring.webmagic.repository.SpiderUpdateRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class DatasourcePipeline implements PageModelPipeline<Spider> {

    @Resource
    private SpiderUpdateRepository repository;


    @Override
    public void process(Spider spider, Task task) {
        String name = spider.getName();
        Optional<SpiderUpdate> optional = repository.findByName(name);
        SpiderUpdate spiderUpdate = new SpiderUpdate();
        if (optional.isEmpty() || optional.get().getContent() == null) {
            BeanUtils.copyProperties(spider, spiderUpdate);
        } else {
            spiderUpdate = optional.get();
            spiderUpdate.setUpdated(false);
            if (!spiderUpdate.getContent().equals(spider.getContent())) {
                spiderUpdate.setUpdated(true);
            }
        }

        repository.save(spiderUpdate);
    }
}
