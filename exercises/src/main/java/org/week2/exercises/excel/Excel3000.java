package org.week2.exercises.excel;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


// It's also important to note that this code assumes that the cell references in the formula
// are in the format $A1, $B2, etc.
// where the first character after the $ is
// an uppercase letter and the next one is a digit.
// Uses exp4j to evaluate formula.
public class Excel3000 {
/*    Mini-Excel (req. Guava)
    Lege eine neue Klasse Excel3000 an.
    Intern soll eine ein Objektvariable Table<Integer *//*row*//*, Integer *//*col*//*, String *//*val*//*> table geben, um eine Art “Excel-Tabelle” zu repräsentieren; es steht das 1. Integer für die Zeile und das 2. Integer für die Spalte.

    Schreibe eine Methode, um die Tabelle zu füllen.
    Ergänze eine Methode setCell(String cell, String content);
    dabei stellt cell für eine Kodierung wie etwa A1 oder T3.
    Ergänze getCellAt(int row, int col) und getCellAt(String cell) zum Erfragen.

    Ergänze in Excel3000 eine öffentliche Methode Excel3000 evaluate(),
    die auf einer Tabelle aufgerufen werden kann.
    Dabei sollen die Zellen, die mit = beginnen,
    Formeln sein, die ausgewertet werden sollen.
    Eine neue berechnete Tabelle vom Typ Excel3000 soll das Ergebnis der Methode sein.
    In der Formel kann es Referenzen auf andere Zellen geben, etwa mit =$A1 * 2 + $T3.
    Nimm an, dass die Formeln keine weiteren Formeln referenzieren. Doch überlege,
    wie sich das lösen lässt, und überlege auch, wie man mit Zyklen umgehen kann.


    Beschäftige dich mit
    https://poi.apache.org/ .
    Nutze POI, um die eigene Tabelle im Excel-Format zu schreiben (XLSX). Öffne mit 7-Zip die XLSX-Datei. Was stellst du fest?
    Schreibe die Excel3000 Tabelle im XLSX-Format.*/
    // -> it doesn't evaluate the formulas right away, need to click and edit the cell

    // < Row, Column, Value >
    private HashBasedTable<String, Integer, String> table;

    Excel3000() {
        table = HashBasedTable.create();
        System.out.println("new table created");

        printTable();
    }

    public void setCell(String cell, String content) {
        String[] parts = cell.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)"); // regex split the string in string (only letters) and numbers (only digits)
//        System.out.println(Arrays.toString(parts));
        String row = parts[0];
        int col = Integer.parseInt(parts[1]);
        table.put(row, col, content);

