package divideconquer;

/**
* 좌표 시스템의 포인트 세트 (최대 10000)
* ClosestPair 클래스는 가장 가까운 두 지점을 계산합니다.
*
* @ 저자 : 익명
* @ 저자 : Marisa Afuera
 */

public final class ClosestPair {


    /**
     * 포인트의 개수
     */
    int numberPoints = 0;
    /**
     * 입력할 데이터 최대 100000.
     */
    private Location[] array;
    /**
     * 최소점 좌표.
     */
    Location point1 = null;
    /**
     * 최소점 좌표.
     */
    Location point2 = null;
    /**
     * 최소점 길이.
     */
    private static double minNum = Double.MAX_VALUE;
    /**
     * 두번째 카운트
     */
    private static int secondCount = 0;

    /**
     * 생성자
     */
    ClosestPair(int points) {
        numberPoints = points;
        array = new Location[numberPoints];
    }

    /**
     * 위치 클래스는 점 좌표를 유지하는 보조 유형입니다.
     */

    public static class Location {

        double x = 0;
        double y = 0;

        /**
         * @param xpar (IN Parameter) x 좌표 <br/>
         * @param ypar (IN Parameter) y 좌표 <br/>

         */

        Location(final double xpar, final double ypar) { //x,y 좌표 저장
            this.x = xpar;
            this.y = ypar;
        }

    }

    public Location[] createLocation(int numberValues) {
        return new Location[numberValues]; //위치 

    }

    public Location buildLocation(double x, double y) {
        return new Location(x, y);
    }


    /**
     * xPartition 기능 : x 축 정렬.
     *
     * @param a (IN Parameter) 포인트 배열 <br/>
     * @param first (IN Parameter) 첫 번째 지점 <br/>
     * @param last (IN Parameter) 마지막 지점 <br/>
     * @return pivot 인덱스
     */

    public int xPartition(
            final Location[] a, final int first, final int last) {

        Location pivot = a[last]; // 피벗
        int pIndex = last;
        int i = first - 1;
        Location temp; // 위치 변환을 위해 값을 임시로 저장
        for (int j = first; j <= last - 1; j++) {
            if (a[j].x <= pivot.x) { // 피벗 이하
                i++;
                temp = a[i]; // array[i] <-> array[j] 교환
                a[i] = a[j];
                a[j] = temp;
            }
        }
        i++;
        temp = a[i]; // array[pivot] <-> array[i] 교환
        a[i] = a[pIndex];
        a[pIndex] = temp;
        return i; // 피벗 인덱스
    }

    /**
     * y 파티션 기능 : y 축 정렬.
     *
     * @param a (IN Parameter) 포인트 배열 <br/>
     * @param first (IN Parameter) 첫 번째 지점 <br/>
     * @param last (IN Parameter) 마지막 지점 <br/>
     * @return pivot index
     */

    public int yPartition(
            final Location[] a, final int first, final int last) {

        Location pivot = a[last]; // 피벗
        int pIndex = last;
        int i = first - 1;
        Location temp; // 위치 변환을 위해 값을 임시로 저장
        for (int j = first; j <= last - 1; j++) {
            if (a[j].y <= pivot.y) { // 피벗보다 작은 값
                i++;
                temp = a[i]; // array[i] <-> array[j] 교환
                a[i] = a[j];
                a[j] = temp;
            }
        }
        i++;
        temp = a[i]; // array[pivot] <-> array[i] 교환 
        a[i] = a[pIndex];
        a[pIndex] = temp;
        return i; // pivot index
    }

    /**
     * xQuickSort 함수 : // x 축 빠른 정렬.
     *
     * @param a (IN Parameter) 포인트 배열 <br/>
     * @param first (IN Parameter) 첫 번째 지점 <br/>
     * @param last (IN Parameter) 마지막 지점 <br/>
     */

