package main.java.thread.lock;

/**
 * AbstractQueuedSynchronizer（同步器）用来构建锁或者其他同步组件。它使用一个int成员表示同步状态，通过内置的fifo队列完成资源获取线程的排队工作
 *
 *
 * getState() setState(int newState) compareAndSetState(int expect,int update),可以保证状态的改变是安全的
 *
 * 子类被推荐定义为自定义同步组件的静态内部类，同步器自身没有实现任何同步接口，仅仅定义了若干同步状态获取和释放的方法来供自定义同步组件使用
 *
 *
 * 同步器既可以支持独占式地获取同步状态，也可以支持共享式地获取同步状态。
 *
 *
 * 同步组件(ReentrantLock,ReentrantReadWriterLock,CountDownLatch)
 *
 * 同步器是是实现锁（也可以是同步组件）的关键。
 *
 * 同步队列中的节点用来保存获取同步状态失败的线程引用，等待状态以及前驱和后继节点，节点的属性类型与名称以及描述
 *
 *
 *
 * 独占式地在获取同步状态时，同步器维护了一个同步队列，获取状态失败的线程会被加入到队列中并在队列中进行自旋；移出队列或者停止自旋的条件是前驱节点为头节点且成果获取了同步状态。
 * 释放同步状态时，同步器调用tryRelease(int arg)方法释放同步状态，然后唤醒头节点的后继节点。
 *
 */
public class LockTest {
}
