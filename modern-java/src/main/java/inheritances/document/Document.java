package inheritances.document;

abstract class Document {

    public abstract byte[] content();
    public final int length() {
        return this.content().length;
    }
}
