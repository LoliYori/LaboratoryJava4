import java.util.List;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListTransformer {
    // Метод для преобразования элементов списка
    public static <T, P> List<P> transformList(List<T> list, TransformFunction<T, P> function) {
        if (list == null || list.isEmpty()) {
            return new ArrayList<>(); 
        }

        List<P> result = new ArrayList<>();
        for (T item : list) {
            result.add(function.apply(item));
        }
        return result;
    }
    
    // Метод для фильтрации списка с помощью предиката
    public static <T> List<T> filterList(List<T> list, java.util.function.Predicate<T> predicate) {
        if (list == null || list.isEmpty()) {
            return new ArrayList<>();
        }

        return list.stream()
                   .filter(predicate)
                   .collect(Collectors.toList());
    }
}

