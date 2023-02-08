defmodule BinarySearchTree do
  @type bst_node :: %{data: any, left: bst_node | nil, right: bst_node | nil}

  @doc """
  Create a new Binary Search Tree with root's value as the given 'data'
  """
  @spec new(any) :: bst_node
  def new(data) do
    %{data: data, left: nil, right: nil}
  end

  @doc """
  Creates and inserts a node with its value as 'data' into the tree.
  """
  @spec insert(bst_node, any) :: bst_node
  def insert(tree, data) do
    cond do
      tree == nil -> new(data)
      data <= tree.data -> Map.put(tree, :left, insert(tree.left, data))
      data > tree.data -> Map.put(tree, :right, insert(tree.right, data))
    end
  end

  @doc """
  Traverses the Binary Search Tree in order and returns a list of each node's data.
  """
  @spec in_order(bst_node) :: [any]
  def in_order(nil), do: []

  def in_order(tree) do
    in_order(tree.left) ++ [tree.data] ++ in_order(tree.right)
  end
end
