class Record {
    private final int recordId;
    private final int parentId;

    public Record(int recordId, int parentId) {
        this.recordId = recordId;
        this.parentId = parentId;
    }

    int getParentId() {
        return parentId;
    }

    int getRecordId() {
        return recordId;
    }
}
