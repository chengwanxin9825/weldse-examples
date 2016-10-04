package examples.weldse.entrypoint;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import examples.weldse.bean.HelloWorldBean;

public class SimpleMain {

    public static void main(String[] args) {
        Weld weld = new Weld();
        try (WeldContainer container = weld.initialize()) {
            HelloWorldBean bean = container.select(HelloWorldBean.class).get();
            System.out.println(bean.execute());
        }
    }

}
