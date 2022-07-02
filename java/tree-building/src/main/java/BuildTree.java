import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class BuildTree {

    TreeNode buildTree(ArrayList<Record> records) throws InvalidRecordsException {
        records.sort(Comparator.comparing(Record::getRecordId));

        if (records.size() == 0) {
            return null;
        }

        if (records.get(records.size() - 1).getRecordId() != records.size() - 1
                || records.get(0).getRecordId() != 0) {
            throw new InvalidRecordsException("Invalid Records");
        }

        boolean invalidRecords = records.stream()
                .anyMatch(record -> record.getRecordId() == 0 && record.getParentId() != 0
                                    || record.getRecordId() < record.getParentId()
                                    || record.getRecordId() == record.getParentId() && record.getRecordId() != 0);
        if (invalidRecords) {
            throw new InvalidRecordsException("Invalid Records");
        }

        List<TreeNode> treeNodes = records.stream()
                .map(record -> new TreeNode(record.getRecordId()))
                .collect(Collectors.toList());

        treeNodes.forEach(parent -> {
            records.stream()
                    .filter(record -> record.getParentId() == parent.getNodeId())
                    .forEach(record -> {
                        treeNodes.stream()
                                .filter(node -> record.getRecordId() == node.getNodeId()
                                        && node.getNodeId() != 0)
                                .forEach(node -> parent.getChildren().add(node));
                    });
        });

        return treeNodes.get(0);
    }

}
