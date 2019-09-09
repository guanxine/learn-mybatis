package cn.gx.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by guanxine on 18-5-17.
 */
public class Main {

    public static void main(String[] args) {
        ServiceImpl serviceImpl = new ServiceImpl();


        Service service = (Service) Proxy.newProxyInstance(Service.class.getClassLoader(), ServiceImpl.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object service, Method method, Object[] args) throws Throwable {

                System.out.println("before");
                method.invoke(serviceImpl, args);
                System.out.println("after");
                return null;
            }
        });
        service.service();
    }

    interface Service {
        void service();
    }

    static class ServiceImpl implements Service {

        @Override
        public void service() {
            System.out.println("service service impl");
        }
    }
}
