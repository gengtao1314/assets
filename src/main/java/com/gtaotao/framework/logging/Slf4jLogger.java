/*
 * Copyright (c) 2014. kupat Corporation. All rights reserved.
 *  see statement on http://www.kupat.cn.
 */
package com.gtaotao.framework.logging;

/**
 * Created by davidcun on 2014/12/23.
 *
 * @author davidcun
 */
public class Slf4jLogger implements Logger {

    private org.slf4j.Logger logger;

    public Slf4jLogger(org.slf4j.Logger logger) {
        this.logger = logger;
    }

    @Override
    public void trace(String msg) {
        logger.trace("[gniuu logger] "+msg);
    }

    @Override
    public void trace(Throwable e) {
        logger.trace("[gniuu logger] "+e.getMessage(), e);
    }

    @Override
    public void trace(String msg, Throwable e) {
        logger.trace("[gniuu logger] "+msg, e);
    }

    @Override
    public void trace(String category, String msg) {

        logger.trace("[gniuu logger] "+"[" + category + "]" + msg);
    }

    @Override
    public void trace(String category, String msg, Throwable e) {
        logger.trace("[gniuu logger] "+"[" + category + "]" + msg, e);
    }

    @Override
    public void debug(String msg) {
        logger.debug("[gniuu logger] "+msg);
    }

    @Override
    public void debug(Throwable e) {
        logger.debug("[gniuu logger] "+e.getMessage(), e);
    }

    @Override
    public void debug(String msg, Throwable e) {
        logger.debug("[gniuu logger] "+msg, e);
    }

    @Override
    public void debug(String category, String msg) {
        logger.debug("[gniuu logger] "+"[" + category + "]" + msg);
    }

    @Override
    public void debug(String category, String msg, Throwable e) {
        logger.debug("[gniuu logger] "+"[" + category + "]" + msg, e);
    }

    @Override
    public void info(String msg) {

        logger.info("[gniuu logger] "+msg);
    }

    @Override
    public void info(Throwable e) {
        logger.info("[gniuu logger] "+e.getMessage(), e);
    }

    @Override
    public void info(String msg, Throwable e) {
        logger.info("[gniuu logger] "+msg,e);
    }

    @Override
    public void info(String category, String msg) {
        logger.info("[gniuu logger] "+"["+category+"]"+msg);
    }

    @Override
    public void info(String category, String msg, Throwable e) {

        logger.info("[gniuu logger] "+"["+category+"]"+msg,e);
    }

    @Override
    public void warn(String msg) {

        logger.warn("[gniuu logger] "+msg);
    }

    @Override
    public void warn(Throwable e) {

        logger.warn("[gniuu logger] "+e.getMessage(),e);
    }

    @Override
    public void warn(String msg, Throwable e) {

        logger.warn("[gniuu logger] "+msg,e);
    }

    @Override
    public void warn(String category, String msg) {

        logger.warn("[gniuu logger] " + "["+category+"]"+msg);
    }

    @Override
    public void warn(String category, String msg, Throwable e) {
        logger.warn("[gniuu logger] " + "["+category+"]"+msg,e);
    }

    @Override
    public void error(String msg) {
        logger.error("[gniuu logger] " + msg);
    }

    @Override
    public void error(Throwable e) {
        logger.error("[gniuu logger] " + e.getMessage(),e);
    }

    @Override
    public void error(String msg, Throwable e) {

        logger.error("[gniuu logger] " + msg,e);
    }

    @Override
    public void error(String category, String msg) {
        logger.error("[gniuu logger] " + "["+category+"]"+msg);
    }

    @Override
    public void error(String category, String msg, Throwable e) {
        logger.error("[gniuu logger] " + "["+category+"]"+msg,e);
    }

    @Override
    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    @Override
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    @Override
    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    @Override
    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

    @Override
    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }

    @Override
    public void forceAudit(String category, String msg) {
        //TODO
    }
}
