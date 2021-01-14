package com.itheima.controller;

/**
 * @author: qincan
 * @create: 2021-01-14 15:28
 * @description:
 * @version: 1.0
 */

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.constant.MessageConstant;
import com.itheima.entity.Result;
import com.itheima.service.MemberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 统计报表
 */
@RestController
@RequestMapping("/report")
public class ReportController {


    @Reference
    private MemberService memberService;
    /**
     * 会员数量统计
     * @return
     */
    @RequestMapping("/getMemberReport")
    public Result getMemberReport() {
        List<String> list = new ArrayList<>();
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.MONTH,-12);
        for (int i=0;i<12;i++){
            calendar.add(Calendar.MONTH,+1);
            list.add(new SimpleDateFormat("yyyy.MM").format(calendar.getTime()));
        }
        Map<String,Object> map = new HashMap<>();
        map.put("months",list);
        List<Integer> memberCount = memberService.findMemberCountByMonth(list);
        map.put("memberCount",memberCount);
        return new Result(true, MessageConstant.GET_MEMBER_NUMBER_REPORT_SUCCESS,map);
    }

    public static void main(String[] args) {
        Calendar calendar=Calendar.getInstance();

            calendar.add(Calendar.MONTH,-1);
           calendar.getTime();
    }
}
