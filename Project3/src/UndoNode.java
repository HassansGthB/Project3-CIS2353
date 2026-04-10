public class UndoNode {
    private String actionName;
    private int value;
    private UndoNode next;

    // Constructor to initialize a new UndoNode
    public UndoNode(String actionName, int value) {
        this.actionName = actionName;
        this.value = value;
        this.next = null;
    }

    // Getters
    public String getActionName() { 
        return actionName; 
    }
    public int getValue() { 
        return value; 
    }
    public UndoNode getNext() { 
        return next; 
    }

    // Setters
    public void setValue(int value) {
        this.value = value;
    }
    //this Setter links the new Top Node
    public void setNext(UndoNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return actionName + " (" + value + ")";
    }

}
