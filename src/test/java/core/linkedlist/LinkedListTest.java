package core.linkedlist;


import org.junit.Assert;
import org.junit.Test;

import core.linkedlist.*;


public class LinkedListTest {

    @Test
    public void test(){

        LinkedList<Integer> ll = new LinkedList<>();
        Assert.assertEquals(ll.size(), 0);
        Assert.assertEquals(ll.peek(), null);
        Assert.assertEquals(ll.remove(5), null);

        ll.add(1);
        ll.add(3);
        ll.add(5);
        ll.add(7);
        Assert.assertEquals(ll.size(), 4);
        Assert.assertEquals(ll.peek().data, 7);
        Assert.assertEquals(ll.remove(1).data, 1);
        Assert.assertEquals(ll.remove(7).data, 7);

    }
}
