package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.bean.Bao;
import com.example.demo.bean.User;
import com.example.demo.bean.UserWu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {

        Bao<User> bao = new Bao<>();

        List<User> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            User user = new User();
            user.setName("wu" + i);
            list.add(user);
        }
        bao.setList(list);

        List<User> wuList = new ArrayList<>();

        bao.getList().stream().forEach(user -> {
            UserWu userWu = new UserWu();
            BeanUtils.copyProperties(user, userWu);
            userWu.setXing("xing");
            wuList.add(userWu);
        });

        bao.setList(wuList);
        bao.getList().stream()
                .forEach(user -> {
                    System.out.println(JSON.toJSONString(user));
                });

        List<User> xingDisList = new ArrayList<>();
        //强行转化使用
        bao.getList().stream().forEach(user -> {
            UserWu userWu = (UserWu) user;
            userWu.setDis("Strong dis");
            xingDisList.add(userWu);
        });
        bao.setList(xingDisList);
        bao.getList().stream()
                .forEach(user -> {
                    System.out.println(JSON.toJSONString(user));
                });

        List<User> disList = new ArrayList<>();
        bao.getList().stream()
                .forEach(user -> {
                    UserWu userWu = new UserWu();
                    BeanUtils.copyProperties(user, userWu);
                    userWu.setDis("DIS");
                    disList.add(userWu);
                });

        bao.setList(disList);
        bao.getList().stream()
                .forEach(user ->
                        System.out.println(JSON.toJSONString(user)));

    }

}

