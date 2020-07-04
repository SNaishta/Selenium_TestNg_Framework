package pages.actions;

import com.google.common.collect.Comparators;
import com.webapp.browser.DriverHelper;
import com.webapp.enums.SortType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.objects.ProductsPageObject;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.webapp.enums.SortType.getSortCode;

public class ProductsPage extends ProductsPageObject {

    DriverHelper driverHelper;

    public ProductsPage(DriverHelper driverHelper) {
        this.driverHelper = driverHelper;
    }

    public void sortProductsByPrice() {
        driverHelper.click(productSortDropdown);
    }

    public void setSortOrder(String sortOrderText) {
        SortType sortType = getSortCode(sortOrderText);
        String shortText = sortType.getSortType();

        Select productDropDown = new Select(driver.findElement(productSortDropdown));
        productDropDown.selectByValue(shortText);
    }

    public boolean validateListIsSorted() {
        List<WebElement> inventoryPriceList = driver.findElements(inventoryPrice);
        for (WebElement temp : inventoryPriceList) {
            ArrayList<String> list = new ArrayList<>();
            list.add(driverHelper.regexTo(temp.getText()));
            return Comparators.isInOrder(list, Comparator.<String>naturalOrder());
        }
        return false;
    }

    public boolean pickCheapestAndNthItemFromtheInventory(Integer index) {
        List<WebElement> productCount = driver.findElements(inventoryCount);
        int count = productCount.size();
        for (int i = 0; i < count; i++) {
            productCount.get(index-1).click();
        }
        productCount.get(count-1).click();
        driver.findElement(viewCart).click();
        return true;
    }
}
