package com.epam.courses.jf.se2.polymorphism;

public class CourseInspector {

    public static void main(String[] args) {
        CourseHelper bch = new BaseCourseHelper();
        Course course = bch.getCourse();
        //BaseCourse course = bch.getCourse();
        //ошибка компиляции
        bch.getCourse();
    }
}

class MedicalStaff {

    public void info() {
        System.out.println("MedicalStaff");
    }

    public static void staticInfo() {
        System.out.println("MedicalStaff.static");
    }


}

class Doctor extends MedicalStaff {

    public void info() {
        System.out.println("Doctor");
    }

    public static void staticInfo() {
        System.out.println("Doctor.static");
    }

}

class Surgeon extends Doctor {

    @Override
    public void info() {
        System.out.println("Surgeon");
    }

}

class Hospital {

    public static void main(String[] args) {
        Doctor doctor = new Doctor();
        doctor.info();
        doctor.staticInfo();

        MedicalStaff med = new Doctor();
        med.info();
        med.staticInfo();

        Surgeon surgeon = new Surgeon();
        surgeon.info();
        surgeon.staticInfo();
    }


}

class Course {}

class BaseCourse extends Course {}

class CourseHelper {

    public Course getCourse() {
        System.out.println("Course");
        return new Course();
    }
}

class BaseCourseHelper extends CourseHelper {

    @Override
    public BaseCourse getCourse() {
        System.out.println("BaseCourse");
        return new BaseCourse();
    }
}
