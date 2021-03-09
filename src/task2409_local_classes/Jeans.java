package task2409_local_classes;

public interface Jeans extends Item{
    @Override
    int getId();

    @Override
    double getPrice();

    @Override
    String getTM();

    int getLength();
    int getSize();
}
