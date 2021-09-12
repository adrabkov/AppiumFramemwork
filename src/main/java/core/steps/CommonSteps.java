package core.steps;

public class CommonSteps {
    private static LoginSteps loginSteps;

    private CommonSteps() { }

    public static LoginSteps getLoginSteps(){
        if (loginSteps == null){
            loginSteps = new LoginSteps();
        }
        return loginSteps;
    }
}