    public void xQuickSort(
            final Location[] a, final int first, final int last) {

        if (first < last) {
            int q = xPartition(a, first, last); // pivot
            xQuickSort(a, first, q - 1); // Left
            xQuickSort(a, q + 1, last); // Right
        }
    }

    /**
     * yQuickSort 기능 : // y 축 빠른 정렬.
     *
     * @param a (IN Parameter) 포인트 배열 <br/>
     * @param first (IN Parameter) 첫 번째 지점 <br/>
     * @param last (IN Parameter) 마지막 지점 <br/>
     */

    public void yQuickSort(
            final Location[] a, final int first, final int last) {

        if (first < last) {
            int q = yPartition(a, first, last); // pivot
            yQuickSort(a, first, q - 1); // Left
            yQuickSort(a, q + 1, last); // Right
        }
    }

    /**
     * closestPair function: find closest pair.
     *
     * @param a        (IN Parameter) array stored before divide <br/>
     * @param indexNum (IN Parameter) number coordinates divideArray <br/>
     * @return minimum distance <br/>
     */

    public double closestPair(final Location[] a, final int indexNum) {

        Location[] divideArray = new Location[indexNum];
        System.arraycopy(a, 0, divideArray, 0, indexNum); // Copy previous array
        int totalNum = indexNum; // number of coordinates in the divideArray
        int divideX = indexNum / 2; // Intermediate value for divide
        Location[] leftArray = new Location[divideX]; //divide - left array
        //divide-right array
        Location[] rightArray = new Location[totalNum - divideX];
        if (indexNum <= 3) { // If the number of coordinates is 3 or less
            return bruteForce(divideArray);
        }
        //divide-left array
        System.arraycopy(divideArray, 0, leftArray, 0, divideX);
        //divide-right array
        System.arraycopy(
                divideArray, divideX, rightArray, 0, totalNum - divideX);

        double minLeftArea = 0; //Minimum length of left array
        double minRightArea = 0; //Minimum length of right array
        double minValue = 0; //Minimum lengt

        minLeftArea = closestPair(leftArray, divideX); // recursive closestPair
        minRightArea = closestPair(rightArray, totalNum - divideX);
        // window size (= minimum length)
        minValue = Math.min(minLeftArea, minRightArea);

        // Create window.  Set the size for creating a window
        // and creating a new array for the coordinates in the window
        for (int i = 0; i < totalNum; i++) {
            double xGap = Math.abs(divideArray[divideX].x - divideArray[i].x);
            if (xGap < minValue) {
                secondCount++; // size of the array
            } else {
                if (divideArray[i].x > divideArray[divideX].x) {
                    break;
                }
            }
        }
        // new array for coordinates in window
        Location[] firstWindow = new Location[secondCount];
        int k = 0;
        for (int i = 0; i < totalNum; i++) {
            double xGap = Math.abs(divideArray[divideX].x - divideArray[i].x);
            if (xGap < minValue) { // if it's inside a window
                firstWindow[k] = divideArray[i]; // put in an array
                k++;
            } else {
                if (divideArray[i].x > divideArray[divideX].x) {
                    break;
                }
            }
        }
        yQuickSort(firstWindow, 0, secondCount - 1); // Sort by y coordinates
        /* Coordinates in Window */
        double length = 0;
        // size comparison within window
        for (int i = 0; i < secondCount - 1; i++) {
            for (int j = (i + 1); j < secondCount; j++) {
                double xGap = Math.abs(firstWindow[i].x - firstWindow[j].x);
                double yGap = Math.abs(firstWindow[i].y - firstWindow[j].y);
                if (yGap < minValue) {
                    length = Math.sqrt(Math.pow(xGap, 2) + Math.pow(yGap, 2));
                    // If measured distance is less than current min distance
                    if (length < minValue) {
                        // Change minimum distance to current distance
                        minValue = length;
                        // Conditional for registering final coordinate
                        if (length < minNum) {
                            minNum = length;
                            point1 = firstWindow[i];
                            point2 = firstWindow[j];
                        }
                    }
                } else {
                    break;
                }
            }
        }
        secondCount = 0;
        return minValue;
    }

