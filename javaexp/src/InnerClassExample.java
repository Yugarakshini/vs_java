class OuterClass {
    private int outerVariable = 10;
    // Static inner class
    static class StaticInnerClass {
        void display() {
            System.out.println("Static Inner Class");
        }
    }
    // Non-static inner class (Regular Inner Class)
    class InnerClass {
        void display() {
            System.out.println("Non-static Inner Class");
            System.out.println("Outer variable: " + outerVariable);
        }
    }
    // Method-local inner class
    void methodWithInnerClass() {
        class MethodLocalInnerClass {
            void display() {
                System.out.println("Method-local Inner Class");
            }
        }
        MethodLocalInnerClass methodLocalInner = new MethodLocalInnerClass();
        methodLocalInner.display();
    }
    // Anonymous inner class (using interface)
    interface Greeting {
        void greet();
    }
    void displayGreeting() {
        Greeting greeting = new Greeting() {
            @Override
            public void greet() {
                System.out.println("Hello, from Anonymous Inner Class!");
            }
        };
        greeting.greet();
    }
}

public class InnerClassExample {
    public static void main(String[] args) {
        // Using static inner class
        OuterClass.StaticInnerClass staticInner = new OuterClass.StaticInnerClass();
        staticInner.display();
        // Using non-static inner class
        OuterClass outerObj = new OuterClass();
        OuterClass.InnerClass inner = outerObj.new InnerClass();
        inner.display();
        // Using method-local inner class
        outerObj.methodWithInnerClass();
        // Using anonymous inner class
        outerObj.displayGreeting();
    }

    
}
