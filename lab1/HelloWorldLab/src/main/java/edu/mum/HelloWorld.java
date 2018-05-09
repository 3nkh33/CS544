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

        ListNode res = addTwoNumbers(l1, l2);
        tmpNode = res;
        System.out.println(tmpNode.val);
        while (tmpNode.next != null) {
            tmpNode = tmpNode.next;
            System.out.println(tmpNode.val);
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int resultValue = l1.val + l2.val;
        int extra = 0;
        if(resultValue > 9){
            resultValue = resultValue%10;
            extra = 1;
        }
        ListNode result = new ListNode(resultValue);
        ListNode tmpNode= result;
        while (l1.next != null && l2.next !=null) {
            l1 = l1.next;
            l2=l2.next;
            resultValue = l1.val + l2.val + extra;
            if(resultValue > 9){
                resultValue = resultValue%10;
                extra = 1;
            }else
                extra = 0;
            tmpNode.next = new ListNode(resultValue);
            tmpNode = tmpNode.next;
        }
        while (l1.next != null) {
            l1 = l1.next;
            resultValue = l1.val + extra;
            if(resultValue > 9){
                resultValue = resultValue%10;
                extra = 1;
            }else
                extra=0;
            tmpNode.next = new ListNode(resultValue);
            tmpNode = tmpNode.next;
        }
        while (l2.next != null) {
            l2 = l2.next;
            resultValue = l2.val + extra;
            if(resultValue > 9){
                resultValue = resultValue%10;
                extra = 1;
            }else
                extra=0;
            tmpNode.next = new ListNode(resultValue);
            tmpNode = tmpNode.next;
        }
        if(extra > 0)
            tmpNode.next = new ListNode(extra);

        return result;
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        long number1 = 0, number2 = 0, tmpIndex = 1;
        ListNode tmpNode = l1;
        number1 = tmpIndex * tmpNode.val + number1;
        while (tmpNode.next != null) {
            tmpIndex = tmpIndex * 10;
            tmpNode = tmpNode.next;
            number1 = tmpIndex * tmpNode.val + number1;
        }
        tmpNode = l2;
        tmpIndex = 1;
        number2 = tmpIndex * tmpNode.val + number2;
        while (tmpNode.next != null) {
            tmpIndex = tmpIndex * 10;
            tmpNode = tmpNode.next;
            number2 = tmpIndex * tmpNode.val + number2;
        }
        long total = number1 + number2;
        long first = total % 10;
        ListNode resNode = new ListNode((int) first);
        total = total / 10;
        tmpNode = resNode;
        while (total > 0) {
            ListNode tmp = new ListNode((int) total % 10);
            tmpNode.next = tmp;
            total = total / 10;
            tmpNode = tmp;
        }
        return resNode;
    }
}


