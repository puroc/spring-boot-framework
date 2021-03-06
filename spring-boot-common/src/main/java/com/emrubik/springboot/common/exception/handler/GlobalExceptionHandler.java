package com.emrubik.springboot.common.exception.handler;

import com.emrubik.springboot.domain.to.base.BaseResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;


@ControllerAdvice("com.emrubik.springboot")
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity ExceptionHandler(HttpServletResponse response, Throwable t) {
        log.error(t.getMessage(),t);
        BaseResp resp = new BaseResp();
        resp.setResultCode(BaseResp.RESULT_FAILED);
        resp.setMessage("操作失败");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity MethodArgumentNotValidExceptionHandler(HttpServletResponse response, Throwable t) {
        BaseResp resp = new BaseResp();
        resp.setResultCode(BaseResp.RESULT_FAILED);
        resp.setMessage("参数校验失败");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
    }

}