package com.itacademy;



import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        try {
            FileWriter fileWriter = new FileWriter("TextFile.txt");
            fileWriter.write("Hello World. I LOVE JAVA 2024 ;)");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //int wordCount= 0;
        //String line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("TextFile.txt"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(line).append(" ");
            }
            bufferedReader.close();

            String text = stringBuilder.toString().replaceAll("[^a-zA-Z0-9]" , " ");

            Map<String,Integer> wordCount = new HashMap<>();
            String[] words = text.split("\\s+");
            for (String word: words)
            {
                wordCount.put(word,wordCount.getOrDefault(word,0)+1);  // кол-во
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter("Result.txt"));
            for (Map.Entry <String,Integer> stringIntegerMap: wordCount.entrySet())
            {
                writer.write(stringIntegerMap.getKey() + ": "+ stringIntegerMap.getValue()+ "\n");
            }
            writer.close();
        }
        catch (IOException e)
        {
            System.out.println("Что-то пошло не так");
        }




//        Comparator<Student> studentComparator = new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return 0;
//            }
//        };
//        List<Student> set = new ArrayList<>(studentComparator);


        List<Student> students = new ArrayList<>();
        students.add(new Student("pasha",18));
        students.add(new Student("Masha",15));
        students.add(new Student("nick",19));
        students.add(new Student("Gorgic",28));
        students.add(new Student("Roza",38));
        students.add(new Student("Anna",24));
        students.add(new Student("zumba",21));
        List<Student> updateAge = students.stream().map(student -> new Student(student.getName(), student.getAge()+1)).collect(Collectors.toList());
        List<Student> sortedStudent = updateAge.stream().sorted((s1, s2)-> Integer.compare(s1.getAge(),s2.getAge())).collect(Collectors.toList());
        List<Student> filterStudent = sortedStudent.stream().filter(student -> student.getAge()>20).collect(Collectors.toList());
        filterStudent.forEach(student -> System.out.println(student.getName() + ": " + student.getAge()));
        long studentCount = filterStudent.stream().count();
        System.out.println(studentCount);


        //collect(Collectors.toList()) - собирает элементы потока в список
       // IntStream.of(students.getLast()).map(x->x+10);
//        long studentCount = students.stream().count();
//        List<String> studentNamesList = students.stream().map(Student::getName).collect(Collectors.toList());


        //long studentCount = students.stream().count();
//        Stream stream = students.stream();
//        System.out.println(stream);
//        students.stream().map(Student::getName);
        int d = 4;
        int b = 6;
        MyFunctionalInterface<Integer> myFuncInterface = (cVal,bVal) -> System.out.println(cVal + bVal);
        myFuncInterface.doSmt(d,b);
    }
    @FunctionalInterface
    public interface MyFunctionalInterface<T>
    {
        void doSmt (T d,T b);
    }


}
