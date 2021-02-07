package org.example.oauth2.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.oauth2.dao.TuserMapper;
import org.example.oauth2.dao.generator.TUserMapper;
import org.example.oauth2.domain.generator.TUser;
import org.example.oauth2.domain.generator.TUserExample;
import org.example.oauth2.pojo.Tuser;
import org.example.oauth2.pojo.TuserParam;
import org.example.oauth2.pojo.TuserResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @description:
 * @author: huanggq
 * @create: 2021-02-01 11:38
 **/
@Service
public class TuserServiceImpl {
    @Autowired
    private TuserMapper tuserMapper;

    @Autowired
    private TUserMapper tUserMapper;

    public Tuser queryById(Long id) {
        Tuser tuser = tuserMapper.selectByPrimaryKey(id);
        return tuser;
    }

    public List<TuserResult> queryList(TuserParam param) {

        List<TuserResult> tuserResults = tuserMapper.selectList(param);

        return tuserResults;
    }


    public PageInfo pageQueryList(int startNum, int pageSize, TuserParam param) {

        PageHelper.startPage(startNum, pageSize, false);
        List<TuserResult> tuserResults = tuserMapper.selectList(param);
        PageInfo pageInfo = new PageInfo(tuserResults);

        return pageInfo;
    }

    public Page pageQueryList2(int startNum, int pageSize, TuserParam param) {

        Page<TuserResult> page = PageHelper.startPage(startNum, pageSize, false).doSelectPage(() -> tuserMapper.selectList(param));

//        PageHelper.startPage(startNum, pageSize, false).doSelectPageInfo()

        return page;
    }


    public PageInfo<TUser> pageQueryList3(int startNum, int pageSize, TuserParam param) {

        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();

        Optional.ofNullable(param.getId()).ifPresent(id -> criteria.andIdEqualTo(id));

        Optional.ofNullable(param.getMobile()).ifPresent(mobile ->criteria.andMobileEqualTo(mobile));

        PageInfo<TUser> pageInfo = PageHelper.startPage(startNum, pageSize, false).doSelectPageInfo(() -> tUserMapper.selectByExample(example));

//        PageHelper.startPage(startNum, pageSize, false).doSelectPageInfo()

        return pageInfo;
    }

}
