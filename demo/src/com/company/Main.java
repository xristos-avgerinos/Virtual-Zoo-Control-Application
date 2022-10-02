package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class Main {
    //Δημιουργια στατικης μεθοδου(συναρτησης) για τον χειρισμο εξαιρεσεων σε  ακεραιες τιμες ως εισοδο
    static int intInput() {
        Scanner input = new Scanner(System.in);
        try {
            int next = input.nextInt();
            return next;
        }
        catch (InputMismatchException e) {
            return 0;
        }
    }
    //Δημιουργια στατικης μεθοδου(συναρτησης) για τον χειρισμο εξαιρεσεων σε  double  τιμες ως εισοδο
    static double doubleInput() {
        Scanner input = new Scanner(System.in);
        try {
            double next = input.nextDouble();
            return next;
        }
        catch (InputMismatchException e) {
            return 0;
        }
    }
    //Δημιουργια στατικης μεθοδου(συναρτησης) με ορισμα την λιστα με τα ζωα ωστε να κανει αναζητηση του ζωου που εχει
    //εναν συγκεκριμενο κωδικο(τον οποιο δινει ο χρηστης) και να το επιστρεφει(το συγκεκριμενο ζωο/αντικειμενο)
    static  Animal search(List<Animal> AnimalList) {
        // αρχικοποιηση την λογικης μεταβλητης found σε false η οποια μας βοηθαει μετα την αναζητηση να γνωριζουμε αν βρεθηκε
        // το ζωο με το συγκεκριμενο ονομα.Αν δεν βρεθηκε ζηταμε απο τον χρησητη να δωσει νεο ονομα μεχρι να βρεθει καποιο ζωο.
        boolean found = false;
        do {
            Scanner input = new Scanner(System.in);
            //ο χρηστης δινει τον κωδικο προς αναζητηση
            String searchCode = input.next();
            for (Animal a : AnimalList) {
                if (a.getCode().equalsIgnoreCase(searchCode)) {
                    //found = true;
                    return a; //αν το βρει σταματαει την εκτελεση του προγραμματος και το επιστρεφει
                }
            }
            //στην περιπτωση που δεν βρει ζωο με αυτον τον κωδικο εμφανιζει καταλληλο μηνυμα και ζηταει απο το χρηστη νεο κωδικο
            System.out.println("Το ζώο που αναζητάτε δεν υπάρχει.Δωστε νεο κωδικό.");
        }while (!found);

        return null;//δεν θα επιστρεψει ποτε την τιμη null η συναρτηση
    }
    //Δημιουργια λογικης στατικης μεθοδου(συναρτησης)  η οποια επιστρεφει true αν ο χρηστης δωσει την τιμη "ΝΑΙ" ως εισοδο
    //αλλιως επιστρεφει false  αν ο χρηστης δωσει την τιμη "ΟΧΙ" η αν δωσει μη εγκυρη τιμη
    static boolean answerEquals(){
        Scanner input = new Scanner(System.in);
        String answer= input.next();
        if (answer.equalsIgnoreCase("ΝΑΙ")) {
            return true;
        }
        else if (answer.equalsIgnoreCase("ΟΧΙ")){
            System.out.println("ΟΚ");
        }
        else{
            System.out.println("Μη έγκυρη επιλογή");
        }
        return false;
    }

    public static void main(String[] args) {
       /*
       /Αρχικα φτιαχνω 10 αντικειμενα (ζωα) , στη συνεχεια τα περναω σε μια λιστα και μετα  περναω σε ενα αρχειο ολη την λιστα...υστερα βαζω ολον
       //αυτο το κωδικα σε σχολια ωστε το πρωτο πραγμα που να κανω στην main να ειναι φορτωση σε μια αλλη λιστα το αρχειο που ειχα αποθηκευσει που εχει τον καταλογο ζωων

        //περναμε τις ιδιοτητες του καθε ζωου μεσω του constructor
        Animal a1 = new Animal("KH123", "Σκύλος", "Θηλαστικό", 27, 16);
        Animal a2 = new Animal("ΜΜ365", "Χελώνα", "Ερπετό", 5, 100);
        Animal a3 = new Animal("NL290", "Γάτα", "Θηλαστικό", 4, 16);
        Animal a4 = new Animal("GH235", "Σαύρα", "Ερπετό", 3, 10);
        Animal a5 = new Animal("SM009", "Κοράκι", "Πτηνό", 1, 13);
        Animal a6 = new Animal("AS234", "Γαύρος", "Ψάρι", 0.27, 5);
        Animal a7 = new Animal("SG528", "Bάτραχος", "Αμφίβιο", 0.33, 10);
        Animal a8 = new Animal("FK903", "Δελφίνι", "Θηλαστικό", 30, 45);
        Animal a9 = new Animal("CK865", "Τσιπούρα", "Ψάρι", 6, 12);
        Animal a10 = new Animal("VL043", "Παπαγάλος", "Πτηνό", 2.5, 60);

        //δημιουργια λιστας στην οποια προσθετουμε ολα τα ζωα
        List<Animal> AnimalList = new ArrayList<>();
        AnimalList.add(a1);
        AnimalList.add(a2);
        AnimalList.add(a3);
        AnimalList.add(a4);
        AnimalList.add(a5);
        AnimalList.add(a6);
        AnimalList.add(a7);
        AnimalList.add(a8);
        AnimalList.add(a9);
        AnimalList.add(a10);

        //σώζουμε την λιστα με τα ζωα σε ενα αρχειο(file.txt)
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("file.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(AnimalList);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("list saved!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        List<Animal> AnimalList = new ArrayList<>();
        //περναμε στην λιστα AnimalList τη λιστα με τα ζωα που εχουμε αποθηκευσει σε αρχειο στο κωδικα με τα σχολια παραπανω
        try {
            FileInputStream fileInputStream = new FileInputStream("file.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            AnimalList = (ArrayList) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int choice ;
        Scanner input = new Scanner(System.in);
        //χρησιμοποιουμε βροχο επαναληψης do-while ωστε να εμφανιζεται επαναλαμβομενα το μενου επιλογων
        // στο χρηστη μεχρι εκεινος να δωσει την τιμη 7
         do {
             // Εμφάνιση του μενου επιλογων
             System.out.println();
             System.out.println("Παρακαλώ επιλέξτε απο το παρακάτω menu επιλογών(1/2/3/4/5/6/7)");
             System.out.println("-----------------------------------------------");
             System.out.println("1.   Προβολή όλων των διαθέσιμων ζώων του ζωολογικού κήπου");
             System.out.println("2.   Προσθήκη νέου ζώου");
             System.out.println("3.   Αναζήτηση ζώου βάσει ονόματος");
             System.out.println("4.   Αναζήτηση ζώου βάσει κωδικού");
             System.out.println("5.   Επεξεργασία ζώου βάσει κωδικού");
             System.out.println("6.   Διαγραφή ζώου βάσει κωδικού");
             System.out.println("7.   Έξοδος από την εφαρμογή");

             //εκχωρουμε στην μεταβλητη choice την επιλογη του χρηστη μεσω της συναρτηση INPUT που εχουμε δημιουργησει για εισαγωγη στοιχειων
             choice = intInput();

             switch (choice) {
                 case 1:
                     //αν ο χρηστης επιλεξει την πρωτη επιλογη εμφανιζουμε τα διαθέσιμα ζώα του ζωολογικού κήπου
                     System.out.println("Tα διαθέσιμα ζώα του ζωολογικού κήπου ειναι:");
                     System.out.println();
                     for (Animal a : AnimalList) {
                         System.out.println(a.getName() + " με κωδικό:" + a.getCode() + ", ομοταξία:"
                                 + a.getHomogeneity() + ", μέσο βάρος:" + a.getWeight() + " και μέση μέγιστη ηλικία:" + a.getAge());
                     }
                     break;
                 case 2:
                     //αν ο χρηστης επιλεξει την δευτερη επιλογη(δηλαδη την προσθηκη νεου ζωου) του ζηταμε να δωσει τιμες για τις ιδιοτητες του νεου ζωου

                     System.out.println("Εισάγετε κωδικό ζωου");
                     String inCode = input.next();
                     System.out.println("Εισάγετε όνομα ζωου");
                     String inName = input.next();
                     System.out.println("Εισάγετε ομοταξία ζωου");
                     String inHomogeneity = input.next();
                     System.out.println("Εισάγετε μέσο βάρος ζωου(σε kg) στο εύρος 0,1-100000");
                     double inWeight;
                     do {
                         inWeight = doubleInput();//αν ο χρηστης δεν δωσει double τιμη ως βαρος τοτε η μεταβλητη inWeight εχει την τιμη 0
                         //αν το βαρος που δινει ο χρηστης  δεν ειναι στο ευρος 0,1-1000000 η ειναι 0 τοτε ενημερωνουμε το χρηστη και του ζηταμε νεο βαρος
                         if ((inWeight==0)||(inWeight<0.1)||(inWeight>1000000)){
                         System.out.println("Μη εγκυρο βάρος.Δώστε ενα έγκυρο βάρος στο ευρος 0,1-1000000.");
                         }
                     }while((inWeight==0)||(inWeight<0.1)||(inWeight>1000000));

                     System.out.println("Εισάγετε μέση μέγιστη ηλικία ζωου στο ευρος 1-400");
                     int inAge;
                     do {
                         inAge = intInput();//αν ο χρηστης δεν δωσει ακεραιο αριθμο ως ηλικια τοτε η μεταβλητη inAge εχει την τιμη 0
                         //αν η ηλικία που δινει ο χρηστης  δεν ειναι στο ευρος 1-400 η ειναι 0 τοτε ενημερωνουμε το χρηστη και του ζηταμε νεα ηλικια
                         if ((inAge==0)||(inAge<1)||(inAge>400)){
                             System.out.println("Μη εγκυρη ηλικια.Δώστε μια έγκυρη ηλικια στο εύρος 1-400.");
                         }
                     }while((inAge==0)||(inAge<1)||(inAge>400)); //μπορουσα και να μην βαλω την συνθηκη (inAge==0) στο
                     // while και στο if απο πανω καθως καλυπτεται απο την συνθηκη (inAge<1).Την εβαλα συμβολικα

                     //περναμε τις ιδιοτητες του νεου ζωου μεσω του constructor
                     Animal a_new = new Animal(inCode, inName, inHomogeneity, inWeight, inAge);
                     //προσθετουμε το νεο ζωο στην λιστα με τα ζωα
                     AnimalList.add(a_new);
                     System.out.println("το ζωο προστεθηκε στο καταλογο ζωων");
                     break;
                 case 3:
                     //αναζητηση ζωου βαση ονομστος
                     System.out.println("Εισάγετε το όνομα του ζώου που θέλετε να αναζητήσετε" +
                             "(ΠΡΟΣΟΧΗ:εισάγετε το ονομα οπως το βλέπετε στο κατάλογο ζώων και κυρίως προσοχή στους τόνους)");
                     // αρχικοποιηση την λογικης μεταβλητης found σε false η οποια μας βοηθαει μετα την αναζητηση να γνωριζουμε αν βρεθηκε
                     // το ζωο με το συγκεκριμενο ονομα.Αν δεν βρεθηκε ζηταμε απο τον χρησητη να δωσει νεο ονομα μεχρι να βρεθει καποιο ζωο.
                     boolean found = false;
                     do {
                         //ο χρηστης δινει το αναζητουμενο ονομα
                         String searchName = input.next();
                         for (Animal a : AnimalList) {
                             if (a.getName().equalsIgnoreCase(searchName)) {
                                 System.out.println("Το ζώο που αναζητάτε με ονομα:" + a.getName() + " εχει κωδικό:" + a.getCode()
                                         + ", ομοταξία:" + a.getHomogeneity() + ", μέσο βάρος:" + a.getWeight() + " και μέση μέγιστη ηλικία:" + a.getAge());
                                 found = true;
                                 break;//αν βρεθει το ζωο βγαινουμε εκτος βροχου
                             }
                         }
                         //αν το ζωο με το συγκεκριμενο ονομα δεν βρεθηκε εμφανιζουμε καταλληλο μηνυμα και ζηταμε νεο ονομα
                         if (!found) {
                             System.out.println("Το ζώο που αναζητάτε δεν υπάρχει.Δωστε αλλο ονομα προς αναζητηση");
                         }
                     }while (!found);
                     break;
                 case 4:
                     //αναζητηση ζωου βαση κωδικου
                     System.out.println("Εισάγετε τον κωδικό του ζώου που θέλετε να αναζητήσετε" +
                             "(ΠΡΟΣΟΧΗ:εισάγετε τον κωδικό οπως το βλέπετε στο κατάλογο ζώων)");
                     Animal a = search(AnimalList);//καλουμε την συναρτηση search η οποια βρισκει το ζωο με τον συγκεκριμενο κωδικο και το περναμε στο a
                     //Εμφανιζουμε τις ιδιοτητες του ζωου με το συγκεκριμενο κωδικο
                         System.out.println("Το ζώο που αναζητάτε με κωδικο:" + a.getCode() + " εχει όνομα:" + a.getName() + ", ομοταξία:"
                                 + a.getHomogeneity() + ", μέσο βάρος:" + a.getWeight() + " και μέση μέγιστη ηλικία:" + a.getAge());
                     break;
                 case 5:
                     //επεξεργασια ζωου βαση κωδικου
                     System.out.println("Εισάγετε τον κωδικό του ζώου που θέλετε να επεξεργαστείτε" +
                             "(ΠΡΟΣΟΧΗ:εισάγετε τον κωδικό οπως το βλέπετε στο κατάλογο ζώων)");
                     //αρχικα βρισκουμε το ζωο με τον συγκεκριμενο κωδικο μεσω την συναρτησης search και το περναμε στο aaa
                     Animal aaa = search(AnimalList);
                     //εμφανιζουμε τις ιδιοτητες του ζωου
                     System.out.println("Το ζώο που επιλέξατε για επεξεργασία εχει κωδικο:" + aaa.getCode() + ", όνομα:" + aaa.getName() + ", ομοταξία:"
                     + aaa.getHomogeneity() + ", μέσο βάρος:" + aaa.getWeight() + " και μέση μέγιστη ηλικία:" + aaa.getAge());
                     //ρωταμε τον χρηστη ποιες ιδιοτητες του ζωου θελει να επεξεργαστει μεσω της συναρτησης answerEquals και του δινουμε την επιλογη για επεξεργασια
                     System.out.println("θέλετε να επεξεργαστείτε τον κωδικό του;(ΝΑΙ/ΟΧΙ)");
                     if (answerEquals()) {
                         System.out.println("Δώστε νέο κωδικό");
                         String newCode = input.next();
                         aaa.setCode(newCode);
                     }

                     System.out.println("θέλετε να επεξεργαστείτε το όνομα του;(ΝΑΙ/ΟΧΙ)");
                     if (answerEquals()) {
                         System.out.println("Δώστε νέο όνομα");
                         String newName = input.next();
                         aaa.setName(newName);
                     }

                     System.out.println("θέλετε να επεξεργαστείτε την ομοταξία του;(ΝΑΙ/ΟΧΙ)");
                     if (answerEquals()) {
                         System.out.println("Δώστε νέα ομοταξία");
                         String newHomogeneity = input.next();
                         aaa.setHomogeneity(newHomogeneity);
                     }

                     System.out.println("θέλετε να επεξεργαστείτε το βάρος του;(ΝΑΙ/ΟΧΙ)");
                     if (answerEquals()) {
                         System.out.println("Δώστε νέο  βάρος στο ευρος 0,1-1000000");
                         double newWeight;
                         do {
                             newWeight = doubleInput();
                             if ((newWeight==0)||(newWeight<0.1)||(newWeight>1000000)){
                                 System.out.println("Μη εγκυρο βάρος.Δώστε ενα έγκυρο βάρος στο ευρος 0,1-1000000.");
                             }
                         }while((newWeight==0)||(newWeight<0.1)||(newWeight>1000000));
                         aaa.setWeight(newWeight);
                     }

                     System.out.println("θέλετε να επεξεργαστείτε τη μέση μέγιστη ηλικία του;(ΝΑΙ/ΟΧΙ)");
                     if (answerEquals()) {
                         System.out.println("Δώστε νέα ηλικία στο ευρος 1-400");
                         int newAge;
                         do {
                             newAge = intInput();
                             if ((newAge==0)||(newAge<1)||(newAge>400)){
                                 System.out.println("Μη εγκυρη ηλικια.Δώστε μια έγκυρη ηλικια στο εύρος 1-400.");
                             }
                         }while((newAge==0)||(newAge<1)||(newAge>400));
                         aaa.setAge(newAge);
                     }
                     System.out.println("Η επεξεργασία ολοκληρώθηκε με επιτυχία");

                     break;
                 case 6:
                     //διαγραφη ζωου(βαση κωδικου) απο τον καταλογο ζωων
                     System.out.println("Εισάγετε τον κωδικό του ζώου που θέλετε να διαγράψετε" +
                             "(ΠΡΟΣΟΧΗ:εισάγετε τον κωδικό οπως το βλέπετε στο κατάλογο ζώων)");
                     //αρχικα βρισκουμε το ζωο με τον συγκεκριμενο κωδικο μεσω την συναρτησης search και το περναμε στο aa
                     Animal aa = search(AnimalList);

                     //αφου βρουμε το ζωο με το συγκεκριμενο κωδικο τοτε αφαιρουμε το ζωο απο την λιστα
                     AnimalList.remove(aa);
                     System.out.println("το ζώο με κωδικό:" + aa.getCode() + " διαγράφηκε απο τον κατάλογο ζώων");
                     break;
                 case 7:
                     //εξοδος
                     System.out.println("Αντίο");
                     break;
                 default:
                     //αν ο χρηστης δωσει μη εγκυρη επιλογη εμφανιζουμε καταλληλο μηνυμα
                     System.out.println("Μη εγκυρη επιλογη.");
             }
             //αν ο χρηστης εχει επιλεξει επεξεργασια,διαγραφη η προσθηκη νεου ζωου τοτε ενημερωνουμε το αρχειο με την ανανεομενη λιστα
             if ((choice == 2) || (choice == 5) || (choice == 6)) {
                 try {
                     FileOutputStream fileOutputStream = new FileOutputStream("file.txt");
                     ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                     objectOutputStream.writeObject(AnimalList);
                     objectOutputStream.close();
                     fileOutputStream.close();
                 } catch (FileNotFoundException e) {
                     e.printStackTrace();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
             }while (choice != 7) ; //αν ο χρηστης επιλεξει εξοδο απο το προγραμμα βγαινουμε απο τον  βροχο επαναληψης
         
         }
}

