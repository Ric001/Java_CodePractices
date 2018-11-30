import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
public class index {
       public static void main(String[] args)throws Exception {
              Game game = new Game();
              game.write();
              game.read();
              System.out.println("Juego Terminado");
              System.out.println("Todos felices");
              Writer writer = new Writer();
              Read reader = new Read();
              
       
       }
}


class Read {
       public void read() throws IOException {
              FileReader reader = new FileReader("ejemplo.txt");

              int character = reader.read();

              while (character != -1) {
                     System.out.print((char)character);
                     character = reader.read();
              }
              reader.close();
       }
}

class Writer {
       public void write() throws IOException {
              FileWriter writer = new FileWriter("ejemplo.txt");
              String string = "Esto es una cadena de txt";

              for (int i = 0; i < string.length(); i++) {
                     writer.write(string.charAt(i));
              }

              writer.close();      
       }
}

class Game {

       public void write() throws Exception {
              FileOutputStream fileStream = new FileOutputStream("MyGame.ser");
              ObjectOutputStream os = new ObjectOutputStream(fileStream);
              os.writeObject(new Character("Deltiluz", "Chicken", "Space Unicorn"));
              os.close();
       }

       public void read() throws Exception{
              FileInputStream fileStream = new FileInputStream("MyGame.ser");
              ObjectInputStream os = new ObjectInputStream(fileStream);
              Character charac = (Character) os.readObject();
              Armor armor = new Armor("Armor","Defense",200);
              os.close();
       }
       class Character {
              String name; 
              String weapon;
              String characterType;

              public Character(String name, String weapon, String characterType) {
                     this.name = name;
                     this.weapon = weapon;
                     this.characterType = characterType;
              }
              
       }

       class Armor {
              String name;
              String type;
              int resistence;
              
              public Armor(String name, String type, int resitence) {
                     this.name = name; 
                     this.type = type;
                     this.resistence = resitence;
                     
              }
       }
}