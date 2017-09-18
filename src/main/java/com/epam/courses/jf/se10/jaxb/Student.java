package com.epam.courses.jf.se10.jaxb;

import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Student", propOrder = {"name", "telephone", "address"})
@Data
public class Student {

    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    private String login;

    @XmlElement(required = true)
    private String name;

    @XmlAttribute(required = true)
    private String faculty;

    @XmlElement(required = true)
    private int telephone;

    @XmlElement(required = true)
    private Address address = new Address();

    public Student() {
    }// необходим для генерации XML

    public Student(String login, String name, String faculty, int telephone,
                   Address address) {
        this.login = login;
        this.name = name;
        this.faculty = faculty;
        this.telephone = telephone;
        this.address = address;
    }

    public String toString() {
        return "\nLogin: " + login + "\nName: " + name + "\nTelephone: " + telephone + "\nFaculty: " + faculty + address.toString();
    }

    @XmlRootElement
    @Data
    public static class Address {// внутренний класс

        private String country;

        private String city;

        private String street;

        public Address() {
        }

        public Address(String country, String city, String street) {
            this.country = country;
            this.city = city;
            this.street = street;
        }

        public String toString() {
            return "\nAddress:" + "\n\tCountry: " + country + "\n\tCity: " + city + "\n\tStreet: " + street + "\n";
        }
    }
}

