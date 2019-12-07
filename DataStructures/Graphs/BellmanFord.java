import java.util.*;
class BellmanFord
/* negative cycles를 감지하기 위해 Bellman ford를 구현. 그래프는 시작 vertex, 끝 vertex, 그리고 가중치를 가진 edge들을 입력받는다
 Verticle들은 0과 총 verticle개수-1 사이의 숫자로 표시되어야 한다*/
{
    int vertex,edge;
    private Edge edges[];
    private int index=0;
    BellmanFord(int v,int e)
    {
        vertex=v;
        edge=e;
        edges=new Edge[e];
    }
    class Edge
    {
        int u,v;
        int w;
        /**
        *@param u Source Vertex
        * @param v End vertex
        * @param w Weight
        */
        Edge(int a,int b,int c)
        {
            u=a;
            v=b;
            w=c;
        }    
    }
    /**
     * @param p[] edge들의 갱신들을 보여주는 parent 배열
     * @param  i 현재 vertex
     */
    void printPath(int p[],int i)
    {
        if(p[i]==-1)//paraent로 돌아갈 경로를 찾는다
            return;
        printPath(p,p[i]);
        System.out.print(i+" ");
    }
    public static void main(String args[])
    {    
        BellmanFord obj=new BellmanFord(0,0);//nonstatic 변수들을 호출하기 위한 더미 객체
        obj.go();
    }
    public void go()//처음으로 클래스를 이해하기 위해 인터랙티브 실행, source vertex가 0이라 가정하고 모든 vertice들의 거리를 보여준다
    {
        Scanner sc=new Scanner(System.in);//사용자 입력을 위한 scanner 객체
        int i,v,e,u,ve,w,j,neg=0;
        System.out.println("Enter no. of vertices and edges please");
        v=sc.nextInt();
        e=sc.nextInt();
        Edge arr[]=new Edge[e];//edge 배열
        System.out.println("Input edges");
        for(i=0;i<e;i++)
        {
            u=sc.nextInt();
            ve=sc.nextInt();
            w=sc.nextInt();
            arr[i]=new Edge(u,ve,w);
        }
        int dist[]=new int[v];// source와 모든 vertices 사이의 최단 경로 길이를 저장하기 위한 배열
        int p[]=new int[v];//경로를 저장하기 위한 parent 배열
        for(i=0;i<v;i++)
            dist[i]=Integer.MAX_VALUE;// 초기화
        dist[0]=0;
        p[0]=-1;
        for(i=0;i<v-1;i++)
        {
            for(j=0;j<e;j++)
            {
                if((int)dist[arr[j].u]!=Integer.MAX_VALUE&&dist[arr[j].v]>dist[arr[j].u]+arr[j].w)
                {
                    dist[arr[j].v]=dist[arr[j].u]+arr[j].w;//갱신
                    p[arr[j].v]=arr[j].u;
                }
            }
        }
        //negative 인지 검사를 할 마지막 사이클
        for(j=0;j<e;j++)
        if((int)dist[arr[j].u]!=Integer.MAX_VALUE&&dist[arr[j].v]>dist[arr[j].u]+arr[j].w)
        {
            neg=1;
            System.out.println("Negative cycle");
            break;
        }
        if(neg==0)//계속하여 계산 결과를 표시
        {
            System.out.println("Distances are: ");
            for(i=0;i<v;i++)
            System.out.println(i+" "+dist[i]);
            System.out.println("Path followed:");
            for(i=0;i<v;i++)
            { 
                System.out.print("0 ");
                printPath(p,i);
                System.out.println();
            }
        }
    }
    /**
     * @param source Starting vertex
     * @param end Ending vertex
     * @param Edge Array of edges 
    */
    public void show(int source,int end, Edge arr[])/*그래프가 전달되면 계산결과를 보여준다. 그래프는 addEdge()메소드로 제작, getEdgeArray()
    메소드로 전달되어야 한다 */
    {
        int i,j,v=vertex,e=edge,neg=0;
        double dist[]=new double[v];// source와 모든 vertices 사이의 최종 최단 경로 거리를 저장하기 위한 거리 배열
        int p[]=new int[v];//경로 저장을 위한 parent 배열
        for(i=0;i<v;i++)
            dist[i]=Integer.MAX_VALUE;//초기화
        dist[source]=0;
        p[source]=-1;
        for(i=0;i<v-1;i++)
        {
            for(j=0;j<e;j++)
            {
                if((int)dist[arr[j].u]!=Integer.MAX_VALUE&&dist[arr[j].v]>dist[arr[j].u]+arr[j].w)
                {
                    dist[arr[j].v]=dist[arr[j].u]+arr[j].w;//갱신
                    p[arr[j].v]=arr[j].u;
                }
            }
        }
        //negative 인지 검사를 할 마지막 사이클
        for(j=0;j<e;j++)
        if((int)dist[arr[j].u]!=Integer.MAX_VALUE&&dist[arr[j].v]>dist[arr[j].u]+arr[j].w)
        {
            neg=1;
            System.out.println("Negative cycle");
            break;
        }
        if(neg==0)//계속하여 계산 결과를 표시
        {
            System.out.println("Distance is: "+dist[end]);
            System.out.println("Path followed:");
            System.out.print(source+" ");
            printPath(p,end);
            System.out.println();
        }
    }
    /**
     *@param x Source Vertex
     * @param y End vertex
     * @param z Weight 
    */
    public void addEdge(int x,int y,int z)//방향성 없는 Edge 추가
    {
        edges[index++]=new Edge(x,y,z);
    }
    public Edge[] getEdgeArray()
    {
       return edges;
    }
}
