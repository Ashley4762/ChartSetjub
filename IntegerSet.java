import java.util.ArrayList;

public class IntegerSet {
    // ใช้ ArrayList เป็นตัวแทนข้อมูล
    private ArrayList<Integer> numbers;  // Rep

    /**
     * AF (Abstraction Function):
     *     numbers แทน "ชุดของจำนวนเต็ม" ที่เรียงจากน้อยไปมาก โดยไม่มีค่าซ้ำ
     *
     * RI (Representation Invariant):
     *     - ห้ามมี null
     *     - ห้ามมีตัวเลขซ้ำ
     *     - ต้องเรียงจากน้อยไปมาก
     */

    public IntegerSet() {
        numbers = new ArrayList<>();
        checkRep();
    }

    /**
     * เพิ่มเลขจำนวนเต็มลงในชุด (เรียงลำดับและไม่มีซ้ำ)
     */
    public void add(int x) {
        // ถ้ามีอยู่แล้ว ไม่ต้องเพิ่ม
        if (numbers.contains(x)) return;

        // หา index ที่ควรแทรกเพื่อให้เรียง
        int i = 0;
        while (i < numbers.size() && numbers.get(i) < x) {
            i++;
        }

        numbers.add(i, x);  // แทรกให้เรียง
        checkRep();
    }

    /**
     * แสดงข้อมูลในชุดเป็น String เช่น [10, 20, 50]
     */
    public String toString() {
        return numbers.toString();
    }

    /**
     * ตรวจสอบว่าโครงสร้างข้อมูลยังคงเป็นไปตาม RI หรือไม่
     */
    private void checkRep() {
        for (int i = 0; i < numbers.size(); i++) {
            Integer current = numbers.get(i);
            if (current == null)
                throw new RuntimeException("พบ null ในชุด");

            if (i > 0) {
                Integer prev = numbers.get(i - 1);
                if (current.equals(prev))
                    throw new RuntimeException("มีค่าซ้ำ: " + current);
                if (current < prev)
                    throw new RuntimeException("ค่าข้อมูลไม่เรียงจากน้อยไปมาก");
            }
        }
    }
}
