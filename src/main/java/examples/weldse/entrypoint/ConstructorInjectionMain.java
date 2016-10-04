package examples.weldse.entrypoint;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import examples.weldse.bean.ConstructorInjectionBean;

public class ConstructorInjectionMain {

    public static void main(String[] args) {
        Weld weld = new Weld();
        try (WeldContainer container = weld.initialize()) {
            ConstructorInjectionBean bean = container.select(ConstructorInjectionBean.class).get();
            System.out.println(bean.execute());
        }
    }

}
