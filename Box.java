// Обобщённая коробка
class Box<T> {
    // Поля
    private T item; 

    // Методы
    
    // Проверки заполненности коробки
    public boolean isEmpty() {
        return item == null;
    }

    // Получения объекта из коробки
    public T getItem() {
        T temp = item;
        item = null;
        return temp;
    }

    // Помещения объекта в коробку
    public void setItem(T item) throws BoxFullException {
        if (!isEmpty()) {
            throw new BoxFullException("Коробка уже содержит объект! Сначала извлеките текущий.");
        }
        this.item = item;
    }
    
    // Свойство

    @Override
    public String toString() {
        return isEmpty() ? "Коробка пуста" : "Коробка содержит: " + item.toString();
    }
}
