package cn.gx.proxy;

/**
 * Created by guanxine on 18-5-16.
 */
public class Main {

    interface Service {
        void service();
    }

    static class ServiceImpl implements Service {
        @Override
        public void service() {
            System.out.println("service service impl");
        }
    }

    static class ServiceProxy implements Service {

        private Service service;

        public ServiceProxy(Service service) {
            this.service = service;
        }

        @Override
        public void service() {
            System.out.println("before");
            service.service();
            System.out.println("after");
        }
    }

    public static void main(String[] args) {
        new ServiceProxy(new ServiceImpl()).service();
    }

}

