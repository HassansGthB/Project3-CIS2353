public class Driver {
    public static void main(String[] args){
        UndoStack stack = new UndoStack();

        // 6. Exception handling (peak on an Empty Stack)
        System.out.println("=== Exception Demo: Peek on Empty Stack ===");
        try {
            System.out.println(stack.peekTopAction());
        } catch (StackEmptyException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // 2. pushing 6 actions into the created stack
        System.out.println("\n=== Pushing Actions ===");

        stack.pushAction("InsertText", 10);
        stack.pushAction("DeleteText", 5);
        stack.pushAction("MoveObject", 2);
        stack.pushAction("ResizeObject", 1);
        stack.pushAction("ApplyStyle", 3);
        stack.pushAction("InsertImage", 4);

        // 3. Print stack to show result
        System.out.println("\n=== Current Stack ===");
        stack.printStack();

        // 4. Peek first time
        System.out.println("\n=== Peek Top (1) ===");
        System.out.println(stack.peekTopAction());

        // 5. Undo 3 times
        System.out.println("\n=== Undo Operations ===");
        System.out.println("Undone: " + stack.undo());
        System.out.println("Undone: " + stack.undo());
        System.out.println("Undone: " + stack.undo());

        // print after Undo
        System.out.println("\n=== Stack After 3 Undos ===");
        stack.printStack();

        // 4. Peek second time
        System.out.println("\n=== Peek Top (2) ===");
        System.out.println(stack.peekTopAction());

        // 7a. increaseOldestActions
        System.out.println("\n=== Increase Oldest 2 Actions by 5 ===");
        stack.increaseOldestActions(2, 5);
        stack.printStack();

        // 7b. decreaseOldestActions
        System.out.println("\n=== Decrease Oldest 5 Actions by 2 ===");
        stack.decreaseOldestActions(5, 2);
        stack.printStack();

        // Undo 3 more times
        System.out.println("\n=== Undo Remaining Operations ===");
        System.out.println("Undone: " + stack.undo());
        System.out.println("Undone: " + stack.undo());
        System.out.println("Undone: " + stack.undo());

        // 7a. increaseOldestActions on an Empty Stack
        System.out.println("\n=== Increase Oldest 2 Actions by 5 on an Empty Stack===");
        stack.increaseOldestActions(2, 5);
        stack.printStack(); // should still be empty

        // 7b. decreaseOldestActions on an Empty Stack
        System.out.println("\n=== Decrease Oldest 5 Actions by 2 on an Empty Stack===");
        stack.decreaseOldestActions(5, 2);
        stack.printStack(); // should still be empty
    }

    
}
