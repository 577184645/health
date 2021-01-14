package com.itheima.service;

import com.itheima.pojo.Member;

import java.util.List;

/**
 * @author: qincan
 * @create: 2021-01-13 13:49
 * @description:  会员接口
 * @version: 1.0
 */

public interface MemberService {
    public void add(Member member);
    public Member findByTelephone(String telephone);

    List<Integer> findMemberCountByMonth(List<String> list);
}
