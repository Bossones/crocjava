package tasktwo;

public class FindWayForHorse {

    private static void checkPosition(String pos) {
        if (pos == null)
            throw new NullPointerException();
        if (pos.charAt(0) > 'h' || pos.charAt(0) < 'a' || pos.charAt(1) < '1' || pos.charAt(1) > '8')
            throw new IllegalArgumentException("Wrong chess position: " + pos);
    }

    private static boolean moveable(String cur, String next) {
        int curX = cur.charAt(0);
        int curY = cur.charAt(1);
        int nextX = next.charAt(0);
        int nextY = next.charAt(1);
        return ( ( (curX - 2 == nextX) || (curX + 2 == nextX) ) && ( (curY + 1 == nextY) || (curY - 1 == nextY) ) ) ||
                ( ( (curY - 2 == nextY) || (curY + 2 == nextY) ) &&  ( (curX + 1 == nextX) || (curX - 1 == nextX) ) );
    }

    public static boolean findWay(String[] positions) throws IllegalMoveException {
        if (positions == null)
            throw new NullPointerException();
        String cur, next;
        for (int i = 0; i < positions.length - 1; i++) {
            cur = positions[i];
            checkPosition(cur);
            next = positions[i + 1];
            checkPosition(next);
            if (!moveable(cur, next)) {
                throw new IllegalMoveException("Wrong way: " + cur + "->" + next);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            System.out.println(findWay(new String[] {"g8", "e7", "c8"})); // true
            System.out.println(findWay(new String[] {"c3", "d5", "c7", "b5"})); // true
            //System.out.println(findWay(new String[] {"g8", "e7", "c7"})); // e7->c7
            System.out.println(findWay(new String[] {"c3", "d5", "c7", "c9"})); // Wrong c9
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
