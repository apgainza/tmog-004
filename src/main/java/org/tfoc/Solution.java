package org.tfoc;

import java.util.Objects;

/**
 * The class containing the solution to this exercise
 */
public class Solution {

    public static ListNode mergeTwoLists(
            ListNode list1,
            ListNode list2) {

        ListNode response = new ListNode();
        ListNode currentNode = response;

        while (true) {
            if (Objects.isNull(list1) || Objects.isNull(list1.val)) {
                currentNode.next = list2;
                break;
            } else if (Objects.isNull(list2) || Objects.isNull(list2.val)) {
                currentNode.next = list1;
                break;
            } else {
                if (list1.val >= list2.val) {
                    currentNode.next = new ListNode(list2.val);
                    list2 = list2.next;
                } else {
                    currentNode.next = new ListNode(list1.val);
                    list1 = list1.next;
                }
                currentNode = currentNode.next;
            }
        }
        return response.next;
    }
}
