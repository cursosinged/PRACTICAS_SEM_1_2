
public class RecordValues {

    private Object key;
    private Object val_;
    private long offset;
    private int partition;

    public RecordValues(Object key, Object val_, long offset, int partition)
    {
        this.key=key;
        this.val_= val_;
        this.offset=offset;
        this.partition=partition;

    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getVal_() {
        return val_;
    }

    public void setVal_(Object val_) {
        this.val_ = val_;
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public int getPartition() {
        return partition;
    }

    public void setPartition(int partition) {
        this.partition = partition;
    }











}
