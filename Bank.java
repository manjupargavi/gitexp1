class BankAccount{
private int balance;
public BankAccount(int balance){
this.balance = balance;
}
public synchronized void withdraw(int amount){
while(balance-amount<10000){
try{
wait();
}
catch(InterruptedException e){
e.printStackTrace();
}
}
balance -= amount;
System.out.println("Withdrawn: "+amount);
System.out.println("Current balance: "+balance);
}
public synchronized void deposit(int amount){
balance += amount;
System.out.println("Deposited: "+amount);
System.out.println("Current balance: "+balance);
notifyAll();
}
}
class Customer implements Runnable{
private BankAccount bankAccount;
public Customer(BankAccount bankAccount){
this.bankAccount = bankAccount;
}
public void run(){
bankAccount.withdraw(20000);
bankAccount.deposit(15000);
bankAccount.withdraw(10000);
bankAccount.deposit(5000);
}
}
public class Bank {
public static void main(String[] args){
BankAccount bankAccount = new BankAccount(25000);
Customer customer = new Customer(bankAccount);
Thread thread = new Thread(customer);
thread.start();
}
}