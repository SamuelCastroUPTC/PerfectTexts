package services;

import models.Person;
import models.Person2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
        String[] cont= line.split("\\\\");
        return cont;
    }

    public Person2 fillOutPerson2(String[] cont) throws NumberFormatException, IOException{
        Person2 person= new Person2();
        person.setCode(cont[0]);
        person.setLastname(cont[1]);
        person.setName(cont[2]);
        person.setGender(cont[3].charAt(0));
        person.setWeigth(stringtoDecimal(cont[4]));
        person.setSalary(stringtoDecimal(cont[5]));
        return person;
    }

    public String convertDecimalaHexadecimalInteger (String cont) throws IOException {
        ArrayList<Integer> decimal= new ArrayList<Integer>();
        for (char c : cont.toCharArray()) {
            decimal.add((int)c);
        }
        return changeDecimalHexadecimal(decimal);
    }

    public String changeDecimalHexadecimal(ArrayList<Integer> decimal){
        String hexadecimal1="";
        for (Integer integer : decimal) {
            hexadecimal1=hexadecimal1+Integer.toHexString(integer);
            System.out.println(hexadecimal1);
        }
        return hexadecimal1;
    }

    public void twoNumbers(){
        int a=194;
        int b=183;
        int c=a*256;
        c=c+b;
        System.out.println((byte)a);
        // String c=a+""+(b);
        // int d= Integer.parseInt(c);
        // System.out.println(d);
        // System.out.println((byte)d);
    }

    public void leerArchivo () throws IOException {
    File filePath = new File(".\\person2.txt");
    // Instance of the FileInputStream
    FileInputStream fileInputStream = new FileInputStream(filePath);

    // Create a byte array
    byte[] demoArray = new byte[(int) filePath.length()];

    // Read file content to byte array
    fileInputStream.read(demoArray);

    // Close the instance
    fileInputStream.close();

    // Print the above byte array
    System.out.println(Arrays.toString(demoArray));
    }

    public int stringtoDecimal(String word){
        int decimal= stringtoByte(word);
        return decimal;
    }

    public int stringtoByte(String word){
        byte[] arregloBytes=word.getBytes();
        return bytetoHexadecimal(arregloBytes);
    }

    public int bytetoHexadecimal(byte[] demoArray){
        StringBuilder sb= new StringBuilder();
        String hexadecimal="";
        for (byte b : demoArray) {
            hexadecimal=""+sb.append(String.format("%02X", b));
        }
        
        return hexadecimaltoDecimal(hexadecimal);
    }

    public int hexadecimaltoDecimal(String hexadecimal){
        int decimal= Integer.parseInt(hexadecimal,16);
        return decimal;
    }
}

