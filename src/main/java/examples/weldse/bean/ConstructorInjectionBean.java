package examples.weldse.bean;

import javax.inject.Inject;

public class ConstructorInjectionBean {
    private HelloWorldBean helloWorldBean;

    @Inject
    public ConstructorInjectionBean(HelloWorldBean helloWorldBean) {
        this.helloWorldBean = helloWorldBean;
    }

    public String execute() {
        return String.format("\"%s\"", helloWorldBean.execute());
    }
}
