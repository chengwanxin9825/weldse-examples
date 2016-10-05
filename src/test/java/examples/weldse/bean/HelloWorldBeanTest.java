package examples.weldse.bean;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class HelloWorldBeanTest {

    @Test
    public void testExecute0001() {
        HelloWorldBean helloWorldBean = new HelloWorldBean();
        assertThat(helloWorldBean.execute(), is("Hello World"));
    }

}
