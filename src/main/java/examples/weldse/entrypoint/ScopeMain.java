package examples.weldse.entrypoint;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import examples.weldse.bean.ApplicationScopedBean;
import examples.weldse.bean.DependentBean;

public class ScopeMain {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Weld weld = new Weld();
        try (WeldContainer container = weld.initialize()) {
            DependentBean dependentBean1 = container.select(DependentBean.class).get();
            DependentBean dependentBean2 = container.select(DependentBean.class).get();
            System.out.println(dependentBean1 == dependentBean2); // false

            ApplicationScopedBean applicationScopedBean1 = container.select(ApplicationScopedBean.class).get();
            ApplicationScopedBean applicationScopedBean2 = container.select(ApplicationScopedBean.class).get();
            System.out.println(applicationScopedBean1 == applicationScopedBean2); // true

            ExecutorService service = Executors.newFixedThreadPool(2);
            Future<Boolean> future1 = service.submit(() -> container.select(ApplicationScopedBean.class).get() == applicationScopedBean1);
            Future<Boolean> future2 = service.submit(() -> container.select(ApplicationScopedBean.class).get() == applicationScopedBean1);
            service.shutdown();
            System.out.println(future1.get()); // true
            System.out.println(future2.get()); // true
        }
    }

}
