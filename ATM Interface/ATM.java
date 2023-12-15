import java.util.Scanner;

class ATM {
    float balance;
    int pin = 5555;
    int EnterPin;
    int option;
    int Withdraw_Amount;
    int Deposite_Amount;
    Scanner sc = new Scanner(System.in);

    void print_Line() {
        System.out.println("************* ATM STRUCTURE *************");
        System.out.println("|                                       |");
        System.out.println("|               [ ATM ]                 |");
        System.out.println("|                                       |");
        System.out.println("|   1. Balance Inquiry                  |");
        System.out.println("|   2. Withdraw Money                   |");
        System.out.println("|   3. Deposit Money                    |");
        System.out.println("|   4. Exit                             |");
        System.out.println("|                                       |");
        System.out.println("****************************************");
    }

    public void check_pin() {
        System.out.print("Enter your Pin : ");
        EnterPin = sc.nextInt();
        if (pin == EnterPin) {
            print_Line();
            menue();
        } else {
            System.out.println("Please Enter a valid Pin!");
            check_pin();
        }
    }

    void menue() {
        System.out.print(" Please select an option : ");
        option = sc.nextInt();
        if (option == 1) {
            System.out.println("Your Available Balance is : " + balance);
            print_Line();
            menue();
        } else if (option == 2) {
            System.out.print("Enter Amount You want to Withdraw : ");
            Withdraw_Amount = sc.nextInt();
            if (Withdraw_Amount>balance)
            {
                System.out.println("Insufficient Balance!");
                print_Line();
                menue();
            }
            else
            {
                balance = balance - Withdraw_Amount;
                System.out.println("Amount Withdrawal Successful ");
                print_Line();
                menue();
            }
        } else if (option == 3) {
            System.out.print("Enter Amount You want to Deposit : ");
            Deposite_Amount = sc.nextInt();
            if (Deposite_Amount <= 0)
            {
                System.out.println("Invalid Input!");
                print_Line();
                menue();
            }
            balance = balance + Deposite_Amount;
            print_Line();
            menue();
        } else if (option == 4) {
            System.out.println("Thank you For using ATM Machine! ");
            return;
        } else {
            System.out.println("Please Enter a Valid option! ");
            print_Line();
            menue();
        }
    }

    public static void main(String args[]) {
        ATM atm = new ATM();
        atm.check_pin();
    }
}