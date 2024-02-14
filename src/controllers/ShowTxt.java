package controllers;

import java.util.List;
import java.util.Scanner;

import models.Person;
import models.Person2;
import services.ProcesTxt;

public class ShowTxt{

    private ProcesTxt procces;
    private Scanner read;

    public ShowTxt(){
        procces= new ProcesTxt();
        read= new Scanner(System.in);
    }
    
    public void CreateTxt(){
        procces.writeFileTxt(getName(), getCont(), getPath());
    }

    public String getName(){
        askName();
        return read.nextLine();
    }

    public void askName(){
        System.out.println("Digite el nombre del archivo");
    }

    public String getCont(){
        askCont();
        return read.nextLine();
    }

    public void askCont(){
        System.out.println("Digite el contenido del archivo");
    }

    public void SearchFiles(){
        String[] list=procces.searchFile(getPath());
        for(int i=0; i<list.length;i++){
            System.out.println(list[i]);
        }
    }

    public void showPersonOrganice(){
        for(Person people: procces.organiceTxtPersons(getPath())){
            System.out.println(people.getName()+" "+people.getLastname()+" "+people.getGender()+" "+people.getCode());
        }
    }

    public String getPath(){
        askPath();
        return read.nextLine();
    }

    public void askPath(){
        System.out.println("Digite la ubicacion del archivo");
    }

    public void showPersonOrganice2(){
        for(Person2 people: procces.organiceTxtPerson2(getPath())){
            System.out.println(people.getName()+" "+people.getLastname()+" "+people.getGender()+" "+people.getCode()+" "+people.getWeigth()+" "+people.getSalary());
        }
    }
}