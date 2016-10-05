package examples.weldse.entrypoint;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import examples.weldse.bean.ConstructorInjectionBean;
import examples.weldse.bean.HelloWorldBean;
import examples.weldse.bean.other.OtherPackageBean;

public class MultiContainerMain {

    public static void main(String[] args) {
        Weld weld = new Weld();
        try {
            WeldContainer container1 = weld.containerId("1").disableDiscovery().packages(HelloWorldBean.class).initialize();
            WeldContainer container2 = weld.containerId("2").disableDiscovery().packages(OtherPackageBean.class).initialize();

            System.out.println(container1.select(HelloWorldBean.class).get().execute());
            System.out.println(container1.select(ConstructorInjectionBean.class).get().execute());
            // UnsatisfiedResolutionException発生
            // System.out.println(container1.select(OtherPackageBean.class).get().execute());

            System.out.println(container2.select(OtherPackageBean.class).get().execute());
            // UnsatisfiedResolutionException発生
            // System.out.println(container2.select(HelloWorldBean.class).get().execute());
        } finally {
            weld.shutdown();
        }
    }

}
