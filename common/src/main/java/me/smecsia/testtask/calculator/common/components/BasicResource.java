package me.smecsia.testtask.calculator.common.components;

import me.smecsia.testtask.calculator.common.util.JsonUtil;

import java.io.IOException;

import static me.smecsia.testtask.calculator.common.util.ExceptionUtil.formatStackTrace;

/**
 * Copyright (c) 2012 i-Free. All Rights Reserved.
 *
 * @author Ilya Sadykov
 *         Date: 13.12.12
 *         Time: 11:24
 */
public abstract class BasicResource extends BasicService {

    public static class Response {
        public static enum Code {
            OK, ERROR
        }

        public Code result;
        public Object data;

        public Response(Code result) {
            this.result = result;
        }

        public Response(Code result, Object data) {
            this.result = result;
            this.data = data;
        }
    }

    protected String errorResponse(Object data) {
        try {
            Response response = new Response(Response.Code.ERROR, data);
            return JsonUtil.toJson(response);
        } catch (IOException e) {
            logAndThrow(e);
        }
        return null;
    }

    protected String errorResponse(Throwable error) {
        try {
            Response response = new Response(Response.Code.ERROR);
            response.data = formatStackTrace(error);
            return JsonUtil.toJson(response);
        } catch (IOException e) {
            logAndThrow(e);
        }
        return null;
    }

    protected String okResponse() {
        return okResponse(null);
    }

    protected String okResponse(Object data) {
        try {
            return JsonUtil.toJson(new Response(Response.Code.OK, data));
        } catch (IOException e) {
            logAndThrow(e);
        }
        return null;
    }
}
