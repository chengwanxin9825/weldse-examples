package examples.weldse.bean;

import javax.enterprise.context.Dependent;

@Dependent
public class DependentBean {

    public String execute() {
        return getClass().getSimpleName();
    }

}
