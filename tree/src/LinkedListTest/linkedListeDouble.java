package LinkedListTest;

public class linkedListeDouble<T> {

    DoubleNode First = null;
    DoubleNode Last = null;
    int size = 0;
    int capi;

    public linkedListeDouble(int Size) {

        this.capi = Size;

    }

    public boolean Isfull() {
        return (capi == size);
    }

    public boolean IsEmpty() {
        return (size == 0);
    }

    public void insertFirst(DoubleNode newNode) {

        if (IsEmpty()) {
            First = newNode;
            Last = newNode;
            size++;
        } else {
            newNode.next = First;
            First.prei = newNode;
            First = newNode;
            size++;
        }
    }

    public void insertLast(DoubleNode newNode) {

        if (IsEmpty()) {
            First = newNode;
            Last = newNode;
            size++;
        } else {
            newNode.prei = Last;
            Last.next = newNode;
            Last = newNode;
            size++;

        }

    }

    public void AddLast(DoubleNode newNode) {
        if (Isfull()) {
            removeFirst();
        }

        if (IsEmpty()) {
            First = newNode;
            Last = newNode;
            size++;
        } else {
            newNode.prei = Last;
            Last.next = newNode;
            Last = newNode;
            size++;

        }

    }

    public void insertAfter(DoubleNode currentNode, DoubleNode newNode) {
        if (size > 1) {
            newNode.next = currentNode.next;
            currentNode.next.prei = newNode;

            currentNode.next = newNode;
            newNode.prei = currentNode;
            size++;
        }
    }

    public void removeFirst() {
        if (IsEmpty()) {
            System.out.println("there is no nodes");

        } else {
            First = First.next;
            First.prei.next = null;
            First.prei = null;
            size--;
        }
    }

    @Override
    public String toString() {
        int i = 0;
        String All = "";
        DoubleNode Node = First;
        while (i!=3) {
            
            All += " " + Node.toString();
            i++;
            Node = Node.next;
        }
        return All;

    }

    public void insert(DoubleNode newNode) {

        if (IsEmpty()) {
            First = newNode;
            Last = newNode;
            size++;
        } else {
            DoubleNode x = First.next;
            if (newNode.grades > First.grades) {
                insertFirst(newNode);
                if (size > 3) {
                    x.next = null;
                }

            } 
            
            else if ( First.next==null || newNode.grades > First.next.grades   ) {
                if(First.next==null){
                newNode.prei = First;
                First.next=newNode;
                newNode.next=null;

                }else{
                x=First.next;
                newNode.prei=First;
                First.next=newNode;
                newNode.next=x;
                x.prei=newNode;
                
                }
            } else if (x.next==null||newNode.grades > x.next.grades&&size>3) {
            
            newNode.next = null;
            newNode.prei = x;
            x.next= null;}
            size++;
        }
    }

    public static void main(String[] args) {
        linkedListeDouble n = new linkedListeDouble(3);
//        DoubleNode a = new DoubleNode("Gaza");
//        DoubleNode b = new DoubleNode("rafah");
//        DoubleNode c = new DoubleNode("zoom");
//        DoubleNode d = new DoubleNode("tree");
//        DoubleNode e = new DoubleNode("Gaza2");
//        DoubleNode f = new DoubleNode("room");
        //-----------------
        DoubleNode e = new DoubleNode(20);
        DoubleNode f = new DoubleNode(10);
        DoubleNode d = new DoubleNode(6);
        DoubleNode b = new DoubleNode(15);

//        n.AddLast(a);
//        n.AddLast(b);
//        n.removeFirst();
//        n.AddLast(c);
//        n.AddLast(d);
        n.insert(e);
        n.insert(f);
        n.insert(d);
        n.insert(b);


        System.out.println(n);

    }

}
