package calculator;

/**
 * @author sugamagarwal
 */
public interface Operation<T> {

    T add(T x, T y);
    T subtract(T x, T y);
    T multiplly(T x, T y);
}
