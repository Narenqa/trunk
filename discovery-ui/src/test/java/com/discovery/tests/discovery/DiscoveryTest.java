package com.discovery.tests.discovery;

import com.discovery.constants.DiscoveryConstants;
import com.discovery.helpers.DiscoveryNavigationHelper;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by narendraguntaka on 25/09/19.
 */
public class DiscoveryTest {

    DiscoveryNavigationHelper discoveryHelper;
    Logger log = Logger.getLogger(DiscoveryTest.class);

    @BeforeTest
    public void setup() {
        discoveryHelper = new DiscoveryNavigationHelper();
    }

    @Test
    public void discoveryTest() {
        log.info("************************ Add Best Seller Item to cart Test started ***********************");
        discoveryHelper.navigateToDiscoveryHomePage(DiscoveryConstants.DISCOVERY_BASE_URL);

        log.info("************************ Add Best Seller Item to cart Test completed ***********************");
    }

}
