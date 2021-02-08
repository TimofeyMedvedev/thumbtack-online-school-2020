package net.thumbtack.school.boxes.v3;

import net.thumbtack.school.figures.v3.Figure;

public class ArrayBox<T extends Figure> {
    private T[] content;

    public ArrayBox(T[] content) {
        super();
        this.content = content;
    }

    public T[] getContent() {
        return content;
    }

    public void setContent(T[] content) {
        this.content = content;
    }

    public T getElement(int index) {
        return content[index];
    }

    public void setElement(T element, int index) {
        content[index] = element;
    }

    public boolean isSameSize(ArrayBox arrayBox) {
        return content.length == arrayBox.getContent().length;
    }
}
