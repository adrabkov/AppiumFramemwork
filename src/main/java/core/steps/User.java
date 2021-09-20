package core.steps;

public class User {

    public AtFormPage atFormPage() {
        return new AtFormPage();
    }

    public AtProductsListPage atProductsListPage() {
        return new AtProductsListPage();
    }

    public AtCartPage atCartPage(){
        return new AtCartPage();
    }
}
