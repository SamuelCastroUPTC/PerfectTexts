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

    public ArrayList<Person2> organicePerson2P () throws IOException {
    File filePath = new File(".\\person2.txt");
    FileInputStream fileInputStream = new FileInputStream(filePath);
    byte[] demoArray = new byte[(int) filePath.length()];
    fileInputStream.read(demoArray);
    fileInputStream.close();
    int cont=0;
    String name="";
    String lastname="";
    String code="";
    String gender="";
    String weigth="";
    String salary="";
    ArrayList<Person2> people= new ArrayList<Person2>();
    for (byte b : demoArray) {
        StringBuilder hexStringBuilder = new StringBuilder();

        if (b==13) {
            Person2 person= new Person2();
            person.setCode(hexadecimalToString(code));
            person.setLastname(hexadecimalToString(lastname));
            person.setName(hexadecimalToString(name));
            person.setGender(hexadecimalToChar(gender));
            person.setWeigth(hexadecimaltoDecimal(weigth));
            person.setSalary(hexadecimaltoDecimal(salary));
            people.add(person);
            cont=0;
            code="";
            lastname="";
            name="";
            gender="";
            weigth="";
            salary="";
        }else{
            if(b==10){

            }else{
                if(b==92){
                    cont=cont+1;
                }else{
                    if (cont==0) {
                        code=code+hexStringBuilder.append(String.format("%02X", b));
                    }
            
                    if (cont==1) {
                        name=name+hexStringBuilder.append(String.format("%02X", b));
                    }
            
                    if (cont==2) {
                        lastname=lastname+hexStringBuilder.append(String.format("%02X", b));
                    }
            
                    if (cont==3) {
                        gender=gender+hexStringBuilder.append(String.format("%02X", b));
                    }
            
                    if (cont==4) {
                        weigth=weigth+hexStringBuilder.append(String.format("%02X", b));
                    }
            
                    if (cont==5) {
                        salary=salary+hexStringBuilder.append(String.format("%02X", b));
                    }
                }
            }
        }
        }
        return people;
    }

    public String hexadecimalToString(String word){
        byte[] byteArray = new byte[word.length() / 2];
        for (int i = 0; i < byteArray.length; i++) {
            int index = i * 2;
            int intValue = Integer.parseInt(word.substring(index, index + 2), 16);
            byteArray[i] = (byte) intValue;
        }
        String convertedString = new String(byteArray);
        return convertedString;
    }

    public char hexadecimalToChar(String word){
        int intValue = Integer.parseInt(word, 16);
        char charValue = (char) intValue;
        return charValue;
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

    public String organiceText(ArrayList<Person2> people){
        String organice="";
        for (Person2 person : people) {
            organice=organice+plusSpace(""+person.getCode())+plusSpace(person.getLastname())
            +plusSpace(person.getName())+plusSpace(""+person.getGender())+
            plusSpace(""+person.getWeigth())+plusSpace(""+person.getSalary())+"\n";
        }
        return organice;
    }

    public String plusSpace(String word){
        String space=" ";
        int stop=20;
        for(int i=0; i<10; i++){
            if ((((word.substring(0, 1)).compareTo(i+""))==1)||word.length()==1) {
                    stop=10;
                    break;
            }
        }
        for(int i=word.length(); i<stop;i++){
            word=word+space;
        }
        
        return word;
    }

}

