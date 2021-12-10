package com.study.thinkinspring.ioc.dependencyInjection;

import com.study.thinkinspring.ioc.overview.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserHolder {

    private User user;

}
