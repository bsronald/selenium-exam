package com.jala.selenium.exam.utils;

import org.apache.commons.lang3.SystemUtils;
import org.apache.log4j.Logger;


/**
 * @author bsronald on 4/12/17.
 */
public class EnvironmentChecker {

    private static EnvironmentChecker instance = null;
    private static String osName = "";
    final static Logger LOG = Logger.getLogger(EnvironmentChecker.class);
    private EnvironmentChecker() {
        osChecker();
    }

    public static EnvironmentChecker getInstance() {
        if (instance == null) {
            instance = new EnvironmentChecker();
        }
        return instance;
    }

    /***
     * This method will verify the environment OS
     */
    private void osChecker() {
        if (SystemUtils.IS_OS_WINDOWS) {
            LOG.info("Environment Detected: Windows based");
            osName = "Windows";
        } else if (SystemUtils.IS_OS_LINUX) {
            LOG.info("Environment Detected: LINUX Based");
            osName = "Linux";
        } else if(SystemUtils.IS_OS_UNIX) {
            LOG.info("Environment Detected: UNIX Based");
            osName = "Unix";
        } else {
            LOG.error("Environment not supported");
            System.exit(1);
        }
    }

    /***
     * This method will return the OS name
     *
     * @return the OS name
     */
    public String getOsName() {
        return osName;
    }

}
