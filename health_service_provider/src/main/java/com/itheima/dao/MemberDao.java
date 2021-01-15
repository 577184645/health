package com.itheima.dao;

import com.itheima.pojo.Member;

/**
 * @author: qincan
 * @create: 2021-01-13 10:32
 * @description:  会员持久层
 * @version: 1.0
 */

public interface MemberDao {

    Member findByTelephone(String telephone);

    void add(Member member);

    int findMemberCountByMonth(String s);

    int findMemberCountByDate(String today);

    int findMemberTotalCount();

    int findMemberCountAfterDate(String thisWeekMonday);

}
