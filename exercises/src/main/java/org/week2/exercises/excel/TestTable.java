package org.week2.exercises.excel;

public class TestTable {
    private static final String FILE_PATH = "C:/Users/Dunguyen/Desktop/Exercise-Dump";

    public static void main(String[] args) {
        Excel3000 table1 = new Excel3000();
        table1.setCell("A", 1, "Hello");
        table1.setCell("B2", "World");
        table1.setCell("C3", "2");
        table1.setCell("D4", "4");
        table1.setCell("E5", "= $C3 * 4 + $D4");
        table1.setCell("F6", "= $C4 * 4 + $D4"); // can't be evaluated
        table1.evaluate();
        table1.saveToExcel("test", FILE_PATH);
    }
}
