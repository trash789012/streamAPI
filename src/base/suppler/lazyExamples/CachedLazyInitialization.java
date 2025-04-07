package base.suppler.lazyExamples;

import java.util.function.Supplier;

public class CachedLazyInitialization {
    public static void main(String[] args) {
        //Ленивая инициализация с кэшированием
        Supplier<HeavyResource> cachedLazyObject = LazyInitializer.of(HeavyResource::new);

        System.out.println("Объект еще не создан");

        HeavyResource res1 = cachedLazyObject.get();
        HeavyResource res2 = cachedLazyObject.get();

        System.out.println("Один и тот же объект:? " + (res1 == res2));
    }

    static class HeavyResource {
        public HeavyResource() {
            System.out.println("Создание нового объекта");
        }
    }

    static class LazyInitializer<T> implements Supplier<T> {
        private final Supplier<T> initializer;
        private T cachedValue;

        private LazyInitializer(Supplier<T> supplier) {
            this.initializer = supplier;
        }

        public static <T> Supplier<T> of (Supplier<T> supplier) {
            return new LazyInitializer<>(supplier);
        }

        @Override
        public synchronized T get() {
            if (cachedValue == null) {
                cachedValue = initializer.get();
            }

            return cachedValue;
        }

    }

}