        printTable();
    }

    public void setCell(String row, int col, String content) {
        table.put(row, col, content);

        printTable();
    }

    public String getCellAt(String row, int col) {
        return table.get(row, col);
    }

    public String getCellAt(String cell) {
        try {
            String[] parts = cell.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)"); // regex split the string in string (only letters) and numbers (only digits)
            String row = parts[0];
            int col = Integer.parseInt(parts[1]);
            return table.get(row, col);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            // Handle the exception here, for example by returning a default value or throwing a custom exception
            System.out.println("Invalid cell format, please use format like A1");
            return "";
        }
    }

    // index starts counting from 0 in Guava Table
    String getRowCols(String value) {
        String result = "";
        for (String row : table.rowKeySet()) {
            for (Integer col : table.columnKeySet()) {
                if (table.get(row, col).equals(value)) {
                    result += "row: " + row + " column: " + col + "\n";
                }
            }
        }
        return result;
    }

    public Excel3000 evaluate() {
        Excel3000 newTable = new Excel3000();
        for (Table.Cell<String, Integer, String> cell : table.cellSet()) {
            String cellValue = cell.getValue();
            if (cellValue.startsWith("=")) {
                String formula = cellValue.substring(1);
                // evaluate formula and get result
                String result = evaluateFormula(formula);
                newTable.setCell(cell.getRowKey(), cell.getColumnKey(), result);
            } else {
                newTable.setCell(cell.getRowKey(), cell.getColumnKey(), cellValue);
            }
        }

        return newTable;
    }

    private String evaluateFormula(String formula) {

        String cellValue = formula;
        ArrayList<String> cellReferences = extractCellReferences(formula);
        String newFormula = replaceCellReferences(formula, cellReferences);
        System.out.println(formula);
        System.out.println(cellReferences);
        System.out.println(newFormula);

        // if it's a number and could be calculated, return new formula, else just return the input from before
        String result = "No values found";
        try {
            Expression ex = new ExpressionBuilder(newFormula)
                    .build();
            result = String.valueOf(ex.evaluate());
        } catch (IllegalArgumentException e) {
            System.out.println("The constructor of the ExpressionBuilder class is not a valid expression, has an invalid syntax or if the provided variables are invalid");
        }
        // only if we were able to calculate something and get a final number, we can then return new cell value
        try {
            double doubleValue = Double.parseDouble(result);
            // assign the result of the calculation to the cell value
            cellValue = String.valueOf(doubleValue);
        } catch (NumberFormatException e) {
            System.out.println("Cell value can't be calculated, cell value remains the same");
        }

        return cellValue;
    }


    private ArrayList<String> extractCellReferences(String formula) {
        ArrayList<String> cellReferences = new ArrayList<>();
        int startIndex = formula.indexOf("$");
        while (startIndex != -1) {
            int endIndex = startIndex + 1;
            while (endIndex < formula.length() && (Character.isLetter(formula.charAt(endIndex)) || Character.isDigit(formula.charAt(endIndex)))) {
                endIndex++;
            }
            if (endIndex > startIndex + 1) {
                // remove the $ symbol from the cell reference
                String cellReference = formula.substring(startIndex + 1, endIndex);
                cellReferences.add(cellReference);
            } else {
                System.out.println("Invalid cell reference in formula: " + formula);
//                throw new IllegalArgumentException("Invalid cell reference in formula: " + formula);
            }
            startIndex = formula.indexOf("$", endIndex);
        }
        return cellReferences;
    }

    private String replaceCellReferences(String formula, ArrayList<String> cellReferences) {
        String newFormula = formula;
        for (String cellReference : cellReferences) {
            // check if the cell reference exists and returns not null
            String cellValue;
            if (getCellAt(cellReference) != null) {
                cellValue = getCellAt(cellReference);
            } else {
                return formula;
            }
            // search the string for the "$cellReference"
            newFormula = newFormula.replace("$" + cellReference, cellValue); // not formula, else "$A1... $N? value" -> only replaced last one
        }
        return newFormula;
    }


    // text based table display
    /*    private void printTable(HashBasedTable<String, Integer, String> table) {
            Map<String, Map<Integer, String>> rows = table.rowMap();
            for (String row : rows.keySet()) {
                Map<Integer, String> columns = rows.get(row);
                for (Integer col : columns.keySet()) {
                    System.out.println("Row: " + row + " Column: " + col + " Value: " + columns.get(col));
                }
            }
            System.out.println();
        }*/
    // graphical table display
    public void printTable() {
        int maxRowNameLength = 0;
        int maxColNameLength = 0;
        int maxCellLength = 0;
        int maxLength = 0;

        // find the maximum length of row, col, cell -> so that everything has the same spacing
        for (String row : table.rowKeySet()) {
            maxRowNameLength = Math.max(maxRowNameLength, row.length());
        }
        for (String row : table.rowKeySet()) {
            for (int col : table.columnKeySet()) {
                maxColNameLength = Math.max(maxColNameLength, String.valueOf(col).length());
                String cell = table.get(row, col);
                if (cell != null) {
                    maxCellLength = Math.max(maxCellLength, cell.length());
                }
            }
        }
        maxLength = Math.max(maxCellLength, Math.max(maxRowNameLength, maxColNameLength));

        // print the table header
/*        System.out.print("-----");
        for (int i = 0; i < maxCellLength - 5; i++) {
            System.out.print(" ");
        }*/
        System.out.print("");
        for (int i = 0; i < maxLength; i++) {
            System.out.print(" ");
        }
        System.out.print(" |");
        for (int col : table.columnKeySet()) {
            int colLen = String.valueOf(col).length();
            for (int i = 0; i < maxLength - colLen; i++) {
                System.out.print(" ");
            }
            System.out.print(" " + col + " |");
        }
        System.out.println();

        // print the table body
        for (String row : table.rowKeySet()) {
            int rowLen = row.length();
            for (int i = 0; i < maxLength - rowLen; i++) {
                System.out.print(" ");
            }
            System.out.print(row + " |");
            for (int col : table.columnKeySet()) {
                String cell = table.get(row, col);
                int cellLen = cell == null ? 0 : cell.length();
                for (int i = 0; i < maxLength - cellLen; i++) {
                    System.out.print(" ");
                }
                System.out.print(" " + (cell == null ? "" : cell) + " |");
            }
            System.out.println();
        }

        System.out.println();
    }


    // Apache POI, table to xlsx file
    public void saveToExcel(String fileName, String filePath) {
        try {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Sheet1");
            int rowNum = 0;
            for (String row : table.rowKeySet()) {
                Row excelRow = sheet.createRow(rowNum);
                int colNum = 0;
                for (Integer col : table.columnKeySet()) {
                    Cell cell = excelRow.createCell(colNum);
                    cell.setCellValue(table.get(row, col));
                    colNum++;
                }
                rowNum++;
            }
            FileOutputStream outputStream = new FileOutputStream(filePath+"/"+fileName+".xlsx");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
            System.out.println("Excel file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
