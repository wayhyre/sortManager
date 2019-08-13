package com.sparta.doo.binaryTree;


import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeTest {

    private BinaryTree binaryTree = new BinaryTreeImpl(20);

    @Test
    public void testRoot() {
        Assert.assertEquals(20, binaryTree.getRootElement());
    }

    @Test
    public void testNumberOfElements() {
        Assert.assertEquals(1, binaryTree.getNumberOfElements());
    }

    @Test
    public void testAddElement() {
        binaryTree.addElement(15);
        Assert.assertTrue(binaryTree.findElement(15));

    }

    @Test
    public void testAddElements() {
        binaryTree.addElements(new int[]{1, 2, 3, 4, 5});
        Assert.assertTrue(binaryTree.findElement(5));
    }

    @Test
    public void testFindElement() {
        Assert.assertFalse(binaryTree.findElement(10));
        Assert.assertTrue(binaryTree.findElement(20));
    }

    @Test
    public void testGetLeftChild() throws ChildNotFoundException {
        binaryTree.addElements(new int[]{6, 5, 4, 3, 2, 1});
        Assert.assertEquals(4, binaryTree.getLeftChild(5));
    }

    @Test
    public void testGetRightChild() {
        binaryTree.addElements(new int[]{1, 2, 3, 4, 30});
        Assert.assertEquals(30, binaryTree.getRightChild(20));
    }

    @Test
    public void testSortedTreeAsc() {

    }

    @Test
    public void testSortedTreeDesc() {
    }

}
