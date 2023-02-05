public class Cat {
    private boolean isPurring;

    public void brush() {
        isPurring = true;
    }

    public static void main(String[] args) {
        Cat fluffy = new Cat();
        Cat whiskers = new Cat();
        fluffy.brush();
        System.out.println("fluffy purring = " + fluffy.isPurring);
        System.out.println("whiskers purring = " + whiskers.isPurring);
    }
}
