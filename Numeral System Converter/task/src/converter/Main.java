package converter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Long number = scan.nextLong();
        String trash = scan.nextLine();
        int base= scan.nextInt();
        Deque <Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        switch (base) {
            case 2 :
             do {
                  stack.offerLast((int) (number%2));
                  number=number/2;
              } while (number>0);
             sb.append("0b");
             while (stack.size()>0) {
                 sb.append(stack.pollLast());
             }
             System.out.println(sb);
             break;
            case 8:
                do {
                    stack.offerLast((int) (number%8));
                    number=number/8;
                } while (number>0);
                sb.append("0");
                while (stack.size()>0) {
                    sb.append(stack.pollLast());
                }
                System.out.println(sb);
                break;
            case 16:
                do {
                    stack.offerLast((int) (number%16));
                    number=number/16;
                } while (number>0);
                sb.append("0x");
                while (stack.size()>0) {
                    int hex=stack.pollLast();
                    switch (hex) {
                        case 15:
                            sb.append("f");
                            break;
                        case 14:
                            sb.append("e");
                            break;
                        case 13:
                            sb.append("d");
                            break;
                        case 12:
                            sb.append("c");
                            break;
                        case 11:
                            sb.append("b");
                            break;
                        case 10:
                            sb.append("a");
                            break;
                        default:
                            sb.append(hex);
                            break;
                    }
                }
                System.out.println(sb);
                break;
            default:
                System.out.println("Unknown radix.");
                break;
        }
    }
}
