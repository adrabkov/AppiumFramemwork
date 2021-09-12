package core.steps;

public class CommonSteps {
    private static LoginSteps loginSteps;
    private static FormStep formStep;
    private static ProductsListStep productsListStep;

    private CommonSteps() { }

    public static LoginSteps getLoginSteps(){
        if (loginSteps == null){
            loginSteps = new LoginSteps();
        }
        return loginSteps;
    }

    public static FormStep getFormSteps(){
        if (formStep == null){
            formStep = new FormStep();
        }
        return formStep;
    }

    public static ProductsListStep getProductsListStep(){
        if (productsListStep == null){
            productsListStep = new ProductsListStep();
        }
        return productsListStep;
    }
}
