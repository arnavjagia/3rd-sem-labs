/*
Design a class named By Twos that will implement the methods of the interface Series such that it generates a series of numbers, each two greater than the previous one. Also design a class which will include the main method for referencing the interface.

Get Next (returns the next number in series)
reset(to restart the series)
set Start (to set the value from which the series should start)
*/

interface Series {
    int getNext();
    void reset();
    void setStart(int start);
}

class ByTwos implements Series {
    private int start = 0;

    public int getNext() { return start += 2; }
    public void reset() { start = 0; }
    public void setStart(int start) { this.start = start; } 
}

public class q3ByTwosInterface {
    public static void main(String[] z) {
        Series If = new ByTwos();
        System.out.println(If.getNext() + "\n" + If.getNext());
        If.reset();
        System.out.println(If.getNext() + "\n" + If.getNext());
        If.setStart(5);
        System.out.println(If.getNext() + "\n" + If.getNext());
    }
}
