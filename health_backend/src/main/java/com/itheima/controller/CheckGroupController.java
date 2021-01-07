package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.constant.MessageConstant;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.entity.Result;
import com.itheima.pojo.CheckGroup;
import com.itheima.pojo.CheckItem;
import com.itheima.service.CheckGroupService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: qincan
 * @create: 2021-01-06 20:08
 * @description: 检查组管理
 * @version: 1.0
 */
@RestController
@RequestMapping("/checkgroup")
public class CheckGroupController {
   @Reference
    private CheckGroupService checkGroupService;




    //查询所有
    @RequestMapping("/findAll")
    public Result findAll(){
        List<CheckGroup> checkGroupList = checkGroupService.findAll();
        if(checkGroupList != null && checkGroupList.size() > 0){
            Result result = new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS);
            result.setData(checkGroupList);
            return result;
        }
        return new Result(false,MessageConstant.QUERY_CHECKGROUP_FAIL);
    }



    @RequestMapping("/findById")
    public Result findById(Integer id){

        try {
            CheckGroup checkGroup = checkGroupService.findById(id);
            return new Result(true,MessageConstant.ADD_CHECKITEM_SUCCESS,checkGroup);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.ADD_CHECKGROUP_FAIL);
        }

    }

    @RequestMapping("/findCheckItemIdsByCheckGroupId")
    public Result findCheckItemIdsByCheckGroupId(Integer id){

        try {
            List<Integer> checkItemIdsByCheckGroupId = checkGroupService.findCheckItemIdsByCheckGroupId(id);
            return new Result(true,MessageConstant.ADD_CHECKITEM_SUCCESS,checkItemIdsByCheckGroupId);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.ADD_CHECKGROUP_FAIL);
        }

    }


    //编辑
    @RequestMapping("/edit")
    public Result edit(@RequestBody CheckGroup checkGroup,Integer[] checkitemIds){
        try {
            checkGroupService.edit(checkGroup,checkitemIds);
        }catch (Exception e){
            return new Result(false,MessageConstant.EDIT_CHECKGROUP_FAIL);
        }
        return new Result(true,MessageConstant.EDIT_CHECKGROUP_SUCCESS);
    }



   @RequestMapping("/add")
    public Result add(@RequestBody CheckGroup checkGroup, Integer [] checkitemIds){
       try {
           checkGroupService.add(checkGroup,checkitemIds);
       } catch (Exception e) {
           e.printStackTrace();
           return new Result(false, MessageConstant.ADD_CHECKGROUP_SUCCESS);
       }
       return new Result(true, MessageConstant.ADD_CHECKGROUP_FAIL);
   }
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
       return  checkGroupService.findPage(queryPageBean);
    }





}
