package com.xzy;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式
 *
 * 意图：表示一个作用于某对象结构中的各元素的操作。它允许在不改变各元素的类的前提下定义作用于这些元素的新操作。
 *
 * 适用性：
 *      1.一个对象结构包含很多类对象，它们有不同的接口，而用户想对这些对象实施一些依赖于其具体类的操作。
 *      2.需要对一个对象结构中的对象进行很多不同的并且不相关的操作，而又想要避免这些操作“污染”这些对象的类。
 *      3.定义对象结构的类很少改变，但经常需要在此结构上定义新的操作。
 */
public class VisitorPattern {
    public static void main(String[] args) {
        PersonStructure structure = new PersonStructure();

        Visitor1 visitor1 = new Visitor1();
        System.out.println("访问者1的访问记录：");
        structure.Accept(visitor1);
        System.out.println("学生年龄的总和：" + visitor1.getStudentAgeSum() + " 老师年龄的总和：" + visitor1.getTeacherAgeSUm());

        System.out.println("=========分割线==============");

        Visitor2 visitor2 = new Visitor2();
        System.out.println("访问者2的访问记录：");
        structure.Accept(visitor2);
        System.out.println("学生的最高成绩：" + visitor2.getMaxScore() + " 老师的最高工龄：" + visitor2.getMaxWorkYear());
    }
}

interface Visitor {
    void VistStudent(Student student); // 访问

    void vistTeacher(Teacher teacher); // 访问老师
}


class Visitor1 implements Visitor { // 访问者1 分别统计学生和老师的年龄总和
    private int studentAgeSum = 0;
    private int teacherAgeSUm = 0;

    public int getStudentAgeSum() {
        return studentAgeSum;
    }

    public int getTeacherAgeSUm() {
        return teacherAgeSUm;
    }

    @Override
    public void VistStudent(Student student) {
        System.out.println("访问者1访问学生：" + student.getName() + " 年龄：" + student.getAge());
        studentAgeSum += student.getAge();
    }

    @Override
    public void vistTeacher(Teacher teacher) {
        System.out.println("访问者1访问老师：" + teacher.getName() + " 年龄：" + teacher.getAge());
        teacherAgeSUm += teacher.getAge();
    }
}


class Visitor2 implements Visitor { // 访问者2 分别求出 学生的最高成绩 以及 老师的最高工龄
    private int maxScore = -1;
    private int maxWorkYear = -1;

    public int getMaxScore() {
        return maxScore;
    }

    public int getMaxWorkYear() {
        return maxWorkYear;
    }

    @Override
    public void VistStudent(Student student) {
        System.out.println("访问者2访问学生：" + student.getName() + " 成绩：" + student.getScore());
        maxScore = Math.max(maxScore, student.getScore());
    }

    @Override
    public void vistTeacher(Teacher teacher) {
        System.out.println("访问者2访问老师：" + teacher.getName() + " 工龄：" + teacher.getWorkYear());
        maxWorkYear = Math.max(maxWorkYear, teacher.getWorkYear());
    }
}


class PersonStructure {
    private List<Person> personList = new ArrayList<>();

    public PersonStructure() {
        personList.add(new Student("张三", 20, 70));
        personList.add(new Student("李四", 21, 80));
        personList.add(new Student("王五", 22, 90));

        personList.add(new Teacher("李老师", 26, 3));
        personList.add(new Teacher("陈老师", 27, 4));
        personList.add(new Teacher("刘老师", 28, 5));
    }

    public void Accept(Visitor visitor) {
        for (Person person : personList) {
            person.Accept(visitor);
        }
    }
}

abstract class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract void Accept(Visitor visitor);
}


class Student extends Person {
    private int score;

    public Student(String name, int age, int score) {
        super(name, age);
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public void Accept(Visitor visitor) {
        visitor.VistStudent(this);
    }
}


class Teacher extends Person {
    private int workYear;

    public Teacher(String name, int age, int workYear) {
        super(name, age);
        this.workYear = workYear;
    }

    public int getWorkYear() {
        return workYear;
    }

    @Override
    public void Accept(Visitor visitor) {
        visitor.vistTeacher(this);
    }
}