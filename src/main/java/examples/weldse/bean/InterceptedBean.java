package examples.weldse.bean;

import examples.weldse.interceptor.ElapsedTimeBinding;

@ElapsedTimeBinding
// @Interceptors({ ElapsedTimeInterceptor.class })
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
