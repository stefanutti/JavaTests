package org.tac.tests.clone;

import java.util.LinkedList;

public class B
{
    LinkedList<A> sequence = new LinkedList<A>();
    C c = null;
    int value = 0;

    /**
     * @param value
     */
    public B(int value) {
        super();
        this.value = value;
        c = new C(109);
        c.value = 100 + value;
    }

    @SuppressWarnings("unchecked")
	public B clone() throws CloneNotSupportedException {
        B bCloned = new B(this.value);
        bCloned.sequence = (LinkedList<A>)this.sequence.clone();
        return bCloned;
    }
}
