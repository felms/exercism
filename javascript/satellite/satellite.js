let current;
let preOrder;
let inOrder;

export const treeFromTraversals = (preorder, inorder) => {

  current = 0;
  preOrder = [...preorder];
  inOrder = [...inorder];

  if (preOrder.length !== inOrder.length) {
    throw new Error('traversals must have the same length');
  }

  let setPre = new Set(preOrder);
  let setIn = new Set(inOrder);

  let eqSet = (a, b) => a.size === b.size && [...a].every(value => b.has(value));

  if (!eqSet(setPre, setIn)) {
    throw new Error('traversals must have the same elements');
  }

  if (setPre.size !== preOrder.length || setIn.size !== inOrder.length) {
    throw new Error('traversals must contain unique items');
  }

  let root = buildTree(0, inOrder.length - 1);

  return root;
};

const buildTree = (left, right) => {

  if (left > right || current > preOrder.length) {
    return {};
  }

  let root = preOrder[current];
  current++;

  let middle = inOrder.indexOf(root);

  let node = {};
  node.value = root;

  node.left = buildTree(left, middle - 1);
  node.right = buildTree(middle + 1, right);

  return node;
};
