//package cn.gx.pool;
//
//import javax.sql.DataSource;
//import java.io.PrintWriter;
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.SQLFeatureNotSupportedException;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.LinkedList;
//import java.util.logging.Logger;
//
///**
// * Created by guanxine on 18-5-16.
// */
//public class MyDataSourcePool implements DataSource {
//
//
//    private static Collection<Object> connections = Collections.synchronizedCollection(new LinkedList<>());
//
//    static {
//        String url = "";
//        String user = "";
//        String password = "";
//        int size = 10;
//
//        for (int i = 0; i < size; i++) {
//            try {
//                connections.add(DriverManager.getConnection(url, user, password));
//            }
//            catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//    }
//
//
//    @Override
//    public Connection getConnection() throws SQLException {
//
//        if(connections.size() > 0) {
//            Connection connection = connections.removeFirst();
//
//            return (Connection) Proxy.newProxyInstance(MyDataSourcePool.class.getClassLoader(), Connection.class.getInterfaces(), new InvocationHandler() {
//                @Override
//                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                    if("close".equals(method.getName())) {
//                        connections.add(connection);
//                    }
//                    else {
//                        method.invoke(connection, args);
//                    }
//
//
//                    return null;
//                }
//            });
//
//        }
//
//
//        return null;
//    }
//
//    @Override
//    public Connection getConnection(String username, String password) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public <T> T unwrap(Class<T> iface) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public boolean isWrapperFor(Class<?> iface) throws SQLException {
//        return false;
//    }
//
//    @Override
//    public PrintWriter getLogWriter() throws SQLException {
//        return null;
//    }
//
//    @Override
//    public void setLogWriter(PrintWriter out) throws SQLException {
//
//    }
//
//    @Override
//    public void setLoginTimeout(int seconds) throws SQLException {
//
//    }
//
//    @Override
//    public int getLoginTimeout() throws SQLException {
//        return 0;
//    }
//
//    @Override
//    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
//        return null;
//    }
//}
