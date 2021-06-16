package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

    }

    //Enkelvoudige associatie Auto<>----Motor, 1 op 1 compositie
    public class Auto {
        private Motor motor;

        public Auto() {
            motor = new Motor();
        }
    }

    public class Motor {
    }

    //Enkelvoudig - Aggregaat PC <z>----Printer, precies 1 printer
    public class PC {
        private Printer printer;

        public PC(Printer print) {
            this.printer = printer;
        }

        public Printer getPrinter() {
            return printer;
        }
    }

    public class Printer {
    }

    //Enkelvoudig - 1 op 0..1, 0..1 Schaakstuk staat op 1 Veld
    public class Veld {
        private Schaakstuk schaakstuk;

        public Veld() {
        }

        public Veld(Schaakstuk stuk) {
            this.schaakstuk = stuk;
        }

        public void setSchaakstuk(Schaakstuk stuk) {
            this.schaakstuk = stuk;
        }
    }

    public class Schaakstuk {
    }

    //Enkelvoudig lastig, 1 Mysterieblok op 0..1 Mushroom    Shroom heeft ALTIJD 1 blok, dan gebruik je dit
    public class Mysterieblok {
        private Mushroom mushshroom;

        public Mysterieblok() {
        }

        public void setMushroom(Mushroom shroom) {
            mushshroom = shroom;
        }
    }

    public class Mushroom {
        public Mushroom(Mysterieblok blok) {
            blok.setMushroom(this);
        }
    }

    //Enkelvoudig Unaire Accociatie - bidirectioneel, Medewerker is ondergeschikte van 0..1 mw en is baas van 0..1 mw. Beide kanten op
    public class Medewerker {
        private Medewerker ondergeschikte;
        private Medewerker baas;

        public Medewerker() {
        }

        public void setOndergeschikte(Medewerker ondergeschikte) {
            this.ondergeschikte = ondergeschikte;
        }

        public void setBaas(Medewerker baas) {
            this.baas = baas;
        }
    }

    //Enkelvoudig Bidirectioneel lastig, 1 verslaafde heeft 1 hobby
    public class Verslaafde {
        private Hobby hobby;

        public Verslaafde() {
            hobby = new Hobby(this);
        }

        private Verslaafde(Hobby hobby) {
            this.hobby = hobby;
        }
    }

    public class Hobby {
        private Verslaafde verslaafde;

        public Hobby() {
            verslaafde = new Verslaafde(this);
        }

        private Hobby(Verslaafde verslaafde) {
            this.verslaafde = verslaafde;
        }
    }

    //Unaire Ass - Unidirectioneel lastig, 0..1 -X- Student is vriend van 0..1 Student
    public class Student {
        private Student mattie;

        public Student() {
        }

        public void setVriend(Student vriend) {
            if (!mattie.equals(vriend)) {
                mattie = vriend;
                vriend.setVriend(this);
            }
        }
    }

    //Enkelvoudig Ass, 0..1 Mens bezit/eigenaar -X- * Huisdier
    class Huisdier {
        private Mens eigenaar;

        public Huisdier() {
        }

        public void setEigenaar(Mens eigenaar) {
            this.eigenaar = eigenaar;
        }
    }

    class Mens {
    }

    //Enkelvoudig, Rekening * op 1 Klant
    public class Rekening {
        private Klant klant;

        public Rekening(Klant klant) {
            this.klant = klant;
        }

        public Klant getKlant() {
            return klant;
        }

        public void setKlant(Klant klant) {
            this.klant = klant;
        }
    }

    class Klant {
    }

    //Meervoudige Ass, Mens -X- 0..1 bezit * Huisdier
    public class Mense {
        private ArrayList<Huisdiere> bezit;

        public Mense() {
            bezit = new ArrayList<Huisdiere>();
        }

        public void nieuwBeest(Huisdiere beest) {
            bezit.add(beest);
        }

        public void wegBeest(Huisdiere beest) {
            bezit.remove(beest);
        }
    }

    //Meervoudig lastig, Mens 1 -X- bezit * Huisdier
    public class Huisdiere {
        public Huisdiere(Mense eigenaar) {
            eigenaar.nieuwBeest(this);
        }
    }

    //Meervoudig - minimaal 1 dier -
    public class Men {
        private ArrayList<Huisdiere> bezit;

        public Men(Huisdiere eersteDier) {
            bezit = new ArrayList<Huisdiere>();
            bezit.add(eersteDier);
        }

        public void nieuwBeest(Huisdiere beest) {
            bezit.add(beest);
        }

        //Er moet er altijd 1 zijn
        public void wegBeest(Huisdiere beest) {
            if (bezit.size() > 1) {
                bezit.remove(beest);
            }
        }
    }

    //Meervoudig - CD 1 op * Track
        public class Cd{
        private ArrayList<Track> tracks;

        public Cd() {
            tracks = new ArrayList<Track>();
        }

        public void addTrack(Track t){
            if (!tracks.contains(t)){
                tracks.add(t);
            }
        }
    }

public class Track {}

    //Meervoudig bidirectioneel - Docent <- * geeft les * -> Student
    public class Studente{
        private ArrayList<Docent> docenten;

        public Studente(){
            docenten = new ArrayList<Docent>();
        }
        public void addDocent(Docent docent){
            if (!docenten.contains(docent)){
                docenten.add(docent);
                docent.addStudent(this);
            }
        }
    }

    public class Docent{
        private ArrayList<Studente> studenten;

        public Docent(){
            studenten = new ArrayList<Studente>();
        }
        public void addStudent(Studente student){
            if (!studenten.contains(student)){
                studenten.add(student);
                student.addDocent(this);
            }
        }
    }




































}
