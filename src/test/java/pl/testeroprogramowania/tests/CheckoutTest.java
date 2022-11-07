package pl.testeroprogramowania.tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.models.Customer;
import pl.testeroprogramowania.pages.HomePage;
import pl.testeroprogramowania.pages.OrderDetailsPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest() {

        Customer customer = new Customer();
        customer.setEmail("specificEmail@gmail.com");

        /*Customer customer = new Customer();
        customer.setFirstName("Marcel");
        customer.setLastName("Testowy");
        customer.setCompanyName("BMB");
        customer.setCountry("Poland");
        customer.setStreet("Testowa");
        customer.setFlatNumber("22");
        customer.setZipCode("11111");
        customer.setCity("Testowe");
        customer.setPhone("624876216");
        customer.setEmail("randomowe@random.com");*/

        OrderDetailsPage orderDetailsPage =
                new HomePage(driver)
                        .openShopPage()
                        .openProduct("Java Selenium WebDriver")
                        .addProductToCart()
                        .viewCart()
                        .openAddressDetails()
                        .fillAddressDetails(customer, "Some random comment");

        Assert.assertEquals(orderDetailsPage.getOrderNotice().getText(), "Thank you. Your order has been received.");
        Assert.assertEquals(orderDetailsPage.getProductName().getText(), "Java Selenium WebDriver × 1");
    }
}

