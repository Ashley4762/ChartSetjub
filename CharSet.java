/**ADT ที่เก็บ character แบบไม่ซ้ำกันและเรียงลำดับ
 */
public class CharSet {
    private String s;

    // Rep Invariant (RI):
    //  - s must not contain duplicate characters.
    //  - characters in s must be sorted in ascending order.
    //
    // Abstraction Function (AF):
    //  - AF(s) = the set of characters in the string s.

    /**
     * Constructor เริ่มต้น สร้างเซตว่าง
     */
    public CharSet() {
        s = "";
        checkRep();
    }

    /**
     * ตรวจสอบว่า Rep Invariant เป็นจริงหรือไม่
     */
    private void checkRep() {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) >= s.charAt(i+1)) {
                throw new RuntimeException("Rep invariant violated!");
            }
        }
    }

    /**
     * เพิ่มตัวอักษรเข้าเซต
     * @param c ตัวอักษรที่ต้องการเพิ่ม
     */
    public void add(char c) {
        if (!this.contains(c)) {
            int i = 0 ;
            while (i < s.length() && s.charAt(i) < c) {
                i++;
            }
            s = s.substring(0, i) + c + s.substring(i);
        }
        checkRep();
    }

    /**
     * ลบตัวอักษรออกจากเซต
     * @param c ตัวอักษรที่ต้องการลบ
     */
    public void remove(char c) {
        int index = s.indexOf(c);
        if (index != -1) {
            s = s.substring(0, index) + s.substring(index + 1);
        }
        checkRep(); 
    }

    /**
     * ตรวจสอบว่ามีตัวอักษรนี้อยู่ในเซตหรือไม่
     * @param c ตัวอักษรที่ต้องการตรวจสอบ
     * @return true หากมี c อยู่ในเซต, false หากไม่มี
     */
    public boolean contains(char c) {
        return s.indexOf(c) != -1;
    }

    /**
     * คืนค่าขนาดของเซต
     * @return จำนวนสมาชิกในเซต
     */
    public int size() {
        return s.length();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (i < s.length() - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}