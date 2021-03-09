package task2408_local_classes;

/*
Please note just how Mouse differs from Dog
This class is familiar to you.
*/
public class Mouse implements Pet, CanSpeak {
    @Override
    public CanSpeak toCanSpeak(int i) {
        return this;
    }

    @Override
    public String speak() {
        return "The mouse squeaks.";
    }
}

