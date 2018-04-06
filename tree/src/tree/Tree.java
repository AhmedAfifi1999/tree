package tree;

public class Tree {

    private Node Root = null;
    int Size = 0;

    public void AddpPerson(Node newNode) {

        if (Root == null) {
            Root = newNode;
            //System.out.println(Root.getPerson().getName());
        } else {
            Node current = Root;
            Root.parent = Root;//
            while (true) {

                if (newNode.getPerson().getId() > current.getPerson().getId()) {//id>id
                    if (current.NodeRigth == null) {
                        newNode.parent = current;
                        current.NodeRigth = newNode;

                        //System.out.println(newNode.getPerson().getName());
                        break;
                    } else {
                        current = current.NodeRigth;

                    }
                } else if (newNode.getPerson().getId() <= current.getPerson().getId()) {
                    if (current.NodeLeft == null) {
                        newNode.parent = current;
                        current.NodeLeft = newNode;
                        //  System.out.println(newNode.getPerson().getName());
                        break;
                    } else {
                        current = current.NodeLeft;
                    }
                }
            }
        }
        Size++;
    }

    public boolean search(person p) {

        Node current = Root;
        int i = 0;
        while (true) {
            i++;

            if (Size == i) {
                System.out.println("not found");
                break;
            }
            if (current.getPerson().getName().equals(p.getName()) && current.getPerson().getId() == p.getId()) {
                // System.out.println("found");
                System.out.println(p.getId() + "\n" + p.getName());
                return true;

            } else {
                if (current.getPerson().getId() > p.getId()) {
                    current = current.NodeLeft;
                } else if (current.getPerson().getId() <= p.getId()) {
                    current = current.NodeRigth;
                } else {
                    System.out.println("not found");
                }

            }

        }
        return false;
    }

    public void inorder(Node Node) {
        if (Node != null) {
            inorder(Node.NodeLeft);
            System.out.println(Node.getPerson().getId() + "  " + Node.getPerson().getName());
            inorder(Node.NodeRigth);
        }

    }

    public void delete(Node Node) {
        Node Save;
        if (Node.NodeLeft == null && Node.NodeRigth == null) {//لما يكون المطلوب حذفه اخر عنصر في الشجرة...
            Node = null;
        } else if (Node.NodeLeft != null && Node.NodeRigth != null ) {
            Node x;
            x = Node.NodeRigth;
            while (true) {
                if (x.NodeLeft == null) {
                    if (x.NodeRigth != null) {
                        x.parent.NodeLeft = x.NodeRigth;
                    }
                    Save = x;
                    x = null;
                    Node A = Node.NodeLeft;
                    Node B = Node.NodeRigth;
                    Node C = Node.parent;
                    Node = x;
                    x.NodeLeft = A;
                    x.NodeRigth = B;
                    x.parent = C;
                    break;
                }
                x = x.NodeLeft;
            }

        } else if (Node.NodeLeft == null || Node.NodeRigth == null) {
            Node x;
            Node A;

            if (Node.NodeLeft == null && Node.NodeRigth != null) {
                x = Node.parent;
                A = Node.NodeRigth;

                A.parent = x;
                Node = null;

            }
            if (Node.NodeRigth == null && Node.NodeLeft != null) {
                x = Node.parent;
                A = Node.NodeLeft;

                A.parent = x;
                Node = null;

            }

        }

    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        person p = new person("ahmed", 10);
        person t = new person("walead", 20);
        person y = new person("ali", 12);
        person U = new person("Eyade", 6);
        person Q = new person("eee", 16);

        Node node = new Node(p);
        Node node2 = new Node(t);
        Node node3 = new Node(y);
        Node node4 = new Node(U);

        tree.AddpPerson(node);
        tree.AddpPerson(node2);

        tree.AddpPerson(node3);
        tree.AddpPerson(node4);

        tree.inorder(node);
        System.out.println("//********/////////");
        tree.delete(node2);
        System.out.println("//********/////////");

        tree.inorder(node);

//.getPerson().getName()
        //  System.out.println(tree.Root.NodeRigth.NodeLeft.getPerson().getName());
        //tree.search(U);
    }

}
/*

public void Search(Person Value, Node Root) {
        if (Root == null) {
            System.out.println("value connot founded");
            return;
        }
        if (Value.equals(Root.getValue())) {
            System.out.println("Value is founded");
            return;
        }
        if (Value.getAge() > Root.getValue().getAge()) {
            Search(Value, Root.getLeft());
            
        }
        
        if (Value.getAge() <= Root.getValue().getAge()) {
            Search(Value, Root.getRigth());
        }

 */
