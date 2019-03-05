package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.bean.DemoDTO;
import com.example.demo.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;

@Slf4j
@Api(value = "test", description = "demoController")
@RestController
@RequestMapping("demo")
public class DemoController {

    @ApiOperation(value = "show", notes = "展示首页信息")
    @GetMapping("/show")
    public static Object showInfo() {
        User user = new User();
        user.getName();
        log.info("");
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);

        return "hello world";
    }

    @ApiOperation(value = "/fileUpload", notes = "上传文件信息")
    @PostMapping(value = "upload", headers = "content-type=multipart/form-data")
    public String demoFileUpload(@RequestBody DemoDTO demoDTO) throws Exception {
        System.out.println(JSON.toJSONString(demoDTO));
        InputStream in = demoDTO.getFile().getInputStream();
        System.out.println(JSON.toJSONString(demoDTO));
        return "hello world";
    }
}