    /**
     * bruteForce function: When the number of coordinates is less than 3.
     *
     * @param arrayParam (IN Parameter) array stored before divide <br/>
     * @return <br/>
     */

    public double bruteForce(final Location[] arrayParam) {

        double minValue = Double.MAX_VALUE; // minimum distance
        double length = 0;
        double xGap = 0; // Difference between x coordinates
        double yGap = 0; // Difference between y coordinates
        double result = 0;

        if (arrayParam.length == 2) {
            // Difference between x coordinates
            xGap = (arrayParam[0].x - arrayParam[1].x);
            // Difference between y coordinates
            yGap = (arrayParam[0].y - arrayParam[1].y);
            // distance between coordinates
            length = Math.sqrt(Math.pow(xGap, 2) + Math.pow(yGap, 2));
            // Conditional statement for registering final coordinate
            if (length < minNum) {
                minNum = length;

            }
            point1 = arrayParam[0];
            point2 = arrayParam[1];
            result = length;
        }
        if (arrayParam.length == 3) {
            for (int i = 0; i < arrayParam.length - 1; i++) {
                for (int j = (i + 1); j < arrayParam.length; j++) {
                    // Difference between x coordinates
                    xGap = (arrayParam[i].x - arrayParam[j].x);
                    // Difference between y coordinates
                    yGap = (arrayParam[i].y - arrayParam[j].y);
                    // distance between coordinates
                    length =
                            Math.sqrt(Math.pow(xGap, 2) + Math.pow(yGap, 2));
                    // If measured distance is less than current min distance
                    if (length < minValue) {
                        // Change minimum distance to current distance
                        minValue = length;
                        if (length < minNum) {
                            // Registering final coordinate
                            minNum = length;
                            point1 = arrayParam[i];
                            point2 = arrayParam[j];
                        }
                    }
                }
            }
            result = minValue;

        }
        return result; // If only one point returns 0.
    }

    /**
     * main function: execute class.
     *
     * @param args (IN Parameter) <br/>
     * @throws IOException If an input or output
     *                     exception occurred
     */

    public static void main(final String[] args) {

        //Input data consists of one x-coordinate and one y-coordinate

        ClosestPair cp = new ClosestPair(12);
        cp.array[0] = cp.buildLocation(2, 3);
        cp.array[1] = cp.buildLocation(2, 16);
        cp.array[2] = cp.buildLocation(3, 9);
        cp.array[3] = cp.buildLocation(6, 3);
        cp.array[4] = cp.buildLocation(7, 7);
        cp.array[5] = cp.buildLocation(19, 4);
        cp.array[6] = cp.buildLocation(10, 11);
        cp.array[7] = cp.buildLocation(15, 2);
        cp.array[8] = cp.buildLocation(15, 19);
        cp.array[9] = cp.buildLocation(16, 11);
        cp.array[10] = cp.buildLocation(17, 13);
        cp.array[11] = cp.buildLocation(9, 12);

        System.out.println("Input data");
        System.out.println("Number of points: " + cp.array.length);
        for (int i = 0; i < cp.array.length; i++) {
            System.out.println("x: " + cp.array[i].x + ", y: " + cp.array[i].y);
        }

        cp.xQuickSort(cp.array, 0, cp.array.length - 1); // Sorting by x value

        double result; // minimum distance

        result = cp.closestPair(cp.array, cp.array.length);
        // ClosestPair start
        // minimum distance coordinates and distance output
        System.out.println("Output Data");
        System.out.println("(" + cp.point1.x + ", " + cp.point1.y + ")");
        System.out.println("(" + cp.point2.x + ", " + cp.point2.y + ")");
        System.out.println("Minimum Distance : " + result);

    }
}
