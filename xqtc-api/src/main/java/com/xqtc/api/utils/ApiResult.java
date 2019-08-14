/**
 *
 */
package com.xqtc.api.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @ClassName: ApiResult
 * @Description: TODO
 * @author zhangw
 * @date 2019-6-27 上午11:05:52
 */
@ApiModel(description= "返回响应数据")
public class ApiResult implements Serializable {

	private static final long serialVersionUID = 7436679719646824776L;
	@ApiModelProperty(value = "是否成功")
	private boolean isSuccess = true;
	@ApiModelProperty(value = "返回对象")
	private Object data;
	private String error;
	private int code = ResultCode.SUCCESS.getCode();

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.isSuccess = false;
		this.error = error;
	}
	public void setError(ResultCode resultCode) {
		this.error=resultCode.getMessage();
		this.code=resultCode.getCode();
		this.isSuccess=false;
	}
	public void setError(ResultCode resultCode, String message) {
		this.error=String.format(resultCode.getMessage(),message);
		this.code=resultCode.getCode();
		this.isSuccess=false;
	}

}
