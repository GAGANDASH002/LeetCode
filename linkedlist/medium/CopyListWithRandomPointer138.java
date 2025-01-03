/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
/*HashMap implementation:

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();

        Node temp = head;
        while(temp != null){
            Node newNode = new Node(temp.val);
            map.put(temp, newNode);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            Node copyNode = map.get(temp);
            copyNode.next = map.get(temp.next);
            copyNode.random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);
    }
}*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node temp = head;

        // Step 1: Create a copy node of each node in between consecutive two nodes
        while (temp != null) {
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = temp.next.next;
        }

        // Step 2: Connect random pointers
        temp = head;
        while (temp != null) {
            Node copy = temp.next;
            // Connect random of copy to the actual node's copy of random pointer
            if (temp.random != null) {
                copy.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        // Step 3: Separate the original and copied lists
        Node dummy = new Node(-1);
        Node res = dummy;
        temp = head;

        while (temp != null) {
            res.next = temp.next; // Extract the copy node
            temp.next = temp.next.next; // Restore the original list

            res = res.next;
            temp = temp.next;
        }

        return dummy.next; // Return the copied list
    }
}
