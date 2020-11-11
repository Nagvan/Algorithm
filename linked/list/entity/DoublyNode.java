package linked.list.entity;

public class DoublyNode {
    private Object data;
    private DoublyNode next;
    private DoublyNode prev;

    public DoublyNode() {
    }

    public DoublyNode(Object data) {
        this.data = data;
        next = null;
        prev = null;
    }

    public DoublyNode(Object data, DoublyNode next, DoublyNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public DoublyNode getNext() {
        return next;
    }

    public void setNext(DoublyNode next) {
        this.next = next;
    }

    public DoublyNode getPrev() {
        return prev;
    }

    public void setPrev(DoublyNode prev) {
        this.prev = prev;
    }
}
