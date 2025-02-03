package businessstrategy;

public class LoadParameters {
    private String firstParameter;
    private String secondParameter;

    public LoadParameters(String firstParameter) {
        this.firstParameter = firstParameter;
    }

    public LoadParameters(String firstParameter, String secondParameter) {
        this.firstParameter = firstParameter;
        this.secondParameter = secondParameter;
    }

    public String getFirstParameter() {
        return firstParameter;
    }

    public String getSecondParameter() {
        return secondParameter;
    }
}
