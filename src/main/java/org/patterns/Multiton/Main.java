package org.patterns.Multiton;

public class Main {
    public static void main (String[] args){
        String path = "Spiderman";

        User peter = new User("Peter", path);
        User miles = new User("Miles", path);
        User harry = new User("Harry", path);


        peter.write("Okay, Miles, I get it—you can turn invisible. But could you at least *pretend* not to sneak up on me?");

        miles.write("Sorry, man! It’s just... your startled face is hilarious every time.");

        harry.write("You should see it from *my* angle. He looks like a scared cat that just saw a cucumber.");

        peter.write("Cucumbers don’t—wait, do I really look like that?");

        miles.write( "Yeah, except, you know... spandex.");

//        System.out.println(peter.getDoc());
//        System.out.println(miles.getDoc());
//        System.out.println(harry.getDoc());

        System.out.println(DefinitelyNotGoogleDriveMultiton.getDoc(path));






    }

}
