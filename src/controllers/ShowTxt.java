package controllers;

import java.io.IOException;
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
        for(Person2 people: procces.organiceTxtPerson2(".\\person2.txt")){
            System.out.println(people.getCode()+" "+people.getName()+" "+people.getLastname()+" "+people.getGender()+" "+people.getWeigth()+" "+people.getSalary());
        }
    }

    public void showBytesAdd() throws IOException{
        int totalsalary=0;
        int cont=0;
        for (Person2 people : procces.organicePerson2P()) {
            System.out.println(people.getCode()+" "+people.getName()+" "+people.getLastname()+" "+people.getGender()+" "+people.getWeigth()+" "+people.getSalary());
            totalsalary=totalsalary+people.getSalary();
            cont++;
        }
        System.out.println("El promedio del salario es: "+totalsalary/cont);
    }

    public void CreateTxtPerson2() throws IOException{
        procces.writeFileTxt("Organice Person 2", procces.organiceText(procces.organicePerson2P()), "C:\\Users\\sala L310\\Documents\\Samuel");
    }


}