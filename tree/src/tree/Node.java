package tree;

public class Node {

    Node NodeRigth = null;//child
    Node NodeLeft = null;//child
    person person = null;
    Node parent = null;

    public Node(person person) {
        this.person = person;
    }

    public Node getNodeRigth() {
        return NodeRigth;
    }

    public void setNodeRigth(Node NodeRigth) {
        this.NodeRigth = NodeRigth;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getNodeLeft() {
        return NodeLeft;
    }

    public void setNodeLeft(Node NodeLeft) {
        this.NodeLeft = NodeLeft;
    }

    public person getPerson() {
        return person;
    }

    public void setPerson(person person) {
        this.person = person;
    }

}
