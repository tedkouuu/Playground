package Multithreading.Atomic_Reference;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

public class LockFreeStack<T> {
    private AtomicReference<StackNode<T>> head = new AtomicReference<>();
    private AtomicInteger counter = new AtomicInteger(0);

    public void push(T value) {

        StackNode<T> newHeadNode = new StackNode<>(value);

        while (true) {
            StackNode<T> currentHeadNode = head.get();
            newHeadNode.next = currentHeadNode;

            if (head.compareAndSet(currentHeadNode, newHeadNode)) {
                break;
            } else {
                LockSupport.parkNanos(1);
            }
        }
        counter.incrementAndGet();

    }

    public T pop() {
        StackNode<T> currentHeadNode = head.get();
        StackNode<T> newHeadNode;

        while (currentHeadNode != null) {
            newHeadNode = currentHeadNode.next;

            if (head.compareAndSet(currentHeadNode, newHeadNode)) {
                break;
            } else {
                LockSupport.parkNanos(1);
                currentHeadNode = head.get();
            }
        }
        counter.incrementAndGet();
        return currentHeadNode != null ? currentHeadNode.value : null;

    }

    public int getCounter() {
        return counter.get();
    }
}
