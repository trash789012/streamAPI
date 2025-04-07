package homework.Task4;

import java.util.function.Supplier;

public class Task4 {

    static class Config{
        private final String data;

        public Config(String data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Config{" +
                    "data='" + data + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {
        Supplier<Config> configSupplier = () -> {
          try {
              Thread.sleep(2000); //имитация загрузки конфигурации из файла
              return new Config("Конфиг загружен");
          } catch (InterruptedException e) {
              throw new RuntimeException(e);
          }
        };

        System.out.println("До вызова get()");
        System.out.println(configSupplier.get()); //загрузка происходит здесь
    }
}
