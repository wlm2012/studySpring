package com.spring.webmagic.serviceImp;

import com.spring.webmagic.entity.Disk;
import com.spring.webmagic.entity.Path;
import com.spring.webmagic.repository.DiskRepository;
import com.spring.webmagic.repository.PathRepository;
import com.spring.webmagic.service.ScanStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ScanService {

    private final DiskRepository diskRepository;
    private final PathRepository pathRepository;

    private final Map<String, ScanStrategy> scanStrategyMap = new HashMap<>();

    @Autowired
    public void setAVScanStrategy(AVScanStrategy avScanStrategy) {
        scanStrategyMap.put(avScanStrategy.getClass().getSuperclass().getSimpleName(), avScanStrategy);
    }

    @Autowired
    public ScanService(DiskRepository diskRepository, PathRepository pathRepository) {
        this.diskRepository = diskRepository;
        this.pathRepository = pathRepository;
    }

    public void scan() {
        Optional<Disk> optionalDisk = diskRepository.findById(1L);
        if (optionalDisk.isEmpty()) {
            System.out.println("未配置磁盘");
            return;
        }

        Disk disk = optionalDisk.get();
        List<Path> paths = pathRepository.findByEnable(true);


        if (!System.getProperty("os.name").contains("Windows")) {
            System.out.println(System.getProperty("os.name"));
            System.out.println("该系统未配置");
            return;
        }

        String diskPath = disk.getDisk() + ":\\";

        for (Path path : paths) {
            ScanStrategy scanStrategy = scanStrategyMap.get(path.getStrategy());
            if (scanStrategy != null) {
                scanStrategy.scan(diskPath + path.getPath());
            }
        }

    }
}
