package Others;

import java.util.*;
/*
 * 배열 삽입 삭제 알고리즘: 배열에서 특정 위치에 새로운 원소를 삽입하거나 특정 위치의 원소를 삭제하는 알고리즘.
 */ 
public class InsertDeleteInArray {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Input statement
        System.out.println("Enter the size of the array");
        int size = s.nextInt();
        int a[] = new int[size];
        int i;

        //초기 배열 설정
        for (i = 0; i < size; i++) {
            System.out.println("Enter the element");
            a[i] = s.nextInt();
        }

        //새 원소를 지정한 위치에 삽입
        System.out.println("Enter the index at which the element should be inserted");
        int insert_pos = s.nextInt();
        System.out.println("Enter the element to be inserted");
        int ins = s.nextInt();
        int size2 = size + 1;
        int b[] = new int[size2];
        for (i = 0; i < size2; i++) {
            if (i <= insert_pos) {
                b[i] = a[i];
            } else {
                b[i] = a[i - 1];
            }
        }
        b[insert_pos] = ins;
        for (i = 0; i < size2; i++) {
            System.out.println(b[i]);
        }

        //지정한 위치의 원소를 삭제
        System.out.println("Enter the index at which element is to be deleted");
        int del_pos = s.nextInt();
        for (i = del_pos; i < size2 - 1; i++) {
            b[i] = b[i + 1];
        }
        for (i = 0; i < size2 - 1; i++)
            System.out.println(b[i]);
    }
}
