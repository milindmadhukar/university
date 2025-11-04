
class Node {
  int data;
  Node next;
  Node prev;

  Node(int data) {
    this.data = data;
    next = null;
    prev = null;
  }
}

public class MergeSortDLL {
  public static void main(String[] args) {
    Node head = createSampleList();

    System.out.println("Original list:");
    printList(head);

    Node sorted = mergeSort(head);
    printList(sorted);
  }

  public static Node mergeSort(Node node) {
    if (node == null || node.next == null)
      return node;
    Node second = split(node);
    node = mergeSort(node);
    second = mergeSort(second);
    return merge(node, second);
  }

  public static Node split(Node node) {
    Node slow = node, fast = node;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    Node temp = slow.next;
    slow.next = null;
    temp.prev = null;
    return temp;
  }

  public static Node merge(Node first, Node second) {
    if (first == null)
      return second;
    if (second == null)
      return first;

    if (first.data < second.data) {
      first.next = merge(first.next, second);
      first.next.prev = first;
      first.prev = null;
      return first;
    } else {
      second.next = merge(first, second.next);
      second.next.prev = second;
      second.prev = null;
      return second;
    }
  }

  private static Node createSampleList() {
    Node head = null;
    Node tail = null;
    int[] values = { 64, 34, 25, 12, 22, 11, 90 };

    for (int value : values) {
      Node newNode = new Node(value);
      if (head == null) {
        head = newNode;
        tail = newNode;
      } else {
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
      }
    }

    return head;
  }

  private static void printList(Node head) {
    Node current = head;
    while (current != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }
    System.out.println();
  }
}
