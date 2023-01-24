package org.week2.exercises.demo;


import com.google.common.collect.*;

public class GuavaDemo {
    public static void main(String[] args) {
//        Lege ein Demo-Projekt an und schreibe kleine Beispiele, die Multiset, Multimap, Table und RangeSet nutzen.

        // Multiset
        MULTISET_DEMO();
        /*
        The word 'the' occurs 2 times.
        Total words: 9*/


        // Multimap
        MULTIMAP_DEMO();
        /*
        Number of entries in the multimap: 5
        Fruits and their colors: {Apple=[Red, Green], Grape=[Purple, Green], Banana=[Yellow]}
        Colors of Apples: []*/


        // Table
        TABLE_DEMO();
        /*
        John's grade in Math: 90
        Mary's grades: {Math=85, Science=95}
        Math grades: {John=90, Mary=85, Bob=75}*/


        // RangeSet
        RANGESET_DEMO();
        /*
        Is 15 in the range set? true
        The range that contains 15: [10..20]
        Ranges: [[10..20], (35..40], [50..60]]
        Ranges: [[10..20], (51..60]]*/


        // RangeMap
        RANGEMAP_DEMO();
        /*
        Value for key 15: Value 1
        Range and value for key 15: [10..20]=Value 1
        Ranges: [[10..20]=Value 1, (35..40]=Value 2, [50..60]=Value 3]
        Ranges: [[10..20]=Value 1, (51..60]=Value 3]*/


        // BiMap
        BIMAP_DEMO();
        /*
        Employee with ID 2: Mary
        ID of employee 'Bob': 3
        Exception in thread "main" java.lang.IllegalArgumentException: value already present: Bob*/
    }


    /**
     * In this example, we first create a new <code>Multiset</code> called <code>words</code> using <code>HashMultiset.create()</code>.
     * We then add some words to the <code>Multiset</code> using the <code>add()</code> method.
     * We can then use the <code>count()</code> method to get the number of occurrences of a specific word,
     * in this example we check the word 'the' and it's occurrence is 2.
     * We can also use the <code>size()</code> method to get the total number of elements in the <code>Multiset</code>.
     * <p>
     * A Multiset is similar to a set, but it allows for duplicate elements,
     * and it keeps track of the number of occurrences of each element.
     * It can be useful when you need to count the occurrences of elements in a collection,
     * without having to manually keep track of them.
     */
    public static final void MULTISET_DEMO() {
        System.out.println("MultiSet-Demo\n");

        // Create a new Multiset
        Multiset<String> words = HashMultiset.create(); // -> uses the hash code of the elements to determine their position in the set. It is efficient for looking up elements and determining if an element is already in the set
//        Multiset<String> words = TreeMultiset.create(); // -> stores the elements in a TreeMap, which means that it uses the natural ordering of the elements to determine their position in the set


        // Add some words to the Multiset
        words.add("the");
        words.add("quick");
        words.add("brown");
        words.add("fox");
        words.add("jumps");
        words.add("over");
        words.add("the");
        words.add("lazy");
        words.add("dog");

        // Print the occurrences of a specific word
        System.out.println("The word 'the' occurs " + words.count("the") + " times.");

        // Print the total number of elements in the Multiset
        System.out.println("Total words: " + words.size());

        System.out.println();
        System.out.println("********************************************************************************************");
        System.out.println();
    }


    /**
     * In this example, we first create a new <code>Multimap</code> called <code>fruitColors</code>
     * using <code>MultimapBuilder.hashKeys().hashSetValues().build()</code>.
     * This creates a new <code>Multimap</code> that uses a <code>HashMap</code> for the keys
     * and a <code>HashSet</code> for the values.
     * We then add some fruits and their associated colors to the <code>Multimap</code>.
     * We can then use the <code>size()</code> method to get the total number of entries in the <code>Multimap</code>,
     * <code>get()</code> method to get all the colors of a specific fruit.
     * <p>
     * A Multimap is similar to a Map but it allows multiple values for each key.
     * A RangeMap associates a range of keys to a value,
     * whereas a RangeSet is a set of non-overlapping ranges.
     */
    public static final void MULTIMAP_DEMO() {
        System.out.println("MultiMap-Demo\n");

        // Create a new HashMultimap
//        Multimap<String, String> fruitColors = HashMultimap.create();
        SetMultimap<String, String> fruitColors = MultimapBuilder.hashKeys().hashSetValues().build(); // better with MultimapBuilder
//        ListMultimap<String, String> fruitColors = MultimapBuilder.hashKeys().arrayListValues().build(); // -> allows duplicate values for a given key -> Colors of Apples: [Red, Green, Green]

        // Add some fruits and their colors
        fruitColors.put("Apple", "Red");
        fruitColors.put("Apple", "Green");
        fruitColors.put("Apple", "Green"); // This will not be added to the set -> SetMultimap -> doesn't allow duplicates values for a given key -> Colors of Apples: [Red, Green]
        fruitColors.put("Banana", "Yellow");
        fruitColors.put("Grape", "Green");
        fruitColors.put("Grape", "Purple");

        // Print the number of entries in the multimap
        System.out.println("Number of entries in the multimap: " + fruitColors.size());

        // Print all the fruits and their colors
        System.out.println("Fruits and their colors: " + fruitColors);

        // Print all the colors of apples
        System.out.println("Colors of Apples: " + fruitColors.get("Apple"));

        System.out.println();
        System.out.println("********************************************************************************************");
        System.out.println();
    }


