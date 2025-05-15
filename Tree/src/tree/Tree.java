package tree;

class TNode {

    int data;
    TNode left, right;

    TNode(int x) {
        data = x;
        left = right = null;
    }

    TNode(int x, TNode ll, TNode rr) {
        data = x;
        left = ll;
        right = rr;
    }
}

public class Tree {

    TNode root;

    void taocayT() {
        TNode A = new TNode(7, new TNode(2), new TNode(6));
        TNode B = new TNode(5, null, new TNode(9));
        root = new TNode(2, A, B);
    }

    void duyet1(TNode T) {
        if (T != null) {
            System.out.print(" " + T.data);
            duyet1(T.left);
            duyet1(T.right);
        }
    }

    void duyetTienTu() {
        System.out.print("\nDuyet Tien Tu:");
        duyet1(root);
    }

    void duyet2(TNode T) {
        if (T != null) {
            duyet2(T.left);
            System.out.print(" " + T.data);
            duyet2(T.right);
        }
    }

    void duyetTrungTu() {
        System.out.print("\nDuyet Trung Tu:");
        duyet2(root);
    }

    void duyet3(TNode T) {
        if (T != null) {
            duyet3(T.left);
            duyet3(T.right);
            System.out.print(" " + T.data);
        }
    }

    void duyetHauTu() {
        System.out.print("\nDuyet Hau Tu:");
        duyet3(root);
    }

    int soNot(TNode T) {
        if (T == null) {
            return 0;
        } else {
            return 1 + soNot(T.left) + soNot(T.right);
        }
    }

    int sn() {
        return soNot(root);
    }

    int tong(TNode T) {
        if (T == null) {
            return 0;
        } else {
            return T.data + tong(T.left) + tong(T.right);
        }
    }

    int tongNot() {
        return tong(root);
    }

    int la(TNode T) {
        if (T == null) {
            return 0;
        } else if (T.left == null && T.right == null) {
            return 1;
        } else {
            return la(T.left) + la(T.right);
        }
    }

    int soLa() {
        return la(root);
    }

    int notTrong(TNode T) {
        if (T == null || T.left == null && T.right == null) {
            return 0;
        } else {
            return 1 + notTrong(T.left) + notTrong(T.right);
        }
    }

    int soNotTrong() {
        return notTrong(root);
    }

    int tongNotTrong(TNode T) {
        if (T == null || T.left == null && T.right == null) {
            return 0;
        } else {
            return T.data + tongNotTrong(T.left) + tongNotTrong(T.right);
        }
    }

    int tongNotTrong() {
        return tongNotTrong(root);
    }

    int tongle(TNode T) {
        if (T == null) {
            return 0;
        } else if (T.data % 2 != 0) {
            return T.data + tongle(T.left) + tongle(T.right);
        } else {
            return tongle(T.left) + tongle(T.right);
        }
    }

    int tongle() {
        return tongle(root);
    }

    int motCon(TNode T) {
        if (T == null || T.left == null && T.right == null) {
            return 0;
        } else if (T.left != null && T.right != null) {
            return motCon(T.left) + motCon(T.right);
        } else {
            return 1 + motCon(T.left) + motCon(T.right);
        }
    }

    int motCon() {
        return motCon(root);
    }

    int cao(TNode T) {
        if (T == null) {
            return 0;
        } else {
            return 1 + Math.max(cao(T.left), cao(T.right));
        }
    }

    int cao() {
        return cao(root);
    }

    boolean timx(TNode T, int x) {
        if (T == null) {
            return false;
        } else if (T.data == x) {
            return true;
        } else if (timx(T.left, x) == false) {
            return timx(T.right, x);
        } else {
            return true;
        }
    }

    boolean timx(int x) {
        return timx(root, x);
    }

    int max(TNode T) {
        if (T == null) {
            return 0;
        } else {
            int max1 = max(T.left);
            int max2 = max(T.right);
            return Math.max(T.data, Math.max(max1, max2));
        }
    }

    int max() {
        return max(root);
    }

    public static void main(String[] args) {
        Tree T = new Tree();
        T.taocayT();
        T.duyetTienTu();
        T.duyetTrungTu();
        T.duyetHauTu();
        System.out.println("So not: " + T.sn());
        System.out.println("Tong gia tri cac not: " + T.tongNot());
        System.out.println("So not la: " + T.soLa());
        System.out.println("So not trong: " + T.soNotTrong());
        System.out.println("Tong so not trong: " + T.tongNotTrong());
        System.out.println("Tong cac not le: " + T.tongle());
        System.out.println("So not co 1 con: " + T.motCon());
        System.out.println("Chieu cao cua cay: " + T.cao());
        if (T.timx(5)) {
            System.out.println("Gia tri can tim co trong cay!");
        } else {
            System.out.println("Gia tri can tim khoong co trong cay!");
        }
        System.out.println("Gia tri lon nhat co trong cay: " + T.max());
    }

}
