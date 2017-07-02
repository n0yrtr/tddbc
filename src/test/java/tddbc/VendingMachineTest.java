package tddbc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineTest {

    private VendingMachine _vm;
    @BeforeEach
    void setUp() {
        _vm = new VendingMachine();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void 十円玉50円玉100円玉500円玉1000円札を１つづつ投入できる() throws Exception {

        try {
            // Exercise
            _vm.insert(10);
            _vm.insert(50);
            _vm.insert(100);
            _vm.insert(500);
            _vm.insert(1000);
        } catch (Exception e) {
            fail(e);
        }

    }

    @Test
    public void 投入金額の総計を取得できる() throws Exception {
        // Exercise
        _vm.insert(10);
        _vm.insert(50);
        _vm.insert(100);
        _vm.insert(500);
        _vm.insert(1000);
        assertEquals(1660, _vm.getTotalAmount());
    }

    @Test
    public void 払い戻し操作を行うと投入金額の総計を釣り銭として出力する() throws Exception {
        // Exercise
        _vm.insert(10);
        _vm.insert(50);
        _vm.insert(100);
        _vm.insert(500);
        _vm.insert(1000);
        assertEquals(1660, _vm.refund());
    }

    @Test
    public void 払い戻し操作を2回行うと2回目は0円を出力する() throws Exception {
        // Exercise
        _vm.insert(10);
        _vm.insert(50);
        _vm.insert(100);
        _vm.insert(500);
        _vm.insert(1000);
        _vm.refund();
        assertEquals(0, _vm.refund());
    }

    @Test
    public void 想定外のものが投入された場合投入金額に加算せずそれをそのまま釣り銭としてユーザに出力する() throws Exception {
        // Exercise
        assertEquals(1, _vm.insert(1));
        assertEquals(5, _vm.insert(5));
        assertEquals(5000, _vm.insert(5000));
        assertEquals(10000, _vm.insert(10000));
    }

    @Test
    public void 初期状態で名前コーラが5本120円で格納されている() throws Exception {
        // Exercise
        StoredDrink cola = _vm.getStoredDrink("コーラ");
        assertNotNull(cola);
        assertEquals(120, cola.getPrice());
        assertEquals(5, cola.getStock());
    }

    @Test
    public void 初期状態で名前レモンウォーターが3本110円で格納されている() throws Exception {
        // Exercise
        StoredDrink lemon = _vm.getStoredDrink("レモンウォーター");
        assertNotNull(lemon);
        assertEquals(110, lemon.getPrice());
        assertEquals(3, lemon.getStock());
    }

    @Test
    public void 追加したサイダーの情報が格納されている() throws Exception {
        // Exercise
        _vm.storeDrink("サイダー",110, 5);
        StoredDrink cyder = _vm.getStoredDrink("サイダー");
        assertNotNull(cyder);
        assertEquals(110, cyder.getPrice());
        assertEquals(5, cyder.getStock());
    }

    @Test
    public void 初期状態でコーラが買えないことを確認できる() throws Exception {
        // Exercise
        assertFalse(_vm.isBuyable("コーラ"));
    }

    @Test
    public void 初期状態から120円を投入してコーラが買えることを確認できる() throws Exception {
        // Exercise
        _vm.insert(100);
        _vm.insert(10);
        _vm.insert(10);
        assertTrue(_vm.isBuyable("コーラ"));
    }


}
