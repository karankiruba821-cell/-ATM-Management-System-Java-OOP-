import java.util.Scanner; 
interface ATMOperations { 
void checkBalance(); 
void deposit(double amount); 
void withdraw(double amount); 
} 
abstract class Account { 
    private String name; 
    private String regNo; 
    private String department; 
    private double balance; 
  
    public Account(String name, String regNo, String department, double balance) { 
        this.name = name; 
        this.regNo = regNo; 
        this.department = department; 
        this.balance = balance; 
    } 
  
    public String getName() { 
        return name; 
    } 
  
    public String getRegNo() { 
        return regNo; 
    } 
  
    public String getDepartment() { 
        return department; 
    } 
  
    public double getBalance() { 
        return balance; 
    } 
  
    protected void setBalance(double balance) { 
        this.balance = balance; 
    } 
  
    public abstract void displayInfo(); 
} 
  
class StudentAccount extends Account implements ATMOperations { 
  
    public StudentAccount(String name, String regNo, String department, double balance) { 
        super(name, regNo, department, balance); 
    } 
  
    public void checkBalance() { 
        System.out.println("Balance: " + getBalance()); 
    } 
  
    public void deposit(double amount) { 
        if (amount > 0) { 
            setBalance(getBalance() + amount); 
            System.out.println("Amount Deposited"); 
        } else { 
            System.out.println("Invalid Amount"); 
        } 
    } 
  
    public void withdraw(double amount) { 
        if (amount > 0 && amount <= getBalance()) { 
            setBalance(getBalance() - amount); 
            System.out.println("Amount Withdrawn"); 
        } else { 
            System.out.println("Insufficient Balance"); 
        } 
    } 
  
    public void displayInfo() { 
        System.out.println("Name: " + getName()); 
        System.out.println("Reg No: " + getRegNo()); 
        System.out.println("Department: " + getDepartment()); 
        System.out.println("Balance: " + getBalance()); 
    } 
} 
  
public class Main { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
  
        StudentAccount acc = new StudentAccount("Kiruba", "101", "CSE", 5000); 
  
        int choice; 
        do { 
            System.out.println("\n1. Display Info"); 
            System.out.println("2. Check Balance"); 
            System.out.println("3. Deposit"); 
            System.out.println("4. Withdraw"); 
            System.out.println("5. Exit"); 
            System.out.print("Enter choice: "); 
            choice = sc.nextInt(); 
  
            switch (choice) { 
                case 1: 
                    acc.displayInfo(); 
                    break; 
                case 2: 
                    acc.checkBalance(); 
                    break; 
                case 3: 
                    System.out.print("Enter amount: "); 
                    acc.deposit(sc.nextDouble()); 
                    break; 
                case 4: 
                    System.out.print("Enter amount: "); 
                    acc.withdraw(sc.nextDouble()); 
                    break; 
                case 5: 
                    System.out.println("Thank You"); 
                    break; 
                default: 
                    System.out.println("Invalid Choice"); 
            } 
        } while (choice != 5); 
  
        sc.close(); 
    } 
}