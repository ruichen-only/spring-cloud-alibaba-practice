package com.tidever.search.controller;

import com.tidever.common.api.CommonPage;
import com.tidever.common.api.CommonResult;
import com.tidever.search.domain.EsUser;
import com.tidever.search.service.EsUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Visit API类
 *
 * @author LiuXin on 2021/11/25
 */
@Controller
@Api(tags = "EsUserConroller")
@RequestMapping("/esVisit")
public class EsUserConroller {
    @Autowired
    private EsUserService esUserService;

    @ApiOperation(value = "导入所有数据库中用户到ES")
    @RequestMapping(value = "/importAll", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> importAllList() {
        int count = esUserService.importAll();
        return CommonResult.success(count);
    }

    @ApiOperation(value = "根据id删除用户")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Object> delete(@PathVariable Long id) {
        esUserService.delete(id);
        return CommonResult.success(null);
    }

    @ApiOperation(value = "根据id批量删除用户")
    @RequestMapping(value = "/delete/batch", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Object> delete(@RequestParam("ids") List<Long> ids) {
        esUserService.delete(ids);
        return CommonResult.success(null);
    }

    @ApiOperation(value = "根据id创建用户")
    @RequestMapping(value = "/create/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<EsUser> create(@PathVariable Long id) {
        EsUser esVisit = esUserService.create(id);
        if (esVisit != null) {
            return CommonResult.success(esVisit);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "简单搜索")
    @RequestMapping(value = "/userManagement/getList", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<EsUser>> search(@RequestParam(required = false) String username,
                                                    @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                    @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Page<EsUser> esProductPage = esUserService.search(username, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(esProductPage));
    }
}
