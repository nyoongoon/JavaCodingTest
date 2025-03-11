package _2_Java_Algo_Interview._3_선형자료구조._4_스택_큐;

import java.util.ArrayDeque;
import java.util.Deque;

public class _5_스택을_이용한_큐구현_내풀이 {
    public static void main(String[] args) {
        
    }
    class MyQueue {
        Deque<Integer> stack;
        Deque<Integer> reverseStack;
        // [ @ @
        // 1 2 -> 2 1
        // 1 2 3 -> 3 2 1

        public MyQueue() {
            stack = new ArrayDeque<>();
            reverseStack = new ArrayDeque<>();
        }

        public void push(int x) {
            while(!stack.isEmpty()){
                reverseStack.push(stack.pop());
            }
            stack.push(x);
            while(!reverseStack.isEmpty()){
                stack.push(reverseStack.pop());
            }
        }

        public int pop() {
            return stack.pop();
        }

        public int peek() {
            return stack.peek();
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }
}
