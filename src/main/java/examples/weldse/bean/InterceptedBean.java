package examples.weldse.bean;

import javax.interceptor.Interceptors;

import examples.weldse.interceptor.ElapsedTimeBinding;
import examples.weldse.interceptor.ElapsedTimeInterceptor;

@ElapsedTimeBinding
@Interceptors({ ElapsedTimeInterceptor.class })
public class InterceptedBean {

    public String execute() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getClass().getName();
    }

}
