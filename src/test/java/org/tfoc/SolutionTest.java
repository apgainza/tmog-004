package org.tfoc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Objects;
import java.util.stream.Stream;

@Slf4j
class SolutionTest {

    private static Stream<Arguments> provideListNodes() {
        return Stream.of(
                Arguments.of(new ListNode(1, new ListNode(2)), new ListNode(1), "112"),
                Arguments.of(new ListNode(1, new ListNode(2, new ListNode(4))),
                        new ListNode(1, new ListNode(3, new ListNode(4))), "112344"),
                Arguments.of(null, new ListNode(0), "0")
        );
    }

    @ParameterizedTest
    @MethodSource("provideListNodes")
    void testSolution1(ListNode l1, ListNode l2, String responseExpected) {
        StringBuilder response = new StringBuilder();
        ListNode listNode = Solution.mergeTwoLists(l1, l2);

        while (Objects.nonNull(listNode)) {
            response.append(listNode.val);
            listNode = listNode.next;
        }

        Assertions.assertEquals(response.toString(), responseExpected);
    }

}