package core.steps;

import core.pages.CartPage;
import core.pages.FormPage;
import core.pages.ProductsListPage;

public class BaseStep {
    protected FormPage formPage;
    protected ProductsListPage productsListPage;
    protected CartPage cartPage;

    public BaseStep() {
        formPage = new FormPage();
        productsListPage = new ProductsListPage();
        cartPage = new CartPage();
    }
}
