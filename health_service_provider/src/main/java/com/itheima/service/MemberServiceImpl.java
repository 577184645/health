package com.itheima.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.dao.MemberDao;
import com.itheima.pojo.Member;
import com.itheima.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: qincan
 * @create: 2021-01-13 13:51
 * @description:
 * @version: 1.0
 */
@Service
@Transactional
public class MemberServiceImpl implements MemberService {
  @Autowired
  private MemberDao memberDao;

    //根据手机号查询会员
    public Member findByTelephone(String telephone) {
        return memberDao.findByTelephone(telephone);
    }

    @Override
    public List<Integer> findMemberCountByMonth(List<String> list) {
        List<Integer> countList=new ArrayList<>();
        for (String s : list) {
            countList.add(memberDao.findMemberCountByMonth(s+".31"));
        }
        return countList;
    }

    //新增会员
    public void add(Member member) {
        if(member.getPassword() != null){
            member.setPassword(MD5Utils.md5(member.getPassword()));
        }
        memberDao.add(member);
    }
}
