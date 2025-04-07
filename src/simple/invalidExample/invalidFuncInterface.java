package simple.invalidExample;

@FunctionalInterface
public interface invalidFuncInterface {
    int calculate(int x, int y);
    //String getName(); //Compilation Error
}
