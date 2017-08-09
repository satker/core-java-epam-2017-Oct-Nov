package com.epam.courses.jf.se2.annotations;

import java.lang.annotation.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Информация о ревизии.
 */
@Documented
@Inherited
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface ClassPreamble {
    String author();
    String date();
    int currentRevision() default 1;
    String lastModified() default "N/A";
    String lastModifiedBy() default "N/A";
    String[] reviewers();
}

@ClassPreamble(
        author = "John Doe",
        date = "3/17/2002",
        currentRevision = 6,
        lastModified = "4/12/2004",
        lastModifiedBy = "Jane Doe",
        reviewers = {"Alice", "Bob", "Cindy"}
)
class AnnotatedClass {

    @ClassPreamble(author = "John Doe",
            date = "3/17/2002",
            currentRevision = 10,
            lastModified = "4/12/2004",
            lastModifiedBy = "Jane Doe",
            reviewers = {"Alice", "Bob", "Cindy"})
    private final int field;

    private final String anotherField;

    private AnnotatedClass() {
        field = -1;
        anotherField = "Private";
    }

    AnnotatedClass(int field, String anotherField) {
        this.field = field;
        this.anotherField = anotherField;
    }

    public int getField() {
        return field;
    }
}

class InheritedClass extends AnnotatedClass {

    InheritedClass(int field, String anotherField) {
        super(field, anotherField);
    }
}

class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class<AnnotatedClass> annotationClass = AnnotatedClass.class;

        AnnotatedClass object = new AnnotatedClass(0, "qwerty");
        Class<? extends AnnotatedClass> objectAnnotationClassClass = object.getClass();

        if (annotationClass != objectAnnotationClassClass) {
            throw new RuntimeException("WTF");
        }

        System.out.println("Before changes: " + object.getField());
        Field field = annotationClass.getDeclaredField("field");
        field.setAccessible(true);
        if (field.isAnnotationPresent(ClassPreamble.class)) {
            System.out.println("Annotation present");
        } else {
            System.out.println("Annotation not present");
        }
        field.set(object, 100);
        System.out.println("After changes: " + object.getField());



        Class<InheritedClass> inheritedClass = InheritedClass.class;
        if (inheritedClass.isAnnotationPresent(ClassPreamble.class)) {
            System.out.println("Annotation present in inherited class");
        } else {
            System.out.println("Annotation not present in inherited class");
        }

        Annotation[] annotations = inheritedClass.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        Constructor privateConstructor = annotationClass.getDeclaredConstructor();
        privateConstructor.setAccessible(true);
        AnnotatedClass privateObject = (AnnotatedClass) privateConstructor.newInstance();
        System.out.println(privateObject.getField());
    }
}
