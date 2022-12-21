package org.example.javexercise.chap2.methods;

//import static org.example.javexercise.chap2.methods.LinePrinter.line;

// overloaded-methods
public class LinePrinterDemo {
    public static void main(String[] args) {
//        line(); // -> import static org.example.javexercise.chap2.methods.LinePrinter.line; -> static import
        LinePrinter.line();

        LinePrinter.line(3);
        System.out.println();

        LinePrinter.line(7, 'x');
        System.out.println();

        LinePrinter.line("╠", 3, '═', "╣");
        System.out.println();


        LinePrinter.line( 10, "Oma" );
    }
}
