package services;

import models.Person;
import models.Person2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProcesTxt {

    public void writeFileTxt(String name, String newcont, String path){
        try {
            File file1=createFileTxt(path, name);
            String cont=existTxt(file1);
            FileWriter fw = new FileWriter(file1);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(cont+newcont);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String existTxt(File file1) throws IOException{
        String cont="";
        if (!file1.exists()) {
            createTxt(file1);
        }else{
            cont=readTxtFile(file1.getPath());
        }
        return cont;
    }
    
    public void createTxt(File file1) throws IOException{
        file1.createNewFile();
    }

    public File createFileTxt(String path, String name){
        String ruta = path+"\\"+name+".txt";
        File file1 = new File(ruta);
        return file1;
    }

    public String readTxtFile(String path){
        String cont="";
        try (FileReader fr = new FileReader(path)) {
            BufferedReader br = new BufferedReader(fr);
            cont=acumulateString(br);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return cont;
    }

    public String acumulateString(BufferedReader br) throws IOException{
        String cont="";
        String linea;
        while((linea=br.readLine())!=null){
            cont=cont+linea;
        }
        return cont;
    }

    public List<Person> organiceTxtPersons(String ruta){
        List<Person> people= readTxt(ruta);
        return people;
    }

    public List<Person> readTxt(String ruta){
        List<Person> people= new ArrayList<Person>();
        try (FileReader fr = new FileReader(ruta)) {
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){
                people.add(fillOutPerson(separateInformationPerson(linea)));
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return people;
    }

    public String[] separateInformationPerson (String line){
        String[] cont= line.split(",");
        return cont;
    }

    public Person fillOutPerson(String[] cont){
        Person person= new Person();
        person.setCode(cont[0]);
        person.setLastname(cont[1]);
        person.setName(cont[2]);
        person.setGender(cont[3].charAt(0));
        return person;
    }

    public String [] searchFile(String location){
        File carpeta = new File(location);
        String[] list = carpeta.list();
        list=verifyContFile(list);
        return list;
    }

    public String[] verifyContFile(String []list){
        if (list == null || list.length == 0) {
            list=new String[1];
        }
        return list;
    }

    public List<Person2> organiceTxtPerson2(String ruta){
        List<Person2> people= readTxt2(ruta);
        return people;
    }

    public List<Person2> readTxt2(String ruta){
        List<Person2> people= new ArrayList<Person2>();
        try (FileReader fr = new FileReader(ruta)) {
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){
                people.add(fillOutPerson2(separateInformationPerson2(linea)));
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return people;
    }

    public String[] separateInformationPerson2 (String line){
        String[] cont= line.split("\\");
        return cont;
    }

    public Person2 fillOutPerson2(String[] cont){
        Person2 person= new Person2();
        person.setCode(cont[0]);
        person.setLastname(cont[1]);
        person.setName(cont[2]);
        person.setGender(cont[3].charAt(0));
        person.setWeigth(Integer.valueOf(cont[4]));
        person.setSalary(Integer.valueOf(cont[5]));
        return person;
    }
}
