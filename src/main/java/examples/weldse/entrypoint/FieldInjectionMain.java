package examples.weldse.entrypoint;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import examples.weldse.bean.FieldInjectionBean;

public class FieldInjectionMain {

    public static void main(String[] args) {
        Weld weld = new Weld();
        try (WeldContainer container = weld.initialize()) {
            FieldInjectionBean bean = container.select(FieldInjectionBean.class).get();
            System.out.println(bean.execute());
        }
    }

}
