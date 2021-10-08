package com.study.thinkinspring.ioc.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class ScopeService {

    private Integer count = 0;

    public void add() {
        System.out.println(count++);
    }
}
