package com.arrays;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {

    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    /**
     * @param data
     */
    public void insert(int data) {
        Node insertNode = new Node(data);
        insertNode.next = null;
        if (head == null) {
            head = insertNode;
        } else {
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = insertNode;
        }
    }

    /**
     * @param node
     * @param pos
     */
    public void printNthElementFromLast(Node node, int pos) {
        Node slowPointer = node;
        Node fastPointer = node;
        int count = 0;
        while (count < pos && fastPointer.next != null) {
            fastPointer = fastPointer.next;
            count++;
        }
        while (fastPointer != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        System.out.println(pos + "th element from back is : " + slowPointer.data);
    }

    /**
     * @param node
     */
    void printMiddle(Node node) {
        Node fastPointer = node;
        Node slowPointer = node;
        while (fastPointer != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        System.out.println("Middle element is :" + slowPointer.data);
    }


    /**
     * @param data
     * @param position where you want to insert data
     */
    public void insertAt(int data, int pos) {
        Node insertNode = new Node(data);
        insertNode.next = null;
        if (head == null) {
            head = insertNode;
        } else {
            Node lastNode = head;
            int count = 1;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
                count++;
                if (count == pos) {
                    if (lastNode.next != null) {
                        Node tempNode = lastNode.next;
                        lastNode.next = insertNode;
                        insertNode.next = tempNode;

                    } else {
                        lastNode.next = insertNode;
                    }
                    continue;
                }
            }
        }
    }

    public void print() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + "-next =>");
            currentNode = currentNode.next;
        }
        System.out.print(currentNode);
    }

    public Node deleteMiddleElement(Node head) {
        if (head == null) return null;
        Node slowPointer = head;
        Node fastPointer = head;
        Node prevPointer = null;
        while (fastPointer != null && fastPointer.next != null) {
            prevPointer = slowPointer;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        prevPointer.next = slowPointer.next;
        return head;
    }

    /**
     *
     * @param head
     * @return
     */
    //1-next =>2-next =>5-next =>4-next =>41-next =>42-next =>null
    public Node removeDuplicateFromSortedLinkedList(Node head)
    {
        Set<Integer> unique=new HashSet<>();
        Node curr=head;
        Node prev=null;
        while(curr!=null)
        {
            if(unique.contains(curr.data))
            {
                //System.out.println(curr.data+ ":::::"+unique);

                if(curr.next!=null) {
                    prev=curr.next;
                    curr = curr.next.next;
                }
                else {
                    System.out.println(prev.data+ ":::::"+unique);
                    prev.next=null;
                    curr = prev;
                }
                }
            else
            {
                unique.add(curr.data);
                curr=curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(3);
        list.insert(4);
        list.insert(4);
        //System.out.println(list);
        list.print();
        System.out.println("");
        list.insertAt(5, 2);
        list.print();
        System.out.println("");


        list.printNthElementFromLast(list.head, 4);
        list.deleteMiddleElement(list.head);
        list.print();
        list.removeDuplicateFromSortedLinkedList(list.head);
        System.out.println("");
        list.print();



    }

}
