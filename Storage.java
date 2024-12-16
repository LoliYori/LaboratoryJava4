public class Storage<T> {
    // Поле
    private final T item;

    // Конструктор
    public Storage(T item) {
        this.item = item;
    }

    // Метод для получения объекта
    public T getItem(T alternative, T specificValue, T specificAlternative) {
        if (item == null) {
            return alternative;
        }
        if (item.equals(specificValue)) {
            return specificAlternative;
        }
        return item;
    }

    // Свойство
    @Override
    public String toString() {
        return "Хранилище содержит: " + (item == null ? "null" : item.toString());
    }
}
