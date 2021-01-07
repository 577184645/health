package com.itheima.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.constant.MessageConstant;
import com.itheima.dao.CheckItemDao;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckItem;
import com.itheima.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: qincan
 * @create: 2021-01-05 14:50
 * @description: 检查项服务
 * @version: 1.0
 */

@Service
@Transactional
public class CheckItemServiceImpl  implements CheckItemService {
    @Autowired
    private CheckItemDao checkItemDao;
    //新增
    public void add(CheckItem checkItem) {
        checkItemDao.add(checkItem);
    }

    @Override
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        PageHelper.startPage(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());
        Page<CheckItem> page = checkItemDao.selectByCondition(queryPageBean.getQueryString());
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public CheckItem findById(Integer id) { return checkItemDao.findById(id);
    }

    @Override
    public void edit(CheckItem checkItem) { checkItemDao.edit(checkItem);
    }

    @Override
    public void delete(Integer id) throws RuntimeException {
      int count=  checkItemDao.findCountByCheckItemId(id);
      if(count>0){
          throw new RuntimeException(MessageConstant.CHECKITEMHASASSOCIATION);
      }
        checkItemDao.delete(id);
    }

    @Override
    public List<CheckItem> findAll() {
        return checkItemDao.findAll();
    }

}
