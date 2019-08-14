package com.xqtc.web.exceptions;

import com.xqtc.common.result.ApiResult;
import com.xqtc.common.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * GlobalExceptionHandler.class
 *
 * @author HangLin.Ren
 * @date 2019/07/19
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResult handleError(MissingServletRequestParameterException e) {
        ApiResult apiResult = new ApiResult();
        log.warn("缺少请求参数", e.getMessage());
        String message = String.format("缺少必要的请求参数: %s", e.getParameterName());
        apiResult.setError(ResultCode.INVOKE_EXCEPTION, message);
        return apiResult;
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResult handleError(MethodArgumentTypeMismatchException e) {
        ApiResult apiResult = new ApiResult();
        log.warn("请求参数格式错误", e.getMessage());
        String message = String.format("请求参数格式错误: %s", e.getName());
        apiResult.setError(ResultCode.INVOKE_EXCEPTION,"请求参数类型错误：" + message);
        return apiResult;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResult handleError(MethodArgumentNotValidException e) {
        ApiResult apiResult = new ApiResult();
        log.warn("参数验证失败", e.getMessage());
        return handleError(e.getBindingResult());
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResult handleError(BindException e) {
        log.warn("参数绑定失败", e.getMessage());
        return handleError(e.getBindingResult());
    }

    private ApiResult handleError(BindingResult result) {
        ApiResult apiResult = new ApiResult();
        FieldError error = result.getFieldError();
        String message = String.format("%s:%s", error.getField(), error.getDefaultMessage());
        apiResult.setError(ResultCode.INVOKE_EXCEPTION,"请求参数绑定错误：" + message);
        return apiResult;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResult handleError(ConstraintViolationException e) {
        ApiResult apiResult = new ApiResult();
        log.warn("参数验证失败", e.getMessage());
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation<?> violation = violations.iterator().next();
        String path = ((PathImpl) violation.getPropertyPath()).getLeafNode().getName();
        String message = String.format("%s:%s", path, violation.getMessage());
        apiResult.setError(ResultCode.INVOKE_EXCEPTION,"参数校验失败：" + message);
        return apiResult;
    }
}
