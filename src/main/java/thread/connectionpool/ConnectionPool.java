package main.java.thread.connectionpool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * 线程的等待超时模式构造一个简单的数据库连接池
 * 连接池：通过构造函数初始化最大连接数，通过一个双向队列来维护连接
 * fetchconnection(long) 指定多少毫秒内超时获取连接
 * releaseconnnection（Connection）将连接放回线程池
 */
public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<>();
    //初始化连接处
    public ConnectionPool(int initialSize){
        if(initialSize > 0){
            for(int i = 0; i < initialSize; i++){
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    public void releaseConnection(Connection connection){
        if(connection != null){
            synchronized (pool) {
                //连接释放后需要通知其他线程连接池已经归还了一个连接
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }
    public Connection fetchConnection(long mills) throws InterruptedException{
        synchronized (pool){
            if(mills <= 0){
                while (pool.isEmpty()){
                    pool.wait();
                }
                return pool.removeFirst();
            }else{
                long future = System.currentTimeMillis() + mills;
                long remaining  = mills;
                while (pool.isEmpty() && remaining > 0 ){
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;
                if(!pool.isEmpty()){
                    result = pool.removeFirst();
                }
                return result;
            }
        }

    }

}
