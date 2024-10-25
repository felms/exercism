class Record:
    def __init__(self, record_id, parent_id):
        self.record_id = record_id
        self.parent_id = parent_id


class Node:
    def __init__(self, node_id):
        self.node_id = node_id
        self.children = []


def BuildTree(records):
    if not records:
        return None

    records.sort(key=lambda x: x.record_id)

    if records[0].record_id != 0:
        raise ValueError("Record id is invalid or out of order.")
    if records[0].parent_id != 0:
        raise ValueError("Node parent_id should be smaller than it's record_id.")
    if records[-1].record_id != len(records) - 1:
        raise ValueError("Record id is invalid or out of order.")

    trees = []

    for record in records:
        if record.record_id < record.parent_id:
            raise ValueError("Node parent_id should be smaller than it's record_id.")
        if record.record_id == record.parent_id and record.record_id != 0:
            raise ValueError('Only root should have equal record and parent id.')
        trees.append(Node(record.record_id))

    for parent in trees:
        children_ids = [r.record_id for r in records if r.parent_id == parent.node_id]
        parent.children.extend([node for node in trees if node.node_id != 0 and node.node_id in children_ids])

    return trees[0]
