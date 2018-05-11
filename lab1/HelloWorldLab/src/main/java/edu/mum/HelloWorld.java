package edu.mum;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.mum.component.MessageDisplay;

public class HelloWorld {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfiguration.class);

        //MessageDisplay messageDisplay = (MessageDisplay) applicationContext.getBean("standardOutMessageDisplay");
//		MessageDisplay messageDisplay = (MessageDisplay) applicationContext.getBean("fileMessageDisplay");
//          try {
//			messageDisplay.display();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        ListNode tmpNode;
        ListNode l1 = new ListNode(9);
        // l1.next = new ListNode(4);
        //l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next.next = new ListNode(9);

//        ListNode res = addTwoNumbers(l1, l2);
//        tmpNode = res;
//        System.out.println(tmpNode.val);
//        while (tmpNode.next != null) {
//            tmpNode = tmpNode.next;
//            System.out.println(tmpNode.val);
//        }
        System.out.println(longestPalindrome("cbbd"));

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int resultValue = l1.val + l2.val;
        int extra = 0;
        if (resultValue > 9) {
            resultValue = resultValue % 10;
            extra = 1;
        }
        ListNode result = new ListNode(resultValue);
        ListNode tmpNode = result;
        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            resultValue = l1.val + l2.val + extra;
            if (resultValue > 9) {
                resultValue = resultValue % 10;
                extra = 1;
            } else
                extra = 0;
            tmpNode.next = new ListNode(resultValue);
            tmpNode = tmpNode.next;
        }
        while (l1.next != null) {
            l1 = l1.next;
            resultValue = l1.val + extra;
            if (resultValue > 9) {
                resultValue = resultValue % 10;
                extra = 1;
            } else
                extra = 0;
            tmpNode.next = new ListNode(resultValue);
            tmpNode = tmpNode.next;
        }
        while (l2.next != null) {
            l2 = l2.next;
            resultValue = l2.val + extra;
            if (resultValue > 9) {
                resultValue = resultValue % 10;
                extra = 1;
            } else
                extra = 0;
            tmpNode.next = new ListNode(resultValue);
            tmpNode = tmpNode.next;
        }
        if (extra > 0)
            tmpNode.next = new ListNode(extra);

        return result;
    }

    public static String longestPalindrome(String s) {
        String max = "";
        String tmp ="";
        for(int i=0; i<s.length(); i++){
            tmp = s.substring(0,i);
            if(idPalindromic(tmp)){
                if(tmp.length()>max.length())
                    max=tmp;
            }

        }
        return max;
    }

    private static boolean idPalindromic(String s) {
        int startSecond = s.length() / 2;
        if (s.length() % 2 != 0)
            startSecond++;
        String first = s.substring(0, s.length() / 2);
        StringBuffer second = new StringBuffer(s.substring(startSecond, s.length()));

        if (first.equals(second.reverse().toString()))
            return true;
        else return false;

    }
}