    /**
     * In this example, we first create a new <code>Table</code> called <code>gradebook</code> using <code>HashBasedTable.create()</code>.
     * A table is a collection that maps a triplet of keys (row, column, value) to a value.
     * We then add grades for some students, where the first key is the student name,
     * the second key is the subject and the value is the grade.
     * We can then use the <code>get()</code> method to get the grade for a specific student and subject,
     * in this example we check the grade of John in Math and it's grade is 90.
     * We can also use the <code>row()</code> method to get all grades for a specific student
     * and <code>column()</code> method to get all grades for a specific subject.
     * <p>
     * A Table is a two-dimensional data structure that allows you
     * to store and retrieve values based on a combination of two keys (row key and column key).
     * It's similar to a spreadsheet,
     * where each cell is identified by its row and column coordinates,
     * and it can be useful when you need to organize and retrieve data in a structured way.
     */
    public static final void TABLE_DEMO() {
        System.out.println("Table-Demo\n");

        // Create a new Table
        Table<String, String, Integer> gradebook = HashBasedTable.create();

        // Add grades for some students
        gradebook.put("John", "Math", 90);
        gradebook.put("John", "Science", 80);
        gradebook.put("Mary", "Math", 85);
        gradebook.put("Mary", "Science", 95);
        gradebook.put("Bob", "Math", 75);
        gradebook.put("Bob", "Science", 70);

        // Get the grade for a specific student and subject
        System.out.println("John's grade in Math: " + gradebook.get("John", "Math"));

        // Get all grades for a specific student
        System.out.println("Mary's grades: " + gradebook.row("Mary"));

        // Get all grades for a specific subject
        System.out.println("Math grades: " + gradebook.column("Math"));

        System.out.println();
        System.out.println("********************************************************************************************");
        System.out.println();
    }


    /**
     * In this example, we first create a new <code>RangeSet</code> called <code>rangeSet</code> using <code>TreeRangeSet.create()</code>.
     * We then add some ranges to the RangeSet using the <code>add()</code> method.
     * The <code>add()</code> method takes a <code>Range</code> object as an argument,
     * which can be created using the <code>Range.closed()</code> method that creates a closed range,
     * which includes its endpoints.
     * We can then use the <code>contains()</code> method to check if a specific value is contained in the <code>RangeSet</code>,
     * in this example we check if 15 is in the range set and it returns true.
     * We can also use the <code>rangeContaining()</code> method to get the range that contains a specific value,
     * in this example we check the range that contains 15 and it returns the range [10..20].
     * <p>
     * A RangeSet is a set of non-overlapping ranges,
     * it allows you to add, remove, and query for ranges in an efficient way.
     * It's useful when you need to keep track of a set of non-overlapping ranges
     * and perform operations on them.
     */
    public static final void RANGESET_DEMO() {
        System.out.println("RangeSet-Demo\n");

        // Create a new RangeSet
        RangeSet<Integer> rangeSet = TreeRangeSet.create();

        // Add some ranges to the RangeSet
        rangeSet.add(Range.closed(10, 20));
        rangeSet.add(Range.closed(30, 40));
        rangeSet.add(Range.closed(50, 60));

/*      No overlap, else merge or ignore the ranges
        // RangeSet will merge them into a single range [10,25]
        rangeSet.add(Range.closed(10, 20));
        rangeSet.add(Range.closed(15, 25));
        // it will be ignored as it's already contained in the merged range [10,25]
        rangeSet.add(Range.closed(18, 20));*/


        // Check if a specific value is contained in the RangeSet
        System.out.println("Is 15 in the range set? " + rangeSet.contains(15));

        // Get the range that contains a specific value
        System.out.println("The range that contains 15: " + rangeSet.rangeContaining(15));

        // Remove a range from the RangeSet
        rangeSet.remove(Range.closed(30, 35)); // inclusive, exclusive
        System.out.println("Ranges: " + rangeSet);
        rangeSet.remove(Range.closed(35, 51));
        System.out.println("Ranges: " + rangeSet);

        System.out.println();
        System.out.println("********************************************************************************************");
        System.out.println();
    }


