package base.suppler.lazyExamples;

import java.util.function.Supplier;

public class LazyInitializationExample {
    public static void main(String[] args) {
        Supplier<ExpensiveObject> lazyObject = () -> {
            System.out.println("Создание нового объекта");
            return new ExpensiveObject();
        };

        System.out.println("Объект еще не создан");

        //Объект создается только при первом обращении к методу get()
        ExpensiveObject obj = lazyObject.get();
        obj.doSomething();

        //Если мы обратимся еще раз к методу get(), то объект будет создан повторно
        ExpensiveObject obj2 = lazyObject.get();
    }

    static class ExpensiveObject {
        public ExpensiveObject() {
            //Предположим, что создание этого объекта очень затратно по ресурсам.
            System.out.println("Expensive object created");
        }

        public void doSomething() {
            System.out.println("Expensive object is doing something");
        }
    }
}
