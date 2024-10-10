package tests;

import pages.DataTablesPage;
import constants.MainPageNavigation;
import utils.SettingsTestData;
import utils.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataTableTests extends BaseTest {
    private final DataTablesPage dataTablesPage = new DataTablesPage();

    @Test
    public void dataTableTest() {
        mainPage.clickNavigationLink(MainPageNavigation.SORTABLE_DATA_TABLES);
        Double actualSum = 0.0;
        for (String due : dataTablesPage.getFirstDueList()) {
            actualSum += StringUtils.getDoubleFromString(due);
        }
        Assert.assertEquals(actualSum, SettingsTestData.getDataTableData().getExpectedDueSum(), "Sum is not correct");
    }
}
