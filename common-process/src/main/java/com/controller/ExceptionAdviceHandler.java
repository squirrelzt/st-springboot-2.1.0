package com.controller;

import com.enums.ExceptionConstant;
import com.result.BaseResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.io.IOException;

@RestControllerAdvice
public class ExceptionAdviceHandler {
    private ObjectError objectError;

    /**
     * 未知异常
     */
    @ExceptionHandler(value = Exception.class)
    public BaseResponse unKnowExceptionHandler(Exception e) {
        return BaseResponse.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), StringUtils.join(ExceptionConstant.UNKNOW_TYPE_EXCEPTION,exceptionHandler(e)));
    }

    /**
     * 运行时异常
     */
    @ExceptionHandler(value = RuntimeException.class)
    public BaseResponse runtimeExceptionHandler(RuntimeException e) {
        return BaseResponse.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), StringUtils.join(ExceptionConstant.RUNTIME_EXCEPTION,exceptionHandler(e)));
    }

    /**
     * 空指针异常
     */
    @ExceptionHandler(NullPointerException.class)
    public BaseResponse nullPointerExceptionHandler(NullPointerException e) {
        return BaseResponse.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), StringUtils.join(ExceptionConstant.NULL_POINTER_EXCEPTION,exceptionHandler(e)));

    }

    /**
     * 类型转换异常
     */
    @ExceptionHandler(ClassCastException.class)
    public BaseResponse classCastExceptionHandler(ClassCastException e) {
        return BaseResponse.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), StringUtils.join(ExceptionConstant.CLASS_CAST_EXCEPTION,exceptionHandler(e)));
    }

    /**
     * IO异常
     */
    @ExceptionHandler(IOException.class)
    public BaseResponse iOExceptionHandler(IOException e) {
        return BaseResponse.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), StringUtils.join(ExceptionConstant.CLASS_CAST_EXCEPTION,exceptionHandler(e)));
    }

    /**
     * 数组越界异常
     */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public BaseResponse indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException e) {
        return BaseResponse.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), StringUtils.join(ExceptionConstant.CLASS_CAST_EXCEPTION,exceptionHandler(e)));

    }

    /**
     * 参数类型不匹配
     */
    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public BaseResponse requestTypeMismatch(MethodArgumentTypeMismatchException e){
        return BaseResponse.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), StringUtils.join(ExceptionConstant.METHOD_ARGUMENT_TYPE_MISMATCH_EXCEPTION,exceptionHandler(e)));
    }
    /**
     * 缺少参数
     */
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public BaseResponse requestMissingServletRequest(MissingServletRequestParameterException e) {
        return BaseResponse.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), StringUtils.join(ExceptionConstant.METHOD_ARGUMENT_TYPE_MISMATCH_EXCEPTION,exceptionHandler(e)));
    }
    /**
     * 请求method不匹配
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public BaseResponse requestMissingServletRequest(HttpRequestMethodNotSupportedException e) {
        return BaseResponse.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), StringUtils.join(ExceptionConstant.HTTP_REQUEST_METHOD_NOT_SUPPORT_EXCEPTION,exceptionHandler(e)));
    }

    /**
     *
     * 控制器方法中@RequestBody类型参数数据类型转换异常
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public BaseResponse httpMessageNotReadableException(HttpMessageNotReadableException e, WebRequest wq){
        e.printStackTrace();
        Throwable throwable = e.getRootCause();
        return BaseResponse.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), StringUtils.join(ExceptionConstant.HTTP_REQUEST_METHOD_NOT_SUPPORT_EXCEPTION,throwable.getMessage()));
    }

    /**
     *
     * 控制器方法参数异常
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public BaseResponse methodArgumentNotValidException(MethodArgumentNotValidException e){
        e.printStackTrace();
        BindingResult bindingResult = e.getBindingResult();
        FieldError fieldError = bindingResult.getFieldError();
        return BaseResponse.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), StringUtils.join(ExceptionConstant.METHOD_ARGUMENT_NOT_VALID_EXCEPTION,fieldError.getDefaultMessage()));
    }

    private String exceptionHandler(Exception e) {
        e.printStackTrace();
        StackTraceElement[] elements = e.getStackTrace();
        String message = StringUtils.EMPTY;
        if(elements.length > 0){
            StackTraceElement element = elements[0];
            message = StringUtils.join(element.getClassName(), ".", element.getMethodName(), "类的第", element.getLineNumber(), "行发生", e.toString(), "异常");
        }
        if(StringUtils.isBlank(message)){
            message = e.toString();
        }
        return message;
    }
}
