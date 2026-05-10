package calculator_app;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.util.Scanner;
public class CalculatorClient {
public static void main(String args[]) {
try {
ORB orb = ORB.init(args, null);
org.omg.CORBA.Object objRef =
orb.resolve_initial_references("NameService");
NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
Calculator calc = CalculatorHelper.narrow(ncRef.resolve_str("Calculator"));
Scanner sc = new Scanner(System.in);
System.out.print("Enter first number: ");
int a = sc.nextInt();
System.out.print("Enter second number: ");
int b = sc.nextInt();
System.out.println("Addition: " + calc.add(a, b));
System.out.println("Subtraction: " + calc.subtract(a, b));
System.out.println("Multiplication: " + calc.multiply(a, b));
System.out.println("Division: " + calc.divide(a, b));
} catch (Exception e) {
e.printStackTrace();
}
}
}

//Download jdk 8 install it  set it in Window → Preferences → Java → Installed JREs → Auto-Detect
//in project properties set java comlpier level to 1.8 
//C:\Users\joshi\Downloads\DS_Assignments\DS\CORBA>"C:\Program Files\Java\jdk1.8.0_201\bin\orbd.exe" -ORBInitialPort 1050
// run CalculatorServer.java as run config  add argument -ORBInitialPort 1050 -ORBInitialHost localhost
// run CalculatorClient.java as run as config add same argumrnt and then run same 