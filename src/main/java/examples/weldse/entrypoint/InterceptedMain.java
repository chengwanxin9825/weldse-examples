package examples.weldse.entrypoint;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import examples.weldse.bean.InterceptedBean;

public class InterceptedMain {

    public static void main(String[] args) {
        Weld weld = new Weld();
        try (WeldContainer container = weld.initialize()) {
            InterceptedBean bean = container.select(InterceptedBean.class).get();
            System.out.println(bean.execute());
        }
    }

}
