package myprojects.automation.assignment4.tests;

import myprojects.automation.assignment4.BaseTest;
import myprojects.automation.assignment4.model.ProductData;
import org.testng.annotations.Test;

public class CreateProductTest extends BaseTest {

    @Test(dataProvider = "authorization")
    public void createNewProduct(String login, String pass) {

        actions.login(login, pass);
        actions.createProduct(ProductData.generate());
    }

    @Test(dependsOnMethods = {"createNewProduct"})
    public void checkTheProduct(){
      actions.goToStore();
      actions.checkTheNameOfTheProduct();
      actions.detailedInfoAboutProduct();
      actions.chekcAllFields();
    }

}
