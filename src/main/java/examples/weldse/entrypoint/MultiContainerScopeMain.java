package examples.weldse.entrypoint;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import examples.weldse.bean.ApplicationScopedBean;

public class MultiContainerScopeMain {

    public static void main(String[] args) {
        Weld weld = new Weld();
        try {
            WeldContainer container1 = weld.containerId("1").initialize();
            WeldContainer container2 = weld.containerId("2").initialize();

            ApplicationScopedBean applicationScopedBean1 = container1.select(ApplicationScopedBean.class).get();
            ApplicationScopedBean applicationScopedBean2 = container2.select(ApplicationScopedBean.class).get();
            System.out.println(applicationScopedBean1 == applicationScopedBean2); // false

        } finally {
            weld.shutdown();
        }
    }

}