    /**
     * In this example, we first create a new <code>RangeMap</code> called <code>rangeMap</code> using <code>TreeRangeMap.create()</code>.
     * We then associate values with ranges of keys using the <code>put()</code> method.
     * The <code>put()</code> method takes a Range object and a value as arguments.
     * The <code>Range</code> object defines the range of keys that the value is associated with.
     * In this example, we used the <code>Range.closed(int, int)</code> method to create closed ranges,
     * which include both the start and end values.
     * We can then use the <code>get()</code> method to get the value associated with a specific key
     * and the <code>getEntry()</code> method to get the range and value associated with a specific key.
     * We can also remove a range from the <code>RangeMap</code> using the <code>remove()</code> method,
     * In this example, we removed the range 30 to 35 from the <code>RangeMap</code>.
     * <p>
     * A RangeMap allows you to associate a value with a range of keys,
     * it's efficient for looking up a value given a key,
     * and it allows you to remove ranges.
     */
    public static final void RANGEMAP_DEMO() {
        System.out.println("RangeMap-Demo\n");

        // Create a new RangeMap
        RangeMap<Integer, String> rangeMap = TreeRangeMap.create();

        // Associate values with ranges of keys
        rangeMap.put(Range.closed(10, 20), "Value 1");
        rangeMap.put(Range.closed(30, 40), "Value 2");
        rangeMap.put(Range.closed(50, 60), "Value 3");

        // Overlap example
        /*
        rangeMap.put(Range.closed(10, 20), "Value 1");
        rangeMap.put(Range.closed(15, 25), "Value 2");

        System.out.println("Value for key 15: " + rangeMap.get(15)); -> Value for key 15: Value 2

        In a RangeMap, ranges are not automatically merged if they overlap, unlike RangeSet.
        Instead, when you add a range to a RangeMap that overlaps with an existing range,
        the new range will overwrite the value associated with the existing range.

        The first range is [10,20] with the value "Value 1"
        and the second range is [15,25] with the value "Value 2".
        Since these ranges overlap,
        the value associated with the key range [10,20] will be "Value 2"
        and not "Value 1" as the second range overwrote the first one.

        It's worth noting that this behavior allows you to use RangeMap as a way to implement a switch-case statement.
        */

        // Get the value associated with a specific key
        System.out.println("Value for key 15: " + rangeMap.get(15));

        // Get the range and value associated with a specific key
        System.out.println("Range and value for key 15: " + rangeMap.getEntry(15));

        // Remove a range from the RangeMap
        rangeMap.remove(Range.closed(30, 35));
        System.out.println("Ranges: " + rangeMap);
        rangeMap.remove(Range.closed(35, 51));
        System.out.println("Ranges: " + rangeMap);

        System.out.println();
        System.out.println("********************************************************************************************");
        System.out.println();
    }


    /**
     * In this example, we first create a new <code>BiMap</code> called <code>employees</code> using <code>HashBiMap.create()</code>.
     * We then add some employees to the <code>BiMap</code>,
     * where the key is the employee ID and the value is the employee name.
     * We can then use the <code>get()</code> method to get the name of an employee using their ID,
     * and the <code>inverse().get()</code> method to get the ID of an employee using their name.
     * <p>
     * A BiMap is a special type of Map that allows you to look up values by key and keys by value.
     * It allows you to create a one-to-one mapping between keys and values,
     * so you can't have duplicate values,
     * if you try to insert duplicate value,
     * it will throw IllegalArgumentException.
     */
    public static final void BIMAP_DEMO() {
        System.out.println("BiMap-Demo\n");
        // Create a new BiMap
        BiMap<Integer, String> employees = HashBiMap.create();

        // Add some employees
        employees.put(1, "John");
        employees.put(2, "Mary");
        employees.put(3, "Bob");

        // Get the name of an employee using their ID
        System.out.println("Employee with ID 2: " + employees.get(2));

        // Overwrite key with new value
        employees.put(2, "Pete");
        System.out.println("Employee with ID 2: " + employees.get(2));

        // Get the ID of an employee using their name
        System.out.println("ID of employee 'Bob': " + employees.inverse().get("Bob"));

        // Try to add a duplicate value
        employees.put(4, "Bob"); // This will throw an IllegalArgumentException

        System.out.println();
        System.out.println("********************************************************************************************");
        System.out.println();
    }
}
