package equality;

import org.junit.jupiter.api.Test;

class EqualityAndIdentityTest {

    private static final String A = "a";
    private static final String A1 = "a";

    @Test
    void testIdentity() {
        String a = "a";
        String a1 = "a";

        System.out.println(a == a1);
        System.out.println(a.equals(a1));
    }

    @Test
    void testObjectIdentity() {
        String a = new String("a");
        String a1 = new String("a");

        System.out.println(a == a1);
        System.out.println(a.equals(a1));
    }

    @Test
    void testConstantsIdentity() {
        String a = A;
        String a1 = A;

        System.out.println(a == a1);
        System.out.println(a.equals(a1));
    }

    @Test
    void testOtherConstantsIdentity() {
        String a = A;
        String a1 = A1;

        System.out.println(a == a1);
        System.out.println(a.equals(a1));
    }


    @Test
    void testIntern() {
        String a = "a";
        String newObjectA = new String("a");
        String refA = newObjectA.intern();

        System.out.println(a == newObjectA);
        System.out.println(a == refA);
        System.out.println(refA == newObjectA);
    }
}