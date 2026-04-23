interface Strategy { 
    int operation (int a, int b); 
} 
class Add implements Strategy { 
    public int operation (int a, int b) { 
        return a + b; 
    } 
} 
class Context { 
    private Strategy strategy; 
    public Context(Strategy strategy) { 
        this.strategy = strategy; 
    } 
    public int execute(int a, int b) { 
        return strategy.operation(a, b); 
    } 
} 
 class Main { 
public static void main (String [] args) { 
Context obj = new Context (new Add ()); 
System.out.println(obj.execute(5, 3)); 
} 
}