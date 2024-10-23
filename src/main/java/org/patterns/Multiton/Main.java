package org.patterns.Multiton;

public class Main {
    public static void main (String[] args){
        User peter = new User("Peter");
        User miles = new User("Miles");
        User harry = new User("Harry");

        String path = "Spiderman";

        peter.write(path, "Okay, Miles, I get it—you can turn invisible. But could you at least *pretend* not to sneak up on me?");

        miles.write(path, "Sorry, man! It’s just... your startled face is hilarious every time.");

        harry.write(path, "You should see it from *my* angle. He looks like a scared cat that just saw a cucumber.");

        peter.write(path, "Cucumbers don’t—wait, do I really look like that?");

        miles.write(path, "Yeah, except, you know... spandex.");




    }

}
