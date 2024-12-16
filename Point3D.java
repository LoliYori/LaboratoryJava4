class Point3D {
    // Поля
    private double x, y, z;

    // Конструктор
    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    // Свойство
    @Override
    public String toString() {
        return String.format("Point3D[x=%.2f, y=%.2f, z=%.2f]", x, y, z);
    }
}
