import java.util.List;
import java.util.function.BinaryOperator;

public class ListReducer {
    // Метод сворачивания
    public static <T> T reduceList(List<T> list, T identity, BinaryOperator<T> accumulator) {
        if (list == null || list.isEmpty()) {
            return identity;
        }
        
        T result = identity;
        for (T item : list) {
            result = accumulator.apply(result, item);
        }
        return result;
    }
}
