public class UndoStack {
    private UndoNode top;
    private int numElements;
    
    // No-arg Constructor
    public UndoStack() {
        top = null;
        numElements = 0;
    }

    // Methods
    public void pushAction(String actionName, int value){
        UndoNode newNode = new UndoNode(actionName, value);
        newNode.setNext(top);  // link new node to current top
        top = newNode;         // move top to new node
        numElements++;         
    }

    public String undo() {
        if (isEmpty()) {
            throw new StackEmptyException();
        }

        UndoNode removedNode  = top;
        top = top.getNext(); // move top to the next node
        numElements--;

        return removedNode.getActionName() + " (" + removedNode.getValue() + ")";
    }

    public UndoNode peekTopAction(){
        if (isEmpty()) {
            throw new StackEmptyException();
        }
        return top; // returns the top object
    }

    public void increaseOldestActions(int k, int amount) {
        changeOldestActions(k, amount);
    }

    public void decreaseOldestActions(int k, int amount) {
        changeOldestActions(k, -amount);
    }

    private void changeOldestActions(int k, int changeAmount){
        // if stack empty or k<= 0, do nothing and return
        if (isEmpty() || k <= 0) return;

        //Start at n−k, but if that’s negative, just start at 0.
        int startIndex = Math.max(0, numElements - k);

        UndoNode current = top;
        int index = 0;

        // Traverse the entire stack
        while (current != null) {
            
            // Once we reach the bottom k portion, update the value
            if (index >= startIndex) {
                current.setValue(current.getValue() + changeAmount);
            }
            current = current.getNext();
            index++;
        }

    }


    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return numElements;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        UndoNode current = top;

        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }

}