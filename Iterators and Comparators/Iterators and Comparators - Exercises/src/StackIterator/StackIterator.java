package StackIterator;

import java.util.ArrayDeque;
import java.util.List;

public class StackIterator {
    List<Integer> stack;

    public StackIterator(List<Integer> stack) {
        this.stack = stack;
    }
      public void pop(){
          if (stack.isEmpty()){
              System.out.println("No elements");
          }
          else {
              stack.remove(stack.size() - 1);
          }

      }
      public void print(){
          for (int i = 0; i < 2; i++) {
              for (int j = stack.size() - 1; j >= 0 ; j--) {
                  System.out.println(stack.get(j));
              }
          }
        }
      }

