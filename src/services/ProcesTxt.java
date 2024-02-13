package services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ProcesTxt {
    
    public void CreateTxt(String name, String cont, String path){
    try {
            String ruta = path+"\\"+name+".txt";
            String contenido = cont;
            File file1 = new File(ruta);
            String newcont="";
            // Si el archivo no existe es creado
            if (!file1.exists()) {
                file1.createNewFile();
            }else{
                newcont=ReadTxt(ruta);
            }
            FileWriter fw = new FileWriter(file1);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(newcont+contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String ReadTxt(String ruta){
        String cont="";
        try (FileReader fr = new FileReader(ruta)) {
            BufferedReader br = new BufferedReader(fr);
            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null)
            cont=cont+linea;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return cont;
    }
}
