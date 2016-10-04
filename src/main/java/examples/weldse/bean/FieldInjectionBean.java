package examples.weldse.bean;

import javax.inject.Inject;

public class FieldInjectionBean {

    @Inject
    private HelloWorldBean helloWorldBean;

    public String execute() {
        return String.format("*** %s ***", helloWorldBean.execute());
    }

}
