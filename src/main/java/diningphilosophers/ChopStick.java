package diningphilosophers;

public class ChopStick {
    // Le nombre total de baguettes
    private static int stickCount = 0;
    // Le numéro de chaque baguette
    private final int myNumber;
    // Est-ce que ma baguette est libre ?
    private boolean iAmFree = true;

    public ChopStick() {
        // Chaque baguette est numérotée 
        myNumber = ++stickCount;
    }

    // ...
    
    @Override
    public String toString() {
        return "Stick#" + myNumber;
    }
    
    synchronized void take() throws InterruptedException{
        while(iAmFree){
            iAmFree=false;
            wait();
        }
        assert (!iAmFree);
        notifyAll();
        System.out.println("J'utilise la baguette.");
    }
    
    synchronized void release() throws InterruptedException{
        while(!iAmFree){
            iAmFree=true;
            wait();
        }
        assert(iAmFree);
        notifyAll();
        System.out.println("La baguette est libre.");
    }
}
