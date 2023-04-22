import interfaces.AbstractStack;

import java.util.Iterator;

public class Stack<E> implements AbstractStack<E> {
    private int size;
    private Node<E> top;

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    private static class Node<E>{
        E element;
        Node<E> previous;
        public Node( E element){
            this(element,null);
        }
        public Node(E element, Node<E> previous){
            this.element = element;
            this.previous = previous;
        }
    }
    public Stack(){

    }

    @Override
    public void push(E element) {
        Node<E> newNode= new Node<>(element);
        newNode.previous=top;
        top=newNode;
        this.size++;
    }

    @Override
    public E pop() {
        ensureNonEmpty();
        E element=this.top.element;
        Node<E> temp= this.top.previous;
        top.previous=null;
        top=temp;
        this.size--;
        return element;
    }

    @Override
    public E peek() {
        ensureNonEmpty();
        return top.element;
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
        if (size == 0) throw new IllegalStateException("Stack is Empty!!! Can not pop!");
    }
}
