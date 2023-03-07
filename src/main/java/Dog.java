public class Dog {
    private boolean isWaggingTail;

    public void giveTreat() {
        isWaggingTail = true;
    }

    public void giveBath() {
        isWaggingTail = false;
    }

    public static void bark(String greeting) {
        System.out.println(greeting + "!");
    }

    public static void main(String[] args) {
        Dog fido = new Dog();
        Dog snoopy = new Dog();

        fido.giveTreat();    //sets fido.isWaggingTail to true
        snoopy.giveTreat();  //sets snoopy.isWaggingTail to true
        fido.giveBath();     //sets fido.isWaggingTail to false

        bark("Woof"); //prints Woof!
        bark("Arf");  //prints Arf!
    }
}
