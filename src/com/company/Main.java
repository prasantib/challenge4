package com.company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main {
    private static ArrayList<Class> classes = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Faculty> faculties = new ArrayList<>();
    private static ArrayList<Link> links = new ArrayList<>();
    private static Scanner kb = new Scanner(System.in);
    public static void main(String[] args) {
        Class java = new Class(0,"Java", "Welcome to Java");
        Class python = new Class(1,"Python", "Welcome to Python");
        Class perl = new Class(2,"Perl", "Welcome to Perl");
        Collections.addAll(classes, java, python, perl);
        Student prasanti = new Student("Prasanti", 0);
        Student sam = new Student("Sam", 1);
        Student samantha = new Student("Samantha", 2);
        Collections.addAll(students, prasanti, sam, samantha);
        Faculty victor = new Faculty("Victor", 0);
        Faculty kenisha = new Faculty("Kenisha", 1);
        Faculty josiah = new Faculty("Josiah", 2);
        Collections.addAll(faculties, victor, kenisha, josiah);
        Link link = new Link(java.getId(), prasanti.getId(), 0, victor.getId());
        Link link1 = new Link(python.getId(), sam.getId(), 1, kenisha.getId());
        Link link2 = new Link(perl.getId(), samantha.getId(), 2, josiah.getId());
        Collections.addAll(links, link, link1, link2);
        display();
        boolean repeat = true;
        String option;
        do {
            System.out.print("Please enter an option (add/edit/enroll)?");
            option = kb.nextLine();
            if (option.equalsIgnoreCase("add")) {
                add();
            }
            else if(option.equalsIgnoreCase("edit")){
                edit();
            }
            else if(option.equalsIgnoreCase("enroll")){
                enroll();
            }
            else if(option.equalsIgnoreCase("hire")){
                hire();
            }
            else{
                if(!option.equalsIgnoreCase("quit")){
                    System.out.print("Invalid Choice!");
                }
            }
        } while(!option.equalsIgnoreCase("quit"));
        display();
    }
    public static int studentLookUp(){
        boolean studentSearch = true;
        long id = 0;
        do {
            System.out.print("Which student?");
            String cn = kb.nextLine();
            for (Student student : students) {
                if (cn.equalsIgnoreCase(student.getName())) {
                    studentSearch = false;
                    id = student.getId();
                }
            }
        } while(studentSearch);
        return (int)id;
    }
    public static int facultyLookUp(){
        boolean facultySearch = true;
        long id = 0;
        do {
            System.out.print("Which faculty?");
            String cn = kb.nextLine();
            for (Faculty faculty: faculties) {
                if (cn.equalsIgnoreCase(faculty.getName())) {
                    facultySearch = false;
                    id = faculty.getId();
                }
            }
        } while(facultySearch);
        return (int)id;
    }

    public static void add(){
        System.out.print("What would you like to add? (Student, Faculty, Class, or Link)");
        String c = kb.nextLine();
        if(c.equalsIgnoreCase("student")){
            System.out.print("What is the student's name?");
            String cn = kb.nextLine();
            students.add(new Student(cn, students.size()));
        }
        else if(c.equalsIgnoreCase("faculty")){
            System.out.print("What is the faculty's name?");
            String cn = kb.nextLine();
            faculties.add(new Faculty(cn, faculties.size()));
        }
        else if(c.equalsIgnoreCase("class")) {
            System.out.print("What is the class's name?");
            String cn = kb.nextLine();
            classes.add(new Class(classes.size(), cn));
        }
        else if(c.equalsIgnoreCase("link")){
            boolean add = true;
            long studentFinal = 0, facultyFinal = 0, classFinal = 0, idFinal = 0;
            do {
                System.out.print("Which student to be linked?");
                String s = kb.nextLine();
                for(Student student: students){
                    if(s.equalsIgnoreCase(student.getName())){
                        add = false;
                        studentFinal = student.getId();
                    }
                }
            } while(add);
            add = true;
            do{
                System.out.print("Which faculty is linked to which class?");
                String name = kb.nextLine();
                for(Faculty faculty: faculties){
                    if(name.equalsIgnoreCase(faculty.getName())){
                        add = false;
                        facultyFinal = faculty.getId();
                    }
                }
            } while (add);
            add = true;
            do {
                System.out.print("Which faculty is linked to which class?");
                String name = kb.nextLine();
                for(Class class: class){
                    if(name.equalsIgnoreCase(class.getName())){
                        add = false;
                        classFinal = class.getId();
                    }
                }
            } while (add);
            links.add(new Link(studentFinal, facultyFinal, classFinal, links.size()));
        }
    }
    public static void edit(){
        System.out.print("Who would you like to edit? (Student or Faculty)");
        String c = kb.nextLine();
        if(c.equalsIgnoreCase("student")){
            int i = studentLookUp();
            System.out.print("Enter a new student: ");
            String n = kb.nextLine();
            students.get(i).setName(n);
        }
        else if(c.equalsIgnoreCase("faculty")){
            int i = facultyLookUp();
            System.out.print("Enter a new faculty: ");
            String n = kb.nextLine();
            faculties.get(i).setName(n);
        }
    }
    public static void enroll(){
        System.out.print("Enroll a student? ");
        String c = kb.nextLine();
        if(c.equalsIgnoreCase("student")){
            int i = studentLookUp();
            System.out.print("Enter a student's name: ");
            String n = kb.nextLine();
            students.get(i).setName(n);
        }
    }
    public static void hire(){
        System.out.print("Hire a faculty? ");
        String c = kb.nextLine();
        if(c.equalsIgnoreCase("faculty")){
            int i = facultyLookUp();
            System.out.print("Enter a faculty's name: ");
            String n = kb.nextLine();
            faculties.get(i).setName(n);
        }
    }
    public static void display(){
        for(Student s : students){
            for(Link l : links){
                if(l.getStudentId() == s.getId()){
                    for(Class c: classes){
                        if(c.getId() == l.getClassId()){
                            System.out.println(s.getName() + ", " + c.getName());
                        }
                    }
                }
            }
        }
    }
}