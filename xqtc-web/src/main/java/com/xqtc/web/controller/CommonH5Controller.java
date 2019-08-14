package com.xqtc.web.controller;

import com.xqtc.api.service.ChannelCityService;
import com.xqtc.api.service.XqtcOrdersService;
import com.xqtc.api.utils.ApiResult;
import com.xqtc.api.utils.ResultCode;
import com.xqtc.common.utils.StringUtils;
import com.xqtc.web.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/common")
@Api(tags = "通用H5接口文档")
public class CommonH5Controller extends BaseController {

    @Autowired
    private ChannelCityService channelCityService;
    @Autowired
    private XqtcOrdersService xqtcOrdersService;

    @ApiImplicitParams({@ApiImplicitParam(name = "userId", value = "用户id", required = true, paramType = "form"),
            @ApiImplicitParam(name = "channelId", value = "渠道id", required = true, paramType = "form"),
            @ApiImplicitParam(name = "cityName", value = "城市名称", required = true, paramType = "form")})
    @ApiOperation(value = "通用H5首页", notes = "首页相关信息查询")
    @PostMapping("/home")
    public ApiResult H5HomePage(String userId, Integer channelId, String cityName) {
        ApiResult apiResult = new ApiResult();
        if (StringUtils.isEmpty(cityName)) {
            apiResult.setError(ResultCode.RESULT_IS_NULL, "参数不能为空！");
            return apiResult;
        }
        apiResult = channelCityService.airportAndHighSpeedInfo(channelId, cityName);
        return apiResult;
    }

    @ApiImplicitParams({@ApiImplicitParam(name = "userId", value = "用户id", required = true, paramType = "form"),
            @ApiImplicitParam(name = "channelId", value = "渠道id", required = true, paramType = "form"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", required = true, paramType = "form"),
            @ApiImplicitParam(name = "pageNum", value = "当前页码", required = true, paramType = "form"),
            @ApiImplicitParam(name = "orderStatus", value = "订单状态 down 完成  all 全部  未支付 unpaid 进行中 underway", required = true, paramType = "form")})
    @ApiOperation(value = "订单列表", notes = "订单列表")
    @PostMapping("/orderList")
    public ApiResult orderList(String userId, String channelId, Integer pageSize, Integer pageNum, String orderStatus) {
        ApiResult apiResult = new ApiResult();
        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(channelId)) {
            apiResult.setError(ResultCode.CHECK_USER_FAIL, "参数为空！");
            return apiResult;
        }
        apiResult = xqtcOrdersService.getOrderList(userId, channelId, pageSize, pageNum, orderStatus);
        return apiResult;
    }

    @ApiImplicitParams({@ApiImplicitParam(name = "orderId", value = "订单id", required = true, paramType = "form")})
    @ApiOperation(value = "订单详情", notes = "订单详情")
    @PostMapping("/orderdetail")
    public ApiResult orderdetail(String orderId) {
        ApiResult apiResult = new ApiResult();
        if (StringUtils.isEmpty(orderId)) {
            apiResult.setError(com.xqtc.api.utils.ResultCode.CHECK_USER_FAIL, "参数为空！");
            return apiResult;
        }
        apiResult = xqtcOrdersService.getOrderDetailed(orderId);
        return apiResult;
    }

    @ApiImplicitParams({@ApiImplicitParam(name = "site", value = "站点名称（比如：杭州东站  北京首都国际机场）", required = true, paramType = "form"),
            @ApiImplicitParam(name = "channelId", value = "渠道id ", required = true, paramType = "form"),
            @ApiImplicitParam(name = "pageNum", value = "当前页码", required = true, paramType = "form"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", required = true, paramType = "form")})
    @ApiOperation(value = "根据站点查询停车场列表", notes = "根据站点查询停车场列表")
    @PostMapping("/selectParkType")
    public ApiResult selectParkType(String site, String channelId, Integer pageNum, Integer pageSize) {
        ApiResult apiResult = channelCityService.selectParkByType(site, channelId, pageNum, pageSize);
        return apiResult;
    }

    @ApiImplicitParams({@ApiImplicitParam(name = "userId", value = "用户id", required = true, paramType = "form")})
    @ApiOperation(value = "招商银行支付", notes = "招商银行支付")
    @PostMapping("/merchantsbank")
    public ApiResult merchantsbank() {
        ApiResult apiResult = new ApiResult();
        //TODO
        return apiResult;
    }
}
