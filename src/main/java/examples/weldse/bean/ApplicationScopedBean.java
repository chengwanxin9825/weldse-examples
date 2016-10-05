package examples.weldse.bean;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ApplicationScopedBean {

    public String execute() {
        return getClass().getSimpleName();
    }

}
