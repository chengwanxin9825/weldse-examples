package examples.weldse.bean;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class ConstructorInjectionBeanTest {

    @Test
    public void testExecute0001() {
        ConstructorInjectionBean constructorInjectionBean = new ConstructorInjectionBean(new HelloWorldBean());
        assertThat(constructorInjectionBean.execute(), is("\"Hello World\""));
    }

    @Test
    public void testExecute0002() {
        ConstructorInjectionBean constructorInjectionBean = new ConstructorInjectionBean(new HelloWorldBean() {
            @Override
            public String execute() {
                return null;
            }
        });
        assertThat(constructorInjectionBean.execute(), is("\"null\""));
    }

}
