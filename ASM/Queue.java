import interfaces.AbstractQueue;

import java.util.Iterator;

public class Queue<E> implements AbstractQueue<E> {
    private int size;
    private Node<E> head;

    private Node<E> tail;

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    private static class Node<E> {
        E element;
        Node<E> next;
        public Node(E element) {
            this(element, null);
        }

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public void offer(E element) {
        Node<E> newNode= new Node<>(element);
        if(head==null){
            head=newNode;
            tail=newNode;
            size ++;}
        else{
            tail.next=newNode;
            tail=newNode;
            size++;
        }
    }

    @Override
    public E poll() {
        ensureNonEmpty();
        E element= head.element;
        if(head!=null){
        }
        Node<E> temp=this.head.next;
        this.head.next=null;
        head=temp;
        size--;
        return element;
    }

    @Override
    public E peek() {
        ensureNonEmpty();
        return head.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
    private void ensureNonEmpty(){
        if (size == 0) throw new IllegalStateException("List is Empty!!!");
    }
    @Override
    public String toString() {
        Node<E> current = head;
        StringBuilder result = new StringBuilder();
        while(current!=null){
            result.append(current.element+ " ");
            current = current.next;
        }
        return result.toString();
    }


//    private static final int DEFAULT_CAPACITY=7;
//    private int rear;
//    private E[] queue;
//
//    public Queue(){
//        rear=-1;
//        queue=(E[]) new Object[DEFAULT_CAPACITY];
//    }
//
//    private void ensureNonEmpty(){
//        if (rear == -1)
//            throw new IllegalStateException("List is Empty!!!");
//    }
//
//    public void offer(E element){
//        if(rear== queue.length-1){
//            throw new IllegalStateException("Queue overflow");
//        }
//        rear++;
//        queue[rear]=element;
//    }
//    public E poll(){
//        ensureNonEmpty();
//        E element=queue[0];
//        for(int i=0;i<rear;i++){
//            queue[i]=queue[i+1];
//        }
//        rear--;
//        return element;
//    }
//
//    public E peek(){return queue[0];}
//
//    public int size(){return rear+1;}
}
