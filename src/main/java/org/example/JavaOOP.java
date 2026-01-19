package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

class O implements Serializable {
    String name;
    int id;

    public O(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

public class JavaOOP {

    static void serializeObj(O[] os)throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("data.ser")));
        oos.writeObject(os);
    }

    static O[] deserializeObj() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get("data.ser")));
       return (O[]) ois.readObject();
    }
    public static void main(String[] args) {

        try{
            O[] obs = deserializeObj();
            for(O ob : obs){
                System.out.println(ob.name);
                System.out.println(ob.id);
            }
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
