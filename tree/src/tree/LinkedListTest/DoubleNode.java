package LinkedListTest;



public class DoubleNode {
    int grades;
    DoubleNode next;
    DoubleNode prei;

    
 DoubleNode(int g) {
grades=g;   
 }

    

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    public DoubleNode getPrei() {
        return prei;
    }

    public void setPrei(DoubleNode prei) {
        this.prei = prei;
    }

    @Override
    public String toString() {
        return grades+"";
    }
    
    
    
}
