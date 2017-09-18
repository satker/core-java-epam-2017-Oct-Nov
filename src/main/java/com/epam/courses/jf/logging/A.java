package com.epam.courses.jf.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class A {

    private static final Logger LOG = LogManager.getLogger(A.class);

    public static void main(String[] args) {
        LOG.info("info");
        LOG.debug("debug");
        LOG.error("error");
    }
}
