// Ivan Yu

import java.util.Scanner;

public class DecimalToBinary {
    private Deque remDequeStack = new Deque(100);
    private int top, userDecimal;
    private Scanner input = new Scanner(System.in);
    private String userBinary = "";

    public DecimalToBinary() {
        top = -1;
        boolean tmp = true;
        System.out.print("Please enter a decimal value: ");
        while (tmp == true) {
            try {
                userDecimal = Integer.parseInt(input.nextLine());
                tmp = false;
            } catch (NumberFormatException e) {
                System.out.print("Please re-enter a decimal value: ");
            }
        }

        convert();
        System.out.println("The decimal value " + userDecimal + " equals the binary value " + userBinary);
    }

    public void push(int value) {
        remDequeStack.insertrear(value);
        top++;
    }

    public int pop() {
        int tmp = remDequeStack.getRear();
        remDequeStack.deleterear();
        return tmp;
    }

    public void convert() {
        int tmp = userDecimal;
        while (tmp != 0) {
            this.push(tmp % 2);
            tmp /= 2;
        }

        for (int i = 0; i <= top; i++) {
            userBinary += pop();
        }
    }

    public static void main(String args[]) {
        DecimalToBinary dtb = new DecimalToBinary();
    }
}
