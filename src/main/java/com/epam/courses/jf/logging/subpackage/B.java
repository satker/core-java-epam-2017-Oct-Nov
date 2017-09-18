package com.epam.courses.jf.logging.subpackage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class B {

    private static final Logger LOG = LogManager.getLogger(B.class);

    public static void main(String[] args) {
        LOG.error("From B class");
    }
}
