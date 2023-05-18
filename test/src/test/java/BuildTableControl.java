public class BuildTableControl<T,C>{
    T t;
    C c;

    public T getT() {
        return t;
    }

    public C getC() {
        return c;
    }

    public BuildTableControl(T t, C c) {
        this.t = t;
        this.c = c;
    }

    public void build(){
        BuildTable.build((Integer) t,(String) c);
    }
}
