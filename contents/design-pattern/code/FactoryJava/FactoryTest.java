public class FactoryTest {

    public static void main(String[] args) {
        Product pencil = ProductFactory.getProduct("Pencil");
        pencil.sell(); // sell Pencil !!!

        Product note = ProductFactory.getProduct("Note");
        note.sell(); // sell Note !!!
    }
}

interface Product {
    public void sell();
}

class Pencil implements Product {

    @Override
    public void sell() {
        System.out.println("sell Pencil !!!");
    }
}

class Note implements Product {

    @Override
    public void sell() {
        System.out.println("sell Note !!!");
    }
}

class ProductFactory {
    public static Product getProduct(String className) {
        Product p = null;
        switch (className) {
            case "Pencil": p = new Pencil(); break;
            case "Note": p = new Note(); break;
        }
        return p;
    }
}
