package LinkedListTest;

public class linkedListeDouble<T> {

    public static void main(String[] args) {
        linkedListeDouble<DoubleNode> n = new linkedListeDouble<>(3);
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

//        n.AddLast(a);
//        n.AddLast(b);
//        n.removeFirst();
//        n.AddLast(c);
//        n.AddLast(d);
        n.insert(e);
        n.insert(f);
        n.insert(d);

        System.out.println(n);

    }

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
        while (true) {
            if (i == size) {
                break;
            }
            All += " " + Node.toString();
            i++;
            Node = Node.next;
        }
        return All;

    }

    /**
     *
     * @param newNode
     * @return True if inserted and false if not inserted
     */
    public boolean insert(DoubleNode newNode) {
        if (!Isfull()) {
            if (IsEmpty()) {
                First = newNode;
                Last = newNode;
                size++;
                First.next = Last;
                Last.prei = First;
                return true;
            } else {
                DoubleNode currentNode = First;
                int i = 0;
                while (i++ < size) {
                    if (currentNode.grades < newNode.grades) {

                        currentNode.prei.next = newNode;// نضع مؤشر النيكست للنود السابق على النود الجديدة
                        currentNode.next.prei = newNode;// نضع مؤشر السابق للنود اللاحق على النود الجديدة

                        newNode.next = currentNode;// نضع التالي هي النود ذات القيمة القليلة
                        newNode.prei = currentNode.prei;//نضع السابق للنود الجديدة هوا السابق للنود القديمة

                        size++;
                        if (currentNode == Last) {
                            Last = newNode;
                        } else if (currentNode == First) {
                            First = newNode;
                        }

                        return true;
                    } else {
                        currentNode = currentNode.next;
                    }
                    insertLast(newNode);
                    return true;
                }
                return false;
            }
        } else {
            return false;
        }
    }

}
