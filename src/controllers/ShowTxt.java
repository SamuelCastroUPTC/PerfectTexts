package controllers;

import java.util.List;
import java.util.Scanner;

import models.Person;
import services.ProcesTxt;

public class ShowTxt{

    private ProcesTxt procces;
    private Scanner read;

    public ShowTxt(){
        procces= new ProcesTxt();
        read= new Scanner(System.in);
    }
    
    public void CreateTxt(){
        System.out.println("Digite la ubicacion del archivo");
        String path=read.nextLine();
        System.out.println("Digite el nombre del archivo");
        String name=read.nextLine();
        System.out.println("Digite el contenido del archivo");
        String cont=read.nextLine();
        procces.CreateTxt(name, cont, path);
        
    }

    public void showTxt(String path){        
        List people = procces.ReadTxt(path);
        for (Person person : people) {
            System.out.println(person.);
        }
    }

    public void SearchFiles(){
        System.out.println("Digite la ubicacion del archivo");
        String path=read.nextLine();
        String[] list=procces.searchFile(path);
        for(int i=0; i<list.length;i++){
            System.out.println(list[i]);
        }
    }
}