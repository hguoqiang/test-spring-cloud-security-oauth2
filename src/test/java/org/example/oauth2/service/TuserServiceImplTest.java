package org.example.oauth2.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.example.oauth2.TestSecurityOauth2Application;
import org.example.oauth2.domain.generator.TUser;
import org.example.oauth2.pojo.Tuser;
import org.example.oauth2.pojo.TuserParam;
import org.example.oauth2.pojo.TuserResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @description:
 * @author: huanggq
 * @create: 2021-02-01 12:09
 **/
@SpringBootTest(classes = TestSecurityOauth2Application.class)
public class TuserServiceImplTest {
    @Autowired
    private TuserServiceImpl tuserService;

    @Test
    void queryById() {
        Tuser tuser = tuserService.queryById(1L);
        System.out.println(tuser);
    }

    @Test
    void queryList() {
        TuserParam param = new TuserParam();
        //param.setId(1L);
        param.setMobile("123");
        List<TuserResult> tuserResults = tuserService.queryList(param);
        System.out.println(tuserResults);
    }


    @Test
    void pageQueryList() {
        TuserParam param = new TuserParam();
        //param.setId(1L);
        param.setMobile("123");
        PageInfo pageInfo = tuserService.pageQueryList(2,3,param);
        System.out.println("pageInfo.getPages():" + pageInfo.getPages());
        System.out.println("pageInfo.getList().size():" + pageInfo.getList().size());
        System.out.println("pageInfo.getSize():" + pageInfo.getSize());
        System.out.println(pageInfo);
        /*
            1, 0, 3   start = pageNo-1 * pageSize
            2, 3, 3
            3, 6, 3
         */

    }
    @Test
    void pageQueryList2() {
        TuserParam param = new TuserParam();
        //param.setId(1L);
        param.setMobile("123");
        Page page = tuserService.pageQueryList2(2, 3, param);

        System.out.println("page.getResult().size():" + page.getResult().size());
        System.out.println("pageInfo.getPages():" + page.getPages());

        System.out.println("pageInfo.getTotal():" + page.getTotal());
        System.out.println(page);
        /*
            1, 0, 3   start = pageNo-1 * pageSize
            2, 3, 3
            3, 6, 3
         */

    }


    @Test
    void pageQueryList3() {
        TuserParam param = new TuserParam();
        param.setId(1L);
        param.setMobile("");
        PageInfo<TUser> pageInfo = tuserService.pageQueryList3(2, 3, param);

        System.out.println("page.getResult().size():" + pageInfo.getList().size());
        System.out.println("pageInfo.getPages():" + pageInfo.getPages());

        System.out.println("pageInfo.getTotal():" + pageInfo.getTotal());
        System.out.println(pageInfo);
        /*
            1, 0, 3   start = pageNo-1 * pageSize
            2, 3, 3
            3, 6, 3
         */

    }


}