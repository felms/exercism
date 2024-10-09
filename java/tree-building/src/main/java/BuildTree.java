import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class BuildTree {

    TreeNode buildTree(ArrayList<Record> records) throws InvalidRecordsException {

        if (records.isEmpty()) {
            return null;
        }

        records.sort(Comparator.comparing(Record::getRecordId));
        checkRecords(records);

        TreeNode root = new TreeNode(records.removeFirst().getRecordId());
        buildTheThree(root, records);

        return root;
    }

    private void buildTheThree(TreeNode root, List<Record> records) {
        root.getChildren().addAll(
                records.stream()
                        .filter(record -> record.getParentId() == root.getNodeId())
                        .map(record -> new TreeNode(record.getRecordId())).toList());

        for (TreeNode node: root.getChildren()) {
            buildTheThree(node, records);
        }
    }

    private void checkRecords(List<Record> records) throws InvalidRecordsException {

        if (records.getFirst().getRecordId() != 0
                || records.getFirst().getParentId() != 0
                || records.getLast().getRecordId() != records.size() - 1) {
            throw new InvalidRecordsException("Invalid Records");
        }

        boolean anyInvalid = records.stream()
                .anyMatch(record -> record.getRecordId() != 0 && (record.getRecordId() <= record.getParentId()));

        if (anyInvalid) {
            throw new InvalidRecordsException("Invalid Records");
        }
    }
}