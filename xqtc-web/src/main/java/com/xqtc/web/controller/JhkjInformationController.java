package com.xqtc.web.controller;

import com.xqtc.api.utils.ApiResult;
import com.xqtc.api.dto.AddInformationDto;
import com.xqtc.api.dto.UpdateInformationDto;
import com.xqtc.api.service.JhkjInformationService;
import com.xqtc.web.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/information")
@Api(tags = "移动官网停车资讯接口文档")
public class JhkjInformationController extends BaseController {

    @Autowired
    private JhkjInformationService jhkjInformationService;

    /**
     * 添加资讯
     *
     * @return
     */
    @PostMapping("/addInformation")
    @ApiOperation(value = "添加资讯")
    public ApiResult addInformation(@Valid @RequestBody AddInformationDto addInformationDto) {
        return jhkjInformationService.addInformation(addInformationDto);
    }

    /**
     * 修改资讯
     *
     * @return
     */
    @PostMapping("/updateInformation")
    @ApiOperation(value = "修改资讯")
    public ApiResult updateInformation(@Valid @RequestBody UpdateInformationDto updateInformationDto) {
        return jhkjInformationService.updateInformation(updateInformationDto);
    }

    /**
     * 分页查询停车资讯列表
     *
     * @return
     */
    @PostMapping("/selectInformationPageList")
    @ApiOperation(value = "分页查询停车资讯列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", value = "当前页(非json)", required = true, dataType = "Integer", example = "1", paramType = "form"),
            @ApiImplicitParam(name = "informationState", value = "发布状态 (0:未发布 1:已发布 )", defaultValue = "1", required = false, example = "1", paramType = "form"),
            @ApiImplicitParam(name = "limit", value = "每页记录数 (非json)", required = true, dataType = "Integer", example = "1", paramType = "form"),
            @ApiImplicitParam(name = "informationType", value = "资讯类型(0:行业资讯 1:公司资讯 2：全部", required = true, dataType = "Integer", example = "1", paramType = "form"),
            @ApiImplicitParam(name = "orderType", value = "0：按照发布时间排序， 1：按照创建时间排序", required = true, dataType = "Integer", example = "1", paramType = "form")})
    public ApiResult selectInformationPageList(@RequestParam Integer page, @RequestParam Integer limit, @RequestParam(required = false) Integer informationState, Integer informationType, Integer orderType) {
        return jhkjInformationService.selectInformationPageList(page, limit, informationState, informationType, orderType);
    }

    /**
     * 根据资讯id查询
     *
     * @return
     */
    @PostMapping("/selectInformationById")
    @ApiOperation(value = "根据资讯id查询")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "资讯id", required = true, dataType = "String", example = "80", paramType = "form")})
    public ApiResult selectInformationById(@RequestParam String id) {
        return jhkjInformationService.jhkjInformationService(id);
    }


    /**
     * 根据资讯id删除
     *
     * @return
     */
    @PostMapping("/deletInformationById")
    @ApiOperation(value = "根据资讯id删除")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "资讯id", required = true, dataType = "Integer", example = "1", paramType = "form")})
    public ApiResult deletInformationById(@RequestParam Integer id) {
        return jhkjInformationService.deletInformationById(id);
    }
}
